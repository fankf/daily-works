package com.fankf.observer;


import java.util.Observable;
import java.util.Observer;

/**
 * fankunfeng
 * 2020-09-14 20:26
 */
public class ObserverDemo extends Observable {


    /**
     * Java9的Flow 才是核心的webflux封装的对象
     * 实现方式
     *      Flow.Publisher<Strig> publisher = ()
     * @param args
     */
    public static void main(String[] args) {
        ObserverDemo demo = new ObserverDemo();
        demo.addObserver(((o, arg) -> System.out.println("拿到信息了。。。")));
        demo.addObserver(((o, arg) -> System.out.println("拿到信息了233333。。。")));

        demo.setChanged();
        demo.notifyObservers();
    }
}
