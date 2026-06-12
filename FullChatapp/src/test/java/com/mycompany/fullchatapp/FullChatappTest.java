/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.fullchatapp;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

/**
 *
 * @author Student
 */
public class FullChatappTest {
    
   @Test
    public void testLongestMessage() {

        ArrayList<String> messages = new ArrayList<>();
        messages.add("Hello");
        messages.add("This is the longest message");
        messages.add("Hi");
        String longest = messages.get(0);
        for (String msg : messages) {
            if (msg.length() > longest.length()) {
                longest = msg;
            }
        }
        assertEquals("This is the longest message", longest);
    }

    @Test
    public void testSearchMessageIDFound() {

        ArrayList<String> messageIDs = new ArrayList<>();
        messageIDs.add("MSG001");
        messageIDs.add("MSG002");
        boolean found = false;
        String searchID = "MSG001";
        for (String id : messageIDs) {
            if (id.equals(searchID)) {
                found = true;
            }
        }
        assertTrue(found);
    }

    @Test
    public void testSearchMessageIDNotFound() {

        ArrayList<String> messageIDs = new ArrayList<>();
        messageIDs.add("MSG001");
        messageIDs.add("MSG002");
        boolean found = false;
        String searchID = "MSG999";
        for (String id : messageIDs) {
            if (id.equals(searchID)) {
                found = true;
            }
        }
        assertFalse(found);
    }

    @Test
    public void testSearchRecipientFound() {

        ArrayList<String> recipients = new ArrayList<>();
        recipients.add("+27831234567");
        recipients.add("+27839876543");
        boolean found = false;
        String recipient = "+27831234567";
        for (String r : recipients) {
            if (r.equals(recipient)) {
                found = true;
            }
        }
        assertTrue(found);
    }

    @Test
    public void testDeleteMessageHash() {

        ArrayList<String> messageHashes = new ArrayList<>();
        messageHashes.add("AB:1:HELLOWORLD");
        messageHashes.add("CD:2:GOODBYEWORLD");
        String hash = "AB:1:HELLOWORLD";
        boolean found = false;
        for (int i = 0; i < messageHashes.size(); i++) {
            if (messageHashes.get(i).equals(hash)) {
                messageHashes.remove(i);
                found = true;
                break;
            }
        }
        assertTrue(found);
        assertEquals(1, messageHashes.size());
    }

    @Test
    public void testSentMessagesCount() {

        ArrayList<String> messageStatus = new ArrayList<>();

        messageStatus.add("Sent");
        messageStatus.add("Stored");
        messageStatus.add("Sent");
        messageStatus.add("Disregarded");

        int sentCount = 0;

        for (String status : messageStatus) {

            if (status.equals("Sent")) {
                sentCount++;
            }
        }
        assertEquals(2, sentCount);
    }

    @Test
    public void testStoredMessagesCount() {

        ArrayList<String> messageStatus = new ArrayList<>();
        messageStatus.add("Stored");
        messageStatus.add("Stored");
        messageStatus.add("Sent");

        int storedCount = 0;

        for (String status : messageStatus) {

            if (status.equals("Stored")) {
                storedCount++;
            }
        }

        assertEquals(2, storedCount);
    }

    @Test
    public void testDisregardedMessagesCount() {

        ArrayList<String> messageStatus = new ArrayList<>();
        messageStatus.add("Disregarded");
        messageStatus.add("Sent");
        messageStatus.add("Disregarded");
        int disregardedCount = 0;
        for (String status : messageStatus) {
            if (status.equals("Disregarded")) {
                disregardedCount++;
            }
        }
        assertEquals(2, disregardedCount);
    }
}  