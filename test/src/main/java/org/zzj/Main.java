package org.zzj;

/**
 * @auther: stan
 * @create: 2021-04-21 16:22
 */
public class Main {


    public static void main(String[] args) throws InterruptedException {
        Test t = new Test();
        while (true){
            Thread.sleep(1000);
            t.test();
        }
    }

}
