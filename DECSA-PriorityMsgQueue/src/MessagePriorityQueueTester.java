	/**
	 * @author arwinstanley
	 * @Date 4/23/18
	 * 
	 * This Class is a tester used to test the O(n) of any given message using 
	 * PriorityQueues and then using a heap 
	 */
public class MessagePriorityQueueTester {
	/**
	 * @param args is a String[] of arguments to the console
	 * @return none
	 * 
	 * runs all the tests and runs the console
	 * 
	 */
	public static void main(String[] args) {
		MessagePriorityQueue test = new MessagePriorityQueue();
		for(int j = 0; j <4;j++) {
			for(int i = 0; i<10;i++) {
				test.add(new Message());
			}
		}
		test.process();
		test.process();
		test.printdata();
		test.printdataAvg();
	}
}
