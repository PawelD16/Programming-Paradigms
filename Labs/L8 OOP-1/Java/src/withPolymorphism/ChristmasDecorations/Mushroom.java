package withPolymorphism.ChristmasDecorations;

import java.awt.Color;

import utilities.ConstantToStrings;

public class Mushroom extends ChristmasDecoration {

    public Mushroom(String design, Color color, int weight, boolean isTranslucent) {
        super(design, color, weight, isTranslucent);
    }

    @Override
    public String toString() {
        return "type: " + ConstantToStrings.MUSHROOM_TO_STRING + super.toString();
    }
}
