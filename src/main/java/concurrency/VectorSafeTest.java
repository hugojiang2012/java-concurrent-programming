package concurrency;
import java.util.*;
import java.util.concurrent.*;
/**
 * Created by jiangjingping on 2018/8/30.
 */
// 进行额外的同步
public class VectorSafeTest {
    static Vector<Integer> vector = new Vector<Integer>();
    public static void main(String[] args) throws InterruptedException {
        while(true) {
            for(int i=0;i<10;i++)
                vector.add(i);
            Thread thread1 = new Thread(){
                public void run() {
                    synchronized (VectorSafeTest.class) {   //进行额外的同步
                        for(int i=0;i<vector.size();i++)
                            vector.remove(i);
                    }
                };
            };
            Thread thread2 = new Thread(){
                public void run() {
                    synchronized (VectorSafeTest.class) {
                        for(int i=0;i<vector.size();i++)
                            System.out.println( vector.get(i));

                    }
                };
            };
            thread1.start();
            thread2.start();
            while(Thread.activeCount()>10)   {

            }
        }
    }
}