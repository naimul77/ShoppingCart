package main;

import products.Product;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Stack;

public class Cart {

    private HashMap<Product, Integer> products = new HashMap<>();
    private int totalProducts;
    private int cartLimit;

    public Cart() {
        this(0, null, 0);
    }

    public Cart(int cartLimit) {
        this(0, null, 0);
    }

    public Cart(int totalProducts, HashMap<Product, Integer> products, int cartLimit) {
        this.totalProducts = totalProducts;
        this.products = products;
        this.cartLimit = cartLimit;
    }

    public void setTotalProducts(int totalProducts) {
        this.totalProducts = totalProducts;
    }

    public HashMap<Product, Integer> getProducts() {
        return this.products;
    }

    public void setProducts(HashMap<Product, Integer> products) {
        this.products = products;
    }

    /*
        CRUD Implemenatin of operations for Online Shopping Cart
    */

    /* CREATE: Create Product item and store relevant information in List */
    public void add(Product product, int quantity) {
        if(this.products == null)
            products = new HashMap<Product, Integer>();

        this.products.put(product, quantity);

        totalProducts++;
    }

    public int getTotalProducts() {
        return totalProducts;
    }

    public int getCartLimit() {
        return cartLimit;
    }

    public void setCartLimit(int cartLimit) {
        this.cartLimit = cartLimit;
    }

    /* REMOVE: Remove specific product from list by Object identification */
    public int remove(Product product) {
        return this.products.remove(product);
    }

    /* REMOVE: Remove specific product from list by name */
    public int remove(String name) {
        for(Product product: products.keySet())
            if(product.getProductName() == name)
                return this.products.remove(product);

        return -1;
    }

    /* REMOVE by id: Remove specific product from list by id */
    public int remove(int id) {
        for(Product product: this.products.keySet())
            if(product.getProductID() == id)
                return this.products.remove(product);

        return -1;
    }

    /* REMOVE all: Remove all products from list */
    public boolean  removeAll() {
        this.products.clear();
        totalProducts = 0;

        return true;
    }

    /* UPDATE: Update specific product quantity in list */
    public boolean update(Product product) {

        int i = 1;
        for (Product prod : this.products.keySet()) {
            if (prod == product)
                break;

            i++;
        }

        if (i == totalProducts)
            return false;

        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.print("What quantity of this product would you like to update to? ");
            try {
                int temp = input.nextInt();
                this.products.put(product, temp);
                if (this.products.get(product) > product.getPurchaseLimit()) {
                    System.out.println("\nSorry! The purchase limit of this product is " + product.getPurchaseLimit());
                    System.out.println("You cannot purchase that many quantity of that product.");
                    continue;
                }
                return true;
            } catch (InputMismatchException imex) {
                System.out.println("\nSorry! You are only allowed to enter an integer value for this input format. ");
                System.out.println("Please try again. ");
            }
        }
    }

    /* READ: Retrieve a specific product from list */
    public Product getProduct(int option, String key) {
        switch (option) {

            case 1:
                for (Product product : this.products.keySet())
                    if (product.getProductID() == Integer.parseInt(key))
                        return product;

                break;

            case 2:
                for (Product product : this.products.keySet())
                    if (product.getProductName() == key)
                        return product;

                break;

            default: System.out.println("Sorry! The option you have selected is input. ");
        }
        return null;
    }

    /* Calculate Total Price */
    public double calculatePrice() {
        double sum = 0.0;
        int i = 0;
        for(Product product: this.products.keySet())
            sum += product.getPrice() * this.products.get(product);

        return sum;
    }

    /* View Cart */
    @Override
    public String toString() {

        String viewCart = "";
        for(Product product: this.products.keySet())
            viewCart += product;

        return "\nShopping Cart: " + (this.products == null && this.totalProducts == 0 ? " is empty." : viewCart);
    }

    /* Class Assignment: reverse a string */
    public String reverseString(String str) {
        Stack<Character> stack = new Stack<Character>();

        for(char character: str.toCharArray())
            stack.push(character);

        str = "";
        while(!stack.isEmpty())
            str += stack.pop();

        return str;
    }
}


