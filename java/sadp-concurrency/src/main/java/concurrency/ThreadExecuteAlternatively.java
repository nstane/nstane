/**
 * 
 */
package concurrency;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * @author ntanwa
 *
 */
public class ThreadExecuteAlternatively {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		final int noOfThreads = (args != null && args.length == 0) ? 5 :  Integer.parseInt(args[0]); 
				
		//usingJoin(noOfThreads);
		ExecutorService exsrvs = Executors.newFixedThreadPool(noOfThreads);
		AtomicInteger count = new AtomicInteger(1);
		IntStream.rangeClosed(1, 15).forEach(index ->{
			try {
				exsrvs.submit(()->{
					System.out.println(Thread.currentThread().getName()+" - "+count.getAndIncrement());
				}).get();
			} catch (InterruptedException e) {
				System.out.println("Error : "+e.getMessage());
			} catch (ExecutionException e) {
				System.out.println("Error : "+e.getMessage());
			}
		});
		exsrvs.shutdown();

	}
	
	private static void usingJoin(int noOfThreads){
		AtomicInteger count = new AtomicInteger();
		IntStream.range(0, 2).forEach( i -> {
			IntStream.range(0, noOfThreads).forEach( ii -> {
				Thread t1 = new Thread(() -> {
					System.out.println(Thread.currentThread().getName()+ " " +count.incrementAndGet());
				},"Thread-"+(ii));
				t1.start();
				try {
					t1.join();
				} catch (Exception e) {
					System.out.println("Error While joining Thread "+t1.getName() +" Because "+e.getMessage());
				}
			});
		});
	}
	
	@SuppressWarnings("unused")
	private static void usingSemaphore(int noOfThreads){
		AtomicInteger count = new AtomicInteger();
		IntStream.range(0, 2).forEach( i -> {
			IntStream.range(0, noOfThreads).forEach( ii -> {
				Thread t1 = new Thread(() -> {
					System.out.println(Thread.currentThread().getName()+ " " +count.incrementAndGet());
				},"Thread-"+(ii));
				t1.start();
			});
		});
	}

}
