package withPolymorphism.Elfs;

import utilities.ConstantToStrings;
import withPolymorphism.ChristmasDecorations.ChristmasDecoration;

import java.util.Stack;

public abstract class Elf<T extends ChristmasDecoration> {
    protected Stack<T[]> unfilledBoxesStack;
    protected Stack<T[]> filledBoxesStack;
    protected int nextPositionInBox;

    protected Elf<? extends ChristmasDecoration> nextElf;

    //zakladam, ze mamy skonczona ilosc pudelek o skonczonej wielkosci, dlatego nie tworzymy po prostu stosu na pudełka
    public Elf(Stack<T[]> unfilledBoxesStack, Elf<? extends ChristmasDecoration> nextElf) {
        this.unfilledBoxesStack = unfilledBoxesStack;
        this.filledBoxesStack = new Stack<>();
        this.nextPositionInBox = 0;
        this.nextElf = nextElf;
    }

    protected Elf() {
    }

    @SuppressWarnings("unchecked")
    protected void addDecorationToBox(ChristmasDecoration decoration) {
        //sprawdzenie typu wczesniej, teraz sprawdzamy czy mamy miejsce, jak nie to przekazujemy dalej, jak nie ma komu to upuszczamy
        while (!unfilledBoxesStack.empty() && unfilledBoxesStack.peek().length - 1 <= nextPositionInBox) {
            nextPositionInBox = 0;
            filledBoxesStack.push(unfilledBoxesStack.pop());
            System.out.println(ConstantToStrings.BOX_IS_FULL_TO_STRING);
        }

        if (!unfilledBoxesStack.empty()) {
            unfilledBoxesStack.peek()[nextPositionInBox++] = (T) decoration;
            System.out.println(ConstantToStrings.ADDED_TO_BOX_TO_STRING + decoration);
        } else {
            checkForNextElf(decoration);
        }
    }

    protected void checkForNextElf(ChristmasDecoration decoration) {
        if (nextElf != null) nextElf.addDecorationToBox(decoration);
        else System.out.println(ConstantToStrings.DESTROYED_DECORATION_TO_STRING + decoration.toString());
    }
}
