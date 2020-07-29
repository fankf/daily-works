package com.fankf.sign.observer;

/**
 * @author fankunfeng
 * @datetime 2020-07-29 11:22
 * @package com.fankf.sign.observer
 */
public class ObserverTest {

    public static void main(String[] args) {
        Observer<DataInterface> observer = new DataObeserver();
        Data1 data1 = new Data1();
        Data2 data2 = new Data2();
        observer.add("data", data1);
        observer.add("data", data2);
        observer.update("data");
        observer.remove("data", data2);
        observer.update("data");

    }
}
