import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Service service = new Service();

        // Create rooms
        service.setRoom(1, RoomType.STANDARD, 1000);
        service.setRoom(2, RoomType.JUNIOR, 2000);
        service.setRoom(3, RoomType.MASTER, 3000);

        // Create users
        service.setUser(1, 5000);
        service.setUser(2, 10000);

        // Booking tests
        service.bookRoom(1, 2, LocalDate.of(2026, 6, 30), LocalDate.of(2026, 7, 7)); // Should succeed
        service.bookRoom(1, 2, LocalDate.of(2026, 7, 7), LocalDate.of(2026, 6, 30)); // Should fail (invalid dates)
        service.bookRoom(1, 1, LocalDate.of(2026, 7, 7), LocalDate.of(2026, 7, 8)); // Should succeed
        service.bookRoom(2, 1, LocalDate.of(2026, 7, 7), LocalDate.of(2026, 7, 9)); // Should fail (room unavailable)
        service.bookRoom(2, 3, LocalDate.of(2026, 7, 7), LocalDate.of(2026, 7, 8)); // Should succeed

        // Update room type and price
        service.setRoom(1, RoomType.MASTER, 10000);

        // Print results
        service.printAll();
        service.printAllUsers();
    }
}
