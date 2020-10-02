package com.lybxxx.util;

/**
 * @author lybxxx
 * 
 */
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectUtil {
  private String url = "jdbc:mysql://localhost:3306/mangerold?useSSL=true&characterEncoding=utf-8&serverTimezone=UTC";
  private String userName = "root";
  private String userPassword = "lyb";
  private String jdbcName = "com.mysql.jdbc.Driver";
  
  public Connection getCon() throws Exception{
	  Class.forName(jdbcName);
	  Connection con = DriverManager.getConnection(url,userName,userPassword);
	  return con;
  }
  public void closeCon(Connection con) throws Exception{
	  if(con!=null){
		  con.close();
	  }
  }

}
