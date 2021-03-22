import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class pre_Priority_SchedulerTest {

	@Test
	/* basic schedueling of three process which was done in paper before hand to get correct output*/
	void basic3ProcessSchduling() {
		ArrayList<process> processes = new ArrayList<process>();
		processes.add(new process(0, 4, 5));
		processes.add(new process(0, 6, 6));
		processes.add(new process(2, 10, 1));
		pre_Priority_Scheduler scheduler = new pre_Priority_Scheduler(processes);
		
		//execute modeling algorithm
		scheduler.model();
		assertEquals(14.666666, scheduler.averageTurnAroundTime(), 0.1);
		assertEquals(8.0, scheduler.averageWaitTime(), 0.1);
		
	}

}
