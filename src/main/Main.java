package main;

import java.util.InputMismatchException;
import java.util.Scanner;
import products.*;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Hello! Welcome to the Online Shopping Cart!");

        System.out.println("\nWhat would you like to do? ");

        Cart cart = new Cart();

        /* Sample Products Entry into the Shopping Cart for testing functional testing purposes */
        cart.add(new Product(77123, "Happy Meal", "Food", -1, 5.99), 3);
        cart.add(new Product(14882, "McFlurry", "Drinks", 5, 3.99), 2);
        cart.add(new Product(113123, "Nike Shoes", "Apparel", 2, 149.99), 1);

        System.out.println("Make a selection: (1) Add Product to Shopping Cart (2) Remove from Cart (3) Update Cart (4) Remove all from Cart");
        System.out.print("Enter your choice: ");
        int choice = input.nextInt();
        Product product = null;
        System.out.println();
        switch(choice) {
            case 1:
                product = createNewProduct();

                System.out.print("How many would you like to purchase? ");
                int quantity = input.nextInt();
                cart.add(product, quantity);

                System.out.println("\nThank you! Product#" + product.getProductID() + " has been added to your cart. ");

                viewCart(cart); 
                break;

            case 2:
            case 3:
                System.out.println("\nWhich product would you like to " + (choice == 2 ? "remove" : "update") + "? ");
                System.out.println("Search product by (1) ID (2) Name");
                System.out.print("Enter your choice: ");
                while(true) {
                    try {
                        int selection = input.nextInt();

                        /* Clear Input Buffer */
                        input.nextLine();

                        System.out.print("Enter product " + (selection == 1 ? "ID: " : "Name: "));
                        String key = input.nextLine();

                        if (choice == 2) {
                            product = cart.getProduct(selection, key);
                            if ( cart.remove(product) != 0) {
                                System.out.println("Sorry! There is no product in the shopping cart with that name. ");
                                System.out.println("Would you like to find a different product? (1) Yes (2) No");
                                System.out.print("Enter your choice: ");

                                int repeat = input.nextInt();
                                if (repeat == 2)
                                    break;
                            }
                        } else if (choice == 3) {

                            product = cart.getProduct(selection, key);

                            if ( cart.update(product) )
                                System.out.println("You have updated the item count of Product" + (selection == 1 ? "ID#": "Name: " ) + key);

                        } else {
                            System.out.println("Sorry! Your choice of input is invalid. ");
                        }

                        viewCart(cart);
                    } catch(InputMismatchException imex) {
                        printImexError();
                    } finally {
                        if(choice == 2) {
                            System.out.println("\nRemoved Product Details:\n" + product);
                            System.out.println("\nProduct has been removed. ");
                        }
                        else if(choice == 3) {
                            System.out.println("\nProduct has been updated. ");
                        }

                        break;
                    }
                }
                break;

            case 4:
                if(cart.removeAll())
                    System.out.println("Shopping Cart is Emptied. ");
                else
                    System.out.println("Sorry! Something was wrong in the processing of your request. ");

                break;

            default: System.out.println("Sorry! Your choice of input is invalid. ");
        }
    }

    public static Product createNewProduct() {
        Scanner input = new Scanner(System.in);

        System.out.println("\nAdding New Product...");
        System.out.println("\nEnter product details");

        System.out.print("Enter product ID: ");
        int productID = input.nextInt();

        /* Clear input buffer */
        input.nextLine();

        System.out.print("Enter product name: ");
        String productName = input.nextLine();

        System.out.print("Enter product category: ");
        String category = input.nextLine();

        System.out.print("Enter the purchase limit for the product: ");
        int purchaseLimit = input.nextInt();

        System.out.print("Enter the price: ");
        double price = input.nextDouble();

        return new Product(productID, productName, category, purchaseLimit, price);
    }

    public static void printImexError() {
        System.out.println("Sorry! Your choice is invalid. The input must be a single-digit integer. ");
        System.out.println("Please try again. ");
        System.out.println("\nEnter your choice: ");
    }

    public static void viewCart(Cart cart) {
        Scanner input = new Scanner(System.in);

        System.out.println("\n\nWould you like to view cart? (1) Yes (2) No ");
        System.out.print("Enter your choice: ");
        int choice = 0;
        while(choice != 1 && choice != 2) {

            try {
                choice = input.nextInt();

                if (choice == 1)
                    System.out.println(cart);

            } catch (InputMismatchException imex) {
                printImexError();
            }
        }
    }
}
