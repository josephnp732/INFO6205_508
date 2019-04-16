package Knapsack;



public class Run {
	static Simulation sim;
	
 
    
    public Run() {
    	sim = new Simulation();
    }
    
    public static void main(String[] args) {
    
    	sim.newGeneration();
    	
    	/*
        for (int i = 1; i < Values.totalGenerations; i++) {
        	sim.newGeneration();
        	
        }
        */
    }
    
    
}
