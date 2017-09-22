/**
 * 
 */
package concurrency;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @author ntanwa
 *
 */
public class CustomCyclicBarrier {

	@SuppressWarnings("unused")
	private final int barriers;
	
	@SuppressWarnings("unused")
	private final Runnable barrierCommand;
	
	public CustomCyclicBarrier(int barriers, Runnable barrierCommand) {
		super();
		this.barriers = barriers;
		this.barrierCommand = barrierCommand;
	}




	/**
	 * @param args
	 */
	public static void main(String[] args) {
		runCyclicBarrier();
	}


	private static void runCyclicBarrier(){
		int numberOfBarriers = 3;
		CyclicBarrier barrier =  new CyclicBarrier(numberOfBarriers, () -> {
			System.out.println("All Threads Have been reached on barrier point now performing Barrier Action...");
		});

		ExecutorService exService = PoolExecutor.getPoolExecutors();
		IntStream.range(0, numberOfBarriers).forEach( i -> {
			exService.execute(() ->{
				System.out.println("Stating task"+i);
				try {
					barrier.await();
				} catch (Exception e) {
					System.out.println("Error while doing await on barrier in task = task"+i+" Because "+e.getMessage());
				}

			});
		});


		exService.shutdown();
		try {
			exService.awaitTermination(5, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			System.out.println("Error while terminating executor pool because +"+e.getMessage());
		}
	}

}
