package hostel21;

/**
 *
 * @author georgecostas
 */
public class Booking {

    public Bed bookableBed;
    public Client bookingUser;
    public Integer aBookingID;
    public boolean booked;
    public boolean canceled;

    public Booking(Bed bookableBed, Client bookingUser, boolean booked,
            boolean canceled, Integer aBookingID) {
        super();
        this.bookableBed = bookableBed;
        this.bookingUser = bookingUser;
        this.booked = booked;
        this.canceled = canceled;
        this.aBookingID = aBookingID;
      }
 
    Booking() {
        this.bookableBed = new Bed();
        this.bookingUser = new Client();
        this.booked = false;
        this.canceled = false;
        this.aBookingID = 0;

    }

    public Bed getBookableBed() {
        return bookableBed;
    }

    public void setBookableBed(Bed bookableBed) {
        this.bookableBed = bookableBed;
    }

    public Client getBookingUser() {
        return bookingUser;
    }

    public void setBookingUser(Client bookingUser) {
        this.bookingUser = bookingUser;
    }

    public boolean isBooked() {
        return booked;
    }

    public void setBooked(boolean booked) {
        this.booked = booked;
    }

    public boolean isCanceled() {
        return canceled;
    }

    public void setCanceled(boolean canceled) {
        this.canceled = canceled;
    }

    public Integer getBookingID() {
        return aBookingID;
    }

    public void setBookingID(Integer bookingID) {
        this.aBookingID = bookingID;
    }

    @Override
    public String toString() {
        return "Booking [bookingUser" + bookingUser.toStringForBookings()+ ", bookingID " + aBookingID + ", " + bookableBed.toString()+"]";
    }
}
