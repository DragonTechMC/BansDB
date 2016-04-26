package us.illyohs.bansdb.util;

import org.spongepowered.api.entity.living.player.Player;

public class BansMeta {

    String  target;
    String  bannerUUID;
    boolean isBanned;
    boolean isMuted;
    String  reason;

    public BansMeta(Player target, Player banner, boolean isBanned, boolean isMuted, String reason) {
        this.target     = target.getUniqueId().toString();
        this.bannerUUID = banner.getIdentifier().toString();
        this.isBanned   = isBanned;
        this.isMuted    = isMuted;
        this.reason     = reason;
    }

    public String getTarget() {
        return target;
    }

    public String getBannerUUID() {
        return bannerUUID;
    }

    public String getReason() {
        return reason;
    }

    public boolean isBanned() {
        return isBanned;
    }

    public boolean isMuted() {
        return isMuted;
    }
}
