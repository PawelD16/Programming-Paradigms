package withoutPolymorphism;

import javafx.util.Pair;
import utilities.ConstantToStrings;

import java.util.Stack;

public class Elf {
    private final ChristmasDecorationType typeOfDecoration;
    private final Stack<ChristmasDecoration[]> unfilledBoxesStack;
    private final Stack<Pair<ChristmasDecoration[], ChristmasDecoration[]>> unfilledBoxesStackForAllBaubleElf;
    private int nextPositionInBox, nextPositionInBoxForSmallBaubles, nextPositionInBoxForBigBaubles;
    private final Elf nextElf;

    public Elf(ChristmasDecorationType typeOfDecoration, Stack<ChristmasDecoration[]> unfilledBoxesStack, Elf nextElf) {
        this.unfilledBoxesStack = unfilledBoxesStack;
        this.unfilledBoxesStackForAllBaubleElf = null;
        this.nextPositionInBox = 0;
        this.nextElf = nextElf;
        this.typeOfDecoration = typeOfDecoration;
    }

    public Elf(Stack<Pair<ChristmasDecoration[], ChristmasDecoration[]>> unfilledBoxesStackForAllBaubleElf, Elf nextElf) {
        this.unfilledBoxesStackForAllBaubleElf = unfilledBoxesStackForAllBaubleElf;
        this.unfilledBoxesStack = null;
        this.nextPositionInBoxForSmallBaubles = 0;
        this.nextPositionInBoxForBigBaubles = 0;
        this.nextElf = nextElf;
        this.typeOfDecoration = ChristmasDecorationType.SOME_BAUBLE;
    }

    public void addDecorationToBox(ChristmasDecoration decoration) {
        if (typeOfDecoration != ChristmasDecorationType.SOME_BAUBLE) addDecorationToNormalBox(decoration);
        else addDecorationToHahaBox(decoration);
    }

    private void addDecorationToHahaBox(ChristmasDecoration decoration) {
        if(decoration.getType() != ChristmasDecorationType.SMALL_BAUBLE && decoration.getType() !=ChristmasDecorationType.BIG_BAUBLE){
            checkForNextElf(decoration);
            return;
        }
        while (!unfilledBoxesStackForAllBaubleElf.empty()
                && (unfilledBoxesStackForAllBaubleElf.peek().getKey().length - 1 <= nextPositionInBoxForBigBaubles
                || unfilledBoxesStackForAllBaubleElf.peek().getValue().length - 1 <= nextPositionInBoxForSmallBaubles)) {
            nextPositionInBoxForSmallBaubles = 0;
            nextPositionInBoxForBigBaubles = 0;
            unfilledBoxesStackForAllBaubleElf.pop();
            System.out.println(ConstantToStrings.BOX_IS_FULL_TO_STRING);
        }

        if (!unfilledBoxesStackForAllBaubleElf.empty()) {
            if (decoration.getType() == ChristmasDecorationType.BIG_BAUBLE) {
                unfilledBoxesStackForAllBaubleElf.peek().getKey()[nextPositionInBoxForBigBaubles++] = decoration;
                System.out.println(ConstantToStrings.ADDED_TO_BOX_TO_STRING + decoration);
            } else {
                unfilledBoxesStackForAllBaubleElf.peek().getValue()[nextPositionInBoxForSmallBaubles++] = decoration;
                System.out.println(ConstantToStrings.ADDED_TO_BOX_TO_STRING + decoration);
            }
        } else {
            checkForNextElf(decoration);
        }
    }

    private void addDecorationToNormalBox(ChristmasDecoration decoration) {
        if (!typeOfDecoration.equals(decoration.getType())) {
            checkForNextElf(decoration);
            return;
        }

        while (!unfilledBoxesStack.empty() && unfilledBoxesStack.peek().length - 1 <= nextPositionInBox) {
            nextPositionInBox = 0;
            unfilledBoxesStack.pop();
            System.out.println(ConstantToStrings.BOX_IS_FULL_TO_STRING);
        }

        if (!unfilledBoxesStack.empty()) {
            unfilledBoxesStack.peek()[nextPositionInBox++] = decoration;
            System.out.println(ConstantToStrings.ADDED_TO_BOX_TO_STRING + decoration);
        } else {
            checkForNextElf(decoration);
        }
    }

    private void checkForNextElf(ChristmasDecoration decoration) {
        if (nextElf != null) nextElf.addDecorationToBox(decoration);
        else System.out.println(ConstantToStrings.DESTROYED_DECORATION_TO_STRING + decoration.toString());
    }
}
