package net.siegerpg.siege.core.utils;

import net.siegerpg.siege.core.database.DatabaseManager;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Levels {
    public static double calculateRequiredExperience(short level) {
        return Math.pow(level+3, 3);
    }
    
    public static void levelCalculate(OfflinePlayer player) {
        short level = getLevel(player);
        int exp = getExp(player);
        while (calculateRequiredExperience(level) <= exp) { //Loops until required exp is greater than current exp
            exp -= calculateRequiredExperience(level); //Removes required exp of the level from current exp
            level += 1;
        }
        if (getExp(player) != exp) {
            setExp(player, exp); //When while loop is finished, set the temp exp variable to remaining exp
        }
        if (getLevel(player) != level) {
            setLevel(player, level); //When while loop is finished, set the temp level variable to player's level
        }
    
        if (player.isOnline()) {
            ((Player) player).setLevel(level);
            ((Player) player).setExp((float) (exp / calculateRequiredExperience(level)));
        }
    }

    public static double getExpCeiling(OfflinePlayer player) {
        return Math.pow((Levels.getLevel(player) + 3), 3);
    }

    public static Short getLevel(OfflinePlayer player) {
        Connection connection = DatabaseManager.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT level FROM userData WHERE uuid=?");
            statement.setString(1, player.getUniqueId().toString());
            ResultSet query = statement.executeQuery();
            query.next();
            short level = query.getShort("level");
            DbManager.releaseConnection(connection);
            statement.close();
            return level;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static void setLevel(OfflinePlayer player, short level) {
        new Thread(() -> {
            Connection connection = DbManager.getConnection();
            try {
                PreparedStatement statement = connection.prepareStatement("UPDATE userData SET level=? WHERE uuid=?");
                statement.setShort(1, level);
                statement.setString(2, player.getUniqueId().toString());
                statement.executeUpdate();
                DbManager.releaseConnection(connection);
                if (player.isOnline()) ((Player) player).setLevel(level);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }).start();
        
    }

    public static void addLevel(OfflinePlayer player, short level) {
        new Thread(() -> {
            Connection connection = DbManager.getConnection();
            try {
                PreparedStatement statement = connection.prepareStatement("UPDATE userData SET level=level+? WHERE uuid=?");
                statement.setShort(1, level);
                statement.setString(2, player.getUniqueId().toString());
                statement.executeUpdate();
                DbManager.releaseConnection(connection);
                levelCalculate(player);
                if (player.isOnline()) ((Player) player).setLevel(level);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }).start();
        
    }

    public static Integer getExp(OfflinePlayer player) {
        Connection connection = DbManager.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT experience FROM userData WHERE uuid=?");
            statement.setString(1, player.getUniqueId().toString());
            ResultSet query = statement.executeQuery();
            query.next();
            int exp = query.getInt("experience");
            DbManager.releaseConnection(connection);
            return exp;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static void setExp(OfflinePlayer player, int exp) {
        new Thread(() -> {
            Connection connection = DbManager.getConnection();
            try {
                PreparedStatement statement = connection.prepareStatement("UPDATE userData SET experience=? WHERE uuid=?");
                statement.setInt(1, exp);
                statement.setString(2, player.getUniqueId().toString());
                statement.executeUpdate();
                DbManager.releaseConnection(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }).start();
        
    }
    
    public static void addExp(OfflinePlayer player, int exp) {
        addExp(player, exp, "");
    }
    
    public static void addExp(OfflinePlayer player, int exp, String message) {
        new Thread(() -> {
            Connection connection = DbManager.getConnection();
            try {
                PreparedStatement statement = connection.prepareStatement("UPDATE userData SET experience=experience+? WHERE uuid=?");
                statement.setInt(1, exp);
                statement.setString(2, player.getUniqueId().toString());
                statement.executeUpdate();
                DbManager.releaseConnection(connection);
                levelCalculate(player);
                if (!message.equals("")) sendExpMessage(player, exp, message);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }).start();
    }
    
    public static void sendExpMessage(OfflinePlayer player, int exp, String reason) {
        if (!player.isOnline()) return;
        Player onlinePlayer = (Player) player;
        onlinePlayer.sendMessage(Utils.tacc("&a+"+exp+" EXP &7&o"+reason));
    }
}
