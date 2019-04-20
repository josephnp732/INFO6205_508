package Knapsack;

import static Knapsack.Values.knapsackCapacity;
import static Knapsack.Values.totalItems;

import java.util.ArrayList;
import java.util.Random;

public class Individual {

	 public ArrayList<Integer> genes;
	    public int weight;
	    public int price;
	    public ArrayList<Integer> phenotype; 
	    public int individualFitness;
	    
	    public Individual() {
	    	this.genes = new ArrayList<>();
	    	this.phenotype = new ArrayList<Integer>();
	    }

	    /** Generates Genes of the size of the total Number of items  **/
	    public void generateGenes() {
	        Random rand = new Random();
	        for (int i = 0; i < totalItems; i++) {
	            this.genes.add(rand.nextInt(2));
	        }
	        calculateGeneFitness();
	        generatePhenotype();
	    }

	    /** Calculates fitness for each gene **/
	    public void calculateGeneFitness() {
	        int tempPrice = 0;
	        int tempWeight = 0;
	        for (int i = 0; i < totalItems; i++) {
	            if (this.genes.get(i) == 1) {
	                tempWeight = tempWeight + ItemRoster.itemList.get(i).getWeight();
	                tempPrice = tempPrice + ItemRoster.itemList.get(i).getPrice();
	            }
	        }
	        this.price = tempPrice;
	        this.weight = tempWeight;
	        if (this.weight > knapsackCapacity) {    //Checking if the knapsack can sustain the total weight of the items
	        	this.individualFitness = (-1)*(this.weight/knapsackCapacity)*this.price;
	        } 
	        else {
	        	this.individualFitness = this.price;
	        }
	    }
	    
	    
	    public void generatePhenotype() {
	    	for(int i:genes) {
	    		if (i== 0)
	    			continue;
	    		else {
	    			phenotype.add(genes.indexOf(i));
	    		}
	    	}
	    	
	    }
	    
	    
	    /** Getters and Setters **/
	    public ArrayList<Integer> getGenes() {
	        return genes;
	    }

	    public void setGenes(ArrayList<Integer> genes) {
	    	ArrayList<Integer> tempgenes = new ArrayList<Integer>();
	    	tempgenes.addAll(genes);
	    	this.genes.clear();
	        this.genes.addAll(genes);
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