package thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class MyProduceConsume {

	private static class Produser implements Runnable {
		private Queue<String> queue;

		Produser(Queue<String> queue) {
			this.queue = queue;
		}

		@Override
		public void run() {
			BufferedReader br = null;
			try {
				br = new BufferedReader(new InputStreamReader(System.in));
				while (true) {
					System.out.println("input any string");
					String s = br.readLine();
					synchronized (queue) {
						queue.add(s);
						queue.notify();
					}
				}
			} catch (IOException e) {
			} finally {
				try {
					if (br != null) {
						br.close();
					}
				} catch (IOException e) {
				}
			}
		}
	}

	private static class Consumer implements Runnable {
		private Queue<String> queue;

		Consumer(Queue<String> queue) {
			this.queue = queue;
		}

		@Override
		public void run() {
			try {
				while (true) {
					synchronized (queue) {
						while (queue.isEmpty()) {
							System.out.println("waiting...");
							queue.wait();
						}
						String s = queue.remove();
						System.out.println(s + " is consumed");
					}
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void doit() throws InterruptedException {
		Queue<String> queue = new LinkedList<String>();
		Thread producer = new Thread(new Produser(queue));
		Thread consumer = new Thread(new Consumer(queue));

		producer.start();
		consumer.start();

		producer.join();
		consumer.join();

	}

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		MyProduceConsume my = new MyProduceConsume();
		my.doit();
	}

}
