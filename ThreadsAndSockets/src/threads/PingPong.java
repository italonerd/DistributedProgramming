package threads;

public class PingPong extends Thread{
	
	private String word;
	private int delay;
	private int cicles;
	
	public PingPong(String whatToSay, int delayTime, int numberCicles){
		this.word = whatToSay;
		this.delay = delayTime;
		this.cicles = numberCicles;  
	}
	
	public void run(){
		try {
			for (int i = 0; i < this.cicles; i++) {			
				System.out.println(this.word + " ");
				Thread.sleep(this.delay);
			}
		} catch (Exception e) {
			System.out.println("Error");
			return;
		}
	}
	
	public static void main(String[] args) {
		PingPong ping =  new PingPong("ping", 500,20);
		ping.start();
		PingPong pong =  new PingPong("pong", 1000,10);
		pong.start();
	}

}
