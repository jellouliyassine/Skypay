
---

##Banking System

### Description
A simple banking simulation where a user can:
- Deposit money.
- Withdraw money (with balance validation).
- Print a statement of all transactions.

### Features
- Transaction history with date and amount.
- Balance validation to prevent overdrafts.
- Uses `ArrayList` to manage in-memory data.
- Exception handling for invalid operations.

### Files
- `Account.java`: Manages account operations.
- `AccountService.java`: Defines the required account methods.
- `Transaction.java`: Represents a transaction with date and amount.
- `Main.java`: Runs example banking operations.

---

##Hotel Reservation System

### Description
A hotel booking system where:
- Users can book rooms if they have sufficient balance.
- Bookings cannot overlap.
- Dates and user balances are strictly validated.

### Features
- Room and user creation.
- Room availability and date validation.
- Booking linked to users and rooms.
- Balance deduction upon successful booking.
- Exception handling for invalid operations.

### Files
- `Service.java`: Manages rooms, users, and bookings.
- `Room.java`: Room details (ID, type, price).
- `RoomType.java`: Enum for room types.
- `User.java`: User with ID and balance.
- `Booking.java`: Booking details with dates.
- `Main.java`: Runs the hotel booking scenario.

---

## 🛠️ How the Projects Were Created

- Developed using **Visual Studio Code (VSCode)**.
- No build tools (Maven, Gradle) were used.
- All files are in **flat folders without packages** for easy compilation and execution.

---

##How to Compile and Run

Navigate to the desired project directory in the terminal.

### EXAMPLE: Banking Service and the same goes for the "Hotel Reservation System"
```bash
cd "Banking Service"
# Compile all Java files
javac *.java
# Or compile targeting a specific Java version (e.g., Java 8)
# javac --release 8 *.java
java Main
```
## Answers for Bonus Section in Problem 2

### 1. Should all functions be inside the same service? Is it recommended?

**Answer:**  
No, it is not the recommended approach.

Placing all functions in the same `Service` class is **not scalable or maintainable** for larger applications.

#### Problems:
- **Single Responsibility Violation** (First SOLID principle):  
  The `Service` class is handling too many responsibilities:
  - Managing users
  - Managing rooms
  - Managing bookings

When a class handles multiple responsibilities, it becomes harder to maintain, test, and extend.

---

### 2. Why does `setRoom()` not impact previous bookings? Is there another way?

**Answer:**  
In this design, changing a room’s type or price does not affect past bookings in order to preserve the historical accuracy of reservations.  
When a user books a room, the price and type at the time of booking should be frozen.  

If the system allowed those values to change in past bookings, it would:
- Corrupt historical data
- Make the system inconsistent like example: changing the price a user already agreed to pay.
### Recommended Alternative:
Instead of storing a direct reference to the room, store  the room’s details at the time of booking.

Example:
```java
public class Booking {
    // Instead of a direct Room reference
    private int bookedRoomNumber;
    private RoomType bookedRoomType;
    private int bookedRoomPrice;

    // These values should be saved at the time of booking
}

