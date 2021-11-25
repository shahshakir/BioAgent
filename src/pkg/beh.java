package pkg;

import jade.core.Agent;



@SuppressWarnings("serial")
public class beh extends Agent {
	static Agent ag;
	static void setagent(Agent agent)
	{
		ag=agent;
	}
	static Agent getagent()
	{
		return ag;	
	}
	   
	} 

