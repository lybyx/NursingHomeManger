package com.lybxxx.dao;

/**
 * @author lybxxx
 * @data 2020/10/2
 * 
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.lybxxx.model.Older;
import com.lybxxx.util.CheckUtil;

public class OlderDao {
  public int OlderAdd(Connection con,Older older) throws Exception{
	 String sql = "insert into older_message values(null,?,?,?,?,?,?)";
	 PreparedStatement pstmt = con.prepareStatement(sql);
	 pstmt.setString(1,older.getName());
	 pstmt.setString(2,older.getSex());
	 pstmt.setString(3, older.getFamily());
	 pstmt.setString(4, older.getPhone());
	 pstmt.setString(5, older.getDormitory()+"");
	 pstmt.setString(6, older.getBed()+"");
	 return pstmt.executeUpdate();
  }
  public int OlderDelete(Connection con,Older older) throws Exception{
	  String sql = "delete from older_message where name=?";
	  PreparedStatement pstmt = con.prepareStatement(sql);
	  pstmt.setString(1,older.getName()+"");
	  return pstmt.executeUpdate();
  }
  public ResultSet OlderSearch(Connection con,Older older) throws Exception{
	  StringBuffer sb = new StringBuffer("select * from older_message b,room_message bt where b.dormitory=bt.id");
	  if(CheckUtil.isNotEmpty(older.getName())){
		 sb.append(" and b.name like '%"+older.getName()+"%'"); 
	  }
	  if(CheckUtil.isNotEmpty(older.getSex())){
			// sb.append(" and b.sex = '"+older.getSex()+"'"); 
			 sb.append(" and b.sex = '"+older.getSex()+"'");
		  }
	  if(CheckUtil.isNotEmpty(older.getFamily())){
			 sb.append(" and b.family like '%"+older.getFamily()+"%'"); 
		  }
	  if(CheckUtil.isNotEmpty(older.getPhone())){
			 sb.append(" and b.phone like '%"+older.getPhone()+"%'"); 
		  }
	  if(older.getDormitory()!=-1){
			 sb.append(" and b.dormitory = " + older.getDormitory()); 
		  }
	  PreparedStatement pstmt = con.prepareStatement(sb.toString());
	  return pstmt.executeQuery();
  }
  public int OlderModify(Connection con,Older older)throws Exception{
	  String sql = "update older_message set name=?,sex=?,family=?,phone=?,dormitory=?,bed=? where id=?";
	  PreparedStatement pstmt = con.prepareStatement(sql);
	  pstmt.setString(1,older.getName());
	  pstmt.setString(2,older.getSex());
	  pstmt.setString(3,older.getFamily());
	  pstmt.setString(4,older.getPhone());
	  pstmt.setInt(5,older.getDormitory());
	  pstmt.setInt(6,older.getBed());
	  pstmt.setInt(7,older.getId());
	  return pstmt.executeUpdate();  
  }
  
}
