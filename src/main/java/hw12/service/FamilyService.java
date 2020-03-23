package hw12.service;

import hw12.entities.Family;
import hw12.entities.Human;
import hw12.dao.CollectionFamilyDao;
import hw12.dao.FamilyDao;
import hw12.entities.Man;
import hw12.entities.Pet;
import hw12.entities.Woman;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class FamilyService {
    public FamilyDao famDao = new CollectionFamilyDao();
    List<Family> fam = famDao.getAllFamilies();

    public List<Family> getAllFamilies() {
        return fam;
    }

    public StringBuffer displayAllFamilies() {
        StringBuffer s = new StringBuffer();
        famDao.getAllFamilies().forEach(fam -> {
            s.append(fam.prettyFormat());
            s.append("\n");
        });
        return s;
    }

    public List<Family> getFamiliesBiggerThan(int numMore) {
        return fam.stream().filter(f -> f.countFamily() > numMore).collect(Collectors.toList());
    }

    public List<Family> getFamiliesLessThan(int numLess) {
        return fam.stream().filter(f -> f.countFamily() < numLess).collect(Collectors.toList());
    }

    public int countFamiliesWithMemberNumber(int num) {
        return (int) fam.stream().filter(f -> f.countFamily() == num).count();
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
        Family currentFam = fam.get(fam.indexOf(family));
        currentFam.addChild(child);
        famDao.saveFamily(family);
        return family;
    }

    public void deleteAllChildrenOlderThen(int age) {
        fam.forEach(f -> {
            int year = LocalDate.now().getYear();
            f.getChildren().removeIf(c -> age < (year -
                    Instant.ofEpochMilli(c.getBirthDate()).atZone(ZoneId.systemDefault()).toLocalDate().getYear()));
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

    public String prettyFormat() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < fam.size(); i++)
            sb.append("family[").append(i+1).append("]:\n").append(fam.get(i).prettyFormat()).append("\n\n");
        return sb.toString();
    }

    public Family getFamilyByIndex(int index) {
        return famDao.getFamilyByIndex(index);
    }

    public boolean deleteFamily(int index) {
        return famDao.deleteFamily(index);
    }

    public boolean deleteFamily(Family fam) {
        return famDao.deleteFamily(fam);
    }

    public void saveFamily(Family fam) {
        famDao.saveFamily(fam);
    }
}
