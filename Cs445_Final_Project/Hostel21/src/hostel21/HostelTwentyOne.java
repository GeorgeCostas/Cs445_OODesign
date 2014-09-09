package hostel21;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;
import java.text.*;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author georgecostas
 */
public class HostelTwentyOne {

    public Date currentDate = new Date();
    SimpleDateFormat ft = new SimpleDateFormat("yyyyMMdd");
    //public Calendar tempDate = Calendar.getInstance();
    //public Scanner userIn = new Scanner(System.in);

    public Integer searchID = 0;
    public Integer userID = 0;
    public Integer hostelID = 0;
    public Integer bedID = 0;
    public Integer bookingID = 0;
    //public Integer roomID = 0;

    public ArrayList<Bed> currentBedsFound;
    public ArrayList<Hostel> hostelList;
    public ArrayList<Client> clientList;
    public Record totalRecord;

    String[] searchString = {"h21", "search", "--city", "San Francisco",
        "--start_date", "20140701", "--end_date", "20140703"};
    String[] searchString2 = {"h21", "search", "--city", "Berlin",
        "--start_date", "20140701", "--end_date", "20140703", "--beds", "2"};
    String[] bookAdd = {"h21", "book", "add", "--search_id", "0", "--user_id", "0"};
    String[] bookCancel = {"h21", "book", "cancel", "--booking_id", "0"};
    String[] adminL = {"h21", "admin", "load", "--file_name", "C:\\Users\\GeeCost\\Documents\\NetBeansProjects\\Hostel21\\src\\hostel21\\hostel-inventory-1-20131117.xml"};
    String[] adminR = {"h21", "admin", "revenue"};
    String[] AdminC = {"h21", "admin", "occupancy"};

    String[] clientAdd = {"h21", "user", "add", "--first_name", "John",
        "--last_name", "Doe", "--email", "john.doe@example.com", "--cc_number",
        "12338789638587", "--expiration_date", "20130809", "--security_code",
        "1234", "--phone", "7736711508"};
    String[] clientView = {"h21", "user", "view", "--user_id", "0", "--first_name", "John",
        "--last_name", "Doe", "--email", "john.doe@example.com"};
    String[] clientChange = {"h21", "user", "change", "--user_id", "0", "--first_name", "johnny", "--last_name", "does",
        "--email", "johnnydoes@gmail.com", "--cc_number", "mycardnuum",
        "--expiration_date", "201309", "--security_code", "1234", "--phone", "7733279016"};

    public Date getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public Integer getHostelID() {
        return hostelID;
    }

    public void setHostelID(Integer hostelID) {
        this.hostelID = hostelID;
    }

    public Integer getBedID() {
        return bedID;
    }

    public void setBedID(Integer bedID) {
        this.bedID = bedID;
    }

    public Integer getBookingID() {
        return bookingID;
    }

    public void setBookingID(Integer bookingID) {
        this.bookingID = bookingID;
    }

    public ArrayList<Hostel> getHostelList() {
        return hostelList;
    }

    public void setHostelList(ArrayList<Hostel> hostelList) {
        this.hostelList = hostelList;
    }

    public ArrayList<Client> getClientList() {
        return clientList;
    }

    public void setClientList(ArrayList<Client> clientList) {
        this.clientList = clientList;
    }

    public Record getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(Record totalRecord) {
        this.totalRecord = totalRecord;
    }

    public void setSearchID(Integer searchID) {
        this.searchID = searchID;
    }

    public void setClientView(String[] clientView) {
        this.clientView = clientView;
    }

    public ArrayList<Bed> getCurrentBedsFound() {
        return currentBedsFound;
    }

    public void setCurrentBedsFound(ArrayList<Bed> currentBedsFound) {
        this.currentBedsFound = currentBedsFound;
    }

    public String[] getSearchString() {
        return searchString;
    }

    public void setSearchString(String[] searchString) {
        this.searchString = searchString;
    }

    public String[] getSearchString2() {
        return searchString2;
    }

    public void setSearchString2(String[] searchString2) {
        this.searchString2 = searchString2;
    }

    public String[] getBookAdd() {
        return bookAdd;
    }

    public void setBookAdd(String[] bookAdd) {
        this.bookAdd = bookAdd;
    }

    public String[] getAdminL() {
        return adminL;
    }

    public void setAdminL(String[] adminL) {
        this.adminL = adminL;
    }

