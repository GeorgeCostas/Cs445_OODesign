/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hostel21;

import java.util.ArrayList;

public class Hostel {

    public String name;
    public String streetAddress;
    public String city;
    public String state;
    public String postalCode;
    public String country;

    public String phone;
    public String email;
    public String facebook;
    public String web;

    public String checkIn;
    public String checkOut;
    public String smoking;
    public String drinking;
    public String deadline;
    public Integer deadlineInDays;
    public String penalty;

    public Integer aHostelID;

    //  public ArrayList<Room> hostelRooms;
    public ArrayList<Bed> hostelBeds;
    public Bed aBed;
    //  public Room aRoom;

    public Hostel(String name, String streetAddress, String city, String state,
            String postalCode, String country, String phone, String email,
            String facebook, String web, String checkIn, String checkOut,
            String smoking, String drinking, String deadline, String penalty,
            Integer aHostelID, ArrayList<Bed> hostelBeds, Bed aBed) {
        super();
        this.name = name;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.country = country;
        this.phone = phone;
        this.email = email;
        this.facebook = facebook;
        this.web = web;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.smoking = smoking;
        this.drinking = drinking;
        this.deadline = deadline;
        this.penalty = penalty;
        this.aHostelID = aHostelID;
        this.hostelBeds = hostelBeds;
        //this.hostelRooms = hostelRooms;
        this.aBed = aBed;
        // this.aRoom = aRoom;
    }

    public Hostel() {
        super();
        this.name = "";
        this.streetAddress = "";
        this.city = "";
        this.state = "";
        this.postalCode = "";
        this.country = "";
        this.phone = "";
        this.email = "";
        this.facebook = "";
        this.web = "";
        this.checkIn = "";
        this.checkOut = "";
        this.smoking = "";
        this.drinking = "";
        this.deadline = "48";
        this.penalty = "75%";
        this.aHostelID = 0;
        this.hostelBeds = new ArrayList<>();
        //this.hostelRooms = new ArrayList<>();
        this.aBed = new Bed();
        // this.aRoom =  new Room();
    }

    public Integer getAHostelID() {
        return aHostelID;

    }

    public void setAHostelID(Integer aHostelID) {
        this.aHostelID = aHostelID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }

    public String getSmoking() {
        return smoking;
    }

    public void setSmoking(String smoking) {
        this.smoking = smoking;
    }

    public String getDrinking() {
        return drinking;
    }

    public void setDrinking(String drinking) {
        this.drinking = drinking;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getPenalty() {
        return penalty;
    }

    public void setPenalty(String deadline) {
        this.penalty = deadline;
    }

    public ArrayList<Bed> getHostelBeds() {
        return hostelBeds;
    }

    public void setHostelBeds(ArrayList<Bed> hostelBeds) {
        this.hostelBeds = hostelBeds;
    }

    public Bed getaBed() {
        return aBed;
    }

    public void setaBed(Bed aBed) {
        this.aBed = aBed;
    }

    public void addBed(Bed aBed) {
        hostelBeds.add(aBed);
    }

    public Bed searchBeds(Bed aBed) {
        for (int i = 0; i < hostelBeds.size(); i++) {
            if (hostelBeds.get(i).equals(aBed)) {
                return hostelBeds.get(i);
            }
        }
        return null;
    }

    public ArrayList<Bed> sortByDate() {
        ArrayList<Bed> sortedList = new ArrayList<Bed>();
        boolean smallest = false;
        for (int i = 0; i < this.hostelBeds.size(); i++) {
            smallest = true;
            for (int j = 0; j < this.hostelBeds.size(); j++) {
                if (Double.parseDouble(this.hostelBeds.get(i).getDateAvailable()) > Double.parseDouble(this.hostelBeds.get(j).getDateAvailable())) {
                    smallest = false;
                }
            }
            if (smallest) {
                sortedList.add(this.hostelBeds.get(i));
                this.hostelBeds.remove(i);
                i--;
            }
        }
       this.hostelBeds = sortedList;
        return sortedList;
    }

    @Override
    public String toString() {
        return "Hostel [name=" + name + ", streetAddress=" + streetAddress
                + ", city=" + city + ", state=" + state + ", postalCode="
                + postalCode + ", country=" + country + ", phone=" + phone
                + ", email=" + email + ", facebook=" + facebook + ", web="
                + web + ", checkIn=" + checkIn + ", checkOut=" + checkOut
                + ", smoking=" + smoking + ", drinking=" + drinking
                + ", hostelBeds=" + hostelBeds + ", aBed=" + aBed + "]";
    }

}
