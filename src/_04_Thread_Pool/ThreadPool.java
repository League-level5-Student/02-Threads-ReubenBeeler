package _04_Thread_Pool;

import java.util.concurrent.ConcurrentLinkedQueue;

public class ThreadPool {
	
	Thread[] threads;
	ConcurrentLinkedQueue<Task> taskQueue = new ConcurrentLinkedQueue<>();
	
	ThreadPool(int totalThreads) {
		threads = new Thread[totalThreads];
		for (int i = 0; i < threads.length; i++) {
			threads[i] = new Thread(new Worker(taskQueue));
		}
	}
	
	void addTask(Task task) {
		taskQueue.add(task);
	}
	
	void start() {
		for (Thread thread : threads) {
			thread.start();
		}
		for (Thread thread : threads) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
