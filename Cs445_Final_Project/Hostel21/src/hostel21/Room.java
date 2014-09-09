/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hostel21;

import java.util.ArrayList;

/**
 *
 * @author GeeCost
 */
public class Room {

    public Hostel bedOwner;
    public ArrayList<Bed> bedsInRoom;
    public Integer roomNumber;
    public Integer aRoomID;

    public Room(Hostel bedOwner, ArrayList<Bed> bedsInRoom,Integer roomNumber, Integer aRoomID) {
        super();
        this.bedOwner = bedOwner;
        this.bedsInRoom = bedsInRoom;
        this.roomNumber = roomNumber;
        this.aRoomID = aRoomID;
    }

    public Room() {
      //  this.bedOwner = new Hostel();
        this.bedsInRoom = new ArrayList<Bed>();
        this.roomNumber = null;
        this.aRoomID = null;
    }

    public int getARoomID(){
        return aRoomID;
    }
    public void setARoomID(Integer aRoomID){
        this.aRoomID = aRoomID;
    }
    public int getRoomNumber(){
        return roomNumber;
    }
    public void setRoomNumber(Integer roomNumber){
        this.roomNumber = roomNumber;
    }
    public Hostel getBedOwner() {
        return bedOwner;
    }
    public void setBedOwner(Hostel bedOwner) {
        this.bedOwner = bedOwner;
    }

    public ArrayList<Bed> getBedsInRoom() {
        return bedsInRoom;
    }

    public void setBedsInRoom(ArrayList<Bed> bedsInRoom) {
        this.bedsInRoom = bedsInRoom;
    }
    public void addBed(Bed aBed) {
        bedsInRoom.add(aBed);
    }
    @Override
    public String toString() {
        return "Room [bedOwner=" + bedOwner + ", bedsInRoom=" + bedsInRoom
                + "]";
    }
    @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Room other = (Room) obj;
		if (roomNumber == null) {
			if (other.roomNumber != null)
				return false;
		} else if (!roomNumber.equals(other.roomNumber))
			return false;
		return true;
	}
}
