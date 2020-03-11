package hw11;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class FamilyService {
    FamilyDao famDao = new CollectionFamilyDao();
    List<Family> fam = famDao.getAllFamilies();

    public List<Family> getAllFamilies() {
        return fam;
    }

    public StringBuffer displayAllFamilies() {
        StringBuffer s = new StringBuffer();
        famDao.getAllFamilies().forEach(fam -> {
            s.append(fam);
            s.append("\n");
        });
        return s;
    }

    public List<Family> getFamiliesBiggerThan(int numMore) {
        List<Family> more = fam.stream().filter(f -> f.countFamily() > numMore).collect(Collectors.toList());
        return more;
    }

    public List<Family> getFamiliesLessThan(int numLess) {
        List<Family> less = fam.stream().filter(f -> f.countFamily() < numLess).collect(Collectors.toList());
        return less;
    }

    public int countFamiliesWithMemberNumber(int num) {
        int countt = (int) fam.stream().filter(f -> f.countFamily() == num).count();
        return countt;
    }

    public void createNewFamily(Woman mother, Man father) {
        List<Human> children = new ArrayList<>();
        HashSet<Pet> pets = new HashSet<>();
        Family family = new Family(mother, father, children);
        family.setPet(pets);
        fam.add(family);
    }

    public Family bornChild(Family family, String fem, String masc) {
        int rand = (int) (Math.random() * 2);
        String childName;
        if (rand == 0) childName = fem;
        else childName = masc;
        Human child = new Human();
        family.addChild(child);
        child.setName(childName);
        child.setSurname(family.getMan().getSurname());
        return family;
    }

    public Family adoptChild(Family family, Human child) {
        if (child != null)
            child.setSurname(family.getMan().getSurname());
        if (family != null)
            family.addChild(child);
        famDao.saveFamily(family);
        return family;
    }

    public void deleteAllChildrenOlderThen(int age) {
        fam.forEach(f -> {
            int year = LocalDate.now().getYear();
            f.getChildren().removeIf(c -> age < (year - c.getBirthDate()));
            famDao.saveFamily(f);
        });
    }

    public int count(){
        return fam.size();
    }

    public Family getFamilyById(int index) {
        return fam.get(index);
    }

    public HashSet<Pet> getPets(int index) {
        return fam.get(index).getPet();
    }

    public void addPet(int index, Pet p) {
        fam.get(index).getPet().add(p);
        famDao.saveFamily(fam.get(index));
    }

}
