
public class MessagePriorityQueueTester {

	public static void main(String[] args) {
		MessagePriorityQueue test = new MessagePriorityQueue();
		for(int i = 0; i<10;i++) {
			test.add(new Message());
		}
		test.process();
		test.process();
	}
}
