package us.illyohs.bansdb.util;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.spongepowered.api.Sponge;
import org.spongepowered.api.service.sql.SqlService;

public class DBUtil {

    private static SqlService sqlServ = null;
    private static DataSource ds      = null;

    public static void init() {

        sqlServ = Sponge.getServiceManager().provide(SqlService.class).get();
        String sqlURL = ""; //TODO: add a config
        try {
            ds = sqlServ.getDataSource(sqlURL);
            Connection connection = ds.getConnection();
            //TODO: Make a lib and make a builder pattern for the sake of my lazyness;
            connection.prepareStatement(
                    "CREATE TABLE IF NOT EXISTS BANS_DB ("+
                            "`banneeUuid` CHARACTER(36) NOT NULL" + //Bannee's uuid
                            "`bannerUuid` CHARACTER(36) NOT NULL" + //Banner's uuid
                            "`isBanned` SMALLINT NOT NULL DEFAULT '0'," + //Is the Player banned
                            "`isMuted` SMALLINT NOT NULL DEFAULT '0'" + //Is the player muted
                            "`reason` MEDIUMTEXT NOT NULL DEFAULT ''" + //
                            ");"
            );

        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    public void checkDB() {

    }

    public boolean isPlayerBanned() {
        return false;
    }

    public boolean isPlayerMuted() {
        return false;
    }

    public List<BansMeta> getBans() {
        return null;
    }

    public List<BansMeta> getMutes() {
        return null;
    }

}
