import Users.status
import Users.system_id
import org.jetbrains.exposed.exceptions.ExposedSQLException
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.exposed.sql.update

object DatabaseConnection {
    fun init() {
        val environment = Environment
        val database = Database.connect(
            "jdbc:postgresql://${environment.serverName()}:5432/${environment.dbName()}",
            driver = "org.postgresql.Driver",
            user = "postgres",
            password = environment.password()
        )
        if (environment.createDb()) {
            try {
                transaction(database) {
                    Users.selectAll().filter { it[status] == "student" }.forEach { user ->
                        val name1 = randomString()
                        val name2 = randomString()
                        val id = randomId()
                        Users.update ({system_id eq user[system_id]}) {
                            it[system_id] = id
                            it[lastname] = randomName(name1)
                            it[firstname] = randomName(name2)
                            it[email] = randomEmail(name2, name1)
                            it[registration_id] = randomRegistration()
                            it[campus_id] = id
                        }
                    }
                }
            } catch (e: ExposedSQLException) {
                println(e.message)
                e.printStackTrace()
            }
        }
    }
}
