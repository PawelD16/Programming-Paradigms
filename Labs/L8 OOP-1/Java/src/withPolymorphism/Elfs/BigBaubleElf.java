package withPolymorphism.Elfs;

import withPolymorphism.ChristmasDecorations.Baubles.BigBauble;
import withPolymorphism.ChristmasDecorations.ChristmasDecoration;

import java.util.Stack;

public class BigBaubleElf extends Elf<BigBauble> {
    public BigBaubleElf(Stack<BigBauble[]> unfilledBoxesStack, Elf<? extends ChristmasDecoration> nextElf) {
        super(unfilledBoxesStack, nextElf);
    }

    public void addDecorationToBox(ChristmasDecoration decoration) {
        if (decoration instanceof BigBauble) super.addDecorationToBox(decoration);
        else checkForNextElf(decoration);
    }
}