    public String[] getAdminR() {
        return adminR;
    }

    public void setAdminR(String[] adminR) {
        this.adminR = adminR;
    }

    public String[] getAdminC() {
        return AdminC;
    }

    public void setAdminC(String[] adminC) {
        AdminC = adminC;
    }

    public String[] getClientAdd() {
        return clientAdd;
    }

    public void setClientAdd(String[] clientAdd) {
        this.clientAdd = clientAdd;
    }

    public String[] getClientView() {
        return clientView;
    }

    public void setClientCancel(String[] clientView) {
        this.clientView = clientView;
    }

    public String[] getClientChange() {
        return clientChange;
    }

    public void setClientChange(String[] clientChange) {
        this.clientChange = clientChange;
    }

    public Integer getSearchID() {
        return searchID;
    }

    public String[] getBookCancel() {
        return bookCancel;
    }

    public void setBookCancel(String[] bookCancel) {
        this.bookCancel = bookCancel;
    }

    public HostelTwentyOne(ArrayList<Hostel> hostelList,
            ArrayList<Client> clientList, Record totalRecord, int searchID, int userID, int bookingID, int hostelID, int bedID) {
        super();
        this.hostelList = hostelList;
        this.clientList = clientList;
        this.totalRecord = totalRecord;
        this.searchID = searchID;
        this.userID = userID;
        this.bookingID = bookingID;
        this.hostelID = hostelID;
        this.bedID = bedID;
    }

    public HostelTwentyOne() {
        super();
        this.hostelList = new ArrayList<>(100);
        this.clientList = new ArrayList<>(100);
        this.totalRecord = new Record();
        this.searchID = 0;
        this.userID = 0;
        this.bookingID = 0;
        this.hostelID = 0;
        this.bedID = 0;
    }

    public Date processDate(String aDateAvailable) {
        Date realDate = null;

        try {
            realDate = ft.parse(aDateAvailable);
            System.out.println(realDate);
        } catch (ParseException e) {
            System.out.println("Unparseable using " + ft);
        }
        return realDate;
    }

