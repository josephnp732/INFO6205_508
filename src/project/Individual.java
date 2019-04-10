package project;

import java.util.ArrayList;
import java.util.Random;
import static project.Values.knapsackCapacity;
import static project.Values.totalItems;

public class Individual {

    public ArrayList<Integer> genes;
    public int weight;
    public int price;
    public int individualFitness;
    
    public Individual() {
    	this.genes = new ArrayList<>();
    }

    /** Generates Genes of the size of the total Number of items  **/
    public void generateGenes() {
        Random rand = new Random();
        for (int i = 0; i < totalItems; i++) {
            this.genes.add(rand.nextInt(2));
        }
        calculateGeneFitness();
    }

    /** Calculates fitness for each gene **/
    public void calculateGeneFitness() {
        int tempPrice = 0;
        int tempWeight = 0;
        for (int i = 0; i < totalItems; i++) {
            if (this.genes.get(i) == 1) {
                tempWeight = tempWeight + Run.itemList.get(i).getWeight();
                tempPrice = tempPrice + Run.itemList.get(i).getPrice();
            }
        }
        this.price = tempPrice;
        this.weight = tempWeight;
        if (this.weight <= knapsackCapacity) {    //Checking if the knapsack can sustain the total weight of the items
            this.individualFitness = this.price;
        }
    }
    
    /** Getters and Setters **/
    public ArrayList<Integer> getGenes() {
        return genes;
    }

    public void setGenes(ArrayList<Integer> genes) {
        this.genes = genes;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getFitness() {
        return individualFitness;
    }

    public void setFitness(int fitness) {
        this.individualFitness = fitness;
    }
}