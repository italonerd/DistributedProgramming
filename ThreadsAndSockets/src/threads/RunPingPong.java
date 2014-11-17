package threads;

public class RunPingPong implements Runnable {
	private String word;
	private int delay;
	private int cicles;

	public RunPingPong(String whatToSay, int delayTime, int numberCicles) {
		this.word = whatToSay;
		this.delay = delayTime;
		this.cicles = numberCicles;
	}

	public void run() {
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
		Runnable ping = new RunPingPong("ping", 500, 20);
		Runnable pong = new RunPingPong("pong", 1000, 10);
		new Thread(ping).start();
		new Thread(pong).start();
	}

}