    public void adminLoad(String fileName) throws IOException {
        String rootNode = "<hostel>", endRoot = "</hostel>";
        String hostelAddr = "<address>", endAddr = "</address>";
        String hostelContact = "<contact>", endContact = "<contact>";
        String hostelRestrictions = "<restrictions>",
                endRestrictions = "</restrictions>";
        String bedAvailability = "<availability>",
                endAvailability = ("</availability>");

        String hostelName = "<name>";
        String hostelStreet = "<street>";
        String hostelCity = "<city>";
        String hostelState = "<state>";
        String hostelPostal = "<postal_code>";
        String hostelCountry = "<country>";

        String hostelPhone = "<phone>";
        String hostelEmail = "<email>";
        String hostelFacebook = "<facebook>";
        String hostelWeb = "<web>";

        String hostelCheckIn = "<check_in_time>";
        String hostelCheckOut = "<check_out_time>";
        String hostelSmoking = "<smoking>";
        String hostelAlcohol = "<alcohol>";
        String hostelDeadline = "<cancellation_deadline>";
        String hostelPenalty = "<cancellation_penalty>";

        String bedDate = "<date>";
        String bedRoom = "<room>";
        String bedNum = "<bed>";
        String bedPrice = "<price>";

        Hostel tempHostel = new Hostel();

        String line;
        BufferedReader in = new BufferedReader(new FileReader(fileName));

        while ((line = in.readLine()) != null) {
            line = line.trim();
            System.out.println(line);
            if (line.equals(rootNode)) {
                tempHostel = new Hostel();
                tempHostel.setAHostelID(hostelID);
                hostelID++;
            }
            if (line.equals(endRoot)) {
                hostelList.add(tempHostel);
            }
            if (line.equals(hostelAddr));
            if (line.equals(endAddr));
            if (line.equals(hostelContact));
            if (line.equals(endContact));
            if (line.equals(hostelRestrictions));
            if (line.equals(endRestrictions));
            if (line.equals(bedAvailability)) {
                tempHostel.aBed = new Bed();
                tempHostel.aBed.setABedID(bedID);
                tempHostel.aBed.setBedOwner(tempHostel);
                bedID++;
            }
            if (line.equals(endAvailability)) {
                tempHostel.addBed(tempHostel.aBed);
                //if(tempHostel.hostelRooms.contains(tempHostel.aRoom.roomNumber)){
                //  tempHostel.aRoom.addBed(tempHostel.aBed);
                //} else {
                //  tempHostel.aRoom.setARoomID(roomID);
                //roomID++;
                //tempHostel.aRoom.addBed(tempHostel.aBed);
                //tempHostel.hostelRooms.add(tempHostel.aRoom);}

            } else if (line.length() >= hostelName.length() && line.substring(0, (hostelName.length())).equals(hostelName)) {
                tempHostel.setName(line.substring(hostelName.length(), line.length() - hostelName.length() - 1));
            } else if (line.length() >= hostelStreet.length() && line.substring(0, (hostelStreet.length())).equals(hostelStreet)) {
                tempHostel.setStreetAddress(line.substring(hostelStreet.length(), line.length() - hostelStreet.length() - 1));
            } else if (line.length() >= hostelCity.length() && line.substring(0, (hostelCity.length())).equals(hostelCity)) {
                tempHostel.setCity(line.substring(hostelCity.length(), line.length() - hostelCity.length() - 1));
            } else if (line.length() >= hostelState.length() && line.substring(0, (hostelState.length())).equals(hostelState)) {
                tempHostel.setState(line.substring(hostelState.length(), line.length() - hostelState.length() - 1));
            } else if (line.length() >= hostelPostal.length() && line.substring(0, (hostelPostal.length())).equals(hostelPostal)) {
                tempHostel.setPostalCode(line.substring(hostelPostal.length(), line.length() - hostelPostal.length() - 1));
            } else if (line.length() >= hostelCountry.length() && line.substring(0, (hostelCountry.length())).equals(hostelCountry)) {
                tempHostel.setCountry(line.substring(hostelCountry.length(), line.length() - hostelCountry.length() - 1));
            } else if (line.length() >= hostelPhone.length() && line.substring(0, (hostelPhone.length())).equals(hostelPhone)) {
                tempHostel.setPhone(line.substring(hostelPhone.length(), line.length() - hostelPhone.length() - 1));
            } else if (line.length() >= hostelEmail.length() && line.substring(0, (hostelEmail.length())).equals(hostelEmail)) {
                tempHostel.setEmail(line.substring(hostelEmail.length(), line.length() - hostelEmail.length() - 1));
            } else if (line.length() >= hostelFacebook.length() && line.substring(0, (hostelFacebook.length())).equals(hostelFacebook)) {
                tempHostel.setFacebook(line.substring(hostelFacebook.length(), line.length() - hostelFacebook.length() - 1));
            } else if (line.length() >= hostelWeb.length() && line.substring(0, (hostelWeb.length())).equals(hostelWeb)) {
                tempHostel.setWeb(line.substring(hostelWeb.length(), line.length() - hostelWeb.length() - 1));
            } else if (line.length() >= hostelCheckIn.length() && line.substring(0, (hostelCheckIn.length())).equals(hostelCheckIn)) {
                tempHostel.setCheckIn(line.substring(hostelCheckIn.length(), line.length() - hostelCheckIn.length() - 1));
            } else if (line.length() >= hostelCheckOut.length() && line.substring(0, (hostelCheckOut.length())).equals(hostelCheckOut)) {
                tempHostel.setCheckOut(line.substring(hostelCheckOut.length(), line.length() - hostelCheckOut.length() - 1));
            } else if (line.length() >= hostelSmoking.length() && line.substring(0, (hostelSmoking.length())).equals(hostelSmoking)) {
                tempHostel.setSmoking(line.substring(hostelSmoking.length(), line.length() - hostelSmoking.length() - 1));
            } else if (line.length() >= hostelAlcohol.length() && line.substring(0, (hostelAlcohol.length())).equals(hostelAlcohol)) {
                tempHostel.setDrinking(line.substring(hostelAlcohol.length(), line.length() - hostelAlcohol.length() - 1));
            } else if (line.length() >= hostelDeadline.length() && line.substring(0, (hostelDeadline.length())).equals(hostelDeadline)) {
                tempHostel.setDeadline(line.substring(hostelDeadline.length(), line.length() - hostelDeadline.length() - 1));
                tempHostel.deadlineInDays = Integer.parseInt(tempHostel.deadline) / 24;
            } else if (line.length() >= hostelPenalty.length() && line.substring(0, (hostelPenalty.length())).equals(hostelPenalty)) {
                tempHostel.setPenalty(line.substring(hostelPenalty.length(), line.length() - hostelPenalty.length() - 1));
            } else if (line.length() >= bedDate.length() && line.substring(0, (bedDate.length())).equals(bedDate)) {
                tempHostel.aBed.setDateAvailable(line.substring(bedDate.length(), line.length() - bedDate.length() - 1));
            } else if (line.length() >= bedRoom.length() && line.substring(0, (bedRoom.length())).equals(bedRoom)) {
                tempHostel.aBed.setRoomNum(Integer.parseInt(line.substring(bedRoom.length(), line.length() - bedRoom.length() - 1)));
               // if(tempHostel.hostelRooms.size() <1){
                //   tempHostel.aRoom = new Room();
                // tempHostel.aRoom.setBedOwner(tempHostel);
                //tempHostel.aRoom.setRoomNumber(Integer.parseInt(line.substring(bedRoom.length(), line.length() - bedRoom.length() - 1)));
                // }else{
                //   for(int i =0; i < tempHostel.hostelRooms.size(); i++){
                //     if(tempHostel.hostelRooms.get(i).roomNumber.equals(Integer.parseInt(line.substring(bedRoom.length(), line.length() - bedRoom.length() - 1)))){
                //       tempHostel.aRoom.setRoomNumber(Integer.parseInt(line.substring(bedRoom.length(), line.length() - bedRoom.length() - 1)));

                // }else if(tempHostel.hostelRooms.get(i).roomNumber != (Integer.parseInt(line.substring(bedRoom.length(), line.length() - bedRoom.length() - 1)))){
                //   tempHostel.aRoom = new Room();
                // tempHostel.aRoom.setBedOwner(tempHostel);
                //tempHostel.aRoom.setRoomNumber(Integer.parseInt(line.substring(bedRoom.length(), line.length() - bedRoom.length() - 1)));}}}
            } else if (line.length() >= bedNum.length() && line.substring(0, (bedNum).length()).equals(bedNum)) {
                tempHostel.aBed.setBedNum(line.substring(bedNum.length(), line.length() - bedNum.length() - 1));
            } else if (line.length() >= bedPrice.length() && line.substring(0, (bedPrice.length())).equals(bedPrice)) {
                tempHostel.aBed.setPrice(Integer.parseInt(line.substring(bedPrice.length(), line.length() - bedPrice.length() - 1)));
            }
        }
    }

