package com.pluralsight;

import javax.security.auth.kerberos.KerberosTicket;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileInputStream;

public class App {
    public static void main(String args[]){
        Scanner Keyboard = new Scanner(System.in);
        System.out.println("Welcome please choose one of the following Bedtime Stories: ");
        System.out.println("1. goldilocks.txt");
        System.out.println("2. hansel_and_gretel.txt");
        System.out.println("3. mary_had_a_little_lamb.txt");
        String storyName = Keyboard.nextLine();

        switch (storyName) {
            case "1":
                storyName = "goldilocks.txt";
                break;
            case "2":
                storyName = "hansel_and_gretel.txt";
                break;
            case "3":
                storyName = "mary_had_a_litle_lamb.txt";
                break;
            default:
                System.out.println("Invalid Selection. Please choose from 1-3.");
                Keyboard.close();
                return;
        }

        try {
            FileInputStream fis = new FileInputStream(storyName);
            Scanner storyScanner = new Scanner(fis);
            String input;
            int lineNumber = 0;

            while (storyScanner.hasNextLine()) {
                input = storyScanner.nextLine();
                System.out.println(lineNumber + ": " + input);
                lineNumber++;
            }
           storyScanner.close();
        }
        catch (IOException e) {
            e.printStackTrace();
            Keyboard.close();

        }
    }
}
