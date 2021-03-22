import java.util.ArrayList;

public class FCFS extends base_Scheduling_Class{


	public FCFS(ArrayList<process>processes, int numP)
	{
		//sort processes by arrival times
		mergeSortProcesses(processes,numP);
		numProcesses=numP;
		//init
		int turnaroundTime=0,waitTime=0; //temp variables
		for (int i=0; i<numP; i++) //i< number of processes
		{
			if (i<numP-1) { // get wait Time
				// wait time is after first and before last
				waitTime+=processes.get(i).getBurstTime(); 
				totalWaitTime+=waitTime;
			}
			// turnaround time is sum of last burst+ and wait time
			turnaroundTime+=processes.get(i).getBurstTime(); // sum of burst
			
			totalTurnAroundTime+=turnaroundTime;//sum of last burst + current process burst
		}	
	}
}
