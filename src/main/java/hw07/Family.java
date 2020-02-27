package hw07;

import java.util.Arrays;

public class Family {
    private Woman woman;
    private Man man;
    private Human[] children;
    private Pet pet;
    int index = 0;

    public Family() {
    }

    public Family(Woman woman, Man man, Human[] children, Pet pet) {
        this.woman = woman;
        this.man = man;
        this.children = children;
        this.pet = pet;
    }

    public int addChild(Human child) {
        children[index] = child;
        index++;
        return index;
    }

    public int countFamily() {
        int countChildren = children.length;
        return countChildren+2;
    }

    public boolean deleteChild(int removedIndex) {
        if (removedIndex < 0 || removedIndex > children.length)  return false;
        for (int i = removedIndex; i < children.length-1; i++)
            children[i] = children[i+1];
        index--;
        children = Arrays.copyOf(children,index);
        return true;
    }

    @Override
    public String toString() {
        return String.format("Family{mother=%s, father=%s, children=%s, pet=%s}", woman, man, Arrays.toString(children), pet);
    }
}
