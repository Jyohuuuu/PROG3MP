import java.util.*;
/**
 * Represents the owner/user of a hotel.
 */
public class Owner {
    private ArrayList<Hotel> hotelList;

    public Owner() {
        this.hotelList = new ArrayList<Hotel>();
    }

    /**
     * Creates a new hotel with a specified name and number of rooms.
     * <p>
     * This method prompts the user to enter a hotel name and the number of rooms.
     * It then creates a new Hotel object with the specified name and adds
     * the specified number of rooms to the hotel. Each room is assigned a unique
     * name in the format "A1", "A2", ..., "E10". The price of each room is set to
     * 1299.0.
     * <p>
     * If the hotel name is not unique, the method will not add the hotel to the
     * list and will display an error message.
     */

    public void createHotel() {
        int exit = 1, loopBreak = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter hotel name: ");
        String hotelName;
        while (true) {
            try {
                hotelName = sc.nextLine();
                break; // Exit the loop if input is valid
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid hotel name.");
            }
        }
        Hotel newTempHotel = new Hotel(hotelName);
        while (exit != 0) {
            int setRow;
            while (true) {
                System.out.println("Enter the amount of rooms: ");
                if (sc.hasNextInt()) {
                    setRow = sc.nextInt();
                    sc.nextLine();
                    break;
                } else {
                    System.out.println("Invalid input. Please enter a valid integer.");
                    sc.next();
                }
            }
            if (setRow <= 0 || setRow > 50) {
                System.out.println("Invalid Number Entered. Please Try Again.");
            } else {
                char roomLetter = 'A'; // start with letter A
                for (int i = 0; i < setRow; i++) {
                    int roomNumber = i % 10 + 1; // room number 1-10
                    String roomName = roomLetter + "" + roomNumber; // create room name
                    Room room = new Room(roomName,'S');
                    newTempHotel.addRoom(room);
                    room.setPrice(1299.0);//default price
                    if (roomNumber == 10) {
                        roomLetter++; // increment letter when room number reaches 10
                    }
                }
                exit = 0;
            }
            while (true) {
                System.out.println("Add any Deluxe or Executive rooms?: ");
                String confirmation = sc.nextLine();

                if (confirmation.equalsIgnoreCase("yes") || confirmation.equalsIgnoreCase("y")) {
                    System.out.println("How Many Deluxe Rooms would you like to add?");
                    int setRoom;
                    while (true) {
                        if (sc.hasNextInt()) {
                            setRoom = sc.nextInt();
                            sc.nextLine();

                            break;
                        } else {
                            System.out.println("Invalid input. Please enter a valid integer.");
                            sc.next();
                        }
                    }
                    if (50 - setRow < setRoom) {
                        System.out.println("Invalid Number Entered. Please Try Again.");
                    } else {
                        char roomLetter = 'Q'; // start with letter A
                        for (int i = 0; i < setRoom; i++) {
                            int roomNumber = i % 10 + 1; // room number 1-10
                            String roomName = roomLetter + "" + roomNumber; // create room name
                            Room room = new Room(roomName,'D');
                            newTempHotel.addRoom(room);
                            room.setPrice(1299.0);//default price
                            if (roomNumber == 10) {
                                roomLetter++; // increment letter when room number reaches 10
                            }
                        }
                    }
                    System.out.println("How Many Executive Rooms would you like to add?");
                    int setRoom2;
                    while (true) {
                        if (sc.hasNextInt()) {
                            setRoom2 = sc.nextInt();
                            sc.nextLine();

                            break;
                        } else {
                            System.out.println("Invalid input. Please enter a valid integer.");
                            sc.next();
                        }
                    }
                    if (50 - setRow - setRoom2 < setRoom2) {
                        System.out.println("Invalid Number Entered. Please Try Again.");
                    } else {
                        char roomLetter = 'V'; // start with letter A
                        for (int i = 0; i < setRoom2; i++) {
                            int roomNumber = i % 10 + 1; // room number 1-10
                            String roomName = roomLetter + "" + roomNumber; // create room name
                            Room room = new Room(roomName,'E');
                            newTempHotel.addRoom(room);
                            room.setPrice(1299.0);//default price
                            if (roomNumber == 10) {
                                roomLetter++; // increment letter when room number reaches 10
                            }
                        }
                    }
                    break;
                } else if (confirmation.equalsIgnoreCase("no") || confirmation.equalsIgnoreCase("n")) {
                    System.out.println("You did not add any Deluxe and Executive rooms.");
                    break;
                } else {
                    System.out.println("Invalid Input, Try Again!");
                }
            }
        }
        boolean checker = isHotelNameUnique(hotelName);//checks if name is unique
        if (checker) {
            this.hotelList.add(newTempHotel);
            System.out.println("Hotel " + hotelName + " created successfully.");
        } else {
            System.out.println("Please Enter A Valid Name. (Must be Unique/Must Not be Empty)");
        }
    }

