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
            }
        });

        this.mainView.addLowLevelBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Low level button clicked");
                mainView.rightPanelClear();
                mainView.rightPanelValidate();
                System.out.println("Right panel cleared and validated");
            }
        });
        this.mainView.addCreateHotelBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainView.rightPanelClear();
                mainView.rightPanelValidate();
                mainView.createHotel();
            }
        });
        this.mainView.addViewHotelBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
                }
            }
        });
        this.mainView.addManageHotelBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainView.rightPanelClear();
                mainView.rightPanelValidate();
                ArrayList<Hotel> tempList = hrsModel.getHotelList();
                hrsModel.setIdentifier(3);
                if (tempList.isEmpty()){
                    mainView.addEmpty();
                    mainView.rightPanelValidate();
                } else {
                    mainView.manageHotel();
                }
            }
        });
        this.mainView.addSimBookingBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainView.rightPanelClear();
                mainView.rightPanelValidate();
                ArrayList<Hotel> tempList = hrsModel.getHotelList();
                if (tempList.isEmpty()){
                    mainView.addEmpty();
                    mainView.rightPanelValidate();
                } else {
                    mainView.simBooking();
                }
            }
        });
        this.mainView.addCreateBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int standardRooms = Integer.parseInt(mainView.getStandardRoom());
                int deluxeRooms = Integer.parseInt(mainView.getDeluxeRoom());
                int executiveRooms = Integer.parseInt(mainView.getExecutiveRoom());
                boolean checker = hrsModel.isHotelNameUnique(mainView.getHotelName());//checks if name is unique
                if (checker) {
                    if (standardRooms+deluxeRooms+executiveRooms>50) {
                        mainView.setFeedbackLBText("Invalid Rooms");
                        mainView.clearTextFieldsCreate();
                    } else {
                        boolean result = hrsModel.addHotel(mainView.getHotelName(),standardRooms,deluxeRooms,executiveRooms);

                        if(result) {
                            mainView.setFeedbackLBText("Hotel: "+mainView.getHotelName()+" has been created");
                            mainView.clearTextFieldsCreate();
                        } else {
                            mainView.setFeedbackLBText("Hotel Creation failed :(");
                        }
                    }
                } else {
                    mainView.setFeedbackLBText("Hotel Name is not Unique");
                    mainView.clearTextFieldsCreate();
                }
            }
        });
        this.mainView.addHighLevelJComboBoxListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
        this.mainView.addLowLevelJComboBoxListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        this.mainView.addChangeHotelNameBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainView.rightPanelClear();
                mainView.changeNameHotel();
                mainView.rightPanelValidate();

            }
        });
        this.mainView.addAddRoomBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainView.rightPanelClear();
                mainView.rightPanelValidate();
            }
        });
        this.mainView.addRemoveRoomBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainView.rightPanelClear();
                mainView.rightPanelValidate();
            }
        });
        this.mainView.addUpdateBasePricingBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainView.rightPanelClear();
                mainView.rightPanelValidate();
            }
        });
        this.mainView.addRemoveReservationBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainView.rightPanelClear();
                mainView.rightPanelValidate();
            }
        });
        this.mainView.addRemoveHotelBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainView.rightPanelClear();
                mainView.rightPanelValidate();
            }
        });
        this.mainView.addUpdateDatePriceModifierBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainView.rightPanelClear();
                mainView.rightPanelValidate();
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