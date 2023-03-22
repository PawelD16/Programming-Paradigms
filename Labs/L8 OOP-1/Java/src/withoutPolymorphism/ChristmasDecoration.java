package withoutPolymorphism;

import utilities.ConstantToStrings;

import java.awt.Color;

public class ChristmasDecoration {
    private final ChristmasDecorationType type;
    private final String design;
    private final Color color;
    private final int weight;
    private final boolean isTranslucent;

    public ChristmasDecoration(ChristmasDecorationType type, String design, Color color, int weight, boolean isTranslucent) {
        this.type = type;
        this.color = color;
        this.design = design;
        this.weight = Math.abs(weight);
        this.isTranslucent = isTranslucent;
    }

    public String toString() {
        String temp = ", color: " + color + ", design: " + design + ", weight: " + weight + ", isTranslucent: " + isTranslucent;
        switch (type) {
            case SMALL_BAUBLE:
                return "type: " + ConstantToStrings.SMALL_BAUBLE_TO_STRING + temp;
            case BIG_BAUBLE:
                return "type: " + ConstantToStrings.BIG_BAUBLE_TO_STRING + temp;
            case MUSHROOM:
                return "type: " + ConstantToStrings.MUSHROOM_TO_STRING + temp;
            case ICICLE:
                return "type: " + ConstantToStrings.ICICLE_TO_STRING + temp;
            case SOME_BAUBLE:
                return "type: " + ConstantToStrings.ALL_BAUBLE_TO_STRING + temp;
            default:
                return "";
        }
    }

    public ChristmasDecorationType getType() {
        return type;
    }
}
