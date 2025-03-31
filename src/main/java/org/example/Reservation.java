package org.example;
import jakarta.persistence.*;

@Entity
@Table(name = "reservations")
public class Reservation  {

    @Id
    @Column(name = "booking_id")
    private int bookingID;
    @Column(name = "customer_name")
    private String customerName;
    @Column(name = "date")
    private String date;
    @Column(name = "start_time")
    private String startTime;
    @Column(name = "end_time")
    private String endTime;
    @ManyToOne
    @JoinColumn(name = "space_id", nullable = false)
    private CoworkingSpace space;

    public Reservation() {}

    public Reservation(int bookingID, String customerName, String date, String startTime, String endTime, CoworkingSpace space){
        this.bookingID = bookingID;
        this.customerName = customerName;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.space = space;
    }

    public int getBookingID() {
        return bookingID;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public CoworkingSpace getSpace() {
        return space;
    }

    public void setSpace(CoworkingSpace space) {
        this.space = space;
    }

    @Override
    public String toString(){
        return
                "Booking ID: " + bookingID +
                        " | Name: " + customerName +
                        " | Date: " + date +
                        " | Start Time: " + startTime +
                        " | End Time: " + endTime +
                        " | Space ID: " + space;

    }
}



