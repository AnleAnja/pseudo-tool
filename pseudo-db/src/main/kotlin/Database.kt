import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.exposed.sql.update

class DatabaseConnection {
    fun init(environment: Environment) {
        val database = Database.connect(
            "jdbc:postgresql://${environment.serverName()}:5432/${environment.dbName()}",
            driver = "org.postgresql.Driver",
            user = "postgres",
            password = environment.password()
        )
        if (environment.createDb()) {
            transaction(database) {
                val name1 = randomString()
                val name2 = randomString()
                val id = randomId()
                Users.update {
                    it[system_id] = id
                    it[lastname] = randomName(name1)
                    it[firstname] = randomName(name2)
                    it[email] = randomEmail(name2, name1)
                    it[registration] = randomRegistration()
                    it[campus_id] = id
                }
            }
        }
    }
}
