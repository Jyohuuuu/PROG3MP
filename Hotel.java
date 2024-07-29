import java.util.ArrayList;
import java.util.Scanner;

/**
 * Represents a hotel with a name, rooms, and reservations.
 */
public class Hotel
{
    private String name;
    private ArrayList<Room> rooms;
    private ArrayList<Reservation> reservations;
    private double[] dayModifier;

    /**
     * Creates a new hotel with the given name.
     *
     * @param name the name of the hotel
     */
    public Hotel(String name)
    {
        this.name = name;
        this.rooms = new ArrayList<Room>();
        this.reservations = new ArrayList<Reservation>();
        this.dayModifier = new double[31];
        for (int i = 0; i < 31; i++) {
            this.dayModifier[i] = 1.0; // Initialize each element to 1.0
        }
    }
    public double[] getDayModifier(){
        return dayModifier;
    }
    @Override
    public String toString() {
        return name;
    }
    /**
     * Returns the name of the hotel.
     *
     * @return the name of the hotel
     */
    public String getName() {
        return name;
    }
    /**
     * Returns the list of rooms in the hotel.
     *
     * @return the list of rooms
     */
    public ArrayList<Room> getRooms() {
        return rooms;
    }
    /**
     * Returns the list of reservations in the hotel.
     *
     * @return the list of reservations
     */
    public ArrayList<Reservation> getReservations() {
        return reservations;
    }
    /**
     * Sets the name of the hotel.
     * @param name the new name of the hotel
    */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Sets the list of rooms in the hotel.
     *
     * @param rooms the new list of rooms
     */
    public void setRooms(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }
    /**
     * Sets the list of reservations in the hotel.
     *
     * @param reservations the new list of reservations
     */
    public void setReservations(ArrayList<Reservation> reservations) {
        this.reservations = reservations;
    }
    /**
     * Adds a new room to the hotel.
     *
     * @param room the room to add
     */
    public void addRoom(Room room) {
        this.rooms.add(room);
    }
    /**
     * Adds a new reservation to the hotel.
     *
     * @param reservations the reservation to add
     */
    public void addReservation(Reservation reservations) {
        this.reservations.add(reservations);
    }
    /**
     * Finds a room in the hotel by its name.
     *
     * @param name the name of the room to find
     * @return the room if found, null otherwise
     */

    public Room findRoomByName(String name)
    {
        for (Room room:rooms) {
            if (room.getName().equals(name)) {
                return room;
            }
        }
        return null;
    }
    /**
     * Finds a reservation in the hotel by the guest's name.
     *
     * @param name the name of the guest to find
     * @return the reservation if found, null otherwise
     */
    public Reservation findReservationByGuestName(String name)
    {
        for (Reservation reservation : reservations) {//loops through the list until we find matching names
            if (reservation.getGuestName().equals(name)) {
                return reservation;
            }
        }
        return null;
    }
    /**
     * Removes a room from the hotel's room list.
     *
     * @param room the room to be removed
     */
    public void removeRoom(Room room) {
        if (rooms.contains(room)) {//if it has the room it removes it
            rooms.remove(room);
            System.out.println("Room " + room.getName() + " has been removed successfully.");
        } else {
            System.out.println("Room " + room.getName() + " does not exist in the hotel.");
        }
    }

    public void setDayModifier(int index, double value){
        if (index >= 0 && index < this.dayModifier.length) {
            this.dayModifier[index] = value;
        } else {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
        }
    }

}
