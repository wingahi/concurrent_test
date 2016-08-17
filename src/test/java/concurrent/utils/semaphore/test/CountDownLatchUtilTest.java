package concurrent.utils.semaphore.test;

import java.util.concurrent.CountDownLatch;

import concurrent.base.AbstrackLimitCountExecutor;
import concurrent.base.BaseCountDownLatch;
import concurrent.base.BaseSemaphore;
import concurrent.utils.CountDownLatchUtil;
import concurrent.utils.SemaphoreUtil;

public class CountDownLatchUtilTest {
	static CountDownLatch countDownLatch = new CountDownLatch(5);
	static BaseCountDownLatch taskExecutorUtil = new CountDownLatchUtil(
			countDownLatch, 5);

	public static void main(String[] args) {

		for (int i = 0; i < 5; i++) {
			new Thread(new Runnable() {

				public void run() {
					// TODO Auto-generated method stub
					TestEntity testEntity = new TestEntity();
					testEntity.setName("ddddddddd" + System.currentTimeMillis());
					taskExecutorUtil
							.execute(new AbstrackLimitCountExecutor<TestEntity>(
									testEntity) {
								public Object execute(TestEntity testEntity) {
									// TODO Auto-generated method stub
									System.out.println("thread-name:"
											+ Thread.currentThread()
											+ ",testEntity"
											+ testEntity.getName());
									return null;
								}

							});
				}
			}).start();
		}
		try {
			countDownLatch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("over");
	}
}
