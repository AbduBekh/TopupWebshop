import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<FixedPrice> fixedproducts = FixedFileReader.read("fix_priced_products.txt");
    static List<VariablePrice> variableproducts = VarFileReader.read("variable_priced_products.txt");
    static List<Transaction> transactionHistory = new ArrayList<>();
    static Customer customer = new Customer("Abderrahmen Belkhiria", "EUR",10000);

    public static void main(String[] args) {

       /*Testing the data parsing
        for (int i = 0; i < fixedproducts.size(); i++) {
            System.out.println((i + 1) + ". " + fixedproducts.get(i).getName());
        }*/

        while (true) {
            printOptions();
            int input = readInput();
            switch (input) {
                case 1:
                    buyFixedPrice();
                    break;
                case 2:
                    buyVariablePrice();
                    break;
                case 3:
                    System.out.println("Enter the transaction ID to refund:");
                    int transactionId = readInput();
                    refund(transactionId);
                    break;
                case 4:
                    System.out.println("Closing website window.\n");
                    return;
                default:
                    System.out.println("Invalid input!\n");
                    break;
            }
        }
    }


    private static void refund(int transactionID) {
        Transaction transactionToRefund = null;
        for (Transaction transaction : transactionHistory) {
            if (transaction.getId() == transactionID) {
                transactionToRefund = transaction;
                break;
            }
        }
        if (transactionToRefund != null) {
            if ("PAID".equals(transactionToRefund.getStatus().toString())) {

                if (transactionToRefund.getFixedproduct() != null) {
                    customer.setBalance(customer.getBalance() + transactionToRefund.getFixedproduct().getPrice());
                    transactionToRefund.getFixedproduct().setQuantity(transactionToRefund.getFixedproduct().getQuantity() + 1);

                }
                else if (transactionToRefund.getVarproduct() != null) {
                    customer.setBalance(customer.getBalance() + transactionToRefund.getVariablePrice());
                    transactionToRefund.getVarproduct().setQuantity(transactionToRefund.getVarproduct().getQuantity() + 1);
                }
                transactionToRefund.setStatus(Status.REFUNDED);
                System.out.println("Transaction refunded successfully!");
                System.out.println("Balance increased: " + customer.getBalance());


                } else {
                System.out.println("Cannot refund transaction. Status is not PAID.");
            }
        } else {
            System.out.println("Transaction not found.");
        }
    }

    private static void buyVariablePrice() {
        System.out.println("Available variable priced products:");
        for (int i = 0; i < variableproducts.size(); i++) {
            System.out.println((i + 1) + ". " + variableproducts.get(i).getName());
        }

        System.out.println("Enter the number of the product you want to buy:");
        int choice = readInput();

        if (choice >= 1 && choice <= variableproducts.size()) {
            VariablePrice selectedProduct = variableproducts.get(choice - 1);
            if (selectedProduct.getQuantity() > 0) {
                System.out.println("Enter the price for the variable product between " + selectedProduct.getMinPrice() + "and " + selectedProduct.getMaxPrice()+": ");
                double price = readDoubleInput();
                if (customer.getBalance() >= price) {

                    customer.setBalance(customer.getBalance() - price);

                    selectedProduct.setQuantity(selectedProduct.getQuantity() - 1);

                    Transaction newTransaction = new Transaction(selectedProduct, price, LocalDateTime.now(), Status.PAID);
                    transactionHistory.add(newTransaction);

                    System.out.println("Product purchased successfully!");
                    System.out.println("Transaction ID: " + newTransaction.getId());
                } else {
                    System.out.println("Insufficient balance to buy the product.");
                }
            } else {
                System.out.println("Product is out of stock.");
            }
        } else {
            System.out.println("Invalid product choice.");
        }
    }

    private static void buyFixedPrice() {
        System.out.println("Available fixed priced products:");
        /*for (FixedPrice product : fixedproducts) {
            System.out.println(product.getName());
        }*/
        for (int i = 0; i < fixedproducts.size(); i++) {
            System.out.println((i + 1) + ". " + fixedproducts.get(i).getName());
        }
        System.out.println("Enter the number of the product you want to buy:");
        int choice = readInput();
        if (choice >= 1 && choice <= fixedproducts.size()) {
            FixedPrice selectedProduct = fixedproducts.get(choice - 1);
            if (selectedProduct.getQuantity()>0) {
                double price = selectedProduct.getPrice();
                if (customer.getBalance() >= price) {

                    customer.setBalance(customer.getBalance() - price);

                    selectedProduct.setQuantity(selectedProduct.getQuantity()-1);

                    Transaction newT = new Transaction(selectedProduct, LocalDateTime.now(), Status.PAID);

                    transactionHistory.add(newT);

                    System.out.println("Product purchased successfully! Here's the transaction ID:" + newT.getId());
                } else {
                    System.out.println("Insufficient balance to buy the product.");
                }
            }else {
                System.out.println("Out of Stock.");
            }
        } else {
            System.out.println("Invalid product choice.");
        }


    }

    private static void printOptions() {
        System.out.println("Your current balance is: " +customer.getBalance());

        System.out.println("(1) Buy a fix priced product.");
        System.out.println("(2) Buy a variable priced product.");
        System.out.println("(3) Refund an order.");
        System.out.println("(4) Close the webshop window.");
        System.out.println("\nWhat do you want to do?");
    }
    private static double readDoubleInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextDouble();
    }

    private static int readInput() {
        Scanner scanner = new Scanner(System.in);
        int input;
        try {
            input = scanner.nextInt();
        } catch (Exception e) {
            input = 0;
        }
        return input;
    }
}