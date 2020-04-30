package map.model;

import java.util.Comparator;

public class DataComparator implements Comparator<AD> {
    @Override
    public int compare(AD ad1, AD ad2) {
        return ad1.getDate().compareTo(ad2.getDate());
    }
}
