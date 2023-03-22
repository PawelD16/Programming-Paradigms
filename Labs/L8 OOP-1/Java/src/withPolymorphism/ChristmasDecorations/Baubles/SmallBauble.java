package withPolymorphism.ChristmasDecorations.Baubles;

import utilities.ConstantToStrings;

import java.awt.Color;

public class SmallBauble extends Bauble {

    public SmallBauble(String design, Color color, int weight, boolean isTranslucent) {
        super(design, color, weight, isTranslucent);
    }

    @Override
    public String toString() {
        return "type: " + ConstantToStrings.SMALL_BAUBLE_TO_STRING + christmasDecorationString();
    }
}
