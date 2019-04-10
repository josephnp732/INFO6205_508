package Knapsack;

import java.util.ArrayList;
import java.util.List;

public class Population {
	
    public static List<Individual> individuals;
    private static Individual fittest;

	public Population(int initialPopulation) {
    	individuals = new ArrayList<Individual>();
        for (int i = 0; i < initialPopulation; i++) {             //Adding individuals and their genes to the population
            Individual individual = new Individual();
            individual.generateGenes();
            individuals.add(individual);
        }
    }
	
	/** Get the fittest individual from the population **/
    public static Individual getFittest() {
        int max = 0;
        int maxFitnessIndex = 0;
        for (int i = 0; i < individuals.size(); i++) {
            if (individuals.get(i).getFitness() > max) {
                max = individuals.get(i).getFitness();
                maxFitnessIndex = i;
            }
        }
        fittest = individuals.get(maxFitnessIndex);
		return fittest;
	}

    /** Getters and Setter **/
	public static void setFittest(Individual fittest) {
		Population.fittest = fittest;
	}
}
