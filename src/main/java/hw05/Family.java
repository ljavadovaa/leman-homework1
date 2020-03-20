package hw05;

import java.util.Arrays;
import java.util.Objects;

public class Family {
    private Human mother;
    private Human father;
    private Human[] children;
    private Pet pet;
    int index = 0;

    public Family(Human mother, Human father, Human[] children, Pet pet) {
        this.mother = mother;
        this.father = father;
        this.children = children;
        this.pet = pet;
    }

    public Human getMother() { return mother; }
    public void setMother(Human mother) { this.mother = mother; }
    public Human getFather() { return father; }
    public void setFather(Human father) { this.father = father; }
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
        return Objects.equals(mother, family.mother) &&
                Objects.equals(father, family.father) &&
                Arrays.equals(children, family.children);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(mother, father, pet, index);
        result = 31 * result + Arrays.hashCode(children);
        return result;
    }

    @Override
    public String toString() {
        children = Arrays.copyOf(children,index);
        return String.format("Family{mother=%s, father=%s, children=%s, pet=%s}", mother, father, Arrays.toString(children), pet);
    }
}
