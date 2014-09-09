/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hostel21;

import java.util.ArrayList;

public class Record {
    public ArrayList<Integer> dailyProfitList;
    public int dailyProfits;
    public int totalProfits;
    public ArrayList<Booking> currentBookings;
    public ArrayList<Booking> pastBookings;
    public Booking aBooking;

    public Record(ArrayList<Booking> currentBookings, Booking aBooking,
            ArrayList<Booking> pastBookings) {
        super();
        this.currentBookings = currentBookings;
        this.pastBookings = pastBookings;
        this.aBooking = aBooking;
    }

    public Record() {
        this.currentBookings = new ArrayList<Booking>();
        this.pastBookings = new ArrayList<Booking>();
        this.aBooking = new Booking();
    }

}
