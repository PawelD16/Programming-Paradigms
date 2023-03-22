package withPolymorphism.ChristmasDecorations.Baubles;

import utilities.ConstantToStrings;

import java.awt.Color;

public class BigBauble extends Bauble {

    public BigBauble(String design, Color color, int weight, boolean isTranslucent) {
        super(design, color, weight, isTranslucent);
    }

    @Override
    public String toString() {
        return "type: " + ConstantToStrings.BIG_BAUBLE_TO_STRING + super.christmasDecorationString();
    }
}
