package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		
		System.out.println("How much do we start with?");
		int startAmount = in.nextInt();
		int origStartAmount = startAmount;
		
		System.out.println("What is the win chance?");
		double winChance = in.nextDouble();
		
		
		System.out.println("What is the win limit?");
		int winLimit = in.nextInt();
		
		System.out.println("How many games are we simulating?");
		int totalSimulations = in.nextInt();
		
		int totalLosses = 0;
		for (int i = 1; i <= totalSimulations; i++)
		{
			int gamesPlayed = 0;
			startAmount = origStartAmount;
			while (startAmount < winLimit && startAmount > 0)
			{
				double winOrLoss = Math.random();
				if (winChance > winOrLoss)
				{
					totalLosses++;
					startAmount--;
					gamesPlayed++;
				}
				else if (winChance < winOrLoss)
				{
					startAmount++;
					gamesPlayed++;
				}
			}
			if (startAmount == winLimit)
			{
				System.out.println("Simulation " + i + ": " + gamesPlayed + " WIN");
			}
			else if (startAmount == 0)
			{
				System.out.println("Simulation " + i + ": " + gamesPlayed + " LOSE");
			}
		}
		
		double simRuinRate = totalLosses/totalSimulations;
		double calculatedWinRate = 0;
		if (winChance == 0.5)
		{
			calculatedWinRate = (1-((startAmount/1.0)/winLimit));
		}
		else
		{
			calculatedWinRate = .25;
		}
		
		System.out.println("Ruin Rate from Simulation: " + simRuinRate + " Expected Ruin Rate: " + calculatedWinRate);
	}

}
