package hostel21;

import java.util.ArrayList;

public class Client {

    public String firstName;
    public String secondName;
    public String clientEmail;
    public String clientPhone;

    public String creditCardNum;
    public String expirationDate;
    public String securityCode;
    public String creationDate;

    public Integer aUserID;
    public Integer amountSpent;

    public Booking currentBooking;
    public ArrayList<Booking> currentBookings;
    public ArrayList<Booking> pastBookings;

    public Client(String firstName, String secondName, String clientEmail,
            String clientPhone, String creditCardNum, String expirationDate,
            String securityCode, String creationDate,Integer aUserID,Integer amountSpent, Booking currentBooking,
            ArrayList<Booking> currentBookings, ArrayList<Booking> pastBookings) {
        super();
        this.firstName = firstName;
        this.secondName = secondName;
        this.clientEmail = clientEmail;
        this.clientPhone = clientPhone;
        this.creditCardNum = creditCardNum;
        this.expirationDate = expirationDate;
        this.securityCode = securityCode;
        this.creationDate = creationDate;
        this.currentBooking = currentBooking;
        this.currentBookings = currentBookings;
        this.pastBookings = pastBookings;
        this.aUserID = aUserID;
        this.amountSpent = amountSpent;
    }

    Client() {
        this.firstName = "";
        this.secondName = "";
        this.clientEmail = "";
        this.clientPhone = "";
        this.creditCardNum = "";
        this.expirationDate = "";
        this.securityCode = "";
        this.creationDate = "";
        this.aUserID = null;
        this.amountSpent =0;
        //this.currentBooking = new Booking();
        this.currentBookings = new ArrayList<>();
        this.pastBookings = new ArrayList<>();
    }

    public Integer getAmountSpent(){
        return amountSpent;
    }
    public void setAmountSpent(Integer amountSpent){
        this.amountSpent += amountSpent;
    }
            
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    public String getClientPhone() {
        return clientPhone;
    }

    public void setClientPhone(String clientPhone) {
        this.clientPhone = clientPhone;
    }

    public String getCreditCardNum() {
        return creditCardNum;
    }

    public void setCreditCardNum(String creditCardNum) {
        this.creditCardNum = creditCardNum;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public Booking getCurrentBooking() {
        return currentBooking;
    }

    public void setCurrentBooking(Booking currentBooking) {
        this.currentBooking = currentBooking;
    }

    public ArrayList<Booking> getCurrentBookings() {
        return currentBookings;
    }

    public void setCurrentBookings(ArrayList<Booking> currentBookings) {
        this.currentBookings = currentBookings;
    }

    public ArrayList<Booking> getPastBookings() {
        return pastBookings;
    }

    public void setPastBookings(ArrayList<Booking> pastBookings) {
        this.pastBookings = pastBookings;
    }

    @Override
    public String toString() {
        return "Client [firstName=" + firstName + ", secondName=" + secondName
                + ", clientEmail=" + clientEmail + ", clientPhone="
                + clientPhone + ", creditCardNum=" + creditCardNum
                + ", expirationDate=" + expirationDate + ", securityCode="
                + securityCode + ", creationDate=" + creationDate + ", userID="
                + aUserID /** + ", currentBooking=" + currentBooking
                + ", currentBookings=" + currentBookings + ", pastBookings="
                + pastBookings**/ + "]";
    }
     public String toStringForBookings() {
        return "Client [firstName=" + firstName + ", secondName=" + secondName
                + ", clientEmail=" + clientEmail + ", userID="
                + aUserID + "]";
     }
    public String toStringWithBookings() {
        return "Client [firstName=" + firstName + ", secondName=" + secondName
                + ", clientEmail=" + clientEmail + ", clientPhone="
                + clientPhone + ", creditCardNum=" + creditCardNum
                + ", expirationDate=" + expirationDate + ", securityCode="
                + securityCode + ", creationDate=" + creationDate + ", userID="
                + aUserID  + ", currentBooking=" + currentBooking
                + ", currentBookings=" + currentBookings + ", pastBookings="
                + pastBookings + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Client other = (Client) obj;
        if (aUserID == null) {
            if (other.aUserID != null) {
                return false;
            }
        } else if (!aUserID.equals(other.aUserID)) {
            return false;
        }
        return true;
    }
}
