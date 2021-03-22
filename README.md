# EECS2011CPUScheduler
Project for EECS 2011(Data Structures and Algorithms) 
This Project is a system for Modeling of CPU Scheduling Algorithms

The scheduling algorithms that can be modelled are: 
Nonpreemptive First-Come, First-Served (FCFS) Scheduling
Nonpreemptive Shortest-Job-First (SJF) Scheduling
Preemptive SJF (Shortest-Remaining-Time-First) Scheduling
Nonpreemptive Priority Scheduling
Preemptive Priority Scheduling
Preemptive Round-Robin (RR) Scheduling

In order the model one of the CPU Scheluing Algorithms you must clone the git project and run the modeller class as java aplication.
Once you run the moddeler calss you will be prompted with 6 possible scheduling algorithms to model of which you can chose one.
Then you will be prompted for the number of processes you would like to model, after which you will be prompted for the information 
of each process. Depending on the scheduling algorithm this inforation could include Arival Time, Burst CPU Time, and Process Priority.
Finally the Deterministic Model will be run and the average waiting time and average turnaround time of the scheduling algorithm for 
your inpuy will be outputed in the console.

There are also Several Junit Test included with the package that test for the correct functionality of the scheduling algorithms.

