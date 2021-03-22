import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class FCFSTest {

	@Test
	void test() {
		ArrayList<process> processes = new ArrayList<process>();
		processes.add(new process(0, 4, 5));
		processes.add(new process(0, 6, 6));
		processes.add(new process(2, 10, 1));
		FCFS scheduler = new FCFS(processes, 3);			
		assertEquals(11.333333, scheduler.averageTurnAroundTime(), 0.1);
		assertEquals(4.666666666, scheduler.averageWaitTime(), 0.1);
	}

}
