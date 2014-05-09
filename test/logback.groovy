import ch.qos.logback.classic.db.DBAppender
import ch.qos.logback.core.db.DriverManagerConnectionSource

import ch.qos.logback.classic.Level

appender("DB", DBAppender) {
  connectionSource(DriverManagerConnectionSource) {
    driverClass = "org.postgresql.Driver"
    url = "jdbc:postgresql://localhost:5432/testingborrar"
    user = "postgres"
    password = "postgres"
  }
}

root(Level.DEBUG, ["DB"])

