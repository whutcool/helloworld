/**********************************@Copyright恒生电子股份有限公司*********************************/

import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/******************************************************************************************************
 * @SYSTEM BEMP
 * @MODULE PACKAGE_NAME
 * @DESCRIPTION TODO
 * @AUTHOR jianglu21141
 * @DATE 2020/3/28
 * @MODIFY
 * -----------------------------------------------------------------------------------------------------
 * |		修改单号		|		修改人员		|		修改日期		|		评审人员		|		修改说明	
 * -----------------------------------------------------------------------------------------------------
 * |	  				|	   				| 	 				|					|				
 * -----------------------------------------------------------------------------------------------------
 *
 *******************************************************************************************************/
public class SynDemo{

    public static void main(String[] arg){
        Runnable t1=new MyThread();
        new Thread(t1,"t1").start();
        new Thread(t1,"t2").start();
    }

}
class MyThread implements Runnable {

    private Lock lock=new ReentrantLock();
    public void run() {
        lock.lock();
        try{
            for(int i=0;i<5;i++)
                System.out.println(Thread.currentThread().getName()+":"+i);
        }finally{
            lock.unlock();
        }
    }

}
