package main.java.dataBase;

/** 
 * This is a very simple example representing how to work with MySQL 
 * using java JDBC interface;
 * The example mainly present how to read a table representing a set of WiFi_Scans
 * Note: for simplicity only two properties are stored (in the DB) for each AP:
 * the MAC address (mac) and the signal strength (rssi), the other properties (ssid and channel)
 * are omitted as the algorithms do not use the additional data.
 * 
 */
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


import java.sql.Statement;


public class MySQL {
	/**
		 * @author amit nuni bar janach
		 * this is taken from boaz's git.
		 * implemented to our code.
		 */
	
	private String ip;// = "5.29.193.52";
	private String url;// = "jdbc:mysql://"+ip+":3306/oop_course_ariel";
	private String user;// = "oop1";
	private String password;// = "Lambda1();";
	private Connection con = null;
	private ArrayList<String> table;

	public MySQL(String ip, String url, String user, String password) {
		this.ip = ip;
		this.url = url;
		this.user = user;
		this.password = password;
		table = new ArrayList<String>();
	}


	public ArrayList<String> readTable() {
		Statement st = null;
		ResultSet rs = null;

		try {     
			con = DriverManager.getConnection(url, user, password);
			st = con.createStatement();
			rs = st.executeQuery("SELECT UPDATE_TIME FROM information_schema.tables WHERE TABLE_SCHEMA = 'oop_course_ariel' AND TABLE_NAME = 'ex4_db'");
			if (rs.next()) {
				System.out.println("**** Update: "+rs.getString(1));
			}

			PreparedStatement pst = con.prepareStatement("SELECT * FROM ex4_db");
			rs = pst.executeQuery();
			int size,len;
			String line ="";
			while (rs.next()) {
				size = rs.getInt(7);
				len = 7+2*size;
				line = "";
				for(int i=2;i<=len;i++){
					if(i>7)
						line += "N/A,";
					line += rs.getString(i)+",";
				}
				line = line.substring(0, line.length()-1);
				table.add(line);
				System.out.println(line);
			}
		} catch (SQLException ex) {
			Logger lgr = Logger.getLogger(MySQL.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);
		} finally {
			try {
				if (rs != null) {rs.close();}
				if (st != null) { st.close(); }
				if (con != null) { con.close();  }
			} catch (SQLException ex) {

				Logger lgr = Logger.getLogger(MySQL.class.getName());
				lgr.log(Level.WARNING, ex.getMessage(), ex);
			}
		}
		return table;
	}

}
