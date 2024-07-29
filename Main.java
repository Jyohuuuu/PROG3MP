import java.util.InputMismatchException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main
{
    /**
     * The main program where all the methods are called to execute.
     */
    public static void main(String[] args)
    {
        MainView mainView = new MainView();
        HRSModel hrsModel = new HRSModel();
        HRSController hrsController = new HRSController(mainView,hrsModel);
        /*
        Owner user = new Owner();
        int userInputInt = 5;
        String userInputString;
        while (true)
        {
            System.out.print(" [0] Exit\n [1] Create a Hotel.\n [2] View Hotel. \n [3] Manage Hotel. \n [4] Simulate Booking.\n");
            Scanner sc = new Scanner(System.in);
            while (true) {
                try {
                    userInputInt = sc.nextInt();
                    sc.nextLine(); // Consume \n
                    break; // Exit the loop if input is valid
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter an integer.");
                    sc.next(); // Consume the invalid input
                }
            }
            switch (userInputInt)
            {
                case 1:
                    user.createHotel();
                    break;
                case 2:
                    user.viewInfo();
                    break;
                case 3:
                    user.manageHotel();
                    break;
                case 4:
                    user.simulateBooking();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }

         */

    }
}
