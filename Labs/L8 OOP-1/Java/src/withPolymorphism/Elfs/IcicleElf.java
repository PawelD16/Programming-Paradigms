package withPolymorphism.Elfs;

import withPolymorphism.ChristmasDecorations.ChristmasDecoration;
import withPolymorphism.ChristmasDecorations.Icicle;

import java.util.Stack;

public class IcicleElf extends Elf<Icicle> {

    public IcicleElf(Stack<Icicle[]> unfilledBoxesStack, Elf<? extends ChristmasDecoration> nextElf) {
        super(unfilledBoxesStack, nextElf);
    }

    public void addDecorationToBox(ChristmasDecoration decoration) {
        if (decoration instanceof Icicle) super.addDecorationToBox(decoration);
        else checkForNextElf(decoration);
    }
}
