package com.company;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class InventoryManagement {
    private int countEquipment;

    static String returnFirstNumber(String string) {
        StringBuilder result = new StringBuilder();
        string = string.replaceAll("^.\\D", " ");
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) != ' ') {
                while (string.charAt(i) != ' ') {
                    //result += string.charAt(i);
                    result.append(string.charAt(i));
                    i++;
                    if (i == string.length()) break;
                }
                return result.toString();
            }
        }
        return "";
    }

    public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

    public static int getInt(Scanner scanner) {
        StringBuilder result = new StringBuilder();
        String string = "";
        while (true) {
            string = scanner.nextLine();
            string = string.replaceAll("\\D", "");
            for (int i = 0; i < string.length(); i++) {
                if (string.charAt(i) != ' ') {
                    while (string.charAt(i) != ' ') {
                        result.append(string.charAt(i));
                        i++;
                        if (i == string.length()) break;
                    }
                }
            }
            if(isNumeric(result.toString())) {
                return Integer.parseInt(result.toString());
            } else {
                result.setLength(0);
                System.out.print("Было введенно некорректное значение!\n\r Введите повторно:");
            }
        }

    }

    public int setCountEquipment(Scanner scanner) {
        System.out.print("Введите кол-во предметов инвентаря: ");
        scanner = new Scanner(System.in);
        //String string = scanner.nextLine();

        this.countEquipment = getInt(scanner);
        return this.countEquipment;
    }

    public void setTypeEquipment(Scanner scanner, int i, SportsEquipment[] sportsEquipments) {
        String string;
        short typeNumber = -1;
        System.out.print("Введите тип инвентаря: \n" +
                "1.Волейбольный мяч\n" +
                "2.Теннисный мяч\n" +
                "3.Ракетка\n" +
                "4.Штанга\n" +
                "5.Гиря\n" +
                "6.Метательное копье\n");
        do {
            string = scanner.nextLine();
            string = InventoryManagement.returnFirstNumber(string);
            typeNumber = Short.parseShort(string);
            switch (typeNumber) {
                case 1 -> {
                    System.out.println("Вы выбрали волейбольный мяч. \n");
                    Ball.Volleyball volleyball = new Ball.Volleyball();
                    volleyball.init(scanner);
                    sportsEquipments[i] = volleyball;
                }
                case 2 -> {
                    System.out.println("Вы выбрали теннисный мяч. \n");
                    Ball.TennisBall tennisBall = new Ball.TennisBall();
                    tennisBall.init(scanner);
                    sportsEquipments[i] = tennisBall;
                }
                case 3 -> {
                    System.out.println("Вы выбрали ракетку. \n");
                    Racket racket = new Racket();
                    racket.init(scanner);
                    sportsEquipments[i] = racket;
                }
                case 4 -> {
                    System.out.println("Вы выбрали штангу. \n");
                    TrainingEquipment.Weight weight = new TrainingEquipment.Weight();
                    weight.init(scanner);
                    sportsEquipments[i] = weight;
                }
                case 5 -> {
                    System.out.println("Вы выбрали гирю. \n");
                    TrainingEquipment.Barbel barbel = new TrainingEquipment.Barbel();
                    barbel.init(scanner);
                    sportsEquipments[i] = barbel;
                }
                case 6 -> {
                    System.out.println("Вы выбрали метательное копье. \n");
                    ThrowingSpear throwingSpear = new ThrowingSpear();
                    throwingSpear.init(scanner);
                    sportsEquipments[i] = throwingSpear;
                }
            }

        } while (!(typeNumber >= 0 && typeNumber <= 6));
    }

    public void putEquipmentItem(Scanner scanner, SportsEquipment[] sportsEquipments) {
        for (int i = 0; i < this.countEquipment; i++) {
            this.setTypeEquipment(scanner, i, sportsEquipments);
        }
    }

    public void outEquipmentAll(SportsEquipment[] sportsEquipments) {
        System.out.println("Вывод всего оборудования.");
        for (SportsEquipment equipment : sportsEquipments) {
            System.out.println(equipment.toString());
        }
    }

    public void outEquipmentTennis(SportsEquipment[] sportsEquipments) {
        System.out.println("Вывод теннисного оборудования.");
        for (SportsEquipment equipment : sportsEquipments) {
            if (equipment.getSportType().toLowerCase(Locale.ROOT).equals("теннис")) {
                System.out.println(equipment.toString());
            }
        }
    }
}
