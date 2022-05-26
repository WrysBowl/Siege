package net.siegerpg.siege.core.database

import net.siegerpg.siege.core.Core
import java.io.File
import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

object DatabaseManager {


	private val dbFile : File = File(Core.plugin().dataFolder.absolutePath, "data.db")

	init {
		try {
			if (!dbFile.exists()) {
				dbFile.createNewFile();
			}

			Class.forName("org.sqlite.JDBC")
			val connection = DriverManager.getConnection("jdbc:sqlite:$dbFile")
			val s = connection.createStatement()
			s.executeUpdate(
					"CREATE TABLE IF NOT EXISTS userData (uuid varchar(64), skill_points int, skill_data text, level int DEFAULT 1, experience int)"
			               )
			s.executeUpdate(
					"CREATE TABLE IF NOT EXISTS ipData (uuid varchar(64), ip text)"
			               )
			s.executeUpdate(
					"CREATE TABLE IF NOT EXISTS webstoreData (uuid varchar(64), command text)"
			               )
			s.executeUpdate(
					"CREATE TABLE IF NOT EXISTS bossData (playerID varchar(64), bossName text, timeTaken int, percentageDone int)"
			               )

			s.close()
		} catch (e : Exception) {
			e.printStackTrace()
		}


	}

	@Throws(SQLException::class)
	fun getConnection() : Connection? {
		return DriverManager.getConnection("jdbc:sqlite:$dbFile")
	}
}