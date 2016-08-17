package concurrent.utils.semaphore.test;

import java.util.concurrent.CountDownLatch;

import concurrent.base.AbstrackLimitCountExecutor;
import concurrent.base.BaseCountDownLatch;
import concurrent.base.BaseSemaphore;
import concurrent.utils.CountDownLatchUtil;
import concurrent.utils.CountDownLatchUtils;
import concurrent.utils.SemaphoreUtil;

public class CountDownLatchUtilsTest {

	static CountDownLatchUtils taskExecutorUtil = new CountDownLatchUtils();

	public static void main(String[] args) {

		for (int i = 0; i < 5; i++) {

			TestEntity testEntity = new TestEntity();
			testEntity.setName("ddddddddd" + i);
			taskExecutorUtil
					.AddExecutor(new AbstrackLimitCountExecutor<TestEntity>(
							testEntity) {
						public Object execute(TestEntity testEntity) {
							// TODO Auto-generated method stub
							System.out.println("thread-name:"
									+ Thread.currentThread() + ",testEntity"
									+ testEntity.getName());
							return null;
						}

			});
		}
		taskExecutorUtil.execute();

		System.out.println("over");
	}
}
