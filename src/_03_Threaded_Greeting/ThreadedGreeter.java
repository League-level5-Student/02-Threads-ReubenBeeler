package _03_Threaded_Greeting;

public class ThreadedGreeter implements Runnable {
	
	int z;
	
	public ThreadedGreeter(int z) {
		this.z = z;
	}

	@Override
	public void run() {
		System.out.println("Hello from thread number " + z);
		if (z < 50) new Thread(new ThreadedGreeter(z + 1)).start();
	}
	
}