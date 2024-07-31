import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class HRSController {
    private MainView mainView;
    private HRSModel hrsModel;

    public HRSController (MainView mainView, HRSModel hrsModel){
        this.mainView = mainView;
        this.hrsModel = hrsModel;

        /**
         * Adds an action listener to the high level button.
         *
         * When the high level button is clicked, this listener is triggered. It clears the right panel,
         * gets the temporary hotel from the hotel reservation system model, and displays the high level
         * information for the hotel if it is not null.
         */
        this.mainView.addHighLevelBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("High level button clicked");
                mainView.rightPanelClear();
                mainView.rightPanelValidate();
                Hotel tempHotel = hrsModel.getTempHotel();
                if (tempHotel!= null) {
                    mainView.highLevelInfo(tempHotel);
                    mainView.rightPanelValidate();
                    System.out.println("High level info displayed for hotel: " + tempHotel.getName());
                } else {
                    System.out.println("No hotel selected");
                }
                mainView.rightPanelValidate();
            }
        });

        this.mainView.addLowLevelBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /**
                 * Clears the right panel, adds a low level info combo box, and validates the right panel.
                 */
                mainView.rightPanelClear();
                mainView.addLowInfoComboBox();
                mainView.rightPanelValidate();
            }
        });
        this.mainView.addCreateHotelBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /**
                 * Clears the right panel, transitions to createHotel, and validates the right panel.
                 */
                mainView.rightPanelClear();
                mainView.rightPanelValidate();
                mainView.createHotel();
            }
        });
        this.mainView.addViewHotelBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /**
                 * Clears the right panel, gets the list of hotels, and displays the view hotel panel.
                 * If the list of hotels is empty, it displays addEmpty.
                 */
                mainView.rightPanelClear();
                ArrayList<Hotel> tempList = hrsModel.getHotelList();
                if (tempList.isEmpty()){
                    mainView.addEmpty();
                    mainView.rightPanelValidate();
                } else {
                    hrsModel.setIdentifier(2);
                    hrsModel.setJList(mainView.getHotelJList());
                    hrsModel.setHotelJComboBox(mainView.getHotelJComboBox());
                    mainView.viewHotel();
                    mainView.rightPanelValidate();
                }
            }
        });
        this.mainView.addHotelJComboBoxListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /**
                 * Gets the selected hotel, sets it as the temporary hotel, and displays the appropriate panel based on the identifier.
                 */
                JComboBox<Hotel> temp = mainView.getHotelJComboBox();
                Hotel selectedItem = (Hotel) temp.getSelectedItem();
                hrsModel.setTempHotel(selectedItem);
                System.out.println("Selected item: " + selectedItem);
                System.out.println("Identifier: " + hrsModel.getIdentifier());
                switch (hrsModel.getIdentifier()){
                    case 2:
                        mainView.rightPanelClear();
                        mainView.hotelSelectedLabel(selectedItem);
                        mainView.viewInfo();
                        mainView.rightPanelValidate();
                        break;
                    case 3:
                        mainView.rightPanelClear();
                        mainView.hotelSelectedLabel(selectedItem);
                        mainView.manageHotel();
                        break;
                    case 4:
                        mainView.rightPanelClear();
                        mainView.hotelSelectedLabel(selectedItem);
                        mainView.hotelBookIn(hrsModel.getTempHotel());
                        break;

                }
            }
        });
        this.mainView.addManageHotelBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /**
                 * Clears the right panel, sets the identifier to 4, and displays the Manage Hotel panel.
                 * If the list of hotels is empty, it displays addEmpty.
                 */
                mainView.rightPanelClear();
                mainView.rightPanelValidate();
                ArrayList<Hotel> tempList = hrsModel.getHotelList();
                hrsModel.setIdentifier(3);
                if (tempList.isEmpty()){
                    mainView.addEmpty();
                    mainView.rightPanelValidate();
                } else {
                    hrsModel.setHotelJComboBox(mainView.getHotelJComboBox());
                    mainView.manageHotel();
                }
            }
        });
        this.mainView.addSimBookingBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /**
                 * Clears the right panel, sets the identifier to 4, and displays the simulate booking panel.
                 * If the list of hotels is empty, it displays addEmpty.
                 */
                mainView.rightPanelClear();
                mainView.rightPanelValidate();
                ArrayList<Hotel> tempList = hrsModel.getHotelList();
                if (tempList.isEmpty()){
                    mainView.addEmpty();
                    mainView.rightPanelValidate();
                } else {
                    hrsModel.setIdentifier(4);
                    hrsModel.setHotelJComboBox(mainView.getHotelJComboBox());
                    mainView.simBooking();
                }
            }
        });
        this.mainView.addCreateBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /**
                 * Creates a new hotel with the given details.
                 *
                 * @param standardRooms the number of standard rooms
                 * @param deluxeRooms the number of deluxe rooms
                 * @param executiveRooms the number of executive rooms
                 * @param hotelName the name of the hotel
                 */
                int standardRooms = Integer.parseInt(mainView.getStandardRoom());
                int deluxeRooms = Integer.parseInt(mainView.getDeluxeRoom());
                int executiveRooms = Integer.parseInt(mainView.getExecutiveRoom());
                boolean checker = hrsModel.isHotelNameUnique(mainView.getHotelName());//checks if name is unique
                if (checker) {
                    if (standardRooms+deluxeRooms+executiveRooms>50) {
                        mainView.setFeedbackLBText("Invalid Rooms");
                        mainView.clearAllTextFields();
                    } else {
                        boolean result = hrsModel.addHotel(mainView.getHotelName(),standardRooms,deluxeRooms,executiveRooms);

                        if(result) {
                            mainView.setFeedbackLBText("Hotel: "+mainView.getHotelName()+" has been created");
                            mainView.clearAllTextFields();
                        } else {
                            mainView.setFeedbackLBText("Hotel Creation failed :(");
                        }
                    }
                } else {
                    mainView.setFeedbackLBText("Hotel Name is not Unique");
                    mainView.clearAllTextFields();
                }
            }
        });

        this.mainView.addLowLevelJComboBoxListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /**
                 * Displays the corresponding panel based on the selected item.
                 */
                String selected = (String) mainView.getLowLevelJComboBox().getSelectedItem();
                switch (selected){
                    case "Total number of available and booked rooms for a selected date":
                        mainView.rightPanelClear();
                        mainView.lowInfo1();
                        mainView.rightPanelValidate();
                        break;
                    case "Room Information":
                        mainView.rightPanelClear();
                        mainView.lowInfo2(hrsModel.getTempHotel());
                        mainView.rightPanelValidate();
                        break;
                    case "Reservation Information":
                        mainView.rightPanelClear();
                        if (hrsModel.getTempHotel().getReservations().size()==0){
                            mainView.addMessage("No Reservations Available");
                        } else {
                            mainView.lowInfo3(hrsModel.getTempHotel());
                        }
                        mainView.rightPanelValidate();
                        break;
                }
            }
        });

        this.mainView.addReservationListListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                /**
                 * Reservation List logic goes to LowInfo3
                 */
                if (!e.getValueIsAdjusting()) {
                    JList<String> roomList = mainView.getReservationList();
                    String selectedReservation = roomList.getSelectedValue();
                    mainView.rightPanelClear();
                    Reservation r = hrsModel.findReservationByGuestName(selectedReservation);
                    mainView.lowInfo3Display(r,hrsModel.getTempHotel());
                    mainView.rightPanelValidate();
                }
            }
        });
        this.mainView.addReservationRemoveListListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                /**
                 * Reservation List logic goes to confirmationWindow.
                 */
                if (!e.getValueIsAdjusting()) {
                    JList<String> roomList = mainView.getReservationRemoveList();
                    String selectedReservation = roomList.getSelectedValue();
                    mainView.rightPanelClear();
                    Reservation r = hrsModel.findReservationByGuestName(selectedReservation);
                    hrsModel.setTempReservation(r);
                    mainView.confirmationWindow();
                    mainView.rightPanelValidate();
                }
            }
        });
        this.mainView.addChangeHotelNameBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /**
                 * Goes to Change Name Hotel.
                 */
                mainView.rightPanelClear();
                mainView.changeNameHotel();
                mainView.rightPanelValidate();
            }
        });
        this.mainView.addConfirmBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean checker = hrsModel.isHotelNameUnique(mainView.getNameChange());
                if (checker){
                    mainView.confirmationWindow();
                    hrsModel.setConfirmationID(1);
                }
            }
        });

        this.mainView.addAddRoomBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainView.rightPanelClear();
                hrsModel.setConfirmationID(2);
                mainView.addRooms();
                mainView.rightPanelValidate();
            }
        });
        this.mainView.addStandardRBListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hrsModel.setAddRoomID(1);
            }
        });
        this.mainView.addDeluxeRBListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hrsModel.setAddRoomID(2);
            }
        });
        this.mainView.addExecutiveRBListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hrsModel.setAddRoomID(3);

            }
        });
        this.mainView.addAddRoomConfirmBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hrsModel.setConfirmationID(2);
                mainView.confirmationWindow();

            }
        });
        this.mainView.addRemoveRoomBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainView.rightPanelClear();
                hrsModel.setConfirmationID(3);
                mainView.removeRooms(hrsModel.getTempHotel());
                mainView.rightPanelValidate();
            }
        });
        this.mainView.addUpdateBasePricingBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainView.rightPanelClear();
                hrsModel.setConfirmationID(4);
                mainView.updateBasePricing(hrsModel.getTempHotel());
                mainView.rightPanelValidate();
            }
        });
        this.mainView.addRemoveReservationBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainView.rightPanelClear();
                hrsModel.setConfirmationID(5);
                mainView.removeReservation(hrsModel.getTempHotel());
                mainView.rightPanelValidate();
            }
        });
        this.mainView.addRemoveHotelBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainView.rightPanelClear();
                hrsModel.setConfirmationID(6);
                mainView.removeHotel();
                mainView.rightPanelValidate();
            }
        });
        this.mainView.addUpdateDatePriceModifierBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainView.rightPanelClear();
                hrsModel.setConfirmationID(7);
                mainView.updateDatePriceModifier();
                mainView.rightPanelValidate();
            }
        });
        this.mainView.addYesBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /**
                 * Confirmation for the 7 different options for manageHotel
                 */
                int confirm = hrsModel.getConfirmationID();
                switch (confirm){
                    case 1:
                        Hotel selectedItem = (Hotel) hrsModel.getTempHotel();
                        selectedItem.setName(mainView.getNameChange());
                        mainView.rightPanelClear();
                        mainView.closeConfirm();
                        mainView.addMessage("You changed the hotel's name to "+mainView.getNameChange());
                        mainView.rightPanelValidate();
                        break;
                    case 2:
                        if(hrsModel.addRooms(Integer.parseInt(mainView.getAddRoom()))){
                            mainView.rightPanelClear();
                            mainView.closeConfirm();
                            mainView.addMessage("Successfully added rooms");
                            mainView.rightPanelValidate();
                        } else {
                            mainView.rightPanelClear();
                            mainView.closeConfirm();
                            mainView.addMessage("Invalid amount of rooms entered");
                            mainView.rightPanelValidate();
                        }
                        break;
                    case 3:
                        if (hrsModel.getTempRoom().hasActiveReservation()){
                            mainView.rightPanelClear();
                            mainView.closeConfirm();
                            mainView.addMessage("Cannot Remove Room: Active Reservation");
                            mainView.rightPanelValidate();
                        } else {
                            mainView.rightPanelClear();
                            mainView.closeConfirm();
                            hrsModel.getTempHotel().removeRoom(hrsModel.getTempRoom());
                            mainView.addMessage("Successfully removed the selected room");
                            mainView.rightPanelValidate();
                        }
                        break;
                    case 4:
                        int value = Integer.parseInt(mainView.getNewPrice());
                        if (hrsModel.newPrice(value)){
                            mainView.rightPanelClear();
                            mainView.closeConfirm();
                            mainView.addMessage("Successfully changed the base pricing to "+value);
                        } else {
                            mainView.rightPanelClear();
                            mainView.closeConfirm();
                            mainView.addMessage("Invalid Pricing");
                        }
                        mainView.rightPanelValidate();
                        break;
                    case 5:
                        mainView.rightPanelClear();
                        mainView.closeConfirm();
                        hrsModel.removeReservations();
                        mainView.addMessage("Successfully removed the reservation");
                        mainView.rightPanelValidate();
                        break;
                    case 6:
                        Hotel hotelRemove = (Hotel) hrsModel.getTempHotel();
                        hrsModel.removeHotel(hotelRemove);
                        mainView.rightPanelClear();
                        mainView.closeConfirm();
                        mainView.addMessage("You successfully removed Hotel: "+ hotelRemove.getName());
                        mainView.rightPanelValidate();
                        break;
                    case 7:
                        int modifier = Integer.parseInt(mainView.getDayModifierPrice());
                        int modifyDay = Integer.parseInt(mainView.getDayModifier());
                        mainView.rightPanelClear();
                        mainView.closeConfirm();
                        if (modifier < 50 || modifier > 150) {
                            mainView.addMessage("Invalid Modifier Entered.");
                        } else {
                            hrsModel.getTempHotel().setDayModifier(modifyDay - 1, modifier);
                            mainView.addMessage("You successfully changed the Day Modifier of Day "+modifyDay+" to "+modifier+"%");
                        }
                        mainView.rightPanelValidate();
                        break;

                }
                mainView.clearAllTextFields();
            }
        });
        this.mainView.addNoBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /**
                 * Confirmation for the 7 different options for manageHotel
                 */
                int confirm = hrsModel.getConfirmationID();
                switch (confirm){
                    case 1:
                        mainView.closeConfirm();
                        mainView.rightPanelClear();
                        mainView.addMessage("You have Cancelled the change.");
                        mainView.rightPanelValidate();
                        break;
                    case 2:
                        mainView.closeConfirm();
                        mainView.rightPanelClear();
                        mainView.addMessage("You have Cancelled adding rooms.");
                        mainView.rightPanelValidate();
                    case 3:
                        mainView.closeConfirm();
                        mainView.rightPanelClear();
                        mainView.addMessage("You have Cancelled removing rooms.");
                        mainView.rightPanelValidate();
                        break;
                    case 4:
                        mainView.closeConfirm();
                        mainView.rightPanelClear();
                        mainView.addMessage("You have Cancelled changing the base price.");
                        mainView.rightPanelValidate();
                        break;
                    case 5:
                        mainView.closeConfirm();
                        mainView.rightPanelClear();
                        mainView.addMessage("You have Cancelled removing the reservation.");
                        mainView.rightPanelValidate();
                    case 6:
                        mainView.closeConfirm();
                        mainView.rightPanelClear();
                        mainView.addMessage("You have Cancelled removing the Hotel.");
                        mainView.rightPanelValidate();
                        break;
                    case 7:
                        mainView.closeConfirm();
                        mainView.rightPanelClear();
                        mainView.addMessage("You have Cancelled changing the Day Modifier.");
                        mainView.rightPanelValidate();
                        break;
                }
                mainView.clearAllTextFields();
            }
        });
        this.mainView.addRoomListBookingListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    JList<String> roomList = mainView.getRoomListBooking();

                    String selectedRoomName = roomList.getSelectedValue();

                    Room selectedRoom = hrsModel.getRoomByName(selectedRoomName);
                    hrsModel.setTempRoom(selectedRoom);
                    mainView.rightPanelClear();
                    mainView.checkInOut();
                    mainView.rightPanelValidate();
                    mainView.clearAllTextFields();

                }
            }
        });
        this.mainView.addRoomListLowInfoListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    JList<String> roomList = mainView.getRoomListLowInfo();
                    String selectedRoomName = roomList.getSelectedValue();
                        mainView.rightPanelClear();
                        mainView.lowInfo2Display(selectedRoomName,hrsModel.getTempHotel());
                        mainView.rightPanelValidate();
                }
            }
        });
        this.mainView.addRemoveRoomListListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    JList<String> roomList = mainView.getRemoveRoomList();
                    String selectedRoomName = roomList.getSelectedValue();
                    Room room = hrsModel.getRoomByName(selectedRoomName);
                    hrsModel.setTempRoom(room);
                    mainView.rightPanelClear();
                    mainView.rightPanelValidate();
                    mainView.confirmationWindow();
                }
            }
        });
        this.mainView.addBookBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String guestName = mainView.getGuestName();
                int checkIn = Integer.parseInt(mainView.getCheckIn());
                int checkout = Integer.parseInt(mainView.getCheckOut());
                boolean bool = hrsModel.isAvailable(checkIn,checkout);
                if ((checkout<=checkIn)||(checkIn>31)||(checkout>31)||(checkIn<1)||(checkout<1)){
                    mainView.rightPanelClear();
                    mainView.addMessage("Invalid Check In and Check Out dates");
                    mainView.clearAllTextFields();
                    mainView.rightPanelValidate();
                } else if (bool){
                    String discount = mainView.getDiscount();
                    hrsModel.addReservation(guestName,checkIn,checkout,hrsModel.getTempRoom(),discount);
                    hrsModel.addReservationR(guestName,checkIn,checkout,hrsModel.getTempRoom(),discount);
                    mainView.rightPanelClear();
                    mainView.addMessage("You have successfully booked Room: "+hrsModel.getTempRoom().getName());
                    mainView.addMessage("From Day "+ checkIn + " to "+checkout);
                    mainView.clearAllTextFields();
                    mainView.rightPanelValidate();
                } else {
                    mainView.rightPanelClear();
                    mainView.addMessage("Sorry, this Room is already booked during this timeslot");
                    mainView.clearAllTextFields();
                    mainView.rightPanelValidate();
                }

            }
        });
        this.mainView.addLowLevel1BtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainView.rightPanelClear();
                mainView.rightPanelValidate();
                int day = Integer.parseInt(mainView.getLowInfo1());
                mainView.lowInfo1Display(day,hrsModel.getTempHotel());
            }
        });
        this.mainView.addNewPriceBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int value = Integer.parseInt(mainView.getNewPrice());
                mainView.confirmationWindow();
            }
        });
        this.mainView.addDayModifierBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainView.confirmationWindow();
            }
        });
    }
    /*
    this.mainView.addBtnListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
        }
    });
     */

}