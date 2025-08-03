package Entities;

public class Product {
    private String name;
    private Double price;
    private Integer quantity;

    public Product(String name, Double price, Integer quantity){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public double TotalValueinStock(){
        return this.price * this.quantity;
    }
    public void AddProducts(Integer quantity){
        this.quantity += quantity;
    }
    public void RemoveProducts(Integer quantity){
        this.quantity -= quantity;
    }
    @Override
    public String toString() {
        return "Product data: " +
                this.name +
                " $ " + this.price +
                ", Quantity: " + this.quantity +
                " Total: " + TotalValueinStock();
    }
}
