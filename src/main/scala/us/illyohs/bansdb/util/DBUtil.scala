package us.illyohs.bansdb.util

import javax.sql.DataSource
import java.sql.Connection
import java.sql.SQLException
import java.sql.Statement
import java.util.UUID

import org.spongepowered.api.Sponge
import org.spongepowered.api.service.sql.SqlService
import us.illyohs.bansdb.util.ConfigUtil._


object DBUtil {
  private var sqlServ: SqlService = null
  private var ds: DataSource = null

  def execute(execute: String): Unit = {
    sqlServ = Sponge.getServiceManager.provide(classOf[SqlService]).get()
    val URL: String = "jdbc:mysql://" + getURL + ":" + getPort + "/" + "?user=" + getUsername + "&password=" + getPass
    try {
      ds = sqlServ.getDataSource(URL)
      val connection: Connection = ds.getConnection
      val statement: Statement = connection.createStatement
      statement.execute(execute)
      statement.close
      connection.close
    }
    catch {
      case e: SQLException => e.printStackTrace
    }
  }

  def init: Unit = {
    execute("CREATE TABLE IF NOT EXISTS WARN_DB (warnee TEXT, sender TEXT, warnings SMALLINT, reason TEXT)")
    execute("CREATE TABLE IF NOT EXISTS BAN_DB (banee TEXT, sender TEXT, reason)")
  }


  def getWarning: Int = {
    null
  }

  def isPlayerBanned(uUID: UUID): Boolean = {
    return false
  }

  def isPlayerMuted(): Boolean = {
    return false
  }
}