/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.loginregistration22;

import java.util.Scanner;

/**
 *
 * @author Student
 */
public class Menu{
     
   static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args){
         
       boolean running = true;
       
       while (running){
           //Displaying the menu
           System.out.println("\n---Menu---");
           System.out.println("1. Send Messages");
           System.out.println("2. Show recently sent message");
           System.out.println("3. Quit");
           System.out.println("Choose option: ");
           
           int choice = scanner.nextInt();
           scanner.nextLine();
           
           //Menu Choices
        if (choice == 1){
            System.out.println("\n-You selected: Send Messages-");
            System.out.println("This feature will be implemented here. ");
        } else if (choice == 2){
            System.out.println("\n-You selected: Show recently sent message-");
            System.out.println("Coming Soon. ");
        }else if (choice == 3){
            System.out.println("\n-Goodbye-");
            running = false;
        }
           
           
       }
    }
}
    
     