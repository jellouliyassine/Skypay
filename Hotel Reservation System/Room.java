/**
 * The `Room` class represents a room in a hotel with properties such as room number, price per night,
 * room type, and a list of bookings.
 */

import java.util.ArrayList;

public class Room {
    private int roomNumber=0 ;
    private double pricePerNight;
    private  RoomType roomType;
    private ArrayList<Booking> bookings= new ArrayList<>();



    public Room(int roomNumber, RoomType roomType, int pricePerNight) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.pricePerNight = pricePerNight;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(double pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumberRoom) {
        roomNumber = roomNumberRoom;
    }

    public ArrayList<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(ArrayList<Booking> bookings) {
        this.bookings = bookings;
    }

}
