package withPolymorphism.Elfs;

import javafx.util.Pair;
import utilities.ConstantToStrings;
import withPolymorphism.ChristmasDecorations.Baubles.Bauble;
import withPolymorphism.ChristmasDecorations.Baubles.BigBauble;
import withPolymorphism.ChristmasDecorations.Baubles.SmallBauble;
import withPolymorphism.ChristmasDecorations.ChristmasDecoration;

import java.util.Stack;

public class AllBaubleElf extends Elf<Bauble> {
    private final Stack<Pair<BigBauble[], SmallBauble[]>> unfilledBoxesStack;
    private final Stack<Pair<BigBauble[], SmallBauble[]>> filledBoxesStack;
    private int nextPositionInBoxForSmallBaubles, nextPositionInBoxForBigBaubles;

    public AllBaubleElf(Stack<Pair<BigBauble[], SmallBauble[]>> unfilledBoxesStack, Elf<? extends ChristmasDecoration> nextElf) {
        this.unfilledBoxesStack = unfilledBoxesStack;
        this.filledBoxesStack = new Stack<>();
        this.nextPositionInBoxForSmallBaubles = 0;
        this.nextPositionInBoxForBigBaubles = 0;
        this.nextElf = nextElf;
    }

    public void addDecorationToBox(ChristmasDecoration decoration) {
        if (decoration instanceof Bauble) {
            while (!unfilledBoxesStack.empty()
                    && (unfilledBoxesStack.peek().getKey().length - 1 <= nextPositionInBoxForBigBaubles
                    || unfilledBoxesStack.peek().getValue().length - 1 <= nextPositionInBoxForSmallBaubles)) {
                nextPositionInBoxForSmallBaubles = 0;
                nextPositionInBoxForBigBaubles = 0;
                filledBoxesStack.push(unfilledBoxesStack.pop());
                System.out.println(ConstantToStrings.BOX_IS_FULL_TO_STRING);
            }

            if (!unfilledBoxesStack.empty()) {
                if (decoration instanceof BigBauble) {
                    unfilledBoxesStack.peek().getKey()[nextPositionInBoxForBigBaubles++] = (BigBauble) decoration;
                    System.out.println(ConstantToStrings.ADDED_TO_BOX_TO_STRING + decoration);
                } else {
                    unfilledBoxesStack.peek().getValue()[nextPositionInBoxForSmallBaubles++] = (SmallBauble) decoration;
                    System.out.println(ConstantToStrings.ADDED_TO_BOX_TO_STRING + decoration);
                }
            } else {
                checkForNextElf(decoration);
            }
        } else checkForNextElf(decoration);
    }
}
