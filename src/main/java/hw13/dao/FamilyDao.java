package hw13.dao;


import hw13.entities.Family;

import java.util.List;

public interface FamilyDao {
    List<Family> getAllFamilies();
    Family getFamilyByIndex(int index);
    boolean deleteFamily(int index);
    boolean deleteFamily(Family fam);
    void saveFamily(Family fam);
}
