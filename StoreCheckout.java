import java.util.Scanner;

public class StoreCheckout {

    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int mouse = 0;
        int keyb = 0;
        int headph = 0;
        int laptop = 0;
        int subtotal = 0;

        while (true){
            System.out.print("===== SIMPLE STORE =====\n\n" +
                    "1. Mouse -           $20\n" +
                    "2. Keyboard -        $40\n" +
                    "3. Headphones -      $50\n" +
                    "4. Laptop Stand -    $30\n\n" +
                    "5. Checkout\n\n" +
                    "Choose a product: ");
            int choice = s.nextInt();
            if (choice < 1 || choice > 5)
                System.out.print("Invalid option. Pls choose an existing option.");
            else if (choice == 5)
                break;
            else {
                int prodpr = 0;
                String basket = "";
                if (choice == 1){
                    basket = "mouse";
                    prodpr = 20;
                }
                else if (choice == 2){
                    basket = "keyboard";
                    prodpr = 40;
                }
                else if (choice == 3){
                    basket = "Headphones";
                    prodpr = 50;
                }
                else if (choice == 4){
                    basket = "laptop stand";
                    prodpr = 30;
                }
                System.out.println("You selected: " + basket);
                System.out.println("Price: $" + prodpr);
                System.out.print("Enter quantity: ");
                int quantity = s.nextInt();

                if (quantity <= 0) {
                    System.out.println("Invalid quantity. Quantity must be greater than 0\n");
                } else {
                    int itemCost = prodpr * quantity;

                    if (quantity >= 5) {
                        itemCost = itemCost - (int)(itemCost * 0.05);
                        System.out.println("Bulk discount applied for this item!");
                    }

                    subtotal = subtotal + itemCost;

                    if (choice == 1) {
                        mouse = mouse + quantity;
                    } else if (choice == 2) {
                        keyb = keyb + quantity;
                    } else if (choice == 3) {
                        headph = headph + quantity;
                    } else if (choice == 4) {
                        laptop = laptop + quantity;
                    }

                    System.out.println(quantity + " x $" + prodpr + " = $" + itemCost);
                    System.out.println("Added to cart!");
                    System.out.println("Current total: $" + subtotal + "\n");
                }
            }
        }

        System.out.println("\n===== CHECKOUT =====");
        System.out.println("Subtotal: $" + subtotal);

        int discount = 0;
        if (subtotal >= 200) {
            discount = (int) (subtotal * 0.15);
            System.out.println("U received a 15% discount!");
        } else if (subtotal >= 100) {
            discount = (int) (subtotal * 0.10);
            System.out.println("U received a 10% discount!");
        }

        int finalTotal = subtotal - discount;
        System.out.println("Discount: $" + discount);
        System.out.println("Final total: $" + finalTotal);

        int paymentAmount = 0;
        while (true) {
            System.out.print("Enter payment amount: $");
            paymentAmount = s.nextInt();

            if (paymentAmount >= finalTotal) {
                System.out.println("Payment successful!");
                break;
            } else {
                int stillNeed = finalTotal - paymentAmount;
                System.out.println("Insufficient payment.");
                System.out.println("You still need to pay: $" + stillNeed);
            }
        }

        int change = paymentAmount - finalTotal;

        System.out.println("\n===== ITEMS PURCHASED =====");
        System.out.println("Mouse: " + mouse);
        System.out.println("Keyboard: " + keyb);
        System.out.println("Headphones: " + headph);
        System.out.println("Laptop Stand: " + laptop);

        String mostPurchasedProduct = "None";
        int maxQuantity = 0;

        if (mouse > maxQuantity) {
            maxQuantity = mouse;
            mostPurchasedProduct = "Mouse";
        }
        if (keyb > maxQuantity) {
            maxQuantity = keyb;
            mostPurchasedProduct = "Keyboard";
        }
        if (headph > maxQuantity) {
            maxQuantity = headph;
            mostPurchasedProduct = "Headphones";
        }
        if (laptop > maxQuantity) {
            maxQuantity = laptop;
            mostPurchasedProduct = "Laptop Stand";
        }

        if (maxQuantity > 0) {
            System.out.println("Most purchased product: " + mostPurchasedProduct);
            System.out.println("Quantity: " + maxQuantity);
        }

        int totalItemsPurchased = mouse + keyb + headph + laptop;
        if (totalItemsPurchased >= 10) {
            System.out.println("\nYou earned a $10 coupon for your next visit!");
        }

        System.out.println("\n========================");
        System.out.println("      SIMPLE STORE      ");
        System.out.println("========================");
        System.out.println("Items purchased: " + totalItemsPurchased);
        System.out.println("Subtotal:        $" + subtotal);
        System.out.println("Discount:        $" + discount);
        System.out.println("Final total:     $" + finalTotal);
        System.out.println("Payment:         $" + paymentAmount);
        System.out.println("Change:          $" + change);
        System.out.println("========================");
        System.out.println("Thank you for shopping!");
        System.out.println("========================");

        s.close();
    }
}