package com.fankf.sign.abstract_factory;

public class ClothesFactory extends AbstractMakefactory {

    private ClothesInterface clothesInterface;

    @Override
    void color(String colorName) {

    }

    @Override
    void make(String clothesName) {
        switch (clothesName) {
            case "skirt":
                clothesInterface = new Skirt();
            case "shirt":
                clothesInterface = new Shirt();
        }
    }

    public ClothesInterface getClothesInterface() {
        return clothesInterface;
    }
}