    public void adminRevenue(ArrayList<String> aCommandList) {
        Integer endDate = Integer.parseInt(aCommandList.get(7));
        Integer startDate = Integer.parseInt(aCommandList.get(5));

        Integer difference = endDate - startDate;
        ArrayList<Bed> bedsFound = new ArrayList<>();
        int revenue = 0;
        int cancelations = 0;
        if (difference > 1) {
            for (int i = 0; i < totalRecord.currentBookings.size(); i++) {
                if (Integer.parseInt(totalRecord.currentBookings.get(i).bookableBed.dateAvailable) >= startDate && Integer.parseInt(totalRecord.currentBookings.get(i).bookableBed.dateAvailable) <= endDate) {
                    revenue += totalRecord.currentBookings.get(i).bookableBed.price;
                    if (totalRecord.currentBookings.get(i).canceled == true) {
                        cancelations++;
                    }
                }
            }
            System.out.println("rooms booked during timeframe" + totalRecord.currentBookings.size());
            System.out.println("Revenue for timeframe:" + revenue + "dollars");
            System.out.println("cancelations in timefreame:" + cancelations);
        }
    }

    public void adminOccupancy(ArrayList<String> aCommandList) throws ParseException {
        //Calendar tempDateStart = null, tempDateEnd = null;
        //tempDateStart.setTime(ft.parse(aCommandList.get(4)));
        //tempDateEnd.setTime(ft.parse(aCommandList.get(6)));

        //tempDateStart.add(Calendar.DATE, 1);
        // tempDate = ft.format(.getTime());  // dt is now the new date
        //Date startDate = processDate(aCommandList.get(4));
        //Date endDate = processDate(aCommandList.get(6));
        //for (int i = 0; i < totalRecord.currentBookings.size(); i++) {
        //  if (totalRecord.currentBookings.get(i).bookableBed.dateAvailable.equals(aCommandList.get(4))) {
        ArrayList<Bed> availableBeds = null;
        for (int i = 0; i < hostelList.size(); i++) {
            for (int j = 0; j < hostelList.get(i).hostelBeds.size(); j++) {
                availableBeds.add(hostelList.get(i).hostelBeds.get(j));
                if (j == hostelList.get(i).hostelBeds.size()) {
                    System.out.println("hostel" + hostelList.get(i).name + " has" + hostelList.get(i).hostelBeds.size() + " beds available");
                }
            }
        }
        totalRecord.currentBookings.trimToSize();
        System.out.println("there are " + totalRecord.currentBookings.size() + " booked hostels");
        System.out.println((totalRecord.currentBookings.size() / availableBeds.size()) * 100 + "% of beds are booked");
        System.out.println("occupancy");
    }

