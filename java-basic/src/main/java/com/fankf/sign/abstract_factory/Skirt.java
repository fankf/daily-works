package com.fankf.sign.abstract_factory;

/**
 * @AUTHOR thinkpad
 * @DATETIME 2020-07-14 19:21
 * @PACKAGE com.fankf.sign.abstract_factory
 */
public class Skirt implements ClothesInterface {
    @Override
    public void makeClothes() {
        System.out.println("制作一条裙子...");
    }
}
