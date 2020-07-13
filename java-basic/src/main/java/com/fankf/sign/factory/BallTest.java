package com.fankf.sign.factory;

public class BallTest {
    public static void main(String[] args) {
        BallInterface baseball = BallFactory.getBall("baseball");
        baseball.describe();
    }
}
