package thread;

import java.util.concurrent.atomic.AtomicInteger;

public class MyAtomic {

	private AtomicInteger count = new AtomicInteger();
	private static final int LOOP_NUM = 10000000;

	private class Worker implements Runnable {

		@Override
		public void run() {
			for (int i = 0; i < LOOP_NUM; i++) {
				count.getAndIncrement();
			}
		}
	}

	public void doit() throws InterruptedException {
		Thread t1 = new Thread(new Worker());
		t1.start();
		Thread t2 = new Thread(new Worker());
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
		MyAtomic my = new MyAtomic();
		my.doit();

	}

}
