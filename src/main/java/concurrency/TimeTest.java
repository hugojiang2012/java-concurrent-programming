package concurrency;
import java.util.*;
/**
 * Created by jiangjingping on 2018/8/30.
 */
public class TimeTest {
    public static void main(String[] args) throws InterruptedException {
        int count = 1000000;
        ArrayList<Integer> list = new ArrayList<Integer>();
        Vector<Integer> vector = new Vector<Integer>();
        long start = System.currentTimeMillis();
        for(int i=0;i<count;i++)
            list.add(i);
        long end = System.currentTimeMillis();
        System.out.println("ArrayList进行1000000次插入操作耗时："+(end-start)+"ms");
        start = System.currentTimeMillis();
        for(int i=0;i<count;i++)
            vector.add(i);
        end = System.currentTimeMillis();
        System.out.println("Vector进行1000000次插入操作耗时："+(end-start)+"ms");
    }
}