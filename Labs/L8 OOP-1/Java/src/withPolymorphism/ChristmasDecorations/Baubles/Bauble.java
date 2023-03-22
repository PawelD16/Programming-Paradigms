package withPolymorphism.ChristmasDecorations.Baubles;

import utilities.ConstantToStrings;
import withPolymorphism.ChristmasDecorations.ChristmasDecoration;

import java.awt.*;

public class Bauble extends ChristmasDecoration {
    public Bauble(String design, Color color, int weight, boolean isTranslucent) {
        super(design, color, weight, isTranslucent);
    }

    @Override
    public String toString() {
        return "type: " + ConstantToStrings.ALL_BAUBLE_TO_STRING + super.toString();
    }

    protected String christmasDecorationString(){
        return super.toString();
    }
}
