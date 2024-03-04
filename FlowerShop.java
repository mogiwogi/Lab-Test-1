/**
 * Program Description : Develop a Java class named FlowerShop that acts as a driver class for the flower management system.
 *
 * Programmer : Adam Isyraf
 * Date : 22/2/2024
 */

import java.util.Scanner;

class Flower {
    private String name;
    private String color;
    private double price;
    private int quantity;
    
    // construction
    public Flower() {
        this.name = "";
        this.color = "";
        this.price = 0.0;
        this.quantity = 0;
    }

    public Flower(String name, String color, double price, int quantity) {
        this.name = name;
        this.color = color;
        this.price = price;
        this.quantity = quantity;
    }

    // (accessors)
    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    // (mutators)
    public void setName(String name) {
        this.name = name;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // toString method
    @Override
    public String toString() {
        return "Flower [Name: " + name + ", Color: " + color + ", Price: " + price + ", Quantity: " + quantity + "]";
    }
}

public class FlowerShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Flower[] inventory = new Flower[10];
        
        // prompt user to enter data for each flower & store objects in array
        for (int i = 0; i < inventory.length; i++) {
            System.out.println("Enter details for Flower #" + (i+1) + ":");
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Color: ");
            String color = scanner.nextLine();
            System.out.print("Price: ");
            double price = scanner.nextDouble();
            System.out.print("Quantity: ");
            int quantity = scanner.nextInt();
            scanner.nextLine(); // consume newline
            
            inventory[i] = new Flower(name, color, price, quantity);
        }
        
        // display flower details
        System.out.println("\nFlower Inventory:");
        for (Flower flower : inventory) {
            System.out.println(flower);
        }
        
        // calculate & display total values of the flower inventory (everything user inputted)
        double totalValue = 0.0;
        for (Flower flower : inventory) {
            totalValue += flower.getPrice() * flower.getQuantity();
        }
        System.out.println("\nTotal value of flower inventory: $" + totalValue);
        
        // allow user to search for a flower by name and display its details
        System.out.print("\nEnter the name of the flower to search: ");
        String searchName = scanner.nextLine();
        boolean found = false;
        for (Flower flower : inventory) {
            if (flower.getName().equalsIgnoreCase(searchName)) {
                System.out.println("\nFound Flower:");
                System.out.println(flower);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("\nThe flower " + searchName + " cannot be found.");
        }
        
        // add a method to restock a specific flower in the inventory
        System.out.print("\nEnter the name of the flower to restock: ");
        String restockName = scanner.nextLine();
        for (Flower flower : inventory) {
            if (flower.getName().equalsIgnoreCase(restockName)) {
                System.out.print("Enter quantity to add: ");
                int quantityToAdd = scanner.nextInt();
                flower.setQuantity(flower.getQuantity() + quantityToAdd);
                System.out.println("\nRestocked " + restockName + " by " + quantityToAdd + " units.");
                break;
            }
        }
        
        // display updated flower inventory
        System.out.println("\nUpdated Flower Inventory:");
        for (Flower flower : inventory) {
            System.out.println(flower);
        }
        
        scanner.close();
    }
} //end
