package org.example;
import jakarta.persistence.*;

@Entity
@Table(name = "workspaces")
public class CoworkingSpace {

    @Id
    @Column(name = "space_id")
    private int spaceID;
    @Column(name = "space_type")
    private String spaceType;
    @Column(name = "price_per_hour")
    private double pricePerHour;
    @Column(name = "availability_status")
    private boolean isAvailable;

    public CoworkingSpace(){}

    public CoworkingSpace(int spaceID, String spaceType, double pricePerHour, boolean isAvailable){
        this.spaceID = spaceID;
        this.spaceType = spaceType;
        this.pricePerHour = pricePerHour;
        this.isAvailable = isAvailable;
    }

    public int getSpaceID(){
        return spaceID;
    }

    public void setSpaceID(int spaceID) {
        this.spaceID = spaceID;
    }

    public String getSpaceType() {
        return spaceType;
    }

    public void setSpaceType(String spaceType) {
        this.spaceType = spaceType;
    }

    public double getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(double pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    public boolean getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    @Override
    public String toString(){
        return "Space ID: " + getSpaceID() +
                " | Space Type: " + getSpaceType() +
                " | Price Per Hour: " + getPricePerHour() +
                " | Status: " + (getIsAvailable() ? "Available" : "Not Available");
    }
}


