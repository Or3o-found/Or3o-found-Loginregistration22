/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.fullchatapp;

import java.util.ArrayList;
import java.util.Scanner; 

/**
 *
 * @author Student
 */
public class FullChatapp {

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

        System.out.print("Enter phone number (+27): ");
        String phoneNumber = input.nextLine();

        if (phoneNumber.matches("\\+27\\d{9}")) {
            System.out.println("Phone number successfully captured");
        } else {
            System.out.println("Phone number not correctly formatted");
        }

        // ================= LOGIN =================
        System.out.println("\n===== LOGIN =====");

        System.out.print("Enter username: ");
        String loginUsername = input.nextLine();

        System.out.print("Enter password: ");
        String loginPassword = input.nextLine();

        System.out.print("Enter phone number: ");
        String loginPhone = input.nextLine();

        if (loginUsername.equals(username)
                && loginPassword.equals(password)
                && loginPhone.equals(phoneNumber)) {

            System.out.println("\nLogin successful!");
            System.out.println("Welcome to QuickChat");

            // ================= ARRAYLISTS =================
            ArrayList<String> messageIDs = new ArrayList<>();
            ArrayList<String> recipients = new ArrayList<>();
            ArrayList<String> messages = new ArrayList<>();
            ArrayList<String> messageHashes = new ArrayList<>();
            ArrayList<String> messageStatus = new ArrayList<>();

            System.out.print("\nHow many messages would you like to process? ");
            int numberOfMessages = input.nextInt();
            input.nextLine();

            for (int i = 1; i <= numberOfMessages; i++) {

                System.out.println("\n===== MESSAGE " + i + " =====");

                System.out.print("Enter Message ID: ");
                String messageID = input.nextLine();

                System.out.print("Enter recipient cell number: ");
                String recipient = input.nextLine();

                System.out.print("Enter message: ");
                String messageText = input.nextLine();

                String[] words = messageText.split(" ");
                String firstWord = words[0];
                String lastWord = words[words.length - 1];

                String messageHash =
                        messageID.substring(0, 2).toUpperCase()
                        + ":" + i + ":"
                        + firstWord.toUpperCase()
                        + lastWord.toUpperCase();

                System.out.println("Message Hash: " + messageHash);

                System.out.println("\n1. Send Message");
                System.out.println("2. Store Message");
                System.out.println("3. Disregard Message");
                System.out.print("Choose option: ");

                int choice = input.nextInt();
                input.nextLine();

                String status = "";

                switch (choice) {

                    case 1:
                        status = "Sent";
                        System.out.println("Message sent successfully.");
                        break;

                    case 2:
                        status = "Stored";
                        System.out.println("Message stored successfully.");
                        break;

                    case 3:
                        status = "Disregarded";
                        System.out.println("Message disregarded.");
                        break;

                    default:
                        status = "Unknown";
                        System.out.println("Invalid option.");
                }

                messageIDs.add(messageID);
                recipients.add(recipient);
                messages.add(messageText);
                messageHashes.add(messageHash);
                messageStatus.add(status);
            }

            // ================= MENU =================
            while (true) {

                System.out.println("\n===== QUICKCHAT MENU =====");
                System.out.println("1. Display All Messages");
                System.out.println("2. Display Longest Message");
                System.out.println("3. Search by Message ID");
                System.out.println("4. Search by Recipient");
                System.out.println("5. Delete by Message Hash");
                System.out.println("6. Full Report");
                System.out.println("7. Exit");

                System.out.print("Choose option: ");
                int menuChoice = input.nextInt();
                input.nextLine();

                if (menuChoice == 1) {

                    for (int i = 0; i < messages.size(); i++) {

                        System.out.println("\nMessage ID: " + messageIDs.get(i));
                        System.out.println("Recipient: " + recipients.get(i));
                        System.out.println("Message: " + messages.get(i));
                        System.out.println("Hash: " + messageHashes.get(i));
                        System.out.println("Status: " + messageStatus.get(i));
                    }

                } else if (menuChoice == 2) {

                    if (!messages.isEmpty()) {

                        String longest = messages.get(0);

                        for (String msg : messages) {
                            if (msg.length() > longest.length()) {
                                longest = msg;
                            }
                        }

                        System.out.println("\nLongest Message:");
                        System.out.println(longest);
                    }

                } else if (menuChoice == 3) {

                    System.out.print("Enter Message ID: ");
                    String searchID = input.nextLine();

                    boolean found = false;

                    for (int i = 0; i < messageIDs.size(); i++) {

                        if (messageIDs.get(i).equals(searchID)) {

                            System.out.println("Message: "
                                    + messages.get(i));
                            found = true;
                        }
                    }

                    if (!found) {
                        System.out.println("Message not found.");
                    }

                } else if (menuChoice == 4) {

                    System.out.print("Enter recipient: ");
                    String searchRecipient = input.nextLine();

                    boolean found = false;

                    for (int i = 0; i < recipients.size(); i++) {

                        if (recipients.get(i).equals(searchRecipient)) {

                            System.out.println(messages.get(i));
                            found = true;
                        }
                    }

                    if (!found) {
                        System.out.println("No messages found.");
                    }

                } else if (menuChoice == 5) {

                    System.out.print("Enter Message Hash: ");
                    String hash = input.nextLine();

                    boolean found = false;

                    for (int i = 0; i < messageHashes.size(); i++) {

                        if (messageHashes.get(i).equalsIgnoreCase(hash)) {

                            messageIDs.remove(i);
                            recipients.remove(i);
                            messages.remove(i);
                            messageHashes.remove(i);
                            messageStatus.remove(i);

                            System.out.println("Message deleted.");
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Hash not found.");
                    }

                } else if (menuChoice == 6) {

                    System.out.println("\n===== QUICKCHAT REPORT =====");

                    int sentCount = 0;
                    int storedCount = 0;
                    int disregardedCount = 0;

                    for (int i = 0; i < messages.size(); i++) {

                        System.out.println("--------------------------------");
                        System.out.println("Message ID: " + messageIDs.get(i));
                        System.out.println("Recipient: " + recipients.get(i));
                        System.out.println("Message: " + messages.get(i));
                        System.out.println("Hash: " + messageHashes.get(i));
                        System.out.println("Status: " + messageStatus.get(i));

                        if (messageStatus.get(i).equals("Sent")) {
                            sentCount++;
                        } else if (messageStatus.get(i).equals("Stored")) {
                            storedCount++;
                        } else if (messageStatus.get(i).equals("Disregarded")) {
                            disregardedCount++;
                        }
                    }

                    System.out.println("\n===== SUMMARY =====");
                    System.out.println("Sent Messages: " + sentCount);
                    System.out.println("Stored Messages: " + storedCount);
                    System.out.println("Disregarded Messages: " + disregardedCount);

                } else if (menuChoice == 7) {

                    System.out.println("Goodbye!");
                    break;

                } else {

                    System.out.println("Invalid option.");
                }
            }

        } else {

            System.out.println("Login failed.");
        }

        input.close();
    }
}

