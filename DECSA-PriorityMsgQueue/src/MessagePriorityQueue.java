import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class MessagePriorityQueue {
	private ArrayList<Queue<Message>> msgs;
	private int time;
	//chance of a random int between 0-9 is 20%
	private final int twentyPercent =5;
	
	public MessagePriorityQueue() {
			time =0;
			msgs = new ArrayList<Queue<Message>>(5);
			for(int i = 0; i < 5;i++) {
				msgs.set(i, new LinkedList<Message>());
			}
	}
			
	public void add(Message m) {
        msgs.get(m.getPriority()).add(m);
	}
	public void itterateTime() {
		time++;
		int test = (int)Math.random()*9;
		if(test == twentyPercent) {
			add(new Message(time));
		}
	}
	public void processMessage(int in){
		for(int i = 0; i< 3; i++) {
			itterateTime();
		}
		System.out.print(in + "th message removed at " + time + " it was recieved at " + msgs.get(in).peek().getArrivalTime());
		msgs.get(in).remove();
	}
	public void process() {
		while(!msgs.get(0).isEmpty()) {
			processMessage(0);
		}
		while(!msgs.get(1).isEmpty()) {
			processMessage(1);
		}
		while(!msgs.get(2).isEmpty()) {
			processMessage(2);
		}
		while(!msgs.get(3).isEmpty()) {
			processMessage(3);
		}
		while(!msgs.get(4).isEmpty()) {
			processMessage(4);
		}
	}
	public Queue<Message> getMsgs(int i){
		return msgs.get(i);
	}
}

