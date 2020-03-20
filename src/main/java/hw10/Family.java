package hw10;

import java.util.HashSet;
import java.util.List;

public class Family {
    private Woman woman;
    private Man man;
    private List<Human> children;
    private HashSet<Pet> pet;

    public Family(Woman mother, Man father, List<Human> children) {
        this.woman = mother;
        this.man = father;
        this.children = children;
    }

    public Family(Woman woman, Man man, List<Human> children, HashSet<Pet> pet) {
        this.woman = woman;
        this.man = man;
        this.children = children;
        this.pet = pet;
    }

    public Woman getWoman() { return woman; }
    public void setWoman(Woman woman) { this.woman = woman; }
    public Man getMan() { return man; }
    public void setMan(Man man) { this.man = man; }
    public List<Human> getChildren() { return children; }
    public void setChildren(List<Human> children) { this.children = children; }
    public HashSet<Pet> getPet() { return pet; }
    public void setPet(HashSet<Pet> pet) { this.pet = pet; }
    
    public void addChild(Human child) {
        children.add(child);
    }

    public int countFamily() {
        int countChildren = children.size();
        return countChildren+2;
    }

    public boolean deleteChild(int removedIndex) {
        if (removedIndex < 0 || removedIndex > children.size())  return false;
        children.remove(removedIndex); return true;
    }

    public void deleteChildObject(Human child) {
        children.remove(child);
    }

    @Override
    public String toString() {
        return String.format("Family{woman=%s, man=%s, children=%s, pet=%s}", woman, man, children, pet);
    }

}
