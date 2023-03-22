package withPolymorphism.Elfs;

import withPolymorphism.ChristmasDecorations.ChristmasDecoration;
import withPolymorphism.ChristmasDecorations.Mushroom;

import java.util.Stack;

public class MushroomElf extends Elf<Mushroom> {

    public MushroomElf(Stack<Mushroom[]> unfilledBoxesStack, Elf<? extends ChristmasDecoration> nextElf) {
        super(unfilledBoxesStack, nextElf);
    }

    public void addDecorationToBox(ChristmasDecoration decoration) {
        if (decoration instanceof Mushroom) super.addDecorationToBox(decoration);
        else checkForNextElf(decoration);
    }
}
