package Java_Contr;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        ToysShop shop = new ToysShop(new ArrayList<Toy>());

        while (true) {
            System.out.println(
                    "\nEnter SHOW to see all toys\n" +
                            "Enter NEW to add a new toy\n" +
                            "Enter ADD to increase a toy number\n" +
                            "Enter CHANCE to change toy's chance\n" +
                            "Enter RAFFLE to start toys raffle\n" +
                            "Enter ESC to exit\n");

            Scanner in = new Scanner(System.in);
            String command = in.nextLine();
            if (command.toLowerCase().equals("new"))
                shop.addToy();
            else if (command.toLowerCase().equals("show"))
                shop.viewAll();
            else if (command.toLowerCase().equals("chance"))
                shop.changeToyChance();
            else if (command.toLowerCase().equals("add"))
                shop.changeToyNumber();
            else if (command.toLowerCase().equals("esc")) {
                in.close();
                break;
            } else if (command.toLowerCase().equals("raffle")) {
                shop.raffle();
            } else
                System.out.println("Invalid command!\nTry again!\n");
        }
    }
}
