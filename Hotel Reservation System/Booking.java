/**
 * The `Booking` class represents a booking made by a user for a room with check-in and check-out
 * dates.
 */

import java.time.LocalDate;

public class Booking {

    private User user;
    private Room room;
    private LocalDate checkIn;
    private LocalDate checkOut;

    public Booking(User user, Room room, LocalDate checkIn, LocalDate checkOut) {
        this.user = user;
        this.room = room;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public User getUser() {
        return user;
    }

    public Room getRoom() {
        return room;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public void setCheckIn(LocalDate checkIn) {
        this.checkIn = checkIn;
    }

    public void setCheckOut(LocalDate checkOut) {
        this.checkOut = checkOut;
    }
}
