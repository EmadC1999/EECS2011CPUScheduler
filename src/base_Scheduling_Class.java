
public class base_Scheduling_Class {

	double aveWaitTime;
	double aveTurnAroundTime;
	int numProcesses;
	double burstTime;
	double totalWaitTime;
	double totalTurnAroundTime;
	
	//Method to calculate average wait time of processes sent to scheduler
	public double averageWaitTime() {
		
		double wait = this.totalWaitTime/ this.numProcesses;
		return wait;
	}
	//Method to calculate average TurnAround time of processes sent to scheduler
	public double averageTurnAroundTime() {
		double turnArouindWait = this.totalTurnAroundTime / this.numProcesses;
		return turnArouindWait;
	}
	//merge sort algorithm to sort processes according to their arrival time
	//this method recursively splits the arrayList of processes into two 
	//sub arrayLists, then calls merge() to sort and merge.
	public void mergeSortProcesses(ArrayList<process>processes, int n) {
		if (n>=2) {
			int mid= n/2; //stores the value of the middle index
			ArrayList<process> l= new ArrayList<process>(); //make sub-ArrayList 1
			ArrayList<process> r= new ArrayList<process>(); // make sub-ArrayList 2
			for (int i=0; i< mid; i++)
				l.add(processes.get(i)); //copies first half of process arrayList into sub arrayList
			for (int i=mid; i<n; i++)
				r.add(processes.get(i)); //copies first half of process arrayList into sub arrayList
			mergeSortProcesses(l,mid); //recursive call to keep splitting towards the left
			mergeSortProcesses(r,n-mid); //recursive call to keep splitting towards right
			merge(processes, l, r, mid, n-mid); //sorts and merges the sub-ArrayLists
		}	
	}
	//method called by mergeSortArrival to merge and sort in acending order of arrival time
	public void merge(ArrayList<process>processes, ArrayList<process>l, ArrayList<process> r, int left, int right) {
		int i=0, j=0, k=0; //iterators
		while (i<left && j<right) {
			if (l.get(i).getArrivalTime()<=r.get(j).getArrivalTime()) 
			{
				processes.add(k, l.get(i));//adds element from sub-ArrayList 1 if smaller
				processes.remove(k+1); //remove any copies created in the main arrayList
				i++;
			}else
			{
				processes.add(k, r.get(j));//adds element from sub-ArrayList 2 if smaller
				processes.remove(k+1);//remove any copies created in the main arrayList
				j++;
			}
			k++;
		}
		//copies rest of elements if the upper loop terminated before 'i' reaches 'left'
		while (i< left){
			processes.add(k, l.get(i));
			processes.remove(k+1);
			i++;k++;
		}
		//copies rest of elements if the upper loop terminated before 'j' reaches 'right'
		while (j< right){
			processes.add(k, r.get(j));
			processes.remove(k+1);
			j++;k++;
		}
	}
	
}
