package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class CustomerConsole {
    private final Scanner input = new Scanner(System.in);
    @Autowired
    Main main;
    @Autowired
    private ReservationService service;

    public void returnToCustomerMenu() {
        service.viewSpaces();
        System.out.println("\nSelect '1' to go back to the Customer Menu");
        System.out.print("Enter your choice: ");
        int opt = input.nextInt();
        main.customerMenu();
    }

    public void handleBooking() {
        System.out.println("------------Make A Reservation-------------");
        while (true) {
            System.out.print("Enter your reservation ID: ");
            int resID = input.nextInt();
            input.nextLine();
            System.out.print("Enter your name: ");
            String name = input.nextLine();
            System.out.print("Enter reservation date: ");
            String date = input.nextLine();
            System.out.print("Enter start time: ");
            String start = input.nextLine();
            System.out.print("Enter end time: ");
            String end = input.nextLine();
            System.out.print("Enter your space ID: ");
            int spaceID = input.nextInt();

            CoworkingSpace space = service.findSpaceID(spaceID);

            Reservation reservation = new Reservation(resID, name, date, start, end, space);

            if (service.bookSpace(reservation)) {
                System.out.println("-------------------------------------------------------");
                System.out.println("Reservation accepted! Space " + resID + "  has been booked for you.");

                System.out.println("\nSelect '1' to go back to the Customer Menu");
                System.out.print("Enter your choice: ");
                int opt = input.nextInt();
                main.customerMenu();
                break;
            }
        }
    }


    public void returnToCustomerMenuu() {
        System.out.println("------------Display My Booking-------------");
        System.out.print("Enter your reservation ID:");
        int resID = input.nextInt();
        service.myBookings(resID);
        System.out.println("\nSelect '1' to go back to the Customer Menu");
        System.out.print("Enter your choice: ");
        int opt = input.nextInt();
        main.customerMenu();
    }


    public void handleCancellation() {
        System.out.println("-----------Cancel Your Booking-----------");
        while (true) {
            System.out.print("Enter your reservation ID:");
            int canID = input.nextInt();


            if (service.cancelBooking(canID)) {
                System.out.println("------------------------------");
                System.out.println("Your booking was successfully canceled!");


                System.out.println("\nSelect '1' to go back to the Customer Menu");
                System.out.print("Enter your choice: ");
                int opt = input.nextInt();
                main.customerMenu();
                break;
            } else {
                System.out.println("\n------------------------------");
                System.out.println("Enter correct booking ID. \n");
            }
        }
    }
}

