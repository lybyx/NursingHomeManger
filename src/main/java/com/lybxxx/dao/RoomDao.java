package com.lybxxx.dao;

/**
 * @author lybxxx
 * 
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.lybxxx.model.Room;
import com.lybxxx.util.CheckUtil;


public class RoomDao {
  public int roomAdd(Connection con,Room room) throws Exception{
	  String sql = "insert into room_message values(null,?,?)";
	  PreparedStatement pstmt = con.prepareStatement(sql);
	  pstmt.setString(1,room.getRoomNumber());
	  pstmt.setString(2, room.getNurse());
	  return pstmt.executeUpdate();
  }
  public ResultSet roomList(Connection con,Room room) throws Exception{
	  StringBuffer sb =new StringBuffer("select * from room_message");
	  if(CheckUtil.isNotEmpty(room.getRoomNumber())){
		  String roomnumber =room.getRoomNumber();
		   sb.append(" and roomnumber like '%"+ room.getRoomNumber()+"%'");
	  }
	  PreparedStatement pstmt = con.prepareStatement(sb.toString().replaceFirst("and", "where"));
	  return pstmt.executeQuery();
  }
  public int roomModify(Connection con,Room room)throws Exception{
	  String sql = "update room_message set roomnumber=?,nurse=? where id=?";
	  PreparedStatement pstmt = con.prepareStatement(sql);
	  pstmt.setString(1,room.getRoomNumber());
	  pstmt.setString(2,room.getNurse());
	  pstmt.setString(3,room.getId());
	  return pstmt.executeUpdate();  
	  }
  public int roomDelete(Connection con ,Room room)throws Exception{
	  String sql = "delete from room_message where roomnumber=?";
	  PreparedStatement pstmt = con.prepareStatement(sql);
	  pstmt.setString(1,room.getId());
	  return pstmt.executeUpdate();
  }
}
