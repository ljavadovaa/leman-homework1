package hw09;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class FamilyService {
    FamilyDao famDao = new CollectionFamilyDao();
    List<Family> fam = famDao.getAllFamilies();

    public List<Family> getAllFamilies() {
        return fam;
    }

    public StringBuffer displayAllFamilies() {
        StringBuffer s = new StringBuffer();
        for (Family fam :famDao.getAllFamilies()){
            s.append(fam);
            s.append("\n");
        }
        return s;
    }

    public List<Family> getFamiliesBiggerThan(int numMore) {
        List<Family> more = new ArrayList<>();
        for (Family f : fam)
            if (f.countFamily() > numMore)
                more.add(f);
        return more;
    }

    public List<Family> getFamiliesLessThan(int numLess) {
        List<Family> less = new ArrayList<>();
        for (Family f : fam)
            if (f.countFamily() < numLess)
                less.add(f);
        return less;
    }

    public int countFamiliesWithMemberNumber(int num) {
        int countt = 0;
        for (Family f : fam) {
            if (f.countFamily() == num)
                countt++;
        }
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
        child.setName(childName);
        child.setSurname(family.getMan().getSurname());
        family.addChild(child);
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
        for (Family f : fam) {
            int year = LocalDate.now().getYear();
            f.getChildren().removeIf(c -> age < (year-c.getYear()));
        }
    }

    public int count(){
        return fam.size();
    }

    public Family getFamilyById(int index) {
        return famDao.getFamilyByIndex(index);
    }

    public HashSet<Pet> getPets(int index) {
        return fam.get(index).getPet();
    }

    public void addPet(int index, Pet p) {
        fam.get(index).getPet().add(p);
        famDao.saveFamily(fam.get(index));
    }

}
