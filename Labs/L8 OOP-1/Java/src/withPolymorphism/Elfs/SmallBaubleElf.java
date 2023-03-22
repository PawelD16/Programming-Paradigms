package withPolymorphism.Elfs;

import withPolymorphism.ChristmasDecorations.ChristmasDecoration;
import withPolymorphism.ChristmasDecorations.Baubles.SmallBauble;

import java.util.Stack;

public class SmallBaubleElf extends Elf<SmallBauble> {

    public SmallBaubleElf(Stack<SmallBauble[]> unfilledBoxesStack, Elf<? extends ChristmasDecoration> nextElf) {
        super(unfilledBoxesStack, nextElf);
    }

    public void addDecorationToBox(ChristmasDecoration decoration) {
        if (decoration instanceof SmallBauble) super.addDecorationToBox(decoration);
        else checkForNextElf(decoration);
    }
}
