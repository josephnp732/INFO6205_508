package Knapsack;

/**
 * @author Christy
 * Item object holds the weight and the price of an item  
 *
 */
public class Item {

    private int weight;
    private int price;

    public int getWeight() {
        return weight;
    }

    public void setWeight(int volume) {
        this.weight = volume;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}