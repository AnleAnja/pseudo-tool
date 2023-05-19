import org.jetbrains.exposed.sql.Table

object Users : Table("\"USERS\"") {
    val system_id = varchar("\"SYSTEM_ID\"", 20)
    val lastname = varchar("\"LASTNAME\"", 50)
    val firstname = varchar("\"FIRSTNAME\"", 50)
    val email = varchar("\"EMAIL\"", 100)
    val status = varchar("\"STATUS\"", 20)
    val registration_id = long("\"REGISTRATION_ID\"")
    val campus_id = varchar("\"CAMPUS_ID\"", 20)
}
