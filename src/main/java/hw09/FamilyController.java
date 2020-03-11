package hw09;

import java.util.HashSet;
import java.util.List;

public class FamilyController {
    FamilyService famServ = new FamilyService();

    public List<Family> getAllFamilies() {
        return famServ.getAllFamilies();
    }

    public StringBuffer displayAllFamilies() {
        return famServ.displayAllFamilies();
    }

    public List<Family> getFamiliesBiggerThan(int numMore) {
        return famServ.getFamiliesBiggerThan(numMore);
    }

    public List<Family> getFamiliesLessThan(int numLess) {
        return famServ.getFamiliesLessThan(numLess);
    }

    public int countFamiliesWithMemberNumber(int num) {
        return famServ.countFamiliesWithMemberNumber(num);
    }

    public void createNewFamily(Woman m, Man f) {
        famServ.createNewFamily(m, f);
    }

    public Family bornChild(Family f, String fem, String masc) {
        return famServ.bornChild(f, fem, masc);
    }

    public Family adoptChild(Family family, Human child) {
        return famServ.adoptChild(family, child);
    }

    public void deleteAllChildrenOlderThen(int age) {
        famServ.deleteAllChildrenOlderThen(age);
    }

    public int count() {
        return famServ.count();
    }

    public Family getFamilyById(int index) {
        return famServ.getFamilyById(index);
    }

    public HashSet<Pet> getPets(int index) {
        return famServ.getPets(index);
    }

    public void addPet(int index, Pet p) {
        famServ.addPet(index, p);
    }

}
