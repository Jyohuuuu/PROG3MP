import java.util.ArrayList;

/**
 * Represents a room in a hotel with a name, price, and reservations.
 */
public class Room
{
    private String name;
    private double price;
    private ArrayList<Reservation> reservations;
    private char category;
    /**
     * Creates a new room with the given name.
     *
     * @param name the name of the room
     */
    public Room(String name, char category)
    {
        this.name = name;
        this.price = price;
        this.reservations = new ArrayList<Reservation>();
        this.category = category;
    }
    /**
     * Returns the name of the room.
     *
     * @return the name of the room
     */
    public String getName()
    {
        return name;
    }
    /**
     * Returns the price of the room.
     *
     * @return the price of the room
     */
    public double getPrice()
    {
        return price;
    }
    public char getCategory()
    {
        return category;
    }
    /**
     * Sets the price of the room.
     *
     * @param price the new price of the room
     */
    public void setPrice(double price)
    {
        this.price = price;
    }
    /**
     * Adds a new reservation to the room.
     *
     * @param reservations the reservation to add
     */
    public void addReservation(Reservation reservations) {
        this.reservations.add(reservations);
    }
    /**
     * Returns the list of reservations for the room.
     *
     * @return the list of reservations
     */
    public ArrayList<Reservation> getReservations() {
        return reservations;
    }
 /*
    public boolean isAvailable(int checkInDay, int checkInTime, String checkInAmOrPm, int checkOutDay, int checkOutTime, String checkOutAmOrPm) {
        for (Reservation reservation : reservations) {
            int reservedCheckInDay = reservation.getCheckInDate().getDay();
            int reservedCheckInTime = reservation.getCheckInDate().getTime();
            String reservedCheckInAmOrPm = reservation.getCheckInDate().getAmOrPm();
            int reservedCheckOutDay = reservation.getCheckOutDate().getDay();
            int reservedCheckOutTime = reservation.getCheckOutDate().getTime();
            String reservedCheckOutAmOrPm = reservation.getCheckOutDate().getAmOrPm();

            // Check if the requested time period overlaps with the reserved time period
            if ((checkInDay == reservedCheckInDay && checkInTime < reservedCheckOutTime && checkOutTime > reservedCheckInTime) ||
                    (checkInDay == reservedCheckOutDay && checkInTime < reservedCheckOutTime && checkOutTime > reservedCheckInTime) ||
                    (checkOutDay == reservedCheckInDay && checkInTime < reservedCheckOutTime && checkOutTime > reservedCheckInTime) ||
                    (checkOutDay == reservedCheckOutDay && checkInTime < reservedCheckOutTime && checkOutTime > reservedCheckInTime) ||
                    (checkInDay < reservedCheckInDay && checkOutDay > reservedCheckOutDay) ||
                    (checkInDay > reservedCheckInDay && checkOutDay < reservedCheckOutDay)) {
                return false; // Room is not available on this date and time
            }
        }
        return true; // Room is available on this date and time
    }
*/
    /**
     * Checks if a room is available for a given check-in and check-out date.
     * @param checkIn the day of check-in (1-31)
     * @param checkOut the day of check-out (1-31)
     * @return true if the room is available for the given date range, false otherwise
     */

    public boolean isAvailable(int checkIn, int checkOut) {
        for (Reservation reservation : reservations) {//Loops through all the reservations
            int reservedCheckIn = reservation.getCheckInDay();
            int reservedCheckOut = reservation.getCheckOutDay();

            // Check if the time period overlaps with the reserved time period
            if ((checkIn >= reservedCheckIn && checkIn < reservedCheckOut) ||
                    (checkOut > reservedCheckIn && checkOut <= reservedCheckOut) ||
                    (checkIn <= reservedCheckIn && checkOut >= reservedCheckOut)) {
                return false; // Room is not available on this date and time
            }
        }
        return true; // The room is available
    }
    /**
     * Checks if the hotel has any active reservations.
     * @return true if the hotel has at least one active reservation, false otherwise.
     */
    public boolean hasActiveReservation() {
        return !reservations.isEmpty();
    }

    public double calculatePrice(){
        if (category=='D'){
            return price*1.20;
        } else if (category=='E') {
            return price * 1.35;
        }
        return price;
    }
}
