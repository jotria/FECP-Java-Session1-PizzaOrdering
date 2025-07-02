package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static String addOrder(ArrayList<String> pizzas, ArrayList<Integer> quantities, String pizzaType, int quantity){
        if (quantity <= 0){
            return "Quantity must be positive.";
        } else{
            pizzas.add(pizzaType);
            quantities.add(quantity);
            return "Order added: " + pizzaType + " x " + quantity;
        }
    }

    public static String updateOrder(ArrayList<Integer> quantities, int index, int newQuantity){
        if(index >= 0 && index < quantities.size()){
            if(newQuantity > 0){
                quantities.set(index, newQuantity);
                return "Order " + (index+1) + " updated to quantity " + newQuantity;
            } else{
                return "Invalid order.";
            }
        } else{
            return "Invalid order number.";
        }
    }

    public static String removeOrder(ArrayList<String> pizzas, ArrayList<Integer> quantities, int index){
        if(index >= 0 && index < quantities.size() && index < pizzas.size()){
            String removedPizza = pizzas.get(index);
            pizzas.remove(index);
            quantities.remove(index);
            return "Order " + (index+1) + " (" + removedPizza + ") removed";
        } else {
            return "Invalid order number.";
        }
    }

    public static String printOrders(ArrayList<String> pizzas, ArrayList<Integer> quantities){
        if(pizzas.isEmpty()){
            return "No current orders.";
        }

        ArrayList<String> lines = new ArrayList<>();
        lines.add("---Current Orders---");
        for (int i = 0; i < pizzas.size(); i++){
            lines.add((i+1) + ". " + pizzas.get(i) + " x " + quantities.get(i));
        }
        return String.join("\n", lines);
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int userChoice;
        ArrayList<String> pizzas = new ArrayList<>();
        ArrayList<Integer> quantities = new ArrayList<>();

        System.out.println("Pizza Ordering Menu");
        System.out.println("1. Add Order");
        System.out.println("2. Update Order");
        System.out.println("3. Remove Order");
        System.out.println("4. View Orders");
        System.out.println("5. Exit");

        do{
            System.out.print("\nChoose option: ");
            userChoice = scanner.nextInt();
            scanner.nextLine();

            switch (userChoice){
                case 1:
                    System.out.print("Pizza Type: ");
                    String pizza = scanner.nextLine();

                    int quantity = 0;

                    do{
                        System.out.print("Quantity: ");
                        quantity = scanner.nextInt();
                        scanner.nextLine();

                        System.out.println(addOrder(pizzas, quantities, pizza, quantity));
                    } while (quantity <= 0);

                    break;

                case 2:
                    System.out.print("Order number to update: ");
                    int orderNumber = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("New quantity: ");
                    int newQuantity = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println(updateOrder(quantities, orderNumber-1, newQuantity));

                    break;

                case 3:
                    System.out.print("Order number to remove: ");
                    int orderRemove = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println(removeOrder(pizzas, quantities, orderRemove-1));

                    break;

                case 4:
                    System.out.println(printOrders(pizzas, quantities));

                    break;

                case 5:
                    System.out.println("---Thank you!---");
                    break;
            }
        } while(userChoice < 5);

    }
}