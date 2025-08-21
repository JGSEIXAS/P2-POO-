import java.util.Scanner;
import Entities.Product;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Entities.Product Data:");
        System.out.print("Name:");
        String name = sc.nextLine();
        System.out.print("Price:");
        Double price = sc.nextDouble();
        System.out.print("Quantity in Stock:");
        Integer quantity = sc.nextInt();
        Product products = new Product(name, price, quantity);
        System.out.println(products);
        System.out.println("Enter the number of products to be added in stock:");
        Integer add = sc.nextInt();
        products.AddProducts(add);
        System.out.println(products);
        System.out.println("Enter the number of products to be removed from stock");
        Integer remove = sc.nextInt();
        products.RemoveProducts(remove);
        System.out.println(products);
        sc.close();
    }
}