    /**
     * Checks if a hotel name is unique in the hotel list.
     * <p>
     * This method iterates through the hotel list and checks if any hotel has the same name as the specified name.
     *
     * @param name the hotel name to check
     */

    public boolean isHotelNameUnique(String name) {
        for (Hotel hotel : hotelList) {//loops through hotel list
            if (hotel != null && hotel.getName() != null && hotel.getName().equals(name)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks the details of a hotel by its name.
     * <p>
     * This method prompts the user to enter a hotel name, and then displays the hotel's details, including its name, number of rooms, and room names.
     * It also calculates and displays the estimated earnings for the month based on the hotel's reservations.
     */

    public void checkHotel(Hotel hotel) {
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
        } else {
            System.out.println("Hotel not Found!");
        }
    }

    /**
     * Finds a hotel by its name in the hotel list.
     * <p>
     * This method iterates through the hotel list and returns the first hotel that matches the specified name (case-insensitive).
     *
     * @param name the hotel name to search for
     * @return the matching hotel, or null if no hotel is found
     */

    public Hotel findHotelByName(String name) {
        for (Hotel hotel : hotelList) {
            if (hotel.getName().equalsIgnoreCase(name)) {
                return hotel;
            }
        }
        // If no matching hotel is found, return null
        return null;
    }

    /**
     * Displays information about a hotel and its rooms and reservations.
     * <p>
     * This method prompts the user to enter a hotel name, and then displays a menu to choose what information to view.
     * The user can choose to view high-level information about the hotel, or low-level information about the hotel's rooms and reservations.
     */

    public void viewInfo() {
        Scanner sc = new Scanner(System.in);
        int input;
        if (hotelList.isEmpty()){
            System.out.println("No Hotels Are Available.");
        } else {
            System.out.println("What Hotel would you Like to View (or 'Cancel' to return to main menu)?");
            for (Hotel hotel : hotelList){
                System.out.print(hotel.getName() + " ");
                System.out.println(" ");
            }
            String hotelName = sc.nextLine();
            if (hotelName.equalsIgnoreCase("cancel")) {
                System.out.println("Returning to main menu.");
            } else {
                Hotel temp = findHotelByName(hotelName);
                if (temp != null) {
                    ArrayList<Room> rooms = temp.getRooms();
                    ArrayList<Reservation> reservations = temp.getReservations();
                    while (true) {
                        System.out.print("What Would You Like to See?\n[0] Cancel\n[1] High Level Information\n[2] Low Level Information\n");
                        if (sc.hasNextInt()) {
                            input = sc.nextInt();
                            if (input == 1 || input == 2) {
                                sc.nextLine();
                                break;
                            } else if (input == 0) {
                                System.out.println("Returning to main menu.");
                                return;
                            } else {
                                System.out.println("Invalid input. Please enter 0, 1, or 2.");
                            }
                        } else {
                            System.out.println("Invalid input. Please enter a valid number.");
                            sc.next();
                        }
                    }
                    switch (input) {
                        case 1:
                            checkHotel(temp);
                            break;
                        case 2:
                            int nextInput;
                            while (true) {
                                System.out.print("What Would You Like to See?\n[0] Cancel\n[1] Total number of available and booked rooms for a selected date\n[2] Room Information\n[3] Reservation Information\n\n");
                                if (sc.hasNextInt()) {
                                    nextInput = sc.nextInt();
                                    if (nextInput == 1 || nextInput == 2 || nextInput == 3) {
                                        sc.nextLine();
                                        break;
                                    } else if (nextInput == 0) {
                                        System.out.println("Returning to main menu.");
                                        return;
                                    } else {
                                        System.out.println("Invalid input. Please enter 0, 1, 2, or 3.");
                                    }
                                } else {
                                    System.out.println("Invalid input. Please enter a valid number.");
                                    sc.next();
                                }
                            }
                            switch (nextInput) {
                                case 1://under progress
                                    int day;
                                    while (true) {
                                        System.out.println("Choose a Date (1-31)");
                                        if (sc.hasNextInt()) {
                                            day = sc.nextInt();
                                            if (day >= 1 && day <= 31) {
                                                sc.nextLine();
                                                break;
                                            } else {
                                                System.out.println("Invalid input. Please enter a day between 1 and 31.");
                                            }
                                        } else {
                                            System.out.println("Invalid input. Please enter a valid number.");
                                            sc.next();
                                        }
                                    }
                                    int totalRooms = rooms.size();
                                    int bookedRooms = 0;
                                    for (Room room : rooms) {
                                        for (Reservation reservation : room.getReservations()) {
                                            int checkintemp = reservation.getCheckInDay(), checkoutTemp = reservation.getCheckOutDay();
                                            if (checkintemp <= day && checkoutTemp >= day) {
                                                bookedRooms++;
                                                break; // no need to check further reservations for this room
                                            }
                                        }
                                    }
                                    System.out.println("Total number of available rooms for the selected date: " + (totalRooms - bookedRooms));
                                    System.out.println("Total number of booked rooms for the selected date: " + bookedRooms);

                                    break;
                                case 2://under progress
                                    System.out.println("Choose what room to view");
                                    for (Room room : rooms) {
                                        System.out.print(room.getName() + " ");
                                    }
                                    System.out.println(" ");
                                    System.out.print("Enter the room name: ");
                                    String roomSelect = sc.nextLine();
                                    Room roomSelected = temp.findRoomByName(roomSelect);
                                    if (roomSelected!= null) {
                                        System.out.println("Room Name: " + roomSelected.getName() + " Room Price: " + roomSelected.calculatePrice());
                                        boolean[] availability = new boolean[31]; // array to store availability of each day
                                        for (int i = 0; i < 31; i++) {
                                            availability[i] = true; //all days are available
                                        }
                                        for (Reservation reservation : roomSelected.getReservations()) {
                                            for (int i = reservation.getCheckInDay(); i <= reservation.getCheckOutDay(); i++) {
                                                availability[i - 1] = false; //there's a reservation
                                            }
                                        }
                                        System.out.print("Available on: ");
                                        for (int i = 0; i < 31; i++) {
                                            if (availability[i]) {
                                                System.out.print((i + 1) + " ");
                                            }
                                        }
                                        System.out.println();
                                    } else {
                                        System.out.println("Invalid Room Selected.");
                                    }
                                    break;
                                case 3:

                                    System.out.println("Choose what Reservation to view");
                                    if (reservations.isEmpty()) {
                                        System.out.println("No reservations available.");
                                    } else {
                                        for (Reservation reservation : reservations) {
                                            System.out.print(reservation.getGuestName() + " ");
                                        }
                                        System.out.println(" ");
                                        System.out.println("Enter a guest name to view reservation details (or 'Cancel' to return to main menu):");
                                        String reservationName = sc.nextLine();
                                        if (reservationName.equalsIgnoreCase("cancel")) {
                                            System.out.println("Returning to main menu.");
                                        } else {
                                            Reservation reservationSelected = temp.findReservationByGuestName(reservationName);
                                            if (reservationSelected != null) {
                                                System.out.println("Guest Name: " + reservationSelected.getGuestName());
                                                System.out.println("Room Name: " + reservationSelected.getRoomInfo().getName());
                                                System.out.println("Room Price per Night: " + reservationSelected.getRoomInfo().calculatePrice());
                                                System.out.println("Booked from Day " + reservationSelected.getCheckInDay()  + " to Day " + reservationSelected.getCheckOutDay());
                                                int nights = reservationSelected.getCheckOutDay() - reservationSelected.getCheckInDay() + 1;
                                                double totalPrice = reservationSelected.calculateReservationPrice(reservationSelected.getRoomInfo(),temp);
                                                System.out.println("Total Price for the Booking: " + totalPrice);
                                            } else {
                                                System.out.println("Invalid Reservation Selected.");
                                            }
                                        }
                                    }
                                    break;
                                default:
                                    System.out.println("Invalid Number Entered, Please Try Again");
                                    break;
                            }

                    }
                } else {
                    System.out.println("Invalid Hotel Entered");
                }
            }
        }


    }

    /**
     * Manages a hotel's information and operations.
     * This method prompts the user to enter a hotel name, and then displays a menu to choose what operation to perform.
     * The user can choose to:
     * Change the name of the hotel
     * Add rooms to the hotel
     * Remove rooms from the hotel
     * Update the base pricing of a room
     * Remove a reservation
     * Remove the hotel
     */

    public void manageHotel() {
        int exit = 0;
        Scanner sc = new Scanner(System.in);
        if(hotelList.isEmpty()){
            System.out.println("No hotels Available.");
        } else {
            System.out.println("What Hotel would you Like to Manage(or 'Cancel' to return to main menu)?");
            for (Hotel hotel : hotelList){
                System.out.print(hotel.getName() + " ");
                System.out.println(" ");
            }
            String hotelName = sc.nextLine();
            if (hotelName.equalsIgnoreCase("cancel")) {
                System.out.println("Returning to main menu.");
            } else {
                Hotel temp = findHotelByName(hotelName);
                if (temp != null) {
                    System.out.println("What Would You Like to Do?\n[0] Cancel \n[1] Change the Name of the Hotel\n[2] Add room(s)\n[3] Remove Rooms\n[4] Update Base Pricing of a Room\n[5] Remove Reservation\n[6] Remove Hotel\n[7]Update the Date Price Modifier");
                    int input;
                    while (true) {
                        try {
                            input = sc.nextInt();
                            sc.nextLine();
                            break;
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Please enter a valid integer.");
                            sc.nextLine();
                        }
                    }
                    switch (input) {
                        case 0:
                            System.out.println("Returning to main menu...");
                            return;
                        case 1:
                            while (exit != 1) {
                                System.out.println("Input the New Hotel Name (or 'Cancel' to return to main menu): ");
                                hotelName = sc.nextLine();

                                if (hotelName.equalsIgnoreCase("cancel")) {
                                    System.out.println("Operation cancelled. Returning to main menu.");
                                    exit = 1;
                                } else if (!isHotelNameUnique(hotelName)) {
                                    System.out.println("Hotel name already exists. Please choose a different name.");
                                } else {
                                    System.out.println("Are you sure you want to name the Hotel " + hotelName);
                                    System.out.println("Yes, No, or Cancel");
                                    String confirmation = sc.nextLine();
                                    if (confirmation.equalsIgnoreCase("yes") || confirmation.equalsIgnoreCase("y")) {
                                        temp.setName(hotelName);
                                        System.out.println("Hotel name has successfully been set to " + hotelName);
                                        exit = 1;
                                    } else if (confirmation.equalsIgnoreCase("no") || confirmation.equalsIgnoreCase("n")) {
                                        System.out.println("Try Again!");
                                    } else if (confirmation.equalsIgnoreCase("cancel")) {
                                        System.out.println("Operation cancelled. Returning to main menu.");
                                        exit = 1;
                                    } else {
                                        System.out.println("Invalid input. Please try again.");
                                    }
                                }
                            }
                            break;
                        case 2:
                            while (exit != 1) {
                                ArrayList<Room> rooms = temp.getRooms();
                                int range = rooms.size();
                                System.out.println("How many rooms would you like to add? ");
                                while (true) {
                                    try {
                                        input = sc.nextInt();
                                        sc.nextLine();
                                        break;
                                    } catch (InputMismatchException e) {
                                        System.out.println("Invalid input. Please enter a valid integer.");
                                        sc.nextLine();
                                    }
                                }

                                if (input < 1 || input > (50 - range)) {
                                    System.out.println("Invalid Amount Entered, Try Again");
                                } else {
                                    System.out.println("You are about to add " + input + " rooms. Are you sure? (yes/no)");
                                    String confirm = sc.nextLine();
                                    if (confirm.equalsIgnoreCase("yes")) {
                                        char roomLetter = 'A';
                                        int roomNumber = 1;
                                        for (int i = 1; i <= input; ) {// room number 1-10
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
                                        System.out.println("You have succesfully added " + input + " rooms.");
                                        exit = 1;
                                    } else if (confirm.equalsIgnoreCase("no")) {
                                        System.out.println("Room addition cancelled.");
                                    } else {
                                        System.out.println("Invalid input. Please enter 'yes' or 'no'.");
                                    }
                                }
                            }
                            break;
                        case 3://under progress
                            while (exit != 1) {
                                ArrayList<Room> rooms = temp.getRooms();
                                int range = rooms.size();
                                System.out.println("How many rooms would you like to remove? ");
                                while (true) {
                                    try {
                                        input = sc.nextInt();
                                        sc.nextLine();
                                        break;
                                    } catch (InputMismatchException e) {
                                        System.out.println("Invalid input. Please enter a valid integer.");
                                        sc.nextLine();
                                    }
                                }

                                if (input < 1 || input > range - 1) {
                                    System.out.println("Invalid Amount Entered, Try Again");
                                } else {
                                    System.out.println("Are you sure you want to remove " + input + " rooms? (yes/no)");
                                    String confirm = sc.next();
                                    if (confirm.equalsIgnoreCase("yes")) {
                                        for (int i = 0; i < input; i++) {
                                            Room room = rooms.get(range - 1 - i);
                                            if (room.hasActiveReservation()) {
                                                System.out.println("Room " + room.getName() + " has an active reservation and cannot be removed.");
                                            } else {
                                                temp.removeRoom(room);
                                            }
                                        }
                                        exit = 1;
                                    } else if (confirm.equalsIgnoreCase("no")) {
                                        System.out.println("Removal cancelled.");
                                    } else {
                                        System.out.println("Invalid input. Please enter 'yes' or 'no'.");
                                    }
                                }
                            }
                            break;
                        case 4:
                            ArrayList<Reservation> reservations = temp.getReservations();
                            ArrayList<Room> rooms = temp.getRooms();
                            double prevPrice = rooms.get(0).getPrice();

                            if (reservations.isEmpty()) {
                                System.out.println("Please enter a new price of at least 100 greater than the previous value of " + prevPrice);
                                while (true) {
                                    double newValue = sc.nextDouble();
                                    sc.nextLine();

                                    if (newValue < prevPrice + 100) {//must be greater than 100 of previous
                                        System.out.println("Invalid Amount Entered, Try Again. The new price must be at least 100 more than the previous price.");
                                    } else {
                                        System.out.println("Are you sure you want to set the price to " + newValue + "? (Yes/No)");//confirmation
                                        String confirmation = sc.nextLine();

                                        if (confirmation.equalsIgnoreCase("yes") || confirmation.equalsIgnoreCase("y")) {
                                            for (Room room : rooms) {
                                                room.setPrice(newValue);
                                            }
                                            System.out.println("The new room price of the Hotel has been successfully set to " + newValue);
                                            exit = 1;
                                            break;
                                        } else if (confirmation.equalsIgnoreCase("no") || confirmation.equalsIgnoreCase("n")) {
                                            System.out.println("You have canceled the change!");
                                            break;
                                        } else {
                                            System.out.println("Invalid Input, Try Again!");
                                        }
                                    }
                                }
                            } else {
                                System.out.println("You cannot change the room price because there are existing reservations.");
                            }
                            break;
                        case 5:
                            ArrayList<Reservation> reservationsList = temp.getReservations();
                            if (reservationsList.isEmpty()) {
                                System.out.println("No reservations available.");
                                break;
                            } else {
                                System.out.println("What Reservation would you like to remove? ");
                                for (Reservation reservation : reservationsList) {
                                    System.out.print(reservation.getGuestName() + " ");
                                }
                                System.out.println();

                                String reservationName = sc.nextLine();
                                Reservation reservationSelected = temp.findReservationByGuestName(reservationName);

                                if (reservationSelected != null) {
                                    System.out.println("Are you sure you want to remove the Reservation by " + reservationSelected.getGuestName() + "? (Yes/No)");
                                    String confirmation = sc.nextLine();

                                    if (confirmation.equalsIgnoreCase("yes") || confirmation.equalsIgnoreCase("y")) {
                                        Room room = reservationSelected.getRoomInfo();
                                        ArrayList<Reservation> roomReservations = room.getReservations();
                                        roomReservations.remove(reservationSelected);//removes reservation from both the hotel and rooms
                                        reservationsList.remove(reservationSelected);
                                        System.out.println("You have successfully removed " + reservationSelected.getGuestName() + "'s reservation.");
                                        exit = 1;
                                    } else {
                                        System.out.println("Try Again!");
                                    }
                                } else {
                                    System.out.println("Invalid Reservation Selected. Please try again.");
                                }
                            }
                            break;
                        case 6:
                            System.out.println("Are you sure you want to remove the Hotel: " + temp.getName() + "?");//confirmation
                            System.out.println("Yes or No");
                            String confirmation = sc.nextLine();
                            if (confirmation.equalsIgnoreCase("yes") || confirmation.equalsIgnoreCase("y")) {
                                hotelList.remove(temp);
                                System.out.println("You have successfully removed " + temp.getName() + " from the Hotel list.");
                                exit = 1;
                            } else {
                                System.out.println("Removal cancelled.");
                            }
                            break;
                        case 7:
                            System.out.println("Which Day would you like to modify? (1-31)");
                            int modifyDay;
                            while (true) {
                                try {
                                    modifyDay = sc.nextInt();
                                    sc.nextLine();
                                    break;
                                } catch (InputMismatchException e) {
                                    System.out.println("Invalid input. Please enter a valid integer.");
                                    sc.nextLine();
                                }
                            }
                            int modifier = 0;
                            if (modifyDay > 31 || modifyDay < 1) {
                                System.out.println("Invalid Date Entered.");
                            } else {
                                System.out.println("Change the Modifier(Type an integer): (50%-150%)");
                                while (true) {
                                    try {
                                        modifier = sc.nextInt();
                                        sc.nextLine();
                                        break;
                                    } catch (InputMismatchException e) {
                                        System.out.println("Invalid input. Please enter a valid integer.");
                                        sc.nextLine();
                                    }
                                }
                                if (modifier < 50 || modifier > 150) {
                                    System.out.println("Invalid Modifier Entered.");
                                } else {
                                    temp.setDayModifier(modifyDay - 1, modifier);
                                }
                            }
                            System.out.println("Successfully changed the modifier of Day " + modifyDay + " to " + modifier + "%");
                            break;
                        default:
                            System.out.println("Invalid Number Entered, Try Again");

                    }
                } else {
                    System.out.println("Hotel not Found!");
                }
            }
        }


    }

    /**
     * Simulates a hotel booking process.
     * This method prompts the user to select a hotel, enter check-in and check-out dates and times, and choose a room to book.
     * It then creates a new reservation and adds it to the hotel's reservation list.
     */

    public void simulateBooking() {
        Scanner sc = new Scanner(System.in);
        int exit = 0;
        int checkoutDay=0;
        if(hotelList.isEmpty()){
            System.out.println("No Available Hotels");
        } else {
            System.out.println("Available Hotels:");
            for (Hotel hotel : hotelList) {
                System.out.println(hotel.getName());
            }

            while (exit != 1) {
                if (hotelList.isEmpty()) {
                    System.out.println("No reservations available.");
                }
                System.out.println("Which hotel would you like to book in?");
                String hotelName = sc.nextLine();
                Hotel hotel = findHotelByName(hotelName);
                String discount = "";
                if (hotel != null) {
                    if (hotel.getRooms() != null) {
                        ArrayList<Room> rooms = hotel.getRooms();

                        int checkInDay;
                        while (true) {
                            System.out.println("Enter the Check in Date (1-31):");
                            checkInDay = sc.nextInt();
                            if (checkInDay >= 1 && checkInDay <= 31) {
                                sc.nextLine();
                                break;
                            } else {
                                System.out.println("Invalid Check in Date. Please enter a date between 1 and 31.");
                                sc.nextLine();
                            }
                        }
                    /*
                    int checkInTime;
                    while (true) {
                        System.out.println("Enter the Check in Time (1-12):");
                        checkInTime = sc.nextInt();
                        if (checkInTime >= 1 && checkInTime <= 12) {
                            sc.nextLine();
                            break;
                        } else {
                            System.out.println("Invalid Check in Time. Please enter a time between 1 and 12.");
                            sc.nextLine();
                        }
                    }

                    String checkInString;
                    while (true) {
                        System.out.println("Enter the Check in Time (AM/PM):");
                        checkInString = sc.nextLine();
                        if (checkInString.equalsIgnoreCase("am") || checkInString.equalsIgnoreCase("pm")) {
                            break;
                        } else {
                            System.out.println("Invalid Check in Time. Please enter AM or PM.");
                        }
                    }
                    */


                        while (true) {
                            System.out.println("Enter the Check out Date (1-31) or type 0 to cancel:");
                            try {
                                checkoutDay = sc.nextInt();
                                if (checkoutDay == 0) {
                                    System.out.println("Checkout date entry cancelled.");
                                    return;
                                } else if (checkoutDay < checkInDay) {
                                    System.out.println("Invalid Check out Date. You cannot Checkout before your Check in Date.");
                                    sc.nextLine(); // clear the newline character
                                } else if (checkoutDay >= 1 && checkoutDay <= 31) {
                                    break; // valid input, exit the loop
                                } else {
                                    System.out.println("Invalid Check out Date. Please enter a date between 1 and 31.");
                                    sc.nextLine(); // clear the newline character
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Invalid input. Please enter a valid number.");
                                sc.next();

                            }
                            while (true) {


                            System.out.println("Input a Discount Code? (type NO all capital, for no discount):");
                            discount = sc.nextLine();
                                switch (discount)   {
                                case "I_WORK_HERE":
                                    //total reservation price * 90%
                                    break;
                                case "STAY4_GET1":
                                    if (checkoutDay-checkInDay+1 >= 5){
                                        //total reservation price - checkinDay*reservation price
                                    }
                                    break;
                                case "PAYDAY":
                                    if ((15 < checkoutDay) && (15 > checkInDay) || (30 < checkoutDay) && (30 > checkInDay)){
                                        //reservation price * 93%
                                    }
                                    break;
                                case "No":
                                    break;
                                default:
                                    System.out.println("Invalid Discount Code Entered, Try Again.");
                                }
                                break;
                            }
                        }
                        sc.nextLine();
                        System.out.println("Kindly Enter Your Name:");
                        String guestName = sc.nextLine();

                        System.out.println("Choose a room to book:");
                        for (Room room : rooms) {
                            System.out.print(room.getName() + " ");
                        }
                        System.out.println();

                        String roomSelect = sc.nextLine();
                        Room roomSelected = hotel.findRoomByName(roomSelect);

                        if (roomSelected != null) {
                            if (roomSelected.isAvailable(checkInDay,checkoutDay)) {
                                System.out.println("You have successfully booked Room " + roomSelect + " from Day " + checkInDay + " to Day " + checkoutDay);
                                roomSelected.addReservation(new Reservation(guestName, checkInDay, checkoutDay, roomSelected, discount));
                                hotel.addReservation(new Reservation(guestName,checkInDay ,checkoutDay , roomSelected, discount));
                                exit = 1;
                            } else {
                                System.out.println("Sorry, Room " + roomSelect + " is already booked during this timeslot. Try Again!");
                            }
                        } else {
                            System.out.println("Invalid Input. Try Again!");
                        }

                    } else {
                        System.out.println("Invalid Hotel Entered. Try Again!");
                    }
                }
            }
        }
    }

}