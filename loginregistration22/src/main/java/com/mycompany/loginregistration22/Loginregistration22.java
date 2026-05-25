/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.loginregistration22;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Student
 */
public class Loginregistration22 {

    
public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // ================= REGISTER =================
        System.out.print("Enter username (<=5 characters and must contain _): ");
        String username = input.nextLine();

        if (username.length() <= 5 && username.contains("_")) {
            System.out.println("Username successfully captured");
        } else {
            System.out.println("Username not correctly formatted");
        }

        // Password
        System.out.print("Enter password (>=8 chars, capital, number, special char): ");
        String password = input.nextLine();

        boolean hasCapital = password.matches(".*[A-Z].*");
        boolean hasNumber = password.matches(".*\\d.*");
        boolean hasSpecial = password.matches(".*[!@#$%^&*()].*");

        if (password.length() >= 8 && hasCapital && hasNumber && hasSpecial) {
            System.out.println("Password successfully captured");
        } else {
            System.out.println("Password not correctly formatted");
        }

        // Phone Number
        System.out.print("Enter phone number (+27): ");
        String phoneNumber = input.nextLine();

        if (phoneNumber.matches("\\+27\\d{9}")) {
            System.out.println("Phone number successfully captured");
        } else {
            System.out.println("Phone number not correctly formatted");
        }

        // ================= LOGIN =================
        System.out.println("\n--- LOGIN ---");

        System.out.print("Enter username: ");
        String loginUsername = input.nextLine();

        System.out.print("Enter password: ");
        String loginPassword = input.nextLine();

        System.out.print("Enter phone number: ");
        String loginPhone = input.nextLine();

        // Check login
        if (loginUsername.equals(username)
                && loginPassword.equals(password)
                && loginPhone.equals(phoneNumber)) {

            System.out.println("\nLogin successful!");
            System.out.println("Welcome to QuickChat");

            // ================= QUICKCHAT =================
            ArrayList<String> messages = new ArrayList<>();
            int totalMessages = 0;

            System.out.print("\nHow many messages would you like to send? ");
            int numberOfMessages = input.nextInt();
            input.nextLine();

            for (int i = 1; i <= numberOfMessages; i++) {

                System.out.println("\nMessage " + i);

                System.out.print("Enter Message ID: ");
                String messageID = input.nextLine();

                if (messageID.length() <= 10) {
                    System.out.println("Message ID captured successfully");
                } else {
                    System.out.println("Message ID exceeds 10 characters");
                }

                System.out.print("Enter recipient cell number: ");
                String recipientCell = input.nextLine();

                if (recipientCell.length() <= 13
                        && recipientCell.startsWith("+27")) {
                    System.out.println("Cell number formatted correctly");
                } else {
                    System.out.println("Cell number not correctly formatted");
                }

                System.out.print("Enter your message: ");
                String messageText = input.nextLine();

                // Message hash
                String[] words = messageText.split(" ");
                String firstWord = words[0];
                String lastWord = words[words.length - 1];

                String messageHash =
                        messageID.substring(0, 2)
                        + ":" + i + ":"
                        + firstWord.toUpperCase()
                        + lastWord.toUpperCase();

                System.out.println("Message Hash: " + messageHash);

                // Options
                System.out.println("\n1. Send Message");
                System.out.println("2. Store Message");
                System.out.println("3. Disregard Message");

                int choice = input.nextInt();
                input.nextLine();

                switch (choice) {

                    case 1:
                        messages.add(messageText);
                        totalMessages++;
                        System.out.println("Message sent successfully");
                        break;

                    case 2:
                        System.out.println("Message stored");
                        break;

                    case 3:
                        System.out.println("Message disregarded");
                        break;

                    default:
                        System.out.println("Invalid choice");
                }
            }

            // Print messages
            System.out.println("\n--- Messages Sent ---");
            for (String msg : messages) {
                System.out.println(msg);
            }

            System.out.println("Total messages sent: " + totalMessages);

        } else {
            System.out.println("Login failed. Please try again.");
        }
    }
}

