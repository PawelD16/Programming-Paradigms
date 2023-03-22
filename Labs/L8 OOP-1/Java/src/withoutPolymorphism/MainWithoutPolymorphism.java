package withoutPolymorphism;

import javafx.util.Pair;

import java.awt.*;
import java.util.Stack;

public class MainWithoutPolymorphism {
    public static void main(String[] args) {
        System.out.println("Without polymorphism");
        int maxSizeOfBoxes = 10;
        int amountOfBoxes = 5;

        Stack<ChristmasDecoration[]> icicleBoxesStack = new Stack<>();
        Stack<Pair<ChristmasDecoration[], ChristmasDecoration[]>> baubleBoxStack = new Stack<>();


        for (int i = 0; i < amountOfBoxes; ++i) {
            icicleBoxesStack.push(new ChristmasDecoration[(int) (Math.random() * maxSizeOfBoxes)]);
            baubleBoxStack.push(new Pair<>(new ChristmasDecoration[(int) (Math.random() * maxSizeOfBoxes)], new ChristmasDecoration[(int) (Math.random() * maxSizeOfBoxes)]));
        }

        Elf firstElf = new Elf(baubleBoxStack, new Elf(ChristmasDecorationType.ICICLE, icicleBoxesStack, null));

        for (int i = 0; i < amountOfBoxes * maxSizeOfBoxes; ++i) {
            if (Math.random() <= 0.4)
                firstElf.addDecorationToBox(new ChristmasDecoration(ChristmasDecorationType.ICICLE, "stripey!", Color.MAGENTA, i, true));
            else if (Math.random() <= 0.7)
                firstElf.addDecorationToBox(new ChristmasDecoration(ChristmasDecorationType.SMALL_BAUBLE, "smooth!", Color.RED, i, false));
            else
                firstElf.addDecorationToBox(new ChristmasDecoration(ChristmasDecorationType.MUSHROOM, "mushroomey!", Color.ORANGE, i, false));
        }
    }
}
