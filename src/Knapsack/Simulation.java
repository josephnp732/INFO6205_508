/**
 * 
 */
package Knapsack;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

/**
 * @author peter
 *
 */
public class Simulation {
	
	static Population population; 
	ItemRoster items;
	static ArrayList<Individual> fitnessList;
	
	public Simulation() {
		items = new ItemRoster();
		population = new Population(Values.initialPopulation);
		fitnessList = new ArrayList<Individual>(Values.totalGenerations);
		totalGeneration();
	}
	
	public static ArrayList<Individual> getFitnessList() {
		return fitnessList;
	}


	public static void setFitnessList(ArrayList<Individual> fitnessList) {
		Simulation.fitnessList = fitnessList;
	}


	/**
	 * method to mate two Individual instances
	 * @param ind1 Individual
	 * @param ind2 Individual
	 * @return ArrayList of genes randomly selected from parent Individuals
	 */
	public static ArrayList<Integer> crossover(Individual ind1, Individual ind2){
		ArrayList<Integer> childGenes = new ArrayList<Integer>(Values.totalItems);
		Random rand = new Random();
		for (int i = 0; i< ItemRoster.itemList.size(); i++) {
			int randInt = rand.nextInt(2);
			if (randInt == 0)
				childGenes.add(ind1.genes.get(i));
			else {
				childGenes.add(ind2.genes.get(i));
			}
		}
		return childGenes;
	}
	
	public static void totalGeneration() {
		 for (int i = 1; i < Values.totalGenerations; i++) {
			 newGeneration();
		 }
	}
	
	
	/**
	 * pairs the top 50% of Individuals and create two children to pair
	 * @param prevGen of Individuals
	 * @return nextGen of Individuals
	 */
	public static ArrayList<Individual> mateGeneration(ArrayList<Individual> prevGen) {
		ArrayList<Individual> nextGen = new ArrayList<Individual>(Values.initialPopulation);
		
		prevGen.sort(new Comparator<Individual>(){
			
			@Override
			public int compare(Individual o1, Individual o2) {
				
				return o2.getFitness()-o1.getFitness();
			}
		});
		int cutoff = prevGen.size()/2;
		
		//mate each pair twice, add parents and children to nextGen list
		for(int i = 0; i<cutoff; i+=2) {
			Individual individual = new Individual();
			Individual individual2 = new Individual();
			individual.setGenes(crossover(prevGen.get(i), prevGen.get(i+1)));
            individual2.setGenes(crossover(prevGen.get(i), prevGen.get(i+1)));
            individual.calculateGeneFitness();
            individual2.calculateGeneFitness();
            individual.generatePhenotype();
            individual2.generatePhenotype();
            nextGen.add(individual);
            nextGen.add(individual2);
            nextGen.add(prevGen.get(i));
            nextGen.add(prevGen.get(i+1));
		}
		return nextGen;
	}
	
	
	public static void newGeneration() {
		ArrayList<Individual> newGen = new ArrayList<Individual>(Values.initialPopulation);
		newGen.addAll(mateGeneration(Population.individuals));
		Population.setIndividuals(newGen);
		Individual mostFit = Population.getFittest();
		fitnessList.add(mostFit);
		System.out.println("Fitness of fittest individual of Generation " + fitnessList.size() + " is : " + mostFit.getFitness());
	}
	
	
	


}
