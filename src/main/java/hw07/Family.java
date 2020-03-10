package hw07;

import java.util.Arrays;

public class Family {
    private Woman woman;
    private Man man;
    private Human[] children;
    private Pet pet;
    int index = 0;
    int saveIndex = 0;

    public Family() {
    }

    public Family(Woman woman, Man man, Human[] children, Pet pet) {
        this.woman = woman;
        this.man = man;
        this.children = children;
        this.pet = pet;
    }

    public Human[] addChild(Human child) {
        children[index] = child;
        index++;
        Human[] array = new Human[children.length + 1];
        System.arraycopy(children, 0, array, 0, children.length);
        array[children.length] = child;
        return array;
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


    public void deleteObject(Human child) {
        saveIndex = children.length;
        try {
            for (int i = 0; i < children.length; i++) {
                if (child == children[i])
                    saveIndex = i;
            }
            for (int i = saveIndex; i < children.length-1; i++)
                children[i] = children[i+1];
            index--;
            children = Arrays.copyOf(children,index);
        } catch (Exception e) {
            System.out.println("It's not deleted");
        }
    }

    @Override
    public String toString() {
        return String.format("Family{mother=%s, father=%s, children=%s, pet=%s}", woman, man, Arrays.toString(children), pet);
    }
}
