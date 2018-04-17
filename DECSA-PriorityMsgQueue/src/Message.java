
public class Message {
	private int priority;
	private int arrival;
	public Message() {
		arrival = 0;
		priority = -1;
	}
	public Message(int arv) {
		arrival = arv;
		priority = -1;
	}
	public int getPriority(){
		if(priority == -1) {
			priority =(int) Math.random()*4;
		}
		return priority;
	}
	public int getArrivalTime() {
		return arrival;
	}
}
