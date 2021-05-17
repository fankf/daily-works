package com.fankf.sign.abstract_factory;

/**
 * @AUTHOR thinkpad
 * @DATETIME 2020-07-14 19:19
 * @PACKAGE com.fankf.sign.abstract_factory
 */
public class BasketBall implements BallInterface {
    @Override
    public void makeBall() {
        System.out.println("制作一个篮球...");
    }
}
