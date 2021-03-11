package com.company;

import java.util.Scanner;

public class TrainingEquipment extends SportsEquipment {
    private float weight;
    private String matherial;

    @Override
    protected void init(Scanner scanner) {
        super.init(scanner);
        String string;
        do {
            System.out.print("Вес оборудования (кг): ");
            string = scanner.nextLine();
            string = InventoryManagement.returnFirstNumber(string);
            try {
                this.weight = Short.parseShort(string);
            } catch (Exception e) {
                this.weight = 0;
            }
        } while (this.weight < 0);
        do {
            System.out.print("Материал из которого сделано оборудование: ");
            this.matherial = scanner.nextLine();

        } while (this.matherial.isEmpty());
    }

    @Override
    public String toString() {
        String str = super.toString();
        return (str + "\n\tВес: " + this.weight + " кг \n\tМатерил: " + this.matherial);
    }

    static class Weight extends TrainingEquipment {
        int price;

        @Override
        protected void init(Scanner scanner) {
            super.init(scanner);
            do {
                String string;
                System.out.print("Введите цену оборудования: ");
                string = scanner.nextLine();
                string = InventoryManagement.returnFirstNumber(string);
                try {
                    this.price = Integer.parseInt(string);
                } catch (Exception e) {
                    this.price = 0;
                }
            } while (this.price < 0);
        }
        @Override
        public String toString() {
            String str = super.toString();
            return ("Штанга" + str + "\n\tЦена оборудования: " + this.price);
        }
    }
    //Гиря
    static class Barbel extends TrainingEquipment {
        float diametr;
        @Override
        protected void init(Scanner scanner) {
            super.init(scanner);
            do {
                String string;
                System.out.print("Введите диаметр окружности гири: ");
                string = scanner.nextLine();
                string = InventoryManagement.returnFirstNumber(string);
                try {
                    this.diametr = Integer.parseInt(string);
                } catch (Exception e) {
                    this.diametr = 0;
                }
            } while (this.diametr < 0);
        }
        @Override
        public String toString() {
            String str = super.toString();
            return ("Гиря" + str + "\n\tДиаметрг окружности гири: " + this.diametr + "см");
        }
    }
}
