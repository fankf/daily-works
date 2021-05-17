package com.fankf.sign.factory;

public class BallFactory {
    public static BallInterface getBall(String name) {
        switch (name) {
            case "baseball":
                return new BaseBall();
            case "basketball":
                return new BaseBall();
            case "football":
                return new BaseBall();
        }
        return null;
    }
}

class BasketBall implements BallInterface {

    @Override
    public void describe() {
        System.out.println(" this is a BasketBall ...");
    }
}

class BaseBall implements BallInterface {
    @Override
    public void describe() {
        System.out.println(" this is a BaseBall ...");
    }
}

class FootBall implements BallInterface {
    @Override
    public void describe() {
        System.out.println(" this is a FootBall ...");
    }
}