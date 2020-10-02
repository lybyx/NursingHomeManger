package com.lybxxx.util;

/**
 * @author lybxxx
 * 
 */
public class CheckUtil {
  public static boolean isEmpty(String type){
	  if(type.equals("")){
		  return true;
	  }else{
		  return false;
	  }
  }
  public static boolean isNotEmpty(String type){

	  if(type!=null&&!type.equals("")){
		  return true;
	  }else{
		  return false;
	  }
  }
}
