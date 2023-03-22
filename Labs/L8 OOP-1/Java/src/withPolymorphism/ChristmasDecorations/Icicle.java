package withPolymorphism.ChristmasDecorations;

import java.awt.Color;

import utilities.ConstantToStrings;

public class Icicle extends ChristmasDecoration {

    public Icicle(String design, Color color, int weight, boolean isTranslucent) {
        super(design, color, weight, isTranslucent);
    }

    @Override
    public String toString() {
        return "type: " + ConstantToStrings.ICICLE_TO_STRING + super.toString();
    }
}
