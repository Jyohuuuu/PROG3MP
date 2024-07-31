/**
 * Represents a reservation made by a guest for a room.
 */
public class Reservation
{
    private String guestName;
    private int checkoutDay;
    private int checkInDay;
    private Room roomInfo;
    private String discountCode;
    /**
     * Creates a new reservation with the given guest name, check-in date, check-out date, and room information.
     *
     * @param guestName the name of the guest making the reservation
     * @param checkInDay the day of check-in
     * @param checkoutDay the day of check-out
     * @param roomInfo the room information for the reservation
     */
    public Reservation(String guestName, int checkInDay, int checkoutDay, Room roomInfo, String discountCode){
        this.guestName = guestName;
        this.checkInDay = checkInDay;
        this.checkoutDay = checkoutDay;
        this.roomInfo = roomInfo;
        this.discountCode = discountCode;
    }
    /**
     * Returns the name of the guest making the reservation.
     *
     * @return the guest name
     */
    public String getGuestName()
    {
        return guestName;
    }
    /**
     * Returns the day of check-in for the reservation.
     *
     * @return the check-in date
     */
    public int getCheckInDay() {
        return checkInDay;
    }
    /**
     * Returns the day of check-out for the reservation.
     *
     * @return the check-out date
     */
    public int getCheckOutDay() {
        return checkoutDay;
    }
    /**
     * Returns the room information for the reservation.
     *
     * @return the room information
     */
    public Room getRoomInfo(){
        return roomInfo;
    }

    public double calculateReservationPrice(Room room, Hotel hotel){
        int i = checkInDay;
        double totalPrice=0;
        double tempPrice=0;
        double[] temp = hotel.getDayModifier();
        while (i<=checkoutDay){
            tempPrice= room.calculatePrice()*temp[i-1];
            totalPrice += tempPrice;
            System.out.println("HERE1");
            i++;
        }
        switch (discountCode)   {
            case "I_WORK_HERE":
                //total reservation price * 90%
                totalPrice*=0.90;
                break;
            case "STAY4_GET1":
                if (checkoutDay-checkInDay+1 >= 5){
                    tempPrice= room.calculatePrice()*temp[i-1];
                    totalPrice-=tempPrice;
                    //total reservation price - checkinDay*reservation price
                }
                break;
            case "PAYDAY":
                if ((15 < checkoutDay) && (15 > checkInDay) || (30 < checkoutDay) && (30 > checkInDay)){
                    //reservation price * 93%
                    totalPrice*=0.93;
                }
                break;
        }

        System.out.println("HERE");
        return totalPrice;
    }

}
