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
            }
        }
    }
}
