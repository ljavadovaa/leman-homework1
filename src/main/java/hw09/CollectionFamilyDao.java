package hw09;

import java.util.ArrayList;
import java.util.List;

public class CollectionFamilyDao implements FamilyDao{
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
        fam.remove(fam.get(fam.indexOf(family)));
        return true;
    }

    @Override
    public void saveFamily(Family family) {
        if (fam.contains(family)) {
            Family family1 = fam.get(fam.indexOf(family));
            family1 = family;
        } else
            fam.add(family);
    }
}
