package hw13.service;

import hw13.dao.CollectionFamilyDao;
import hw13.dao.FamilyDao;
import hw13.entities.*;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class FamilyService {
    public CollectionFamilyDao colDao = new CollectionFamilyDao();
    List<Family> fam = colDao.getAllFamilies();

    public List<Family> getAllFamilies() {
        return fam;
    }

    public StringBuffer displayAllFamilies() {
        StringBuffer s = new StringBuffer();
        colDao.getAllFamilies().forEach(fam -> {
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
        Human child = new Human(childName, family.getMan().getSurname(),"10/10/2000",56);
        family.addChild(child);
        return family;
    }

    public Family adoptChild(Family family, Human child) {
        if (child != null)
            child.setSurname(family.getMan().getSurname());
        if (family != null)
            family.addChild(child);
        colDao.saveFamily(family);
        return family;
    }

    public void deleteAllChildrenOlderThen(int age) {
        fam.forEach(f -> {
            int year = LocalDate.now().getYear();
            f.getChildren().removeIf(c -> age < (year -
                    Instant.ofEpochMilli(c.getBirthDate()).atZone(ZoneId.systemDefault()).toLocalDate().getYear()));
            colDao.saveFamily(f);
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
        colDao.saveFamily(fam.get(index));
    }

    public String prettyFormat() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < fam.size(); i++)
            sb.append("family[").append(i+1).append("]:\n").append(fam.get(i).prettyFormat()).append("\n\n");
        return sb.toString();
    }

    public Family getFamilyByIndex(int index) {
        return colDao.getFamilyByIndex(index);
    }

    public boolean deleteFamily(int index) {
        return colDao.deleteFamily(index);
    }

    public boolean deleteFamily(Family fam) {
        return colDao.deleteFamily(fam);
    }

    public void saveFamily(Family fam) {
        colDao.saveFamily(fam);
    }

    public void loadData() {
        colDao.loadData();
    }

    public void getData() {
        colDao.getData();
    }
}