    public void searchByBed(ArrayList<String> aCommandList, ArrayList<Hostel> aHostelList) { //Call with results of a hostelSearch
        Integer numberOfBeds = Integer.parseInt(aCommandList.get(9));
        ArrayList<Bed> bedsFound = new ArrayList<>();
        if (numberOfBeds > 1) {
            for (int i = 0; i < aHostelList.size(); i++) {
                int lastRoom = findLastRoom(aHostelList.get(i));
                for (int j = 0; j < aHostelList.get(i).hostelBeds.size(); j++) {
                    for (int k = 0; k < lastRoom; k++) {
                        if (aHostelList.get(i).hostelBeds.get(j).bedNum.equals(k)) {
                            bedsFound.add(aHostelList.get(i).hostelBeds.get(j));
                        }
                    }
                    hostelList.get(i).hostelBeds.get(j).searchIDResults.add(searchID);
                    searchID++;
                    bedsFound.add(hostelList.get(i).hostelBeds.get(j));
                    System.out.println(bedsFound.get(i).toString());
                }
            }
        } else {
            for (int i = 0; i <= aHostelList.size(); i++) {
                for (int j = 0; j <= aHostelList.get(i).hostelBeds.size(); j++) {
                    hostelList.get(i).hostelBeds.get(j).searchIDResults.add(searchID);
                    searchID++;
                    bedsFound.add(hostelList.get(i).hostelBeds.get(j));
                    System.out.println(bedsFound.get(i).toString());
                }
            }
        }
    }

    public void searchByDate(ArrayList<String> aCommandList, ArrayList<Hostel> aHostelList) {
        Integer difference;
        Integer endDate = Integer.parseInt(aCommandList.get(7));
        Integer startDate = Integer.parseInt(aCommandList.get(5));
        difference = Integer.parseInt(aCommandList.get(7)) - Integer.parseInt(aCommandList.get(5));
        ArrayList<Bed> bedsFound = new ArrayList<>();

        if (difference > 1) {
            for (int i = 0; i < aHostelList.size(); i++) {
                aHostelList.get(i).sortByDate();
                for (int j = 0; j < aHostelList.get(i).hostelBeds.size(); j++) {
                    if (Integer.parseInt(aHostelList.get(i).hostelBeds.get(j).dateAvailable) >= startDate && Integer.parseInt(aHostelList.get(i).hostelBeds.get(j).dateAvailable) <= endDate) {///checks date differen
                        hostelList.get(i).hostelBeds.get(j).searchIDResults.add(searchID);
                        searchID++;
                        bedsFound.add(hostelList.get(i).hostelBeds.get(j));
                    }

                }
                System.out.println("Hostel #" + aHostelList.get(i).aHostelID + "," + aHostelList.get(i).name);
                for (int j = 1; j < bedsFound.size(); j++) {
                        if (Integer.parseInt(aHostelList.get(i).hostelBeds.get(j).dateAvailable) >= startDate && Integer.parseInt(aHostelList.get(i).hostelBeds.get(j).dateAvailable) <= endDate) {
                            System.out.println(bedsFound.get(j).searchDatesToString());
      
                    }
                }
            }
        } else if (difference == 1) {
            for (int i = 0; i < hostelList.size(); i++) {
                for (int j = 0; j < hostelList.get(i).hostelBeds.size(); j++) {
                    if (hostelList.get(i).hostelBeds.get(j).dateAvailable.equals(startDate)) {
                        bedsFound.add(hostelList.get(i).hostelBeds.get(j));
                        hostelList.get(i).hostelBeds.get(j).searchIDResults.add(searchID);
                        searchID++;
                        bedsFound.add(hostelList.get(i).hostelBeds.get(j));

                    }
                }
                System.out.println("Hostel #" + aHostelList.get(i).aHostelID + "," + aHostelList.get(i).name);
                for (int j = 1; j < bedsFound.size(); j++){
                        if (Integer.parseInt(aHostelList.get(i).hostelBeds.get(j).dateAvailable) >= startDate && Integer.parseInt(aHostelList.get(i).hostelBeds.get(j).dateAvailable) <= endDate) {
                            System.out.println(bedsFound.get(j).searchDatesToString());
                        }
                    
                }
            }
        } else {
            System.out.println("bad input, dates are most likely invalid.");
        }
    }
    
