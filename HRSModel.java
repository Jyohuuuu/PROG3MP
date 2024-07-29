import javax.swing.*;
import java.util.ArrayList;

public class HRSModel
{
    private ArrayList<Hotel> hotelList;
    private Hotel tempHotel;
    private int identifier;
    public HRSModel() {
        this.hotelList = new ArrayList<Hotel>();
    }

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
            roomLetter = 'U'; // start with letter A
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
            roomLetter = 'X'; // start with letter A
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
            // No error should be thrown but this mimicks a database
            // Will through an error however if id not a number
            System.out.println("Error: " + e);
        }

        return result;
    }
    public ArrayList<Hotel> getHotelList() {
        return this.hotelList;
    }
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
    public void setHighLevelInformation(Hotel hotel){
        if (hotel != null) {
            if (hotel.getRooms() != null) {
                System.out.println("The hotel name is: " + hotel.getName());
                System.out.println("Number of rooms: " + hotel.getRooms().size());
                for (Room room : hotel.getRooms()) {
                    System.out.println("Room: " + room.getName());
                }

                // Calculate estimate earnings for the month
                double totalEarnings = 0;
                for (Reservation reservation : hotel.getReservations()) {
                    int nights = reservation.getCheckOutDay() - reservation.getCheckInDay()+1;
                    double totalPrice = nights * reservation.getRoomInfo().getPrice();
                    totalEarnings += totalPrice;
                }
                System.out.println("Estimated earnings for the month: " + totalEarnings);
            } else {
                System.out.println("Rooms collection is null!");
            }
        }
    }
    public void setLowLevelJComboBox(){
        JComboBox<String> comboBox = new JComboBox<>();

        comboBox.addItem("[1] Total number of available and booked rooms for a selected date");
        comboBox.addItem("[2] Room Information");
        comboBox.addItem("[3] Reservation Information");
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
}
