/**
 * SADP Concurrency Assingment
 */
package concurrency;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Custom ThreadPoolExecutors class
 * @author ntanwa
 *
 */
public final class PoolExecutor {
	
	private static volatile ThreadPoolExecutor poolEx;
	
	/**
	 * Get ThreadPoolExecutor with corePoolSize = 5 and maxPoolSize = 10 with keepAliveTime = 60s 
	 * @return poolEx
	 */
	public static ThreadPoolExecutor getPoolExecutors(){
		if(poolEx == null){
			synchronized(PoolExecutor.class){
				if(poolEx == null){
					poolEx = new ThreadPoolExecutor(5, 10, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
				}
			}
		}
		return poolEx;
	}

}
