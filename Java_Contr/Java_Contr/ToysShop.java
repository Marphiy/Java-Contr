package Java_Contr;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.io.*;
import java.util.Date;

public class ToysShop {
    private ArrayList<Toy> toysShop = new ArrayList<>();

    public ToysShop(ArrayList<Toy> toysShop) {
        this.toysShop = toysShop;
    }

    public void raffle() {
        Comparator<Toy> tcc = (o1, o2) -> o2.getChance() - o1.getChance();
        PriorityQueue<Toy> raffleQueue = new PriorityQueue<>(tcc);
        System.out.println("\n                   RAFFLE LIST:\n");
        for (Toy toy : toysShop) {
            if (toy.getNumber() > 0) {
                raffleQueue.add(toy);
                System.out.printf("%s\n", toy);
            }
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Press Enter to start raffle!\n");
        int winner = 0;
        Toy currentToy = null;
        while ((currentToy = raffleQueue.poll()) != null) {
            winner += 1;
            scanner.nextLine();
            System.out.printf("Winner #%d gets %s\n", winner, currentToy);

            try (FileWriter writer = new FileWriter("raffles.txt", true)) {
                String text = String.format("%s: %s\n", new Date().toString(), currentToy);
                writer.append(text);
                writer.flush();
            } catch (IOException ex) {

                System.out.println(ex.getMessage());
            }

            toyOff(currentToy);
            System.out.println("\n               CURRENT RAFFLE QUEUE\n");
            for (Toy toy : raffleQueue) {
                System.out.printf("%s\n", toy);
            }
        }
    }

    public void changeToyNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEnter toy's name to change it's number: ");
        String name = scanner.nextLine();
        Boolean eq = false;
        int number = 0;
        for (Toy toy : toysShop) {
            eq = false;
            if (toy.getName().equals(name.toLowerCase())) {
                while (true) {
                    number = enterDigitTry("\nEnter new number: ");
                    if (number > 0 && number < 101)
                        break;
                    else
                        System.out.println("Valid value must be in 1 - 100%!\n");
                }
                toy.setNumber(toy.getNumber() + number);
                eq = true;
            }
            if (eq)
                System.out.printf("\n%s's number has been changed to %d!\n", name, toy.getNumber());
        }
    }

    public void changeToyChance() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEnter toy's name to change it's chance: ");
        String name = scanner.nextLine();
        Boolean eq = false;
        int chance = 0;
        for (Toy toy : toysShop) {
            eq = false;
            if (toy.getName().equals(name.toLowerCase())) {
                while (true) {
                    chance = enterDigitTry("\nEnter new chance: ");
                    if (chance > 0 && chance < 101)
                        break;
                    else
                        System.out.println("Valid value must be in 1 - 100%!\n");
                }
                toy.setChance(chance);
                eq = true;
            }
            if (eq)
                System.out.printf("\n%s's chance has been changed to %d!\n", name, chance);
        }
    }

    public void toyOff(Toy toy) {
        if (toy.getNumber() > 0) {
            toy.setNumber(toy.getNumber() - 1);
        } else
            System.out.println("Not enouhg toys!\n");
        ;
    }

    public int enterDigitTry(String str) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(str);
        int dig = 0;
        while (true) {
            try {
                dig = Integer.parseInt((scanner.nextLine()));
                if (dig > 0)
                    break;
                else
                    System.out.println("No negative values! Try again!");
            } catch (NumberFormatException e) {
                System.out.println("Wrong data type! Try it again!");
            }
        }
        return dig;
    }

    public void addToy() {
        Scanner scanner = new Scanner(System.in);
        int id;
        String name;
        int chance;
        int number;
        Boolean eq = false;
        while (true) {
            eq = false;
            id = enterDigitTry("\nEnter the new toy's id: ");
            for (Toy toy : toysShop) {
                if (toy.getId().equals(id)) {
                    eq = true;
                }
            }
            if (!eq) {
                break;
            } else
                System.out.println("id is not uniq! Try again!\n");
        }
        while (true) {
            eq = false;
            System.out.println("\nEnter the new toy's name: ");
            name = scanner.nextLine();
            for (Toy toy : toysShop) {
                if (toy.getName().equals(name)) {
                    eq = true;
                }
            }
            if (!eq) {
                break;
            } else {
                System.out.println("Name is not uniq! Try again!");
            }
        }
        while (true) {
            chance = enterDigitTry("\nEnter the new toy's chance: ");
            if (chance > 0 && chance < 101)
                break;
            else
                System.out.println("Valid value must be in 1 - 100%!\n");
        }
        while (true) {
            number = enterDigitTry("\nEnter the new toy's number: ");
            if (number > 0 && number < 101)
                break;
            else
                System.out.println("Valid value must be in 1 - 100%!\n");
        }
        toysShop.add(new Toy(id, name, chance, number));
    }

    public void viewAll() {
        System.out.println("\n                  TOYS SHOP\n");
        for (Toy toy : toysShop)
            System.out.printf("%s\n", toy);
    }
}
