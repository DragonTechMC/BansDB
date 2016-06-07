package us.illyohs.bansdb

import java.nio.file.{Files, Path, Paths}
import java.util.logging.Logger

import com.google.inject.Inject
import org.spongepowered.api.event.game.state.GameStartingServerEvent
import org.spongepowered.api.plugin.Plugin
import us.illyohs.bansdb.util.ConfigUtil
import us.illyohs.bansdb.util.InfoUtil._

@Plugin(
  id = PLUGIN_ID,
  name = PLUGIN_NAME,
  version = PLUGIN_VERSION,
  authors = AUTHORS
)
object BansDB {

  @Inject
  var logger:Logger = null


  def onStart(e:GameStartingServerEvent): Unit = {
    val folder:Path = Paths.get("config/bansdb")
    if (!Files.exists(folder)) Files.createDirectory(folder)
    ConfigUtil.init
  }

}
