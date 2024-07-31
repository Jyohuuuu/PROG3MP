
import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.print.Book;
import java.util.ArrayList;


public class MainView {
    private JFrame mainFrame, confirm;
    private JLabel createHotelLB,feedbackLB,emptyLB;
    private JButton dayModifierBtn,removeThisRoom,newPriceBtn,createHotelBtn,viewHotelBtn,manageHotelBtn,simBookingBtn,createBtn,highlevelBtn,lowlevelBtn,changeHotelNameBtn,addRoomBtn,removeRoomBtn,updateBasePricingBtn,removeReservationBtn,removeHotelBtn,updateDatePriceModifierBtn,confirmBtn,yesBtn,noBtn,bookBtn,addRoomConfirmBtn,lowlevel1Btn;
    private JTextField dayModifierPriceTF,dayModifierTF,hotelNameTF,standardTF,deluxeTF,executiveTF,nameChangeTF,addRoomTF,checkInTF,checkOutTF,discountTF,guestNameTF,lowInfo1TF,newPriceTF;
    private JPanel leftPanel, rightPanel, emptyPanel;
    private DefaultListModel<String> listModelInfo,listModelBooking,listModelLowInfo,listReservation,listReservationRemove,listRoomRemove;
    private JList<Hotel> hotelJList;
    private JList<String> roomListInfo,roomListBooking,roomListLowInfo,reservationList,reservationRemoveList,removeRoomList;
    private JComboBox<Hotel> hotelJComboBox,highLevelJComboBox;
    private JComboBox<String> lowLevelJComboBox;
    public JRadioButton standardRB,deluxeRB,executiveRB;

    /**
     * This constructor initializes the main frame and its components,
     * including buttons, labels, text fields, combo boxes, and lists.
     */
    public MainView() {
        this.mainFrame = new JFrame("Hotel Reservation System");

        this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.mainFrame.setLayout(new BorderLayout());
        this.mainFrame.setSize(900, 800);
        this.mainFrame.setResizable(false);

        bookBtn = new JButton("Book");
        bookBtn.setPreferredSize(new Dimension(150, 25));

        listModelInfo = new DefaultListModel<>();
        listModelBooking = new DefaultListModel<>();
        listModelLowInfo = new DefaultListModel<>();
        listReservation = new DefaultListModel<>();
        listReservationRemove = new DefaultListModel<>();
        listRoomRemove = new DefaultListModel<>();

        removeRoomList = new JList<>(listRoomRemove);
        removeRoomList.setLayoutOrientation(JList.HORIZONTAL_WRAP);

        reservationRemoveList = new JList<>(listReservationRemove);
        reservationRemoveList.setLayoutOrientation(JList.HORIZONTAL_WRAP);

        reservationList = new JList<>(listReservation);
        reservationList.setLayoutOrientation(JList.HORIZONTAL_WRAP);

        roomListLowInfo = new JList<>(listModelLowInfo);
        roomListLowInfo.setLayoutOrientation(JList.HORIZONTAL_WRAP);

        roomListBooking = new JList<>(listModelBooking);
        roomListBooking.setLayoutOrientation(JList.HORIZONTAL_WRAP);

        roomListInfo = new JList<>(listModelInfo);
        roomListInfo.setLayoutOrientation(JList.HORIZONTAL_WRAP);

        feedbackLB = new JLabel();
        leftPanel = new JPanel();

        standardRB = new JRadioButton("Standard Room");

        deluxeRB = new JRadioButton("Deluxe Room");

        executiveRB = new JRadioButton("Executive Room");

        confirm = new JFrame("Cofirmation");

        yesBtn = new JButton("Yes");
        noBtn = new JButton("No");

        addRoomConfirmBtn = new JButton("Add Room");
        addRoomConfirmBtn.setPreferredSize(new Dimension(150, 30));

        dayModifierTF = new JTextField("");
        dayModifierTF.setPreferredSize(new Dimension(150,15));

        dayModifierPriceTF = new JTextField("");
        dayModifierPriceTF.setPreferredSize(new Dimension(150,15));

        lowInfo1TF = new JTextField("");
        lowInfo1TF.setPreferredSize(new Dimension(150,15));
        newPriceTF = new JTextField("");
        newPriceTF.setPreferredSize(new Dimension(150,15));
        checkInTF = new JTextField("");
        checkInTF.setPreferredSize(new Dimension(150,15));
        discountTF= new JTextField("");
        discountTF.setPreferredSize(new Dimension(150,15));
        checkOutTF = new JTextField("");
        checkOutTF.setPreferredSize(new Dimension(150,15));
        guestNameTF = new JTextField("");
        guestNameTF.setPreferredSize(new Dimension(150,15));

        addRoomTF = new JTextField("");
        addRoomTF.setPreferredSize(new Dimension(150,15));

        nameChangeTF = new JTextField("");
        nameChangeTF.setPreferredSize(new Dimension(150,15));

        confirmBtn = new JButton("Confirm");
        highlevelBtn = new JButton("High level Information");
        highlevelBtn.setPreferredSize(new Dimension(200, 30));

        newPriceBtn = new JButton("New Price");
        newPriceBtn.setPreferredSize(new Dimension(200, 30));

        lowlevelBtn = new JButton("Low level Information");
        lowlevelBtn.setPreferredSize(new Dimension(200, 30));
        lowlevel1Btn = new JButton("Low level Information");
        lowlevel1Btn.setPreferredSize(new Dimension(200, 30));

        changeHotelNameBtn = new JButton("Change the Name of the Hotel");
        changeHotelNameBtn.setPreferredSize(new Dimension(250, 25));

        addRoomBtn = new JButton("Add Room(s)");
        addRoomBtn.setPreferredSize(new Dimension(250, 25));

        removeRoomBtn = new JButton("Remove Room");
        removeRoomBtn.setPreferredSize(new Dimension(250, 25));

        dayModifierBtn = new JButton("Day Modifier");
        dayModifierBtn.setPreferredSize(new Dimension(250, 25));

        updateBasePricingBtn = new JButton("Update Base Pricing of a Room");
        updateBasePricingBtn.setPreferredSize(new Dimension(250, 25));

        removeReservationBtn = new JButton("Remove Reservation");
        removeReservationBtn.setPreferredSize(new Dimension(250, 25));

        removeHotelBtn = new JButton("Remove Hotel");
        removeHotelBtn.setPreferredSize(new Dimension(250, 25));

        updateDatePriceModifierBtn = new JButton("Update the Date Price Modifier");
        updateDatePriceModifierBtn.setPreferredSize(new Dimension(250, 25));

        highLevelJComboBox = new JComboBox<Hotel>();

        lowLevelJComboBox = new JComboBox<String>();
        lowLevelJComboBox.addItem("Total number of available and booked rooms for a selected date");
        lowLevelJComboBox.addItem("Room Information");
        lowLevelJComboBox.addItem("Reservation Information");

        emptyLB = new JLabel("No Hotels are available");
        emptyLB.setFont(new Font("Arial", Font.BOLD, 24));
        emptyPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.CENTER;
        emptyPanel.add(emptyLB, gbc);

        hotelJList= new JList<>();
        hotelJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        hotelJComboBox = new JComboBox<Hotel>();
        hotelJComboBox.setPreferredSize(new Dimension(200, 25));
        hotelJComboBox.setMaximumSize(new Dimension(200, 25));

        leftPanel.setLayout(new GridLayout(5, 1, 10, 10));
        leftPanel.setMinimumSize(new Dimension(350, 750));

        rightPanel = new JPanel();
        rightPanel.setPreferredSize(new Dimension(500, 750));
        rightPanel.setMinimumSize(new Dimension(550, 750));

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, rightPanel);
        initializeMainMenu();
        splitPane.setDividerLocation(400);
        this.mainFrame.add(splitPane, BorderLayout.CENTER);

