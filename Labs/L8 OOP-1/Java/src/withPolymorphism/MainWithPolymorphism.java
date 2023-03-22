package withPolymorphism;

import javafx.util.Pair;
import withPolymorphism.ChristmasDecorations.*;
import withPolymorphism.ChristmasDecorations.Baubles.BigBauble;
import withPolymorphism.ChristmasDecorations.Baubles.SmallBauble;
import withPolymorphism.Elfs.*;

import java.awt.*;
import java.util.Stack;

public class MainWithPolymorphism {
    public static void main(String[] args) {
        System.out.println("With polymorphism");
        int maxSizeOfBoxes = 10;
        int amountOfBoxes = 5;

        Stack<Icicle[]> icicleBoxesStack = new Stack<>();
        Stack<Pair<BigBauble[], SmallBauble[]>> baublesStack = new Stack<>();

        for (int i = 0; i < amountOfBoxes; ++i) {
            icicleBoxesStack.push(new Icicle[(int) (Math.random() * maxSizeOfBoxes)]);
            baublesStack.push(new Pair<BigBauble[], SmallBauble[]>(new BigBauble[(int) (Math.random() * maxSizeOfBoxes)], new SmallBauble[(int) (Math.random() * maxSizeOfBoxes)]));
        }

        AllBaubleElf firstElf = new AllBaubleElf(baublesStack, new IcicleElf(icicleBoxesStack, null));

        for (int i = 0; i < amountOfBoxes * maxSizeOfBoxes; ++i) {
            if (Math.random() <= 0.4)
                firstElf.addDecorationToBox(new Icicle("stripey!", Color.MAGENTA, i, true));
            else if (Math.random() <= 0.7)
                firstElf.addDecorationToBox(new SmallBauble("smooth!", Color.RED, i, false));
            else
                firstElf.addDecorationToBox(new Mushroom("mushroomey!", Color.ORANGE, i, false));
        }
    }
}