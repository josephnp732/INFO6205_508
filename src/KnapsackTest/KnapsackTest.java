package KnapsackTest;

import org.junit.Test;

import Knapsack.*;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Random;

public class KnapsackTest {
	
	@Test
	public void testItemRoster() {
		ItemRoster items = new ItemRoster();
		
		Random rand = new Random();
		assertEquals(Values.totalItems,ItemRoster.itemList.size());
		assertEquals(5, ItemRoster.itemList.get(rand.nextInt(Values.totalItems)).getPrice(),5);
		assertEquals(5, ItemRoster.itemList.get(rand.nextInt(Values.totalItems)).getPrice(),5);
		assertEquals(5, ItemRoster.itemList.get(rand.nextInt(Values.totalItems)).getWeight(),5);
		assertEquals(5, ItemRoster.itemList.get(rand.nextInt(Values.totalItems)).getWeight(),5);
	}
	@Test
	public void testGenerateGenes() {
		ItemRoster items = new ItemRoster();
		Individual ind1 = new Individual();
		ind1.generateGenes();
		Random rand = new Random();
		assertEquals(0,ind1.genes.get(rand.nextInt(Values.totalItems)),1);
		assertEquals(Values.totalItems,ind1.genes.size());
		
		
	}
	@Test
	public void testCrossoverSize() {
		//test that 200 elements were generated during crossover
		ItemRoster items = new ItemRoster();
		Individual ind1 = new Individual();
		ind1.generateGenes();
		Individual ind2 = new Individual();
		ind2.generateGenes();
		assertEquals(Values.totalItems,Simulation.crossover(ind1, ind2).size());
		
	}
	@Test
	public void testCrossoverValidity() {
		//test that between 0-200 elements were initialized in crossover as 0 or 1
		ItemRoster items = new ItemRoster();
		Individual ind1 = new Individual();
		ind1.generateGenes();
		Individual ind2 = new Individual();
		ind2.generateGenes();
		ArrayList<Integer> list = Simulation.crossover(ind1, ind2);
		int sum = 0;
		for(int i = 0; i<list.size(); i++) {
			sum =+ list.get(i);
			
		}
		assertEquals(100, sum, 100);
		
	}
	@Test
	public void testCrossoverNotSame() {
		//test that product of crossover is not identical to either parent
		ItemRoster items = new ItemRoster();
		Individual ind1 = new Individual();
		ind1.generateGenes();
		Individual ind2 = new Individual();
		ind2.generateGenes();
		ArrayList<Integer> list = Simulation.crossover(ind1, ind2);
		int j = 0;
		int k = 0;
		//check parent 1
		//if child different from parent, j will increment
		for (int i = 0; i< Values.totalItems; i++) {
			if(j>0)
				break;
			if(list.get(i)!= ind1.getGenes().get(i))
				j++;
			
		}
		//check parent 2
		//if child different from parent, k will increment
		for (int i = 0; i< Values.totalItems; i++) {
			if(k>0)
				break;
			if(list.get(i)!= ind2.getGenes().get(i))
				k++;
			
		}
		assertEquals(1, j, 0);
		assertEquals(1,k, 0);
		
	}
	@Test
	public void testGetFittest() throws Exception{
		//Test that the fittest individual is more fit than random population individuals
		ItemRoster items = new ItemRoster();
		Population pop = new Population(Values.initialPopulation);
		Individual ind = Population.getFittest();
		Random rand = new Random();
		assertTrue(ind.getFitness() >= Population.individuals.get(rand.nextInt(Values.initialPopulation)).getFitness());
		assertTrue(ind.getFitness() >= Population.individuals.get(rand.nextInt(Values.initialPopulation)).getFitness());
		assertTrue(ind.getFitness() >= Population.individuals.get(rand.nextInt(Values.initialPopulation)).getFitness());
		
		
	}
	
	@Test
	public void testCalculateGeneFitness() {
		//test that gene fitness is a positive value if knapsack weight capacity is not reached
		//test that gene fitness is a negative value if knapsack weight capacity is reached
		ItemRoster items = new ItemRoster();
		Population pop = new Population(Values.initialPopulation);
		Random rand = new Random();
		
		Individual ind1 = Population.individuals.get(rand.nextInt(Values.initialPopulation));
		Individual ind2 = Population.individuals.get(rand.nextInt(Values.initialPopulation));
		Individual ind3 = Population.individuals.get(rand.nextInt(Values.initialPopulation));
		
		if (ind1.getWeight() > Values.knapsackCapacity)
			assertTrue(ind1.getFitness() < 0);
		else
			assertTrue(ind1.getFitness() >= 0);
		if (ind1.getWeight() > Values.knapsackCapacity)
			assertTrue(ind2.getFitness() < 0);
		else
			assertTrue(ind2.getFitness() >= 0);
		if (ind1.getWeight() > Values.knapsackCapacity)
			assertTrue(ind3.getFitness() < 0);
		else
			assertTrue(ind3.getFitness() >= 0);
	}
	@Test
	public void testMateGeneration() {
		//test that output generation is equal to input generation size
		ItemRoster items = new ItemRoster();
		Population pop = new Population(Values.initialPopulation);
		ArrayList<Individual> nextGen = Simulation.mateGeneration(Population.individuals);
		assertEquals(Population.individuals.size(), nextGen.size(), 0);
		
	}
	
	
	
	
}
