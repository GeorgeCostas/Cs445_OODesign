package hostel21;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Bed {
    SimpleDateFormat ft = new SimpleDateFormat ("yyyyMMdd"); 
    
    public Date aRealDate;
    public String dateAvailable;
    public Integer price;
    public String bedNum;
    public Integer roomNum;
    public boolean booked;
    public Hostel bedOwner;
    public ArrayList<Integer> searchIDResults;
    public int aBedID;

    public Bed(String dateAvailable, Integer price, String bedNum,
            Integer roomNum, boolean booked, int aBedID, Date aRealDate, 
            ArrayList<Integer> searchIDResults) {
        super();
        this.aRealDate = aRealDate;
        this.dateAvailable = dateAvailable;
        this.price = price;
        this.bedNum = bedNum;
        this.roomNum = roomNum;
        this.booked = booked;
        this.aBedID = 0;
        this.searchIDResults = new ArrayList<>();
    }

    public Bed() {
        super();
        this.dateAvailable = "";
        this.price = 0;
        this.bedNum = "";
        this.roomNum = 0;
        this.booked = false;
        this.aBedID = 0;
        this.aRealDate = null;
        this.searchIDResults = new ArrayList<>();
        
    }

    public ArrayList<Integer> getSearchIDResults() {
        return searchIDResults;
    }

    public void setSearchIDResults(ArrayList<Integer> searchIDResults) {
        this.searchIDResults = searchIDResults;
    }

    public int getABedID() {
        return aBedID;
    }

    public void setABedID(int aBedID) {
        this.aBedID = aBedID;
    }

    public Hostel getBedOwner() {
        return bedOwner;
    }

    public void setBedOwner(Hostel bedOwner) {
        this.bedOwner = bedOwner;
    }

    public String getDateAvailable() {
        return dateAvailable;
    }

    public void setDateAvailable(String dateAvailable) {
        this.dateAvailable = dateAvailable;
        aRealDate = processDate(dateAvailable);
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getBedNum() {
        return bedNum;
    }

    public void setBedNum(String bedNum) {
        this.bedNum = bedNum;
    }

    public Integer getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(Integer roomNum) {
        this.roomNum = roomNum;
    }

    public boolean isBooked() {
        return booked;
    }

    public void setBooked(boolean booked) {
        this.booked = booked;
    }
    
    public Date processDate(String aDateAvailable){  
      Date realDate = null; 

      try { 
          realDate = ft.parse(aDateAvailable); 
      } catch (ParseException e) { 
          System.out.println("Unparseable using " + ft); 
      }
      return realDate;
    }

    @Override
    public String toString() {
        return "Bed [dateAvailable=" + dateAvailable + ", price=" + price
                + ", bedNum=" + bedNum + ", roomNum=" + roomNum
                + ", bedOwner=" + bedOwner.name
                + ", searchIDResults=" + searchIDResults + ", bedID="
                + aBedID + "]";
      
    }
    
    public String searchDatesToString() {
        return  aRealDate+ " : Room Number " + roomNum+ " , Price " + price + " Dollars, SearchID " + searchIDResults.toString();
    }
    

}
