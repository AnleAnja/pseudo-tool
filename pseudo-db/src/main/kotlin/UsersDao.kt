import org.jetbrains.exposed.sql.Table

object Users : Table() {
    val system_id = varchar("system_id", 20)
    val lastname = varchar("lastname", 50)
    val firstname = varchar("firstname", 50)
    val email = varchar("email", 100)
    val registration = long("registration")
    val campus_id = varchar("campus_id", 20)
}
