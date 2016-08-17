# concurrent_test
本项目中，对concurrent中的CountDownLatch、Semaphore、CyclicBarrier进行封装，方便使用。
一、共包括模块
    CountDownLatchUtil
    CountDownLatchUtils
    CyclicBarrierUtil
    SemaphoreUtil
二、使用示例
  1、  CountDownLatchUtil
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
  2、  CountDownLatchUtils
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
  3、  CyclicBarrierUtil
        static BaseCyclicBarrier taskExecutorUtil = new CyclicBarrierUtil(3);
      	public static void main(String[] args) {
      		
      		for (int i = 0; i < 6; i++) {
      			new Thread(new Runnable() {
      				
      				public void run() {
      					// TODO Auto-generated method stub
      					TestEntity testEntity = new TestEntity();
      					testEntity.setName("ddddddddd"+System.currentTimeMillis());
      					taskExecutorUtil.execute(new AbstrackLimitCountExecutor<TestEntity>(testEntity) {
      						public Object execute(TestEntity testEntity) {
      							// TODO Auto-generated method stub
      							System.out.println("thread-name:"+Thread.currentThread()+",testEntity"+testEntity.getName());
      							return null;
      						}
      						
      					});
      				}
      			}).start();
      		}
      	}
  4、  SemaphoreUtil
        static BaseSemaphore taskExecutorUtil = new SemaphoreUtil<TestEntity>(3, true);
      	public static void main(String[] args) {
      		
      		for (int i = 0; i < 20; i++) {
      			new Thread(new Runnable() {
      				
      				public void run() {
      					// TODO Auto-generated method stub
      					TestEntity testEntity = new TestEntity();
      					testEntity.setName("ddddddddd"+System.currentTimeMillis());
      					taskExecutorUtil.execute(new AbstrackLimitCountExecutor<TestEntity>(testEntity) {
      						public Object execute(TestEntity testEntity) {
      							// TODO Auto-generated method stub
      							System.out.println("thread-name:"+Thread.currentThread()+",testEntity"+testEntity.getName());
      							return null;
      						}
      						
      					});
      				}
      			}).start();
      		}
      	}
