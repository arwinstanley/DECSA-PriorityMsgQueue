/**
 * @author arwinstanley
 * @Date 4/23/18
 * 
 * This Class is a representation of any given 'message' that you might need to deal with
 */
public class Message {
	//the importance of the message
	private int priority;
	//the time of arrival(from simulation base 0)
	private int arrival;
	/**
	 * @param none
	 * @return none
	 * 
	 * creates a Message and sets priority to -1 and arrival to 0
	 * 
	 */
	public Message() {
		arrival = 0;
		priority = -1;
	}
	/**
	 * @param arv is the time of arrival in an int
	 * @return none
	 * 
	 * creates a Message and sets priority to -1 and arrival to arv
	 * 
	 */
	public Message(int arv) {
		arrival = arv;
		priority = -1;
	}	/**
	 * @param none
	 * @return a random int between 0-4 that is the priority
	 * 
	 * returns a number 0-4 with a random chance of each
	 * 
	 */
	public int getPriority(){
		if(priority == -1) {
			priority =(int)(Math.random()*5);
		}
		return priority;
	}	/**
	 * @param none
	 * @return none
	 * 
	 * returns the time of arrival
	 * 
	 */
	public int getArrivalTime() {
		return arrival;
	}
}
