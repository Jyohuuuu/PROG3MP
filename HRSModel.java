import javax.swing.*;
import java.util.ArrayList;

public class HRSModel
{
    private ArrayList<Hotel> hotelList;
    private Hotel tempHotel;
    private int identifier;
    private int confirmationID;
    private int addRoomID;
    private Room tempRoom;
    private Reservation tempReservation;

    public HRSModel() {
        this.hotelList = new ArrayList<Hotel>();
    }
    /**
     * Adds a new reservation to the temporary hotel.
     *
     * This method creates a new Reservation object with the given parameters and adds it to the temporary hotel.
     *
     * @param guestName the name of the guest
     * @param checkInDay the day the guest checks in
     * @param checkoutDay the day the guest checks out
     * @param roomInfo the room information
     * @param discountCode the discount code (if any)
     */
    public void addReservation(String guestName, int checkInDay, int checkoutDay, Room roomInfo, String discountCode){
        tempHotel.addReservation(new Reservation(guestName,checkInDay,checkoutDay,roomInfo,discountCode));
    }
    /**
     * Adds a new reservation to the temporary room
     *
     * This method creates a new Reservation object with the given parameters and adds it to the temporary hotel.
     *
     * @param guestName the name of the guest
     * @param checkInDay the day the guest checks in
     * @param checkoutDay the day the guest checks out
     * @param roomInfo the room information
     * @param discountCode the discount code (if any)
     */
    public void addReservationR(String guestName, int checkInDay, int checkoutDay, Room roomInfo, String discountCode){
        tempRoom.addReservation(new Reservation(guestName,checkInDay,checkoutDay,roomInfo,discountCode));
    }
    public boolean newPrice(int value){
        if (value < tempHotel.getRooms().get(1).getPrice() + 100){
            return false;
        } else {
            for (Room room : tempHotel.getRooms()) {
                room.setPrice(value);
            }
            return true;
        }
    }
    /**
     * Removes the reservation from the hotel and rooms
     */
    public void removeReservations(){
        ArrayList<Reservation> rooms= tempRoom.getReservations();
        ArrayList<Reservation> reservations= tempHotel.getReservations();
        System.out.println(tempReservation);
        reservations.remove(tempReservation);
        rooms.remove(tempReservation);
    }
    /**
     * Checks if a room is available for a given check-in and check-out date.
     * @param checkIn the day of check-in (1-31)
     * @param checkOut the day of check-out (1-31)
     * @return true if the room is available for the given date range, false otherwise
     */
    public boolean isAvailable(int checkIn, int checkOut) {
        for (Reservation reservation : tempHotel.getReservations()) {//Loops through all the reservations
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
     * Adds a new hotel to the hotel list.
     *
     * This method creates a new Hotel object with the given name and adds the specified number of single, double, and executive rooms to it.
     * The rooms are named in the format of a letter (A, B, C, etc.) followed by a number (1-10). The price of each room is set to a default value.
     *
     * @param name the name of the hotel
     * @param sRoom the number of single rooms
     * @param dRoom the number of double rooms
     * @param eRoom the number of executive rooms
     * @return true if the hotel was successfully added, false otherwise
     */
    public boolean addHotel(String name, int sRoom, int dRoom, int eRoom) {
        boolean result = false;
        try {
            Hotel temp = new Hotel(name);
            char roomLetter = 'A'; // start with letter A
            for (int i = 0; i < sRoom; i++) {
                int roomNumber = i % 10 + 1; // room number 1-10
                String roomName = roomLetter + "" + roomNumber; // create room name
                Room room = new Room(roomName,'S');
                temp.addRoom(room);
                room.setPrice(1299.0);//default price
                if (roomNumber == 10) {
                    roomLetter++; // increment letter when room number reaches 10
                }
            }
            roomLetter = 'Q'; // start with letter A
            for (int i = 0; i < dRoom; i++) {
                int roomNumber = i % 10 + 1; // room number 1-10
                String roomName = roomLetter + "" + roomNumber; // create room name
                Room room = new Room(roomName,'D');
                temp.addRoom(room);
                room.setPrice(1299.0);//default price
                if (roomNumber == 10) {
                    roomLetter++; // increment letter when room number reaches 10
                }
            }
            roomLetter = 'V'; // start with letter A
            for (int i = 0; i < eRoom; i++) {
                int roomNumber = i % 10 + 1; // room number 1-10
                String roomName = roomLetter + "" + roomNumber; // create room name
                Room room = new Room(roomName,'E');
                temp.addRoom(room);
                room.setPrice(1299.0);//default price
                if (roomNumber == 10) {
                    roomLetter++; // increment letter when room number reaches 10
                }
            }
            this.hotelList.add(temp);
            result = true;
        }
        catch(Exception e) {
            System.out.println("Error: " + e);
        }

        return result;
    }
    public ArrayList<Hotel> getHotelList() {
        return this.hotelList;
    }
    /**
     * Checks if a hotel name is unique.
     *
     * This method checks if a hotel with the given name already exists in the hotel list.
     *
     * @param name the name to check
     * @return true if the name is unique, false otherwise
     */
    public boolean isHotelNameUnique(String name) {
        for (Hotel hotel : hotelList) {//loops through hotel list
            if (hotel != null && hotel.getName() != null && hotel.getName().equals(name)) {
                return false;
            }
        }
        return true;
    }
    public void setJList(JList<Hotel> list) {
        DefaultListModel<Hotel> listModel = new DefaultListModel<>();
        for (Hotel hotel : hotelList) {
            listModel.addElement(hotel);
        }
        list.setModel(listModel);
    }
    public void setHotelJComboBox(JComboBox<Hotel> comboBox) {
        DefaultComboBoxModel<Hotel> comboBoxModel = new DefaultComboBoxModel<>();
        for (Hotel hotel : hotelList) {
            comboBoxModel.addElement(hotel);
        }
        comboBox.setModel(comboBoxModel);
    }
    public Hotel getTempHotel(){
        return this.tempHotel;
    }
    public void setTempHotel(Hotel tempHotel){
        this.tempHotel = tempHotel;
    }
    public int getIdentifier() {
        return identifier;
    }
    public void setIdentifier(int identifier) {
        this.identifier = identifier;
    }
    public int getConfirmationID() {
        return confirmationID;
    }

    public void setConfirmationID(int confirmationID) {
        this.confirmationID = confirmationID;
    }
    public void setAddRoomID(int addRoomID) {
        this.addRoomID = addRoomID;
    }
    /**
     * Adds a specified number of rooms to the temporary hotel.
     *
     * This method checks if the hotel has enough capacity to add the specified number of rooms. If it does, it adds the rooms to the hotel.
     * The rooms are named in the format of a letter (A, Q, or V) followed by a number (1-10). The price of each room is set to the same as the first room in the hotel.
     *
     * @param roomNum the number of rooms to add
     * @return true if the rooms were successfully added, false otherwise
     */
    public boolean addRooms(int roomNum){
        Hotel temp = getTempHotel();
        ArrayList<Room> rooms = temp.getRooms();
        if (50-rooms.size()<roomNum){
            return false;
        } else{
            switch (addRoomID){
                case 1:
                    char roomLetter = 'A';
                    int roomNumber = 1;
                    for (int i = 1; i <= roomNum; ) {// room number 1-10
                        String roomName = roomLetter + "" + roomNumber; // create room name
                        boolean exists = false;
                        for (Room r : rooms) {
                            if (r.getName().equals(roomName)) {
                                exists = true;
                                break;
                            }
                        }
                        if (!exists) {
                            Room room = new Room(roomName, 'S');
                            temp.addRoom(room);
                            Room roomPrice = rooms.get(1);
                            double prevPrice = roomPrice.getPrice();
                            room.setPrice(prevPrice);
                            i++;
                            roomNumber++;
                            if (roomNumber > 10) {
                                roomLetter++;
                                roomNumber = 1;
                            }
                        } else {
                            // skip the current iteration
                            roomNumber++;
                            if (roomNumber > 10) {
                                roomLetter++;
                                roomNumber = 1;
                            }
                        }
                    }
                    break;
                case 2:
                    roomLetter = 'Q';
                    roomNumber = 1;
                    for (int i = 1; i <= roomNum; ) {// room number 1-10
                        String roomName = roomLetter + "" + roomNumber; // create room name
                        boolean exists = false;
                        for (Room r : rooms) {
                            if (r.getName().equals(roomName)) {
                                exists = true;
                                break;
                            }
                        }
                        if (!exists) {
                            Room room = new Room(roomName, 'D');
                            temp.addRoom(room);
                            Room roomPrice = rooms.get(1);
                            double prevPrice = roomPrice.getPrice();
                            room.setPrice(prevPrice);
                            i++;
                            roomNumber++;
                            if (roomNumber > 10) {
                                roomLetter++;
                                roomNumber = 1;
                            }
                        } else {
                            // skip the current iteration
                            roomNumber++;
                            if (roomNumber > 10) {
                                roomLetter++;
                                roomNumber = 1;
                            }
                        }
                    }
                    break;
                case 3:
                    roomLetter = 'V';
                    roomNumber = 1;
                    for (int i = 1; i <= roomNum; ) {// room number 1-10
                        String roomName = roomLetter + "" + roomNumber; // create room name
                        boolean exists = false;
                        for (Room r : rooms) {
                            if (r.getName().equals(roomName)) {
                                exists = true;
                                break;
                            }
                        }
                        if (!exists) {
                            Room room = new Room(roomName, 'E');
                            temp.addRoom(room);
                            Room roomPrice = rooms.get(1);
                            double prevPrice = roomPrice.getPrice();
                            room.setPrice(prevPrice);
                            i++;
                            roomNumber++;
                            if (roomNumber > 10) {
                                roomLetter++;
                                roomNumber = 1;
                            }
                        } else {
                            // skip the current iteration
                            roomNumber++;
                            if (roomNumber > 10) {
                                roomLetter++;
                                roomNumber = 1;
                            }
                        }
                    }
                    return true;

            }
            return true;
        }
    }
    /**
     * Removes a hotel from the hotel list.
     *
     * @param hotel the hotel to remove
     */
    public void removeHotel(Hotel hotel){
        hotelList.remove(hotel);
    }
    /**
     * Gets a room by its name from the temporary hotel.
     *
     * @param roomName the name of the room to find
     * @return the room if found, null otherwise
     */
    public Room getRoomByName(String roomName) {
        for (Room room : tempHotel.getRooms()) {
            if (room.getName().equals(roomName)) {
                return room;
            }
        }
        return null;
    }
    public Room getTempRoom() {
        return tempRoom;
    }
    public void setTempRoom(Room tempRoom) {
        this.tempRoom = tempRoom;
    }
/**
 * Finds a reservation by the guest's name.
 *
 * This method loops through the list of reservations in the temporary hotel and returns the first reservation that matches the given guest name.
 *
 * @param name the guest's name to search for
 * @return the reservation if found, null otherwise
 */
    public Reservation findReservationByGuestName(String name)
    {
        for (Reservation reservation : tempHotel.getReservations()) {//loops through the list until we find matching names
            if (reservation.getGuestName().equals(name)) {
                return reservation;
            }
        }
        return null;
    }
    public void setTempReservation(Reservation tempReservation) {
        this.tempReservation = tempReservation;
    }
}
