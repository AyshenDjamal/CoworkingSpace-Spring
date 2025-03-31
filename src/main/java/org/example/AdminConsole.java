package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class AdminConsole {
    private final Scanner input = new Scanner(System.in);
    @Autowired
    Main main;
    @Autowired
    private CoworkingSpaceService service;


    public void addSpaceWithUserInput() {
        while (true) {
            try {
                System.out.print("Enter Space ID: ");
                int id = input.nextInt();
                System.out.print("Enter Space Type (open/private): ");
                String spaceType = input.next();
                System.out.print("Enter Price: ");
                double price = input.nextDouble();
                System.out.print("Is available? (true/false): ");
                boolean isAvailable = input.nextBoolean();

                service.addSpace(id, spaceType, price, isAvailable);
                System.out.println("----------------------------------");
                System.out.println("New coworking space added successfully!\n");

                System.out.println("Go back to Admin Menu or add another space? (back/add)");
                System.out.print("Enter your choice: ");
                String answer = input.next();

                if (answer.equalsIgnoreCase("Back")) {
                    main.adminMenu();
                    return;
                }
            } catch (Exception e) {
                System.out.println("Invalid input, please try again.");
                input.nextLine();
            }
        }
    }


    public void removeSpaceWithUserInput() {
        while (true) {
            System.out.print("Enter the Space ID to be removed: ");
            int id = input.nextInt();

            if (service.removeSpace(id)) {
                System.out.println("----------------------------");
                System.out.println("Space removed successfully!");


                System.out.println("\nSelect '1' to go back to the Admin Menu or '2' to remove a space. (1/2)");
                System.out.print("Enter your choice: ");
                int num = input.nextInt();

                if (num == 1) {
                    main.adminMenu();
                    break;
                }
            } else {
                System.out.println("-----------------------------------");
                System.out.println("Failed to remove space. It may not exist or is booked. \n");
            }
        }
    }


    public void returnToAdminMenu() {
        service.viewAllBookings();
        System.out.println("\nSelect '1' to go back to the Admin Menu");
        System.out.print("Enter your choice: ");
        int opt = input.nextInt();
        if (opt == 1) {
            main.adminMenu();
        }
    }
}







