package hw05;

import java.util.Arrays;
import java.util.Objects;

public class Family {
    private Human mother;
    private Human father;
    private Human[] children;
    private Pet pet;

    public Human getMother() { return mother; }
    public void setMother(Human mother) { this.mother = mother; }
    public Human getFather() { return father; }
    public void setFather(Human father) { this.father = father; }
    public Human[] getChildren() { return children; }
    public void setChildren(Human[] children) { this.children = children; }
    public Pet getPet() { return pet; }
    public void setPet(Pet pet) { this.pet = pet; }

    public void addChild(Human child) {
        int i=0;
        children[i] = child;
        i++;
    }

    public int countFamily() {
        int countChildren = children.length;
        return countChildren+2;
    }

//    public Human[] deleteChild(Human[] children, int removedIndex) {
//        Human[] newChild = new Human[children.length-1];
//        for (int i = 0; i < removedIndex; i++) {
//            newChild[i] = children[i];
//        }
//        for (int i = removedIndex; i < children.length-1; i++) {
//            newChild[i] = children[i+1];
//        }
//        return newChild;
//    }

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
        return String.format("Family{mother=%s, father=%s, children=%s, pet=%s}", mother, father, Arrays.toString(children), pet);
    }
}
