/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import hostel21.Bed;
import hostel21.Hostel;
import hostel21.HostelTwentyOne;
import static hostel21.HostelTwentyOne.*;
import hostel21.Room;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author GeeCost
 */
///#$%^I could not get my tsts to run at any point, here are some example of what I
///#$%^thought could work, but did not.
public class HostelTwentyOneUnitTests {
            String[] searchString = {"h21", "search", "--city", "San Francisco",
        "--start_date", "20140701", "--end_date", "20140703"};
    String[] searchString2 = {"h21", "search", "--city", "Berlin",
        "--start_date", "20140701", "--end_date", "20140703", "--beds", "2"};
    String[] bookAdd = {"h21", "book", "add", "--search_id", "0", "--user_id", "0"};
    String[] bookCancel = {"h21", "book", "cancel", "--booking_id", "0"};
    String[] adminL = {"h21", "admin", "load", "--file_name", "C:\\Users\\GeeCost\\Downloads\\hostel-inventory-1-20131117.xml"};
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
    HostelTwentyOne hostel21 = new HostelTwentyOne();
    ArrayList<String> argHolder = new ArrayList<>();
   
    
    public HostelTwentyOneUnitTests() {
    }
    
    @BeforeClass
    public static void setUpClass() throws IOException, ParseException {
    
    
    }
    
    @AfterClass
    public static void tearDownClass() {
        
    }
    
    @Before
    public void setUp() throws IOException, ParseException {
        String[] searchString = {"h21", "search", "--city", "San Francisco",
        "--start_date", "20140701", "--end_date", "20140703"};
    String[] searchString2 = {"h21", "search", "--city", "Berlin",
        "--start_date", "20140701", "--end_date", "20140703", "--beds", "2"};
    String[] bookAdd = {"h21", "book", "add", "--search_id", "0", "--user_id", "0"};
    String[] bookCancel = {"h21", "book", "cancel", "--booking_id", "0"};
    String[] adminL = {"h21", "admin", "load", "--file_name", "C:\\Users\\GeeCost\\Downloads\\hostel-inventory-1-20131117.xml"};
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
    HostelTwentyOne hostel21 = new HostelTwentyOne();
    ArrayList<String> argHolder = new ArrayList<>();
    argHolder = storeCommands(adminL);
    hostel21.processCommand(argHolder);
    ArrayList<Hostel> aHostelList = hostel21.hostelList;
    ArrayList<Bed> aBedList = hostel21.hostelList.get(0).hostelBeds;
    System.out.println(hostel21.hostelList);
    for(int i =0 ; i< hostel21.hostelList.get(i).hostelBeds.size() ; i++){
        System.out.println(hostel21.hostelList.get(i));
        System.out.println(hostel21.hostelList.get(i).hostelBeds.get(i));
    }
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testFindHostelOwner(){
        
        
        String hostelName= "Hostel 21 - Romantic";
        Hostel expectedHostel = new Hostel();      
        expectedHostel = hostel21.hostelList.get(0);
        Hostel resultHostel = hostel21.findHostelOwner(hostelName);
        assertEquals(expectedHostel, resultHostel);
        fail("Hostel owner not found");
                
        }
}
