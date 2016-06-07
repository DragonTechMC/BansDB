package us.illyohs.bansdb.util

import java.io.IOException
import java.nio.file.{Files, Path, Paths}

import ninja.leaping.configurate.ConfigurationOptions
import ninja.leaping.configurate.commented.CommentedConfigurationNode
import ninja.leaping.configurate.hocon.HoconConfigurationLoader
import ninja.leaping.configurate.loader.ConfigurationLoader

object ConfigUtil {

  private val configUtil = ConfigUtil

  def getConf = configUtil

  private val file:Path = Paths.get("./config/bansdb/config.conf")
  private val manger:ConfigurationLoader[CommentedConfigurationNode] = HoconConfigurationLoader.builder().setPath(file).build()
  private var node: CommentedConfigurationNode = manger.createEmptyNode(ConfigurationOptions)


  def init: Unit = {
    try {
      if (!Files.exists(file)) {
        Files.createFile(file)

        node.getNode("mysql", "url").setValue("127.0.0.1")
        node.getNode("mysql", "port").setValue(3306)
        node.getNode("mysql", "username").setValue("foo")
        node.getNode("mysql", "password").setValue("bar")
        node.getNode("mysql", "database").setValue("BanDB")

        node.getNode("bans", "maxwarnings").setValue(3)
        node.getNode("bans", "banmessage").setValue("You have been banned from this server")

        manger.save(node)
      }

      node = manger.load()

    } catch {
      case e:IOException => e.printStackTrace()
    }
  }

  def getURL: String = node.getNode("mysql", "url").getString
  def getPort: Int = node.getNode("mysql", "port").getInt
  def getUsername: String = node.getNode("mysql", "username").getString
  def getPass: String = node.getNode("mysql", "password").getString
  def getDB: String = node.getNode("mysql", "database").getString
  def getBanMsg: String = node.getNode("mysql", "banmessage").getString


}
