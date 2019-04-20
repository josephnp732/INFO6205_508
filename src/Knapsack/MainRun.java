package Knapsack;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class MainRun extends Application{
	
	static Simulation sim;
	private static ArrayList<Individual> fitnessList;
    
    public MainRun() {
    	sim = new Simulation();
    	fitnessList = Simulation.getFitnessList();
    	
    }
    
    public static void main(String[] args) {
    
    	@SuppressWarnings("unused")
		MainRun run = new MainRun();
    	//sim.newGeneration();
    	/*
        for (int i = 1; i < Values.totalGenerations; i++) {
        	sim.newGeneration();
        	
        }
        */
    	launch();
    }

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Fitness chart");
        //defining the axes
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Generation");
        yAxis.setLabel("Fitness");
        yAxis.setForceZeroInRange(false);
        //creating the chart
        final LineChart<Number, Number> lineChart
                = new LineChart<Number, Number>(xAxis, yAxis);

        lineChart.setTitle("Fitness Tracker for 0-1 Knapsack problem");
        //defining a series
        XYChart.Series series = new XYChart.Series();
        series.setName("Fitness Track");
        //populating the series with data
        for (int i = 0; i < fitnessList.size(); i++) {
            series.getData().add(new XYChart.Data(i, fitnessList.get(i).getFitness()));
        }
        Scene scene = new Scene(lineChart, 800, 600);
        lineChart.getData().add(series);

        stage.setScene(scene);
        stage.show();
	}
    
    
}