        this.mainFrame.setVisible(true);
    }
    /**
     * This method initializes the mainview and its components,
     * including 4 buttons and a label.
     */
    public void initializeMainMenu() {
        JLabel mainLabel = new JLabel("Main Menu");
        mainLabel.setFont(new Font("Arial", Font.BOLD, 24));


        JPanel labelPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.CENTER;
        labelPanel.add(mainLabel, gbc);

        leftPanel.add(labelPanel);

        createHotelBtn = new JButton("Create Hotel");
        createHotelBtn.setPreferredSize(new Dimension(200, 30)); // Set the preferred size of the JButton
        leftPanel.add(createHotelBtn);

        viewHotelBtn = new JButton("View Hotel");
        viewHotelBtn.setPreferredSize(new Dimension(200, 30)); // Set the preferred size of the JButton
        leftPanel.add(viewHotelBtn);

        manageHotelBtn = new JButton("Manage Hotel");
        manageHotelBtn.setPreferredSize(new Dimension(200, 30)); // Set the preferred size of the JButton
        leftPanel.add(manageHotelBtn);

        simBookingBtn = new JButton("Simulate Booking");
        simBookingBtn.setPreferredSize(new Dimension(200, 30)); // Set the preferred size of the JButton
        leftPanel.add(simBookingBtn);

        createBtn = new JButton("Create");
        createBtn.setPreferredSize(new Dimension(100, 30));
    }
    /**
     * This method sets up the CreateHotel panel,
     * including a variety of JComponents
     */
    public void createHotel() {
        createHotelLB = new JLabel("What would you like to name your hotel?");
        createHotelLB.setFont(new Font("Arial", Font.BOLD, 24));

        JPanel labelPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.CENTER;
        labelPanel.add(createHotelLB, gbc);

        rightPanel.add(labelPanel);

        hotelNameTF = new JTextField("");
        hotelNameTF.setPreferredSize(new Dimension(400, 30));
        rightPanel.add(hotelNameTF);

        JLabel createLB2 = new JLabel("Enter your rooms: (Maximum 50 total)");
        createLB2.setFont(new Font("Arial", Font.BOLD, 24));

        JPanel labelPanel2 = new JPanel(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.CENTER;
        labelPanel2.add(createLB2, gbc);
        rightPanel.add(labelPanel2);

        JLabel standardLB = new JLabel("Standard Rooms: ");
        standardLB.setFont(new Font("Arial", Font.BOLD, 24));
        JPanel labelPanel3 = new JPanel(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.CENTER;
        labelPanel3.add(standardLB, gbc);
        rightPanel.add(labelPanel3);

        standardTF = new JTextField("");
        standardTF.setPreferredSize(new Dimension(400, 30));
        rightPanel.add(standardTF);

        JLabel deluxeLB = new JLabel("Deluxe Rooms: ");
        deluxeLB.setFont(new Font("Arial", Font.BOLD, 24));
        JPanel labelPanel4 = new JPanel(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.CENTER;
        labelPanel4.add(deluxeLB, gbc);
        rightPanel.add(labelPanel4);

        deluxeTF = new JTextField("");
        deluxeTF.setPreferredSize(new Dimension(400, 30));
        rightPanel.add(deluxeTF);

        JLabel executiveLB = new JLabel("Executive Rooms: ");
        executiveLB.setFont(new Font("Arial", Font.BOLD, 24));
        JPanel labelPanel5 = new JPanel(new GridBagLayout());
        gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.CENTER;
        labelPanel5.add(executiveLB, gbc);
        rightPanel.add(labelPanel5);

        executiveTF = new JTextField("");
        executiveTF.setPreferredSize(new Dimension(400, 30));
        rightPanel.add(executiveTF);


        rightPanel.add(createBtn);

        feedbackLB.setPreferredSize(new Dimension(200, 30));
        rightPanel.add(feedbackLB);

        rightPanel.revalidate();
        rightPanel.repaint();
    }
    /**
     * This method sets up the viewHotel panel,
     * including a variety of JComponents
     */
    public void viewHotel(){

        JLabel viewLB = new JLabel("What hotel would you like to view: ");
        viewLB.setFont(new Font("Arial", Font.BOLD, 24));
        JPanel labelPanel5 = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.CENTER;
        labelPanel5.add(viewLB, gbc);
        rightPanel.add(labelPanel5);

        addToPanel(hotelJComboBox);

        rightPanel.revalidate();
        rightPanel.repaint();
    }
    /**
     * This method sets up the manageHotel panel,
     * including a variety of JComponents
     */
    public void manageHotel(){

        addToPanel(hotelJComboBox);
        rightPanel.add(changeHotelNameBtn);
        rightPanel.add(addRoomBtn);
        rightPanel.add(removeRoomBtn);
        rightPanel.add(updateBasePricingBtn);
        rightPanel.add(removeReservationBtn);
        rightPanel.add(removeHotelBtn);
        rightPanel.add(updateDatePriceModifierBtn);

        rightPanel.revalidate();
        rightPanel.repaint();

    }
    /**
     * This method sets up the confirmation frame,
     * including a variety of JComponents
     * used in logic for manageHotel
     */
    public void confirmationWindow(){

        confirm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        confirm.setLayout(new BorderLayout());
        confirm.setSize(300, 300);
        confirm.setResizable(false);
        JLabel label = new JLabel("Are you sure you want to make this change?");
        confirm.add(label,BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BorderLayout());

        buttonPanel.add(yesBtn, BorderLayout.WEST);
        buttonPanel.add(noBtn, BorderLayout.EAST);

        confirm.add(buttonPanel, BorderLayout.SOUTH);

        confirm.setVisible(true);
    }
    /**
     * This method sets up the changeNameHotel panel,
     * including a variety of JComponents
     */
    public void changeNameHotel(){
        JLabel label = new JLabel("Enter New Hotel Name: ");
        addToPanel(label);

        rightPanel.add(nameChangeTF);
        addToPanel(confirmBtn);
    }
    /**
     * This method sets up the addRooms panel,
     * including a variety of JComponents
     */
    public void addRooms(){
        JLabel label = new JLabel("How many rooms would you like to add: ");
        addToPanel(label);

        rightPanel.add(standardRB);
        standardRB.setSelected(true);
        rightPanel.add(deluxeRB);
        rightPanel.add(executiveRB);

        ButtonGroup roomTypeGroup = new ButtonGroup();
        roomTypeGroup.add(standardRB);
        roomTypeGroup.add(deluxeRB);
        roomTypeGroup.add(executiveRB);
        rightPanel.add(addRoomTF);
        rightPanel.add(addRoomConfirmBtn);

        rightPanel.revalidate();
        rightPanel.repaint();
    }
    /**
     * Removes a room from a hotel.
     *
     * This method prompts the user to select a room to remove from the given hotel.
     * It clears the list of rooms to remove, populates it with the guest names of the reservations in the hotel,
     * and adds the list to the right panel.
     *
     * @param hotel the hotel from which to remove a room
     */
    public void removeRooms(Hotel hotel){
        JLabel label = new JLabel("Which room would you like to remove?");
        addToPanel(label);

        listRoomRemove.clear();
        removeRoomList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        for (Reservation reservation : hotel.getReservations()) {
            listRoomRemove.addElement(reservation.getGuestName());
        }
        JScrollPane scrollPane = new JScrollPane(removeRoomList);
        addToPanel(removeRoomList);

        rightPanel.revalidate();
        rightPanel.repaint();
    }
    /**
     * Updates the base pricing of a room in a hotel.
     *
     * This method prompts the user to enter a new price for the second room in the hotel.
     * The new price must be at least 100 greater than the previous value.
     *
     * @param hotel the hotel in which to update the base pricing
     */
    public void updateBasePricing(Hotel hotel){
        Room room =hotel.getRooms().get(1);
        JLabel label = new JLabel("Please enter a new price of at least 100 greater than the previous value of "+ room.getPrice());
        addToPanel(label);
        rightPanel.add(newPriceTF);
        addToPanel(newPriceBtn);
        rightPanel.revalidate();
        rightPanel.repaint();
    }
    /**
     * Removes a reservation from a hotel.
     *
     * This method prompts the user to select a reservation to remove from the given hotel.
     * It clears the list of reservations to remove, populates it with the guest names of the reservations in the hotel,
     * and adds the list to the right panel.
     *
     * @param hotel the hotel from which to remove a reservation
     */
    public void removeReservation(Hotel hotel){
        JLabel label = new JLabel("Which reservation would you like to remove?");
        addToPanel(label);

        listReservationRemove.clear();
        reservationRemoveList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        for (Reservation reservation : hotel.getReservations()) {
            listReservationRemove.addElement(reservation.getGuestName());
        }
        JScrollPane scrollPane = new JScrollPane(reservationRemoveList);
        addToPanel(reservationRemoveList);

        rightPanel.revalidate();
        rightPanel.repaint();
    }
    /**
     *
     * This method sends the user to confirmationWindow.
     * in which the logic for removeHotel is placed.
     */
    public void removeHotel(){
        confirmationWindow();
    }
    /**
     * Adds a combo box to the right panel for selecting low-level information.
     */
    public void addLowInfoComboBox(){
        rightPanel.add(lowLevelJComboBox);
    }
    /**
     * Displays the first level of low-level information.
     *
     * This method prompts the user to select a date and then displays the total number of available and booked rooms for that date.
     */
    public void lowInfo1(){
        JLabel label = new JLabel("Select a date (1-31)");
        addToPanel(label);
        addToPanel(lowInfo1TF);
        addToPanel(lowlevel1Btn);

        rightPanel.revalidate();
        rightPanel.repaint();
    }
    /**
     * Displays the total number of available and booked rooms for a given date.
     *
     * This method calculates the total number of available and booked rooms for the given date in the given hotel,
     * and then displays this information to the user.
     *
     * @param day the day for which to display the room information
     * @param tempHotel the hotel for which to display the room information
     */
    public void lowInfo1Display(int day, Hotel tempHotel){
        ArrayList<Room> rooms = tempHotel.getRooms();
        int totalRooms = rooms.size();
        int bookedRooms = 0;
        for (Room room : rooms) {
            for (Reservation reservation : room.getReservations()) {
                int checkintemp = reservation.getCheckInDay(), checkoutTemp = reservation.getCheckOutDay();
                if (checkintemp <= day && checkoutTemp >= day) {
                    bookedRooms++;
                    break;
                }
            }
        }
        JLabel availableRoomsLabel = new JLabel("Total number of available rooms for the selected date: " + (totalRooms - bookedRooms));
        addToPanel(availableRoomsLabel);

        JLabel bookedRoomsLabel = new JLabel("Total number of booked rooms for the selected date: " + bookedRooms);
        addToPanel(bookedRoomsLabel);

        rightPanel.revalidate();
        rightPanel.repaint();
    }
    /**
     * Displays the second level of low-level information.
     *
     * This method prompts the user to select a room to view and then displays a list of available rooms in the given hotel.
     */
    public void lowInfo2(Hotel hotel){
        JLabel label = new JLabel("Select a room to View: ");
        addToPanel(label);
        listModelLowInfo.clear();
        roomListLowInfo.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        for (Room room : hotel.getRooms()) {
            listModelLowInfo.addElement(room.getName());
        }
        JScrollPane scrollPane = new JScrollPane(roomListLowInfo);
        addToPanel(roomListLowInfo);
        rightPanel.revalidate();
        rightPanel.repaint();
    }
    /**
     * Displays the details of a selected room.
     *
     * This method displays the name and price of the selected room, as well as its availability for each day of the month.
     *
     * @param roomSelect the name of the room to display
     * @param temp the hotel in which the room is located
     */
    public void lowInfo2Display(String roomSelect, Hotel temp){
        Room roomSelected = temp.findRoomByName(roomSelect);
        if (roomSelected!= null) {
            JLabel label = new JLabel("Room Name: " + roomSelected.getName() + " Room Price: " + roomSelected.calculatePrice());
            addToPanel(label);
            boolean[] availability = new boolean[31]; // array to store availability of each day
            for (int i = 0; i < 31; i++) {
                availability[i] = true; //all days are available
            }
            for (Reservation reservation : roomSelected.getReservations()) {
                for (int i = reservation.getCheckInDay(); i <= reservation.getCheckOutDay(); i++) {
                    availability[i - 1] = false; //there's a reservation
                }
            }
            DefaultListModel<String> listModel = new DefaultListModel<>();
            JList<String> availabilityList = new JList<>(listModel);
            availabilityList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
            JLabel label2 = new JLabel("Available On:");
            addToPanel(label2);
            for (int i = 0; i < 31; i++) {
                if (availability[i]) {
                    listModel.addElement(String.valueOf(i + 1));
                }
            }
            JScrollPane listScrollPane = new JScrollPane(availabilityList);
            addToPanel(listScrollPane);
            System.out.println();
        }
    }
    /**
     * Displays the third level of low-level information.
     *
     * This method prompts the user to select a reservation and then displays a list of reservations in the given hotel.
     */
    public void lowInfo3(Hotel hotel){
        JLabel label = new JLabel("Select a reservation:");
        addToPanel(label);
        listReservation.clear();
        reservationList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        for (Reservation reservation : hotel.getReservations()) {
                listReservation.addElement(reservation.getGuestName());
        }
        JScrollPane scrollPane = new JScrollPane(reservationList);
        addToPanel(reservationList);
        rightPanel.revalidate();
        rightPanel.repaint();
    }
    /**
     * Displays the details of a selected reservation.
     *
     * This method displays the guest name, room name, room price, booking dates, and total price for the selected reservation.
     *
     * @param reservationSelected the reservation to display
     * @param temp the hotel in which the reservation was made
     */
    public void lowInfo3Display(Reservation reservationSelected, Hotel temp){
        rightPanelClear();

        JLabel label1 = new JLabel("Guest Name:");
        JLabel label2 = new JLabel(reservationSelected.getGuestName());
        JLabel label0 = new JLabel("Room Name:");
        JLabel label3 = new JLabel(reservationSelected.getRoomInfo().getName());
        JLabel label4 = new JLabel("Room Price per Night:");
        JLabel label5 = new JLabel(""+reservationSelected.getRoomInfo().calculatePrice());
        JLabel label6 = new JLabel("Booked from Day:");
        JLabel label7 = new JLabel("Day " + reservationSelected.getCheckInDay()  + " to Day " + reservationSelected.getCheckOutDay());
        JLabel label8 = new JLabel("Total Price for the Booking:");
        System.out.println(reservationSelected.getRoomInfo());
        System.out.println(temp);
        double price = reservationSelected.calculateReservationPrice(reservationSelected.getRoomInfo(), temp);
        JLabel label9 = new JLabel(""+price);

        addToPanel(label0);
        addToPanel(label3);
        addToPanel(label1);
        addToPanel(label2);
        addToPanel(label4);
        addToPanel(label5);
        addToPanel(label6);
        addToPanel(label7);
        addToPanel(label8);
        addToPanel(label9);

        rightPanel.revalidate();
        rightPanel.repaint();
    }
    /**
     * Updates the date price modifier.
     *
     * This method prompts the user to select a day and enter a modifier to update the price for that day.
     */
    public void updateDatePriceModifier(){
        JLabel label = new JLabel("Which Day Price would you like to modify? (1-31)");
        addToPanel(label);
        rightPanel.add(dayModifierTF);
        JLabel label2 = new JLabel("Set the modifier (50%-150%; type the integer)");
        addToPanel(label2);
        rightPanel.add(dayModifierPriceTF);
        addToPanel(dayModifierBtn);

        rightPanel.revalidate();
        rightPanel.repaint();
    }
    /**
     * Simulates a booking.
     *
     * This method prompts the user to select a hotel to book in.
     */
    public void simBooking(){
        JLabel label = new JLabel("Which Hotel would you like to book in? ");
        addToPanel(label);
        addToPanel(hotelJComboBox);
        rightPanel.revalidate();
        rightPanel.repaint();

    }
    /**
     * Initiates the booking process for a hotel.
     *
     * This method prompts the user to select a room to book in the given hotel.
     *
     * @param hotel the hotel in which to book a room
     */
    public void hotelBookIn(Hotel hotel){
        rightPanelClear();
        JLabel label = new JLabel("Which Room would you like to book in?");
        JLabel label2 = new JLabel("(A-E) - Standard (Q-U) - Deluxe (V-Z) - Executive");

        addToPanel(label);
        addToPanel(label2);

        listModelBooking.clear();
        roomListBooking.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        for (Room room : hotel.getRooms()) {
            listModelBooking.addElement(room.getName());
        }
        JScrollPane scrollPane = new JScrollPane(roomListBooking);
        addToPanel(roomListBooking);
        rightPanelValidate();
    }
    /**
     * Checks in a guest and books a room.
     *
     * This method prompts the user to enter their name, check-in and check-out dates, and an optional discount code.
     */
    public void checkInOut(){
        JLabel label0 = new JLabel("Enter Your Name");
        addToPanel(label0);
        rightPanel.add(guestNameTF);
        JLabel label = new JLabel("Enter Check In Date: (1-31)");
        addToPanel(label);
        rightPanel.add(checkInTF);
        JLabel label2 = new JLabel("Enter Check Out Date: (1-31)");
        addToPanel(label2);
        rightPanel.add(checkOutTF);
        JLabel label3 = new JLabel("Optional: Add your discount code.");
        addToPanel(label3);
        rightPanel.add(discountTF);
        rightPanel.add(bookBtn);
    }
    /**
     * Adds an action listener to the "Add Room Confirm" button.
     * @param actionListener the action listener to add
     */
    public void addAddRoomConfirmBtnListener(ActionListener actionListener) {
            addRoomConfirmBtn.addActionListener(actionListener);
    }
    /**
     * Adds an action listener to the "dayModifierBtn" button.
     * @param actionListener the action listener to add
     */
    public void addDayModifierBtnListener(ActionListener actionListener) {
        dayModifierBtn.addActionListener(actionListener);
    }
    /**
     * Adds an action listener to the "bookBtn" button.
     * @param actionListener the action listener to add
     */
    public void addBookBtnListener(ActionListener actionListener) {
            bookBtn.addActionListener(actionListener);
    }
    /**
     * Adds an action listener to the "createHotelBtn" button.
     * @param actionListener the action listener to add
     */
    public void addCreateHotelBtnListener(ActionListener actionListener) {
            createHotelBtn.addActionListener(actionListener);
    }
    /**
     * Adds an action listener to the "viewHotelBtn" button.
     * @param actionListener the action listener to add
     */
    public void addViewHotelBtnListener(ActionListener actionListener) {
            viewHotelBtn.addActionListener(actionListener);
    }
    /**
     * Adds an action listener to the "manageHotelBtn" button.
     * @param actionListener the action listener to add
     */
    public void addManageHotelBtnListener(ActionListener actionListener) {
            manageHotelBtn.addActionListener(actionListener);
    }
    /**
     * Adds an action listener to the "simBookingBtn" button.
     * @param actionListener the action listener to add
     */
    public void addSimBookingBtnListener(ActionListener actionListener) {
            simBookingBtn.addActionListener(actionListener);
    }
    /**
     * Adds an action listener to the "createBtn" button.
     * @param actionListener the action listener to add
     */
    public void addCreateBtnListener(ActionListener actionListener) {
            createBtn.addActionListener(actionListener);
    }
    /**
     * Adds an ListSelectionListener to the "roomListBooking" list.
     * @param listSelectionListener the listener to add
     */
    public void addRoomListBookingListener(ListSelectionListener listSelectionListener) {
            roomListBooking.addListSelectionListener(listSelectionListener);
    }
    /**
     * Adds an ListSelectionListener to the "roomListLowInfo" list.
     * @param listSelectionListener the listener to add
     */
    public void addRoomListLowInfoListener(ListSelectionListener listSelectionListener) {
        roomListLowInfo.addListSelectionListener(listSelectionListener);
    }
    /**
     * Adds an ListSelectionListener to the "reservationList" list.
     * @param listSelectionListener the listener to add
     */
    public void addReservationListListener(ListSelectionListener listSelectionListener) {
        reservationList.addListSelectionListener(listSelectionListener);
    }
    /**
     * Adds an ListSelectionListener to the "reservationRemoveList" list.
     * @param listSelectionListener the listener to add
     */
    public void addReservationRemoveListListener(ListSelectionListener listSelectionListener) {
        reservationRemoveList.addListSelectionListener(listSelectionListener);
    }
    /**
     * Adds an ListSelectionListener to the "removeRoomList" list.
     * @param listSelectionListener the listener to add
     */
    public void addRemoveRoomListListener(ListSelectionListener listSelectionListener) {
        removeRoomList.addListSelectionListener(listSelectionListener);
    }
    /**
     * Adds an action listener to the "yesBtn" button.
     * @param actionListener the action listener to add
     */
    public void addYesBtnListener(ActionListener actionListener) {
            yesBtn.addActionListener(actionListener);
    }
    /**
     * Adds an action listener to the "noBtn" button.
     * @param actionListener the action listener to add
     */
    public void addNoBtnListener(ActionListener actionListener) {
            noBtn.addActionListener(actionListener);
    }
    /**
     * Adds an action listener to the "standardRB" button.
     * @param actionListener the action listener to add
     */
    public void addStandardRBListener(ActionListener actionListener) {
            standardRB.addActionListener(actionListener);
    }
    /**
     * Adds an action listener to the "deluxeRB" button.
     * @param actionListener the action listener to add
     */
    public void addDeluxeRBListener(ActionListener actionListener) {
            deluxeRB.addActionListener(actionListener);
    }
    /**
     * Adds an action listener to the "executiveRB" button.
     * @param actionListener the action listener to add
     */
    public void addExecutiveRBListener(ActionListener actionListener) {
            executiveRB.addActionListener(actionListener);
    }
    /**
     * Adds an action listener to the "confirmBtn" button.
     * @param actionListener the action listener to add
     */
    public void addConfirmBtnListener(ActionListener actionListener) {
            confirmBtn.addActionListener(actionListener);
    }
    /**
     * Adds an Empty Panel
     */
    public void addEmpty(){
        rightPanel.add(emptyPanel);
    }
    /**
     * Adds an action listener to the "hotelJComboBox" comboBox.
     * @param actionListener the action listener to add
     */
    public void addHotelJComboBoxListener(ActionListener actionListener) {
            hotelJComboBox.addActionListener(actionListener);
    }
    /**
     * Adds an action listener to the "lowLevelJComboBox" comboBox.
     * @param actionListener the action listener to add
     */
    public void addLowLevelJComboBoxListener(ActionListener actionListener) {
            lowLevelJComboBox.addActionListener(actionListener);
    }
    /**
     * Adds an action listener to the "highlevelBtn" button.
     * @param actionListener the action listener to add
     */
    public void addHighLevelBtnListener(ActionListener actionListener) {
            highlevelBtn.addActionListener(actionListener);
    }
    /**
     * Adds an action listener to the "changeHotelNameBtn" button.
     * @param actionListener the action listener to add
     */
    public void addChangeHotelNameBtnListener(ActionListener actionListener) {
            changeHotelNameBtn.addActionListener(actionListener);
    }
    /**
     * Adds an action listener to the "newPriceBtn" button.
     * @param actionListener the action listener to add
     */
    public void addNewPriceBtnListener(ActionListener actionListener) {
        newPriceBtn.addActionListener(actionListener);
    }
    /**
     * Adds an action listener to the "addRoomBtn" button.
     * @param actionListener the action listener to add
     */
    public void addAddRoomBtnListener(ActionListener actionListener) {
            addRoomBtn.addActionListener(actionListener);
    }
    /**
     * Adds an action listener to the "removeRoomBtn" button.
     * @param actionListener the action listener to add
     */
    public void addRemoveRoomBtnListener(ActionListener actionListener) {
            removeRoomBtn.addActionListener(actionListener);
    }
    /**
     * Adds an action listener to the "updateBasePricingBtn" button.
     * @param actionListener the action listener to add
     */
    public void addUpdateBasePricingBtnListener(ActionListener actionListener) {
            updateBasePricingBtn.addActionListener(actionListener);
    }
    /**
     * Adds an action listener to the "removeReservationBtn" button.
     * @param actionListener the action listener to add
     */
    public void addRemoveReservationBtnListener(ActionListener actionListener) {
            removeReservationBtn.addActionListener(actionListener);
    }
    /**
     * Adds an action listener to the "removeHotelBtn" button.
     * @param actionListener the action listener to add
     */
    public void addRemoveHotelBtnListener(ActionListener actionListener) {
            removeHotelBtn.addActionListener(actionListener);
    }
    /**
     * Adds an action listener to the "updateDatePriceModifierBtn" button.
     * @param actionListener the action listener to add
     */
    public void addUpdateDatePriceModifierBtnListener(ActionListener actionListener) {
            updateDatePriceModifierBtn.addActionListener(actionListener);
    }
    /**
     * Adds an action listener to the "lowlevelBtn" button.
     * @param actionListener the action listener to add
     */
    public void addLowLevelBtnListener(ActionListener actionListener) {
            lowlevelBtn.addActionListener(actionListener);
    }
    /**
     * Adds an action listener to the "lowlevel1Btn" button.
     * @param actionListener the action listener to add
     */
    public void addLowLevel1BtnListener(ActionListener actionListener) {
            lowlevel1Btn.addActionListener(actionListener);
    }
    /**
     * clears the right panel
     */
    public void rightPanelClear(){
        rightPanel.removeAll();
        rightPanel.setLayout(new GridLayout(0, 1));
        rightPanel.revalidate();
        rightPanel.repaint();
    }
    /**
     * refreshes the right panel
     */
    public void rightPanelValidate(){
        rightPanel.revalidate();
        rightPanel.repaint();
    }
    public String getHotelName() {
        return this.hotelNameTF.getText();
    }
    public String getNewPrice(){
        return this.newPriceTF.getText();
    }
    public String getStandardRoom() {
        return this.standardTF.getText();
    }
    public String getDayModifier(){
        return this.dayModifierTF.getText();
    }
    public String getDeluxeRoom() {
        return this.deluxeTF.getText();
    }
    public String getExecutiveRoom() {
        return this.executiveTF.getText();
    }
    public String getNameChange(){
        return this.nameChangeTF.getText();
    }
    public String getAddRoom(){
        return this.addRoomTF.getText();
    }
    public String getLowInfo1(){
        return this.lowInfo1TF.getText();
    }
    public String getCheckIn(){
        return this.checkInTF.getText();
    }
    public String getCheckOut(){
        return this.checkOutTF.getText();
    }
    public String getDiscount(){
        return this.discountTF.getText();
    }
    public String getGuestName(){
        return this.guestNameTF.getText();
    }
    public String getDayModifierPrice(){
        return this.dayModifierPriceTF.getText();
    }
    public void setFeedbackLBText(String text) {
        this.feedbackLB.setText(text);
    }
    public void setFeedbackLB(){
        rightPanel.add(feedbackLB);
    }
    public JList<Hotel> getHotelJList() {
        return this.hotelJList;
    }
    public JComboBox<Hotel> getHotelJComboBox() {
        return this.hotelJComboBox;
    }
    public JComboBox<String> getLowLevelJComboBox(){
        return this.lowLevelJComboBox;
    }
    public JList<String> getRoomListBooking(){
        return this.roomListBooking;
    }
    public JList<String> getRoomListLowInfo(){
        return this.roomListLowInfo;
    }
    public JList<String> getReservationList(){
        return this.reservationList;
    }
    public JList<String> getReservationRemoveList(){
        return this.reservationRemoveList;
    }
    public JList<String> getRemoveRoomList(){
        return this.removeRoomList;
    }
    public void removeFeedbackLB(){
        rightPanel.remove(feedbackLB);
    }
    /**
     * clears all textfields
     */
    public void clearAllTextFields() {
        this.hotelNameTF.setText("");
        this.standardTF.setText("");
        this.deluxeTF.setText("");
        this.executiveTF.setText("");
        this.nameChangeTF.setText("");
        this.addRoomTF.setText("");
        this.checkInTF.setText("");
        this.checkOutTF.setText("");
        this.discountTF.setText("");
        this.guestNameTF.setText("");
        this.lowInfo1TF.setText("");
        this.dayModifierTF.setText("");
        this.dayModifierPriceTF.setText("");
    }
    /**
     * adds to the right panel with a certain format
     */
    public void addToPanel(JComponent component){
        JPanel labelPanel1 = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.CENTER;
        labelPanel1.add(component, gbc);
        rightPanel.add(labelPanel1);
    }
    /**
     * Adds a hotel selected label
     */
    public void hotelSelectedLabel(Hotel hotel){
        JLabel label = new JLabel("Hotel Selected: "+ hotel);
        addToPanel(label);
    }
    /**
     * Adds both view info buttons
     */
    public void viewInfo(){
        rightPanel.add(highlevelBtn);
        rightPanel.add(lowlevelBtn);
    }
    /**
     * Closes the confirm window.
     */
    public void closeConfirm(){
        confirm.dispose();
    }
    /**
     * Adds a message to the panel.
     *
     * This method creates a new JLabel with the given message and adds it to the panel.
     *
     * @param message the message to display
     */
    public void addMessage(String message){
        JLabel label = new JLabel(message);
        addToPanel(label);
    }
    /**
     * Displays high-level information about a hotel.
     *
     * This method displays the hotel's name, number of rooms, and a list of room names. It also calculates and displays the estimated earnings for the month.
     *
     * @param hotel the hotel to display information about
     */
    public void highLevelInfo(Hotel hotel){
        JLabel label = new JLabel("Hotel name is: "+ hotel);
        addToPanel(label);
        JLabel label2 = new JLabel("Number of Rooms is: "+ hotel.getRooms().size());
        addToPanel(label2);
        listModelInfo.clear();
        roomListInfo.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        for (Room room : hotel.getRooms()) {
            listModelInfo.addElement(room.getName());
        }
        JScrollPane scrollPane = new JScrollPane(roomListInfo);
        //roomListInfo.setEnabled(false);
        double totalEarnings = 0;
        for (Reservation reservation : hotel.getReservations()) {
            int nights = reservation.getCheckOutDay() - reservation.getCheckInDay()+1;
            double totalPrice = nights * reservation.getRoomInfo().calculatePrice();
            totalEarnings += totalPrice;
        }
        JLabel label3 = new JLabel("Estimated earnings for the month: " + totalEarnings);
        addToPanel(roomListInfo);
        addToPanel(label3);
        rightPanelValidate();
    }
}