      public void bookAdd(ArrayList<String> aCommandList) {
        Integer tempPrice;
        Booking tempBooking = new Booking();
        tempBooking.setBookableBed(searchIDSearch(aCommandList.get(4)));
        tempBooking.setBookingUser(clientIDSearch(aCommandList.get(6))); 
        tempPrice = tempBooking.bookableBed.price;
        tempBooking.setBooked(true);

        for (int i = 0; i < hostelList.size(); i++) {
            for (int j = 0; j < hostelList.get(i).hostelBeds.size(); j++) {
                if (tempBooking.bookingUser.creditCardNum != null) {
                    tempBooking.bookingUser.setAmountSpent(tempPrice);
                    hostelList.get(i).hostelBeds.remove(tempBooking.bookableBed);
                    break;
                }
            }
        }
        for (int i = 0; i < clientList.size(); i++) {
            if (tempBooking.bookingUser.equals(clientList.get(i))) {
                clientList.get(i).currentBookings.add(tempBooking);
            }
        }
        totalRecord.totalProfits += tempBooking.bookableBed.price;
        totalRecord.currentBookings.add(tempBooking);
        System.out.println(tempBooking.toString());
        System.out.println("booking added");
    }

    public void bookCancel(ArrayList<String> aCommandList) {
        Integer deadlineInDays;
        Integer penaltyPercentage;

        for (int i = 0; i < totalRecord.currentBookings.size(); i++) {
            if (totalRecord.currentBookings.get(i).aBookingID.equals(Integer.parseInt(aCommandList.get(4)))) {
                String tempString = totalRecord.currentBookings.get(i).bookableBed.bedOwner.penalty;
                tempString = tempString.substring(0, 1);
                penaltyPercentage = Integer.parseInt(tempString);
                // deadlineInDays = Integer.parseInt(totalRecord.currentBookings.get(i).bookableBed.bedOwner.deadline) / 24;
                // Date lastCancelDate = addDays((totalRecord.currentBookings.get(i).bookableBed.aRealDate), -deadlineInDays);
                if (currentDate.after(totalRecord.currentBookings.get(i).bookableBed.aRealDate)) {//charge penalty
                    double penaltyAmount = penaltyPercentage * 0.01 * totalRecord.currentBookings.get(i).bookableBed.price;
                    totalRecord.dailyProfits += penaltyAmount;
                    totalRecord.currentBookings.get(i).setBooked(false);
                    totalRecord.currentBookings.get(i).setCanceled(true);
                    totalRecord.currentBookings.get(i).setBookingUser(null);
                    totalRecord.currentBookings.get(i).bookableBed.bedOwner.hostelBeds.add(totalRecord.currentBookings.get(i).bookableBed);
                    totalRecord.currentBookings.remove(i);
                }

                if (currentDate.before(totalRecord.currentBookings.get(i).bookableBed.aRealDate)) {
                    totalRecord.currentBookings.get(i).setBooked(false);
                    totalRecord.currentBookings.get(i).setCanceled(true);
                    totalRecord.currentBookings.get(i).setBookingUser(null);
                    totalRecord.currentBookings.get(i).bookableBed.bedOwner.hostelBeds.add(totalRecord.currentBookings.get(i).bookableBed);
                    totalRecord.currentBookings.remove(i);
                }
            }
        }
        System.out.println("Booking Canceled");
    }

    public void bookView(ArrayList<String> aCommandList) {
        Booking tempBooking;
        if (totalRecord.currentBookings.contains(clientIDSearch(aCommandList.get(4)))) {
            tempBooking = aBookingSearch(aCommandList.get(4));
            System.out.println("view");
            System.out.println(tempBooking.toString());
            System.out.println("Viewing Booking");
        }
    }

