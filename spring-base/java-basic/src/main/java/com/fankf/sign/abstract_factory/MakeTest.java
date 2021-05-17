package com.fankf.sign.abstract_factory;

/**
 * @AUTHOR thinkpad
 * @DATETIME 2020-07-14 19:35
 * @PACKAGE com.fankf.sign.abstract_factory
 */
public class MakeTest {

    public static void main(String[] args) {
        AbstractMakefactory ballMakefactory = new BallFactory();
        ballMakefactory.make("baseBall");
        BallInterface ballInterface = ((BallFactory) ballMakefactory).getBallInterface();
        ballInterface.makeBall();


        AbstractMakefactory clothesFactory = new ClothesFactory();
        clothesFactory.make("skirt");
        ClothesInterface clothesInterface = ((ClothesFactory) clothesFactory).getClothesInterface();
        clothesInterface.makeClothes();
    }
}
