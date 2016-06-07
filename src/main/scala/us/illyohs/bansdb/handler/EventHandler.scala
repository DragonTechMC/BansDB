package us.illyohs.bansdb.handler

import org.spongepowered.api.event.network.ClientConnectionEvent.{Join, Login}
import us.illyohs.bansdb.util.DBUtil

object EventHandler {


  def connectionEvent(e:Login): Unit = {
    val uuid = e.getProfile.getUniqueId

    if (DBUtil.isPlayerBanned(uuid)) {
      e.setCancelled(true)
    }

  }

  def joinEvent(e:Join): Unit = {

  }

}