    public void userAdd(ArrayList<String> aCommandList) {
        Client tempClient = new Client();
        tempClient.setFirstName(aCommandList.get(4));
        tempClient.setSecondName(aCommandList.get(6));
        tempClient.setClientEmail(aCommandList.get(8));
        if (aCommandList.size() > 9) {
            tempClient.setCreditCardNum(aCommandList.get(10));
            tempClient.setExpirationDate(aCommandList.get(12));
            tempClient.setSecurityCode(aCommandList.get(14));
            tempClient.setClientPhone(aCommandList.get(16));
        }
        tempClient.aUserID = userID;
        userID++;
        clientList.add(tempClient);
        System.out.println("user added\n");
    }

    public void userChange(ArrayList<String> aCommandList) {
        Client tempClient = clientIDSearch(aCommandList.get(4));
        for (int i = 0; i < clientList.size(); i++) {
            if (clientList.contains(clientIDSearch(aCommandList.get(4)))) {
                clientList.get(i).setFirstName(aCommandList.get(6));
                clientList.get(i).setSecondName(aCommandList.get(8));
                clientList.get(i).setClientEmail(aCommandList.get(10));
                System.out.println(tempClient);
                if (aCommandList.size() > 10) {
                    clientList.get(i).setCreditCardNum(aCommandList.get(12));
                    clientList.get(i).setExpirationDate(aCommandList.get(14));
                    clientList.get(i).setSecurityCode(aCommandList.get(16));
                    clientList.get(i).setClientPhone(aCommandList.get(18));
                    System.out.println(tempClient);
                }

            }
            System.out.println("client Changed");

        }
    }

    public void userView(ArrayList<String> aCommandList) {
        Client tempUser;
        if (clientList.contains(clientIDSearch(aCommandList.get(4)))) {
            tempUser = clientIDSearch(aCommandList.get(4));
            System.out.println("view");
            System.out.println(tempUser.toString());
        }
    }

    public ArrayList<Hostel> hostelSearch(String aCity) {
        ArrayList<Hostel> hostelsFound = new ArrayList<>();
        for (int i = 0; i < hostelList.size(); i++) {
            if (hostelList.get(i).city.equals(aCity)) {
                hostelsFound.add(hostelList.get(i));
            }
        }
        return hostelsFound;
    }
    
     public Bed bedSearch(Bed aBed) {
        for (int i = 0; i < hostelList.size(); i++) {
            for (int j = 0; j < hostelList.get(i).hostelBeds.size(); j++) {
                if (hostelList.get(i).hostelBeds.get(j).equals(aBed)) {
                    return hostelList.get(i).hostelBeds.get(j);
                }
            }
        }
        return null;
    }

    public Booking aBookingSearch(String bookingID) {
        Booking tempBooking = new Booking();
        Integer tempID = Integer.parseInt(bookingID);
        for (int i = 0; i < totalRecord.currentBookings.size(); i++) {
            if (totalRecord.currentBookings.get(i).aBookingID.equals(tempID)) {
                System.out.println("booking found");
                tempBooking = totalRecord.currentBookings.get(i);
            }
        }
        for (int i = 0; i < totalRecord.pastBookings.size(); i++) {
            if (totalRecord.currentBookings.get(i).aBookingID.equals(tempID)) {
                System.out.println("booking found");
                tempBooking = totalRecord.currentBookings.get(i);
            }

        }
        return tempBooking;
    }
        public Client clientIDSearch(String aUserID) {
        Client tempClient = new Client();
        for (int i = 0; i < clientList.size(); i++) {
            if (clientList.get(i).aUserID.equals(Integer.parseInt(aUserID))) {
                tempClient = clientList.get(i);
            }
        }
        return tempClient;

    }

    public Bed searchIDSearch(String aSearchID) {
        for (int i = 0; i < hostelList.size(); i++) {
            for (int j = 0; j < hostelList.get(i).hostelBeds.size(); i++) {
                for (int k = 0; k < hostelList.get(i).hostelBeds.get(j).searchIDResults.size(); i++) {
                    if (hostelList.get(i).hostelBeds.get(j).searchIDResults.get(k).equals(Integer.parseInt(aSearchID))) {
                        return hostelList.get(i).hostelBeds.get(i);
                    }
                }
            }
        }
        return null;
    }

