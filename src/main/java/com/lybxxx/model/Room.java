package com.lybxxx.model;

/**
 * @author lybxxx
 * 
 */
public class Room {
  String id;
  String roomNumber;
  String nurse;
  
 
  
public Room(String roomNumber) {
	super();
	this.roomNumber = roomNumber;
}

public Room() {
	super();
}
public Room(String id, String roomNumber, String nurse) {
	super();
	this.id = id;
	this.roomNumber = roomNumber;
	this.nurse = nurse;
}
public Room(String roomNumber, String nurse) {
	super();
	this.roomNumber = roomNumber;
	this.nurse = nurse;
}
public String getRoomNumber() {
	return roomNumber;
}
public void setRoomNumber(String roomNumber) {
	this.roomNumber = roomNumber;
}
public String getNurse() {
	return nurse;
}
public void setNurse(String nurse) {
	this.nurse = nurse;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
@Override
public String toString() {
	return this.getRoomNumber();
}
  
  
}
