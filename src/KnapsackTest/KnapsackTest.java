package KnapsackTest;

import org.junit.Test;

import Knapsack.*;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

import java.util.ArrayList;

public class KnapsackTest {
	
	@Test
	public void testItemRoster() {
		ItemRoster items = new ItemRoster();
		
		assertEquals(Values.totalItems,ItemRoster.itemList.size());
		assertEquals(5, ItemRoster.itemList.get(42).getPrice(),5);
		assertEquals(5, ItemRoster.itemList.get(57).getPrice(),5);
		assertEquals(5, ItemRoster.itemList.get(101).getWeight(),5);
		assertEquals(5, ItemRoster.itemList.get(4).getWeight(),5);
	}
	@Test
	public void testGenerateGenes() {
		ItemRoster items = new ItemRoster();
		Individual ind1 = new Individual();
		ind1.generateGenes();
		assertEquals(0,ind1.genes.get(15),1);
		assertEquals(Values.totalItems,ind1.genes.size());
		
		
	}
	@Test
	public void testCrossoverSize() {
		ItemRoster items = new ItemRoster();
		Individual ind1 = new Individual();
		ind1.generateGenes();
		Individual ind2 = new Individual();
		ind2.generateGenes();
		assertEquals(Values.totalItems,Simulation.crossover(ind1, ind2).size());
		
	}
	@Test
	public void testCrossoverValidity() {
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
	public void testGetFittest() throws Exception{
		Population pop = new Population(Values.initialPopulation);
		Individual ind = Population.getFittest();
		assert (ind.getFitness() >= Population.individuals.get(57).getFitness());
		
		
		
	}
	
	@Test
	public void testCalculateGeneFitness() {
		
		
		
	}
	@Test
	public void testMateGeneration() {
		
		
	}
	@Test
	public void testNewGeneration() {
		
		
	}
	
	
	
	
	
}
