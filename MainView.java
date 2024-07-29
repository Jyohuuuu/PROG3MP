
import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MainView {
    private JFrame mainFrame;
    private JLabel createHotelLB,feedbackLB,emptyLB;
    private JButton createHotelBtn,viewHotelBtn,manageHotelBtn,simBookingBtn,createBtn,highlevelBtn,lowlevelBtn,changeHotelNameBtn,addRoomBtn,removeRoomBtn,updateBasePricingBtn,removeReservationBtn,removeHotelBtn,updateDatePriceModifierBtn;
    private JTextField mainTF,hotelNameTF,standardTF,deluxeTF,executiveTF;
    private JPanel leftPanel, rightPanel, emptyPanel;
    private JList<Hotel> hotelJList;
    private JComboBox<Hotel> hotelJComboBox,highLevelJComboBox,lowLevelJComboBox;

    public MainView() {
        this.mainFrame = new JFrame("Hotel Reservation System");

        this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.mainFrame.setLayout(new BorderLayout());
        this.mainFrame.setSize(900, 800);
        this.mainFrame.setResizable(false);

        feedbackLB = new JLabel();
        leftPanel = new JPanel();
        highlevelBtn = new JButton("High level Information");
        highlevelBtn.setPreferredSize(new Dimension(200, 30));

        lowlevelBtn = new JButton("Low level Information");
        lowlevelBtn.setPreferredSize(new Dimension(200, 30));

        changeHotelNameBtn = new JButton("Change the Name of the Hotel");
        changeHotelNameBtn.setPreferredSize(new Dimension(250, 25));

        addRoomBtn = new JButton("Add Room(s)");
        addRoomBtn.setPreferredSize(new Dimension(250, 25));

        removeRoomBtn = new JButton("Remove Rooms");
        removeRoomBtn.setPreferredSize(new Dimension(250, 25));

        updateBasePricingBtn = new JButton("Update Base Pricing of a Room");
        updateBasePricingBtn.setPreferredSize(new Dimension(250, 25));

        removeReservationBtn = new JButton("Remove Reservation");
        removeReservationBtn.setPreferredSize(new Dimension(250, 25));

        removeHotelBtn = new JButton("Remove Hotel");
        removeHotelBtn.setPreferredSize(new Dimension(250, 25));

        updateDatePriceModifierBtn = new JButton("Update the Date Price Modifier");
        updateDatePriceModifierBtn.setPreferredSize(new Dimension(250, 25));

        highLevelJComboBox = new JComboBox<Hotel>();
        lowLevelJComboBox = new JComboBox<Hotel>();

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
    public void viewHotel(){

        //feedbackLB.setPreferredSize(new Dimension(200, 30));
        //rightPanel.add(feedbackLB);

        JLabel viewLB = new JLabel("What hotel would you like to view: ");
        viewLB.setFont(new Font("Arial", Font.BOLD, 24));
        JPanel labelPanel5 = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.CENTER;
        labelPanel5.add(viewLB, gbc);
        rightPanel.add(labelPanel5);

        //rightPanel.add(hotelJList);
        //rightPanel.add(hotelJComboBox);
        addToPanel(hotelJComboBox);

        rightPanel.revalidate();
        rightPanel.repaint();
    }
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
    public void changeNameHotel(){
        JLabel label = new JLabel("Enter New Hotel Name: ");
        addToPanel(label);
        JTextField textField = new JTextField("");
        textField.setPreferredSize(new Dimension(200,30));
        rightPanel.add(textField);
    }
    public void simBooking(){

        rightPanel.revalidate();
        rightPanel.repaint();

    }
    public void addCreateHotelBtnListener(ActionListener actionListener) {
        if (createHotelBtn != null) {
            createHotelBtn.addActionListener(actionListener);
        } else {
            System.out.println("createHotelBtn is null!");
        }
    }
    public void addViewHotelBtnListener(ActionListener actionListener) {
        if (viewHotelBtn != null) {
            viewHotelBtn.addActionListener(actionListener);
        } else {
            System.out.println("viewHotelBtn is null!");
        }
    }
    public void addManageHotelBtnListener(ActionListener actionListener) {
        if (manageHotelBtn != null) {
            manageHotelBtn.addActionListener(actionListener);
        } else {
            System.out.println("manageHotelBtn is null!");
        }
    }
    public void addSimBookingBtnListener(ActionListener actionListener) {
        if (simBookingBtn != null) {
            simBookingBtn.addActionListener(actionListener);
        } else {
            System.out.println("simBookingBtn is null!");
        }
    }
    public void addCreateBtnListener(ActionListener actionListener) {
        if (createBtn != null) {
            createBtn.addActionListener(actionListener);
        } else {
            System.out.println("createBtn is null!");
        }
    }
    public void addHotelJListListener(ListSelectionListener listSelectionListener) {
        if (hotelJList != null) {
            hotelJList.addListSelectionListener(listSelectionListener);
        } else {
            System.out.println("hotelJList is null!");
        }
    }
    /*
    public void (ActionListener actionListener) {
        if ( != null) {
            .addActionListener(actionListener);
        } else {
            System.out.println(" is null!");
        }
    }
     */
    public void addEmpty(){
        rightPanel.add(emptyPanel);
    }
    public void addHotelJComboBoxListener(ActionListener actionListener) {
        if (hotelJComboBox != null) {
            hotelJComboBox.addActionListener(actionListener);
        } else {
            System.out.println("hotelJComboBox is null!");
        }
    }
    public void addHighLevelJComboBoxListener(ActionListener actionListener) {
        if (highLevelJComboBox != null) {
            highLevelJComboBox.addActionListener(actionListener);
        } else {
            System.out.println("highLevelJComboBox is null!");
        }
    }
    public void addLowLevelJComboBoxListener(ActionListener actionListener) {
        if (lowLevelJComboBox != null) {
            lowLevelJComboBox.addActionListener(actionListener);
        } else {
            System.out.println("lowLevelJComboBox is null!");
        }
    }
    public void addHighLevelBtnListener(ActionListener actionListener) {
        if (highlevelBtn != null) {
            highlevelBtn.addActionListener(actionListener);
            System.out.println("high called!");
        } else {
            System.out.println("highlevelBtn is null!");
        }
    }
    public void addChangeHotelNameBtnListener(ActionListener actionListener) {
        if (changeHotelNameBtn!= null) {
            changeHotelNameBtn.addActionListener(actionListener);
            System.out.println("changeHotelNameBtn called!");
        } else {
            System.out.println("changeHotelNameBtn is null!");
        }
    }
    public void addAddRoomBtnListener(ActionListener actionListener) {
        if (addRoomBtn!= null) {
            addRoomBtn.addActionListener(actionListener);
            System.out.println("addRoomBtn called!");
        } else {
            System.out.println("addRoomBtn is null!");
        }
    }
    public void addRemoveRoomBtnListener(ActionListener actionListener) {
        if (removeRoomBtn!= null) {
            removeRoomBtn.addActionListener(actionListener);
            System.out.println("removeRoomBtn called!");
        } else {
            System.out.println("removeRoomBtn is null!");
        }
    }
    public void addUpdateBasePricingBtnListener(ActionListener actionListener) {
        if (updateBasePricingBtn!= null) {
            updateBasePricingBtn.addActionListener(actionListener);
            System.out.println("updateBasePricingBtn called!");
        } else {
            System.out.println("updateBasePricingBtn is null!");
        }
    }
    public void addRemoveReservationBtnListener(ActionListener actionListener) {
        if (removeReservationBtn!= null) {
            removeReservationBtn.addActionListener(actionListener);
            System.out.println("removeReservationBtn called!");
        } else {
            System.out.println("removeReservationBtn is null!");
        }
    }
    public void addRemoveHotelBtnListener(ActionListener actionListener) {
        if (removeHotelBtn!= null) {
            removeHotelBtn.addActionListener(actionListener);
            System.out.println("removeHotelBtn called!");
        } else {
            System.out.println("removeHotelBtn is null!");
        }
    }
    public void addUpdateDatePriceModifierBtnListener(ActionListener actionListener) {
        if (updateDatePriceModifierBtn!= null) {
            updateDatePriceModifierBtn.addActionListener(actionListener);
            System.out.println("updateDatePriceModifierBtn called!");
        } else {
            System.out.println("updateDatePriceModifierBtn is null!");
        }
    }
    public void addLowLevelBtnListener(ActionListener actionListener) {
        if (lowlevelBtn!= null) {
            lowlevelBtn.addActionListener(actionListener);
            System.out.println("lowlevelBtn called!");
        } else {
            System.out.println("lowlevelBtn is null!");
        }
    }
    public void rightPanelClear(){
        rightPanel.removeAll();
        rightPanel.setLayout(new GridLayout(0, 1));
        rightPanel.revalidate();
        rightPanel.repaint();
    }
    public void rightPanelValidate(){
        rightPanel.revalidate();
        rightPanel.repaint();
    }
    public JPanel getRightPanel() {
        return rightPanel;
    }
    public String getHotelName() {
        return this.hotelNameTF.getText();
    }
    public String getStandardRoom() {
        return this.standardTF.getText();
    }
    public String getDeluxeRoom() {
        return this.deluxeTF.getText();
    }
    public String getExecutiveRoom() {
        return this.executiveTF.getText();
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
    public void removeFeedbackLB(){
        rightPanel.remove(feedbackLB);
    }
    public void clearTextFieldsCreate() {
        this.hotelNameTF.setText("");
        this.standardTF.setText("");
        this.deluxeTF.setText("");
        this.executiveTF.setText("");
    }
    public void addToPanel(JComponent component){
        JPanel labelPanel1 = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.CENTER;
        labelPanel1.add(component, gbc);
        rightPanel.add(labelPanel1);
    }
    public void hotelSelectedLabel(Hotel hotel){
        JLabel label = new JLabel("Hotel Selected: "+ hotel);
        addToPanel(label);
    }
    public void viewInfo(){
        rightPanel.add(highlevelBtn);
        rightPanel.add(lowlevelBtn);
    }
    public void highLevelInfo(Hotel hotel){
        JLabel label = new JLabel("Hotel name is: "+ hotel);
        addToPanel(label);
        JLabel label2 = new JLabel("Number of Rooms is: "+ hotel.getRooms().size());
        addToPanel(label2);
        DefaultListModel<String> listModel = new DefaultListModel<>();
        JList<String> roomList = new JList<>(listModel);
        for (Room room : hotel.getRooms()) {
            listModel.addElement(room.getName());
        }
        JScrollPane scrollPane = new JScrollPane(roomList);
        double totalEarnings = 0;
        for (Reservation reservation : hotel.getReservations()) {
            int nights = reservation.getCheckOutDay() - reservation.getCheckInDay()+1;
            double totalPrice = nights * reservation.getRoomInfo().getPrice();
            totalEarnings += totalPrice;
        }
        JLabel label3 = new JLabel("Estimated earnings for the month: " + totalEarnings);
        addToPanel(roomList);
        addToPanel(label3);
    }
}