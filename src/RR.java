
// Round Robin Scheduling with different arrival time
import java.util.*;

public class RR {
	public static void waitTime(int process[], int waittime[], int brusttime[], int quantum, int completiontime[],
			int arrivaltime[], int n) {
		// copy the value of brusttime array to store remaining burst times
		int remainingtime[] = new int[n];

		for (int i = 0; i < waittime.length; i++) {
			remainingtime[i] = brusttime[i];
		}
		int t = 0, arrival = 0;
		// processing until the value of element of remainingtime array is 0
		while (true) {
			boolean done = true;
			//pr
			for (int i = 0; i < n; i++) {
				//if burst time is more than 0, then only need to keep processing 
				if (remainingtime[i] > 0) {
					done = false;
					
					if (remainingtime[i] > quantum && arrivaltime[i] <= arrival) {
						//increasing t value to show how much time a process has been processed
						t += quantum;
						//decrease the remaining time by a quantum
						remainingtime[i] -= quantum;
						arrival++;
						
						//if arrival time is less than or equal to quantum, it is the last cycle for this process
					} else {
						if (arrivaltime[i] <= arrival) {
							arrival++;
							//increase the value of t by how much time a process has been processed 
							t += remainingtime[i];
							completiontime[i] = t;
							//as the process is fully executed, make its remaining timo = 0
							remainingtime[i] = 0;
						}
					}
				}
			}
			
			if (done == true) {
				break;
			}
		}
	}

	// tat = turn around time
    // Method to get turn around time 
	public static void turnaroundTime(int process[], int waittime[], int brusttime[], int tattime[],
			int completiontime[], int arrivaltime[], int n) {
		for (int i = 0; i < n; i++) {
			tattime[i] = completiontime[i] - arrivaltime[i];
			waittime[i] = tattime[i] - brusttime[i];

		}

	}
    // Method to get the average time 
	public static void averageTime(int process[], int brusttime[], int quantum, int arrivaltime[], int n) {
		
		int waittime[] = new int[n], tattime[] = new int[n];
		int total_waittime = 0, total_tat = 0;
		
		int completiontime[] = new int[n];
		
        // Function to find waiting time of all processes 
		waitTime(process, waittime, brusttime, quantum, completiontime, arrivaltime, n);
		
        // Function to find turn around time for all processes 
		turnaroundTime(process, waittime, brusttime, tattime, completiontime, arrivaltime, n);
		
        // Display processes along with all details 
		System.out.println("Processes " + " Arrival Time\t" + " Burst time " + " completion time" + " Turn Around Time "
				+ " Waiting time");
		
        // Calculate total waiting time and total turn and around time 
		for (int i = 0; i < n; i++) {
			total_waittime = total_waittime + waittime[i];
			total_tat = total_tat + tattime[i];
			System.out.println(" " + (i + 1) + "\t\t" + arrivaltime[i] + "\t\t" + +brusttime[i] + "\t "
					+ completiontime[i] + "\t\t" + tattime[i] + "\t\t " + waittime[i]);
		}

		System.out.println("Average waiting time = " + (float) total_waittime / (float) n);
		System.out.println("Average turn around time = " + (float) total_tat / (float) n);
	}


}
