package hw12.dao;

import hw12.entities.Family;

import java.util.List;

public interface FamilyDao {
    List<Family> getAllFamilies();
    Family getFamilyByIndex(int index);
    boolean deleteFamily(int index);
    boolean deleteFamily(Family fam);
    void saveFamily(Family fam);
}
