package thread;

class MyWorker implements Runnable {
	private static final int LOOP_NUM = 10000000;
	private MyCounter counter;

	MyWorker(MyCounter counter) {
		this.counter = counter;
	}

	@Override
	public void run() {
		synchronized (counter) {
			for (int i = 0; i < LOOP_NUM; i++) {
				counter.increment();
			}
		}
	}
}

public class MyCounter {
	private int count = 0;

	private Object lock = new Object();

	public void increment() {
		// synchronized (lock) {
		count++;
		// }
	}

	public void increment2() {
		count++;
	}

	public void doit() throws InterruptedException {
		Thread t1 = new Thread(new MyWorker(this));
		t1.start();
		Thread t2 = new Thread(new MyWorker(this));
		t2.start();

		t1.join();
		t2.join();
		System.out.println(count);
	}

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		MyCounter my = new MyCounter();
		my.doit();
	}

}
