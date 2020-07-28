package src;
/**
 * 合并线程
 */
//public class TestDemo implements Runnable {
//    @Override
//    public void run() {
//        for (int i = 0; i < 10; i++) {
//            System.out.println("线程Vip来了" + i);
//        }
//    }
//
//    public static void main(String[] args) throws InterruptedException {
//        //启动我们的线程
//        TestDemo testJoin = new TestDemo();
//        Thread thread = new Thread(testJoin);
//        thread.start();
//
//        //主线程
//        for (int i = 0; i < 100; i++) {
//            if (i == 20) {
//                thread.join();//插队（这里一插队，就是当主线程执行到i==200的时候，就让子线程去执行打印“线程Vip来了”，必须等插队的那个子线程打印100条“线程Vip”执行完了，再继续执行主线程没有执行完的语句。）
//            }
//            System.out.println("main" + i);
//        }
//    }
//}


/**
 * 线程优先级
 */
public class TestDemo extends Thread {
    public static void main(String[] args) {
        //主线程 默认优先级 为5
        System.out.println(Thread.currentThread().getName() + "--->" + Thread.currentThread().getPriority());

        MyPriority myPriority = new MyPriority();

        Thread thread1 = new Thread(myPriority);
        Thread thread2 = new Thread(myPriority);
        Thread thread3 = new Thread(myPriority);

        //先设置优先级，再启动，不设置优先级，默认为5
        thread1.start();

        thread2.setPriority(3);
        thread2.start();

        thread3.setPriority(Thread.MAX_PRIORITY);//MAX_PRIORITY = 10
        thread3.start();
    }
}

class MyPriority implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "--->" + Thread.currentThread().getPriority());
    }
}