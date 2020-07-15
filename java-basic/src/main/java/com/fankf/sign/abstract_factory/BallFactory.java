package com.fankf.sign.abstract_factory;

public class BallFactory extends AbstractMakefactory {
    private BallInterface ballInterface;

    @Override
    void color(String colorName) {

    }

    @Override
    void make(String ballName) {
        switch (ballName) {
            case "baseBall":
                ballInterface = new BaseBall();
                return;
            case "basketBall":
                ballInterface = new BasketBall();
                return;
        }
    }

    public BallInterface getBallInterface() {
        return ballInterface;
    }
}
