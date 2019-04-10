package Knapsack;

import static Knapsack.Values.totalItems;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Run {

    public static List<Item> itemList = new ArrayList<>();
    public static List<Integer> fitnessList = new ArrayList<>();
    public static Population population;
    
    public Run() {
    	itemList = new ArrayList<>();
    	fitnessList = new ArrayList<>();
    }
    
    public static void main(String[] args) {
    	generateItems();
    	
    	KnapsackPhenotype kP = new KnapsackPhenotype();
    	System.out.println("Phenotype Value (Best possible fitness [value]): " + kP.phenotype);
    	
    	//Setup the initial population
    	population = new Population(Knapsack.Values.initialPopulation);
    	
    	
        for (int i = 1; i < Knapsack.Values.totalGenerations; i++) {
        	int mostFit = population.getFittest().getFitness();
        	System.out.println("Fitness of fittest individual of Generation " + i + " is : " + mostFit);
        	fitnessList.add(mostFit);
        	//TODO: Select the most fit individuals
        	//TODO: Perform Crossover on the most fit individuals
        	//TODO: Perform mutation on the most fit individuals
        }
    }
    
    public static void generateItems() {
        Random rand = new Random();
        for (int i = 0; i < totalItems; i++) {
            Item item = new Item();
            item.setWeight(rand.nextInt(10));
            item.setPrice(rand.nextInt(10) );
            itemList.add(item);
        }
    }
}
