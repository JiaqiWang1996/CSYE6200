
public class SwitchingThreads {
	private String data = "abcdefghijklmnopqrstuvwxyz";
	private int alternator = 0;
	private int index = 0;

	private synchronized void alternateTheData() {
		if (0 == this.alternator) {
			System.out.print(this.data.toLowerCase().charAt(this.index));
			this.alternator = 1;
		}
		if (1 == this.alternator) {
			System.out.print(this.data.toUpperCase().charAt(this.index));
			this.index += this.alternator;
			this.alternator = 0;
		}
	}

	public void startTwoThreads() {
		Runnable alternatingRunnable = () -> {
			do {
				this.alternateTheData();
			} while (this.index < 25);
		};

		Thread t1 = new Thread(alternatingRunnable);
		Thread t2 = new Thread(alternatingRunnable);
		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(" alternatingThreads... done!");
	}

	public static void main(String[] args) {

		SwitchingThreads obj = new SwitchingThreads();
		obj.startTwoThreads();
	}
}