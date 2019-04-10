package project;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static project.Values.totalItems;

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
    	
    	//Setup the initial population
    	population = new Population(project.Values.initialPopulation);
    	
    	
        for (int i = 1; i < project.Values.totalGenerations; i++) {
        	int mostFit = population.getFittest().getFitness();
        	System.out.println("Fitness of fittest individual of Generation " + i + "is : " + mostFit);
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
