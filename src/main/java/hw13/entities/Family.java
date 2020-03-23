package hw13.entities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
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

    public String prettyFormat() {
        return String.format("family: \nmother: %s,\nfather: %s,\nchildren:\n%s\npets: %s\n",
                woman.showHuman(), man.showHuman(), formatChildren(), showPet());
    }

    @Override
    public String toString() {
        return String.format("Family{woman=%s, man=%s, children=%s, pet=%s}", woman, man, children, pet);
    }

    public String formatChildren() {
        String child;
        StringBuilder sb = new StringBuilder();
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        for (Human ch : children) {
            sb.append(ch.getName()).append(": {");
            sb.append("name='").append(ch.getName()).append("', ").append("surname='").append(ch.getSurname()).append("', ")
                    .append("birthDate='").append(formatter.format(ch.getBirthDate())).append("', ")
                    .append("IQ='").append(ch.getIQ()).append("'").append("} \n");
        }
        child = sb.toString();
        return child;
    }

    public String showPet() {
        String pett;
        StringBuilder sb = new StringBuilder();
        for (Pet pet1 : pet) {;
            sb.append("species: ").append(pet1.getSpecies()).append(" nickname: ").append(pet1.getNickname()).append(" age: ").append(pet1.getAge()).append(" tricklevel: ")
                    .append(pet1.getTrickLevel()).append(" habits: ").append(pet1.getHabits());
        }
        pett = sb.toString();
        return pett;
    }

    public String formatPet() {
        String pett;
        StringBuilder sb = new StringBuilder();
        for (Pet pet1 : pet) {
            sb.append(pet1.getSpecies()).append("#").append(pet1.getNickname()).append("#").append(pet1.getAge()).append("#")
                    .append(pet1.getTrickLevel()).append("#").append(pet1.getHabits());
        }
        pett = sb.toString();
        return pett;
    }

    public String showFam() {
        return String.format("%s@%s@%s@%s",woman.humanForFile(),man.humanForFile(),children,formatPet());
    }

}
