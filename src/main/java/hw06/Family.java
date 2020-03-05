package hw06;

import java.util.Arrays;
import java.util.Objects;

public class Family {
    private Human mother;
    private Human father;
    private Human[] children;
    private Pet pet;
    private int indexx = 0;

    public Family() {
    }

    public Human getMother() { return mother; }
    public void setMother(Human mother) { this.mother = mother; }
    public Human getFather() { return father; }
    public void setFather(Human father) { this.father = father; }
    public Human[] getChildren() { return children; }
    public void setChildren(Human[] children) { this.children = children; }
    public Pet getPet() { return pet; }
    public void setPet(Pet pet) { this.pet = pet; }

    public Family(Human mother, Human father, Human[] children, Pet pet) {
        this.mother = mother;
        this.father = father;
        this.children = children;
        this.pet = pet;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }

    public int addChild(Human child) {
        children[indexx] = child;
        indexx++;
        return indexx;
    }

    public int countFamily() {
        int countChildren = children.length;
        return countChildren+2;
    }

    public boolean deleteChild(int removedIndex) {
        if (removedIndex < 0 || removedIndex > children.length)  return false;
        for (int i = removedIndex; i < children.length-1; i++)
            children[i] = children[i+1];
        indexx--;
        children = Arrays.copyOf(children,indexx);
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Family family = (Family) o;
        return Objects.equals(mother, family.mother) &&
                Objects.equals(father, family.father) &&
                Arrays.equals(children, family.children) &&
                Objects.equals(pet.getAge(), family.pet.getAge());
    }

    @Override
    public String toString() {
        children = Arrays.copyOf(children,indexx);
        return String.format("Family{mother=%s, father=%s, children=%s, pet=%s}", mother, father, Arrays.toString(children), pet);
    }
}
