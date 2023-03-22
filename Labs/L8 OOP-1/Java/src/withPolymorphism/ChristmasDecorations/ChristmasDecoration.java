package withPolymorphism.ChristmasDecorations;

import java.awt.Color;

//nie dodaje Bauble (ktore byloby rozszerzone w BigBauble i SmallBauble), bo nic to nie daje w sumie
public abstract class ChristmasDecoration {
    protected final String design;
    protected final Color color;
    protected final int weight;
    protected final boolean isTranslucent;

    public ChristmasDecoration(String design, Color color, int weight, boolean isTranslucent) {
        this.color = color;
        this.design = design;
        this.weight = Math.abs(weight);
        this.isTranslucent = isTranslucent;
    }

    public String toString() {
        return ", Color: " + color + ", Design: " + design + ", Weight: " + weight + ", isTranslucent: " + isTranslucent;
    }
}
