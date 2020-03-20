package hw07;

import java.util.Arrays;
import java.util.Objects;

public class Family {
    private Woman woman;
    private Man man;
    private Human[] children;
    private Pet pet;
    private int index = 0;

    public Family() { }

    public Family(Woman woman, Man man, Human[] children, Pet pet) {
        this.woman = woman;
        this.man = man;
        this.children = children;
        this.pet = pet;
    }

    public Woman getWoman() { return woman; }
    public void setWoman(Woman woman) { this.woman = woman; }
    public Man getMan() { return man; }
    public void setMan(Man man) { this.man = man; }
    public Human[] getChildren() { return children; }
    public void setChildren(Human[] children) { this.children = children; }
    public Pet getPet() { return pet; }
    public void setPet(Pet pet) { this.pet = pet; }

    public int addChild(Human child) {
        children = Arrays.copyOf(children, index + 1);
        children[index++] = child;
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
        children = Arrays.copyOf(children,children.length-1);
        return true;
    }

    public void deleteObject(Human child) {
        try {
            for (int i = 0; i < children.length; i++) {
                if (child == children[i]) {
                    for (int j = i; j < children.length-1; j++)
                        children[j] = children[j+1];
                }
            }
            children = Arrays.copyOf(children,children.length-1);
        } catch (Exception e) {
            System.out.println("It's not deleted");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Family family = (Family) o;
        return index == family.index &&
                woman.equals(family.woman) &&
                man.equals(family.man) &&
                Arrays.equals(children, family.children) &&
                pet.equals(family.pet);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(woman, man, pet, index);
        result = 31 * result + Arrays.hashCode(children);
        return result;
    }

    @Override
    public String toString() {
        children = Arrays.copyOf(children,index);
        return String.format("Family{mother=%s, father=%s, children=%s, pet=%s}", woman, man, Arrays.toString(children), pet);
    }
}
