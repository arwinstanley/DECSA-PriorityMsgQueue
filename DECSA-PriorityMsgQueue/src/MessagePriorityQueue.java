import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
/**
 * @author arwinstanley
 * @Date 4/23/18
 * 
 * This Class is a representation of a device handling messages with a priority queue
 */
public class MessagePriorityQueue {
	private ArrayList<Queue<Message>> msgs;
	private int time;
	//chance of a random int between 0-9 is 20%
	private final int twentyPercent =5;
	//data table
	private ArrayList<ArrayList<Integer>> data;
	/**
	 * @param none
	 * @return none
	 * 
	 * creates msgs and instantiates each element of msgs as a linked list of <Message>
	 * sets time = 0
	 * 
	 */
	public MessagePriorityQueue() {
			time =0;
			data = new ArrayList<ArrayList<Integer>>(5);
			for(int i = 0; i < 5;i++) {
				data.add(new ArrayList<Integer>());
			}
			msgs = new ArrayList<Queue<Message>>(5);
			for(int i = 0; i < 5;i++) {
				msgs.add(new LinkedList<Message>());
			}
	}
	/**
	 * @param m Message 
	 * @return none
	 * 
	 * adds Message m to the correct Queue based on priority
	 * 
	 */		
	public void add(Message m) {
        msgs.get(m.getPriority()).add(m);
	}
	/**
	 * @param none 
	 * @return none
	 * 
	 * Iterates time by 1 and generates a 20% chance for a new message popping up
	 * 
	 */		
	public void itterateTime() {
		time++;
		int test = (int)(Math.random()*10);
		if(test == twentyPercent) {
			add(new Message(time));
		}
	}
	/**
	 * @param in is the ArrayList index for the priority
	 * @return none
	 * 
	 * IteratesTime 4 times, then deletes the element to simulate 4 minutes going by while the machine processes it
	 *  and it prints out data to the console
	 * 
	 */		
	public void processMessage(int in){
		for(int i = 0; i< 4; i++) {
			itterateTime();
		}
		System.out.println(in + "th message removed at " + time + " it was received at " + msgs.get(in).peek().getArrivalTime());
		System.out.println("It took "+ (time-(msgs.get(in).peek().getArrivalTime()))+ " minutes to process, at a priority level "+in);
		data.get(in).add((time-(msgs.get(in).peek().getArrivalTime())));
		msgs.get(in).remove();
	}
	/**
	 * @param none 
	 * @return none
	 * 
	 * uses a while loop to go through each msgs set in order
	 * 
	 */		
	public void process() {
		while(!msgs.get(0).isEmpty()) {
			processMessage(0);
		}
		while(!msgs.get(1).isEmpty()&&msgs.get(0).isEmpty()) {
			
			processMessage(1);
		}
		while(!msgs.get(2).isEmpty()&&msgs.get(1).isEmpty()&&msgs.get(0).isEmpty()) {
			processMessage(2);
		}
		while(!msgs.get(3).isEmpty()&&msgs.get(2).isEmpty()&&msgs.get(1).isEmpty()&&msgs.get(0).isEmpty()) {
			processMessage(3);
		}
		while(!msgs.get(4).isEmpty()&&msgs.get(3).isEmpty()&&msgs.get(2).isEmpty()&&msgs.get(0).isEmpty()&&msgs.get(3).isEmpty()) {
			processMessage(4);
		}
	}	
	/**
	 * @param int i
	 * @return msgs Queue of Messages
	 * 
	 * returns the Queue at msgs.get(i)
	 * 
	 */		
	public Queue<Message> getMsgs(int i){
		return msgs.get(i);
	}
	/**
	 * @param none
	 * @return none
	 * 
	 * print data prints out the data table in a readable format
	 * 
	 */	
	public void printdata() {
		for(int i = 0; i< data.size();i++) {
			for(int j = 0; j< data.get(i).size();j++) {
				System.out.print("|"+data.get(i).get(j)+"|");
			}
			System.out.println();
		}
	}
	/**
	 * @param none
	 * @return none
	 * 
	 * prints out the averages from all of the data tables
	 * 
	 */
	public void printdataAvg() {
		
		for(int i = 0; i< data.size();i++) {
			double count = 0;
			for(int j = 0; j< data.get(i).size();j++) {
				count += data.get(i).get(j);
			}
			count = count/(data.get(i).size());
			System.out.println("The average processing time of a message in the "+ i+"th queue is, "+count);
		}
		System.out.println();
	}
}

