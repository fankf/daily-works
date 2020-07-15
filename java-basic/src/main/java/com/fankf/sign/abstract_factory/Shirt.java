package com.fankf.sign.abstract_factory;

/**
 * @AUTHOR thinkpad
 * @DATETIME 2020-07-14 19:20
 * @PACKAGE com.fankf.sign.abstract_factory
 */
public class Shirt implements ClothesInterface {
    @Override
    public void makeClothes() {
        System.out.println("制作一件上衣...");
    }
}
