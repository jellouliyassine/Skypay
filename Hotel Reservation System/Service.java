/**
 * The `Service` class manages rooms, users, and bookings for a booking service application.
 */
import java.time.LocalDate;
import java.util.ArrayList;

public class Service {
    private ArrayList<Room> rooms = new ArrayList<>();
    private ArrayList<User> users = new ArrayList<>();
    private ArrayList<Booking> bookings = new ArrayList<>();

/**
 * The function `setRoom` updates an existing room's type and price per night or adds a new room with
 * the specified type and price if the room does not already exist.
 * 
 * @param roomNumber The `roomNumber` parameter is an integer that represents the unique identifier of
 * a room in a hotel.
 * @param roomType The `roomType` parameter in the `setRoom` method represents the type of the room,
 * such as single, double, suite, etc. It is used to specify the category or classification of the
 * room.
 * @param roomPricePerNight The `roomPricePerNight` parameter in the `setRoom` method represents the
 * price per night for the room being set or updated. This value indicates how much it costs to stay in
 * the room for one night.
 */
    public void setRoom(int roomNumber, RoomType roomType, int roomPricePerNight) {
        Room existingRoom = findRoomByNumber(roomNumber);
        if (existingRoom != null) {
            existingRoom.setRoomType(roomType);
            existingRoom.setPricePerNight(roomPricePerNight);
        } else {
            rooms.add(new Room(roomNumber,roomType, roomPricePerNight));
        }
    }

/**
 * The `setUser` function in Java adds a new User object with a specified balance to a collection of
 * users.
 * 
 * @param balance The `balance` parameter in the `setUser` method represents the initial balance that
 * will be assigned to the new `User` object being created and added to the `users` collection.
 */
public void setUser(int userId, double  balance) {
    User existingUser = findUserById(userId);
    if (existingUser == null) {
        users.add(new User(userId, balance));
    }
}

/**
 * The `bookRoom` function books a room for a user for a specified period, checking for availability,
 * user balance, and validity of input parameters.
 * 
 * @param userId The `userId` parameter represents the unique identifier of the user who is booking the
 * room. It is used to find the user in the system before proceeding with the booking process.
 * @param roomNumber The `roomNumber` parameter in the `bookRoom` method represents the unique
 * identifier of the room that the user wants to book for a specific period. This number is used to
 * find the corresponding room object in the system to check its availability and calculate the total
 * cost of the booking based on the room
 * @param checkIn The `checkIn` parameter in the `bookRoom` method represents the date when the user
 * intends to check into the room. It is of type `LocalDate`, which is a date without a time zone in
 * the ISO-8601 calendar system, such as 2022-09-15
 * @param checkOut The `checkOut` parameter in the `bookRoom` method represents the date when the user
 * is planning to check out of the room. It is of type `LocalDate`, which is a date without a time zone
 * in the ISO-8601 calendar system, such as 2022-12
 */
    public void bookRoom(int userId, int roomNumber, LocalDate checkIn, LocalDate checkOut) {
        try {
            if (checkOut.isBefore(checkIn)) {
                throw new IllegalArgumentException("Check-out date cannot be before check-in date.");
            }

            User user = findUserById(userId);
            if (user == null) {
                throw new IllegalArgumentException("User does not exist.");
            }

            Room room = findRoomByNumber(roomNumber);
            if (room == null) {
                throw new IllegalArgumentException("Room does not exist.");
            }

            if (!isRoomAvailable(room, checkIn, checkOut)) {
                throw new IllegalArgumentException("Room is not available for the selected period.");
            }

            int nights = checkOut.getDayOfYear() - checkIn.getDayOfYear();
            double totalCost = nights * room.getPricePerNight();

            if (user.getBalance() < totalCost) {
                throw new IllegalArgumentException("User does not have enough balance.");
            }

            Booking booking = new Booking(user, room, checkIn, checkOut);
            bookings.add(0, booking); // Insert at beginning
            room.getBookings().add(booking);
            user.calculateBalance(totalCost);

        } catch (Exception e) {
            System.out.println("Booking failed: " + e.getMessage());
        }
    }

/**
 * The `printAll` method prints information about all rooms and bookings in reverse order.
 */
    public void printAll() {
        System.out.println("All Rooms :");
        for (int i = rooms.size() - 1; i >= 0; i--) {
            Room room = rooms.get(i);
            System.out.println("Room " + room.getRoomNumber() + " | Type: " + room.getRoomType() + " | Price per Night: " + room.getPricePerNight());
        }

        System.out.println("All Bookings :");
        for (Booking booking : bookings) {
            System.out.println("User " + booking.getUser().getId() + " booked Room " + booking.getRoom().getRoomNumber()
                    + " from " + booking.getCheckIn() + " to " + booking.getCheckOut()
                    + " | Room Type: " + booking.getRoom().getRoomType() + " | Price per Night: " + booking.getRoom().getPricePerNight());
        }
    }
/**
 * The `printAllUsers` function prints all users in reverse order along with their ID and balance.
 */

    public void printAllUsers() {
        System.out.println("All Users :");
        for (int i = users.size() - 1; i >= 0; i--) {
            User user = users.get(i);
            System.out.println("User ID: " + user.getId() + " | Balance: " + user.getBalance());
        }
    }

/**
 * The `findRoomByNumber` function searches for a room in a collection of rooms based on the room
 * number and returns the room if found, otherwise returns null.
 * 
 * @param roomNumber The `roomNumber` parameter in the `findRoomByNumber` method represents the number
 * of the room that we are searching for in a collection of rooms. The method iterates through the
 * `rooms` collection and returns the `Room` object that matches the specified `roomNumber`. If no room
 * @return The method `findRoomByNumber` returns a `Room` object with the specified room number, or
 * `null` if no room with that number is found.
 */
    private Room findRoomByNumber(int roomNumber) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber) {
                return room;
            }
        }
        return null;
    }

/**
 * The function `findUserById` searches for a user in a collection by their ID and returns the user if
 * found, otherwise returns null.
 * 
 * @param userId The `userId` parameter in the `findUserById` method is an integer value that
 * represents the unique identifier of the user that needs to be found in the `users` collection. The
 * method iterates through the `users` collection and returns the user object with the matching
 * `userId`, or `
 * @return The method `findUserById` returns a `User` object with the specified `userId` if it is found
 * in the `users` collection. If no user is found with the given `userId`, the method returns `null`.
 */
    private User findUserById(int userId) {
        for (User user : users) {
            if (user.getId() == userId) {
                return user;
            }
        }
        return null;
    }

/**
 * The function checks if a room is available for booking within a specified date range by comparing
 * existing bookings.
 * 
 * @param room Room object representing a room in a hotel or accommodation facility.
 * @param checkIn The `checkIn` parameter represents the check-in date for a booking. It is of type
 * `LocalDate` in Java, which is a date without a time zone. This parameter is used in the
 * `isRoomAvailable` method to check if the room is available for booking on the specified check
 * @param checkOut The `checkOut` parameter represents the date when a guest is planning to check out
 * of the room.
 * @return The method `isRoomAvailable` returns a boolean value indicating whether the room is
 * available for booking within the specified check-in and check-out dates. It returns `true` if the
 * room is available and `false` if it is not available.
 */
    private boolean isRoomAvailable(Room room, LocalDate checkIn, LocalDate checkOut) {
        for (Booking booking : room.getBookings()) {
            if (!(checkOut.isBefore(booking.getCheckIn()) || checkIn.isAfter(booking.getCheckOut()))) {
                return false;
            }
        }
        return true;
    }
}