    public Hostel findHostelOwner(String aHostelName) {
        for (int i = 0; i < hostelList.size(); i++) {
            if (hostelList.get(i).name.equals(aHostelName)) {
                return (hostelList.get(i));
            }
        }
        return null;
    }
    public int findLastRoom(Hostel aHostel) {
        int tempBed = 0;
        for (int i = 0; i < aHostel.hostelBeds.size(); i++) {
            if (aHostel.hostelBeds.get(i).roomNum > tempBed) {
                tempBed = aHostel.hostelBeds.get(i).roomNum;
            }
        }
        return tempBed;
       }
       
    public void processCommand(ArrayList<String> commands) throws IOException, ParseException {
        if (commands.get(1).equals("search")) {
            this.processSearch(commands);
        } else if (commands.get(1).equals("book")) {
            this.processBook(commands);
        } else if (commands.get(1).equals("user")) {
            this.processUser(commands);
        } else if (commands.get(1).equals("admin")) {
            this.processAdmin(commands);
        }
    }

    public void processSearch(ArrayList<String> aCommandList) {
        if (aCommandList.size() > 8) {
            searchByBed(aCommandList, hostelSearch(aCommandList.get(3)));
        } else {
            searchByDate(aCommandList, hostelSearch(aCommandList.get(3)));
        }
    }

    public void processBook(ArrayList<String> aCommandList) {
        if (aCommandList.get(2).equals("add")) {
            bookAdd(aCommandList);
        }
        if (aCommandList.get(2).equals("cancel")) {
            bookCancel(aCommandList);
        }
        if (aCommandList.get(2).equals("view")) {
            bookView(aCommandList);
        }
    }

    public void processUser(ArrayList<String> aCommandList) {
        if (aCommandList.get(2).equals("add")) {
            userAdd(aCommandList);
        }
        if (aCommandList.get(2).equals("change")) {
            userChange(aCommandList);
        }
        if (aCommandList.get(2).equals("view")) {
            userView(aCommandList);
        }
    }

    public void processAdmin(ArrayList<String> aCommandList) throws IOException, ParseException {
        if (aCommandList.get(2).equals("load")) {
            adminLoad(aCommandList.get(4));
        }
        if (aCommandList.get(2).equals("revenue")) {
            adminRevenue(aCommandList);
        }
        if (aCommandList.get(2).equals("occupancy")) {
            adminOccupancy(aCommandList);
        }
    }

    public static ArrayList<String> storeCommands(String[] array) {
        ArrayList<String> tempCommands = new ArrayList<>(20);
        for (int i = 0; array.length > i; i++) {
            tempCommands.add(array[i]);
        }
        System.out.println("here");
        return tempCommands;
    }

    public static void main(String[] args) throws IOException, ParseException {
        HostelTwentyOne h21 = new HostelTwentyOne();
        Scanner aScanner = new Scanner(System.in);
        String command = aScanner.nextLine();
        ArrayList<String> commands = new ArrayList<String>();
        Pattern regex = Pattern.compile("[^\\s\"']+|\"([^\"]*)\"|'([^']*)'");
        Matcher regexMatcher = regex.matcher(command);
        while (regexMatcher.find()) {
            if (regexMatcher.group(1) != null) {
                // Add double-quoted string without the quotes
                commands.add(regexMatcher.group(1));
            } else if (regexMatcher.group(2) != null) {
                // Add single-quoted string without the quotes
                commands.add(regexMatcher.group(2));
            } else {
                // Add unquoted word
                commands.add(regexMatcher.group());
            }
        }

        while (commands.get(0).equals("h21")) {
            System.out.println(command);

            h21.processCommand(commands);
            System.out.println("command Processed");
            commands.clear();
            command = aScanner.nextLine(); 
            regexMatcher = regex.matcher(command);
            while (regexMatcher.find()) {
                if (regexMatcher.group(1) != null) {
                    // Add double-quoted string without the quotes
                    commands.add(regexMatcher.group(1));
                } else if (regexMatcher.group(2) != null) {
                    // Add single-quoted string without the quotes
                    commands.add(regexMatcher.group(2));
                } else {
                    // Add unquoted word
                    commands.add(regexMatcher.group());
                }
            }
        }

    }
}
