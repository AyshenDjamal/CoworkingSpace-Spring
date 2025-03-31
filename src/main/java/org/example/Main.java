package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class Main {
    private final Scanner input = new Scanner(System.in);
    @Autowired
    private AdminConsole adminConsole;
    @Autowired
    private CustomerConsole customerConsole;

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        Main springApp = applicationContext.getBean(Main.class);
        springApp.mainMenu();
    }

    public void mainMenu() {
        System.out.println("--------------------Main Menu--------------------");
        System.out.println("Welcome To The Coworking Space Reservation System");
        System.out.println("1. Admin Login");
        System.out.println("2. Customer Login");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");

        int option = input.nextInt();

        switch (option) {
            case 1:
                adminMenu();
                break;
            case 2:
                customerMenu();
                break;
            case 0:
                exit();
                break;
            default:
                System.out.println("Invalid choice, try again.");
                mainMenu();
        }
    }


    public void adminMenu() {
        System.out.println("-----------Admin Menu-----------");
        System.out.println("1. Add a new coworking space");
        System.out.println("2. Remove a coworking space");
        System.out.println("3. View all reservations");
        System.out.println("0. Log out");
        System.out.print("Enter your choice: ");
        int option = input.nextInt();

        switch (option) {
            case 1:
                adminConsole.addSpaceWithUserInput();
                break;
            case 2:
                adminConsole.removeSpaceWithUserInput();
                break;
            case 3:
                adminConsole.returnToAdminMenu();
                break;
            case 0:
                mainMenu();
                break;
            default:
                System.out.println("Invalid choice, try again.");
                adminMenu();
        }

    }


    public void customerMenu() {
        System.out.println("-----------Customer Menu-------------");
        System.out.println("1. Browse available spaces");
        System.out.println("2. Make a reservation");
        System.out.println("3. View my reservations");
        System.out.println("4. Cancel a reservation");
        System.out.println("0. Log Out");
        System.out.print("Enter your choice: ");
        int option = input.nextInt();

        switch (option) {
            case 1:
                customerConsole.returnToCustomerMenu();
                break;
            case 2:
                customerConsole.handleBooking();
                break;
            case 3:
                customerConsole.returnToCustomerMenuu();
                break;
            case 4:
                customerConsole.handleCancellation();
                break;
            case 0:
                mainMenu();
                break;
            default:
                System.out.println("Invalid choice, try again.");
                customerMenu();
        }

    }


    public void exit() {
        System.out.println("Good Bye!");
        System.exit(0);
    }
}