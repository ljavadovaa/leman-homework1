package hw13.dao;

import hw13.entities.Family;
import hw13.entities.*;

import java.io.*;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CollectionFamilyDao implements FamilyDao {
    List<Family> fam = new ArrayList<>();

    @Override
    public List<Family> getAllFamilies() {
        return fam;
    }

    @Override
    public Family getFamilyByIndex(int index) {
        return fam.get(index);
    }

    @Override
    public boolean deleteFamily(int index) {
        if (index < 0 || index > fam.size())  return false;
        fam.remove(index); return true;
    }

    @Override
    public boolean deleteFamily(Family family) {
        fam.remove(family);
        return true;
    }

    @Override
    public void saveFamily(Family family) {
        if (fam.contains(family)) {
            Family family1  = family;
        } else
            fam.add(family);
    }

    public void loadData() {
        File file = new File("src/main/java/hw13/database/famData.txt");
        try {
            new BufferedReader(new FileReader(file)).lines().collect(Collectors.toList());
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            for (Family family : fam) {
                bw.write(family.showFam());
                bw.write("\n");
            }
            bw.close();
        } catch (IOException e) {
            System.out.printf("File: '%s' not found!\n", file);
            try {
                BufferedWriter bw = new BufferedWriter(new FileWriter(file));
                for (Family family : fam) {
                    bw.write(family.showFam());
                    bw.write("\n");
                }
                bw.close();
            } catch (Exception e1) {
                System.out.println("Error");
            }
        }
    }

    public void getData() {
        File file = new File("src/main/java/hw13/database/famData.txt");
        List<Family> familyArrayList = new ArrayList<>();

        if(fam.size()==0) {
            try {
                List<String> lines = new BufferedReader(new FileReader(file)).lines().collect(Collectors.toList());
                lines.stream().map(line -> line.split("@")).forEach(splitted -> {
                    String[] mother = splitted[0].split("-");

                    long birthLongMom = Long.parseLong(mother[2]);
                    LocalDate date = Instant.ofEpochMilli(birthLongMom).atZone(ZoneId.systemDefault()).toLocalDate();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    String formattedBirthDateMom = date.format(formatter);

                    Woman woman = new Woman(mother[0], mother[1], formattedBirthDateMom, Integer.parseInt(mother[3]));

                    String[] father = splitted[1].split("-");

                    long birthLongDad = Long.parseLong(father[2]);
                    LocalDate date2 = Instant.ofEpochMilli(birthLongDad).atZone(ZoneId.systemDefault()).toLocalDate();
                    String formattedBirthDateDad = date2.format(formatter);

                    Man man = new Man(father[0], father[1], formattedBirthDateDad, Integer.parseInt(father[3]));

                    String[] children = splitted[2].split(",");
                    String[] pets = splitted[3].split("&");

                    ArrayList<Human> childrenList = new ArrayList<>();
                    HashSet<Pet> petSet = new HashSet<>();

                    for (String childData : children) {
                        String[] c1 = childData.split("-");
                        String name = c1[0].replaceAll("\\[", "").trim();
                        String surname = c1[1];
                        String birthDate = c1[2];
                        String iq = c1[3].replaceAll("]", "");

                        long birthLong = Long.parseLong(birthDate);
                        LocalDate date3 = Instant.ofEpochMilli(birthLong).atZone(ZoneId.systemDefault()).toLocalDate();
                        String formattedBirthDate = date3.format(formatter);

                        childrenList.add(new Human(name, surname, formattedBirthDate, Integer.parseInt(iq)));
                    }

                    for (String petData : pets) {
                        String[] p1 = petData.split("#");
                        String name = p1[1];
                        String age = p1[2];
                        String trickLevel = p1[3];
                        String habits = p1[4].replaceAll(";\\[", "").replaceAll("]", "");

                        String[] habitArray = habits.split(", ");

                        Set<String> habitSet = new HashSet<>();
                        for (String h : habitArray) habitSet.add(h);

                        petSet.add(new Dog(name, Integer.parseInt(age), Integer.parseInt(trickLevel), habitSet));

                    }
                    familyArrayList.add(new Family(woman, man, childrenList, petSet));
                });
                fam.addAll(familyArrayList);

            } catch (IOException e) {
                System.out.printf(" Database fileeeeeeeeee: '%s' not found! \n", file);
            }
        }



    }
}
