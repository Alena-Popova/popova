package popova.characterRecognition;

import java.util.*;

public class SamplePatern {
    private List<DataJPG> images;

    public SamplePatern(List<DataJPG> images) {
        this.images = images;
    }

    public  Comparator<DataJPG> setComparatorByLenght() {
            Comparator<DataJPG> comparatorByLenght = new Comparator<DataJPG>() {
                public int compare(DataJPG o1, DataJPG o2) {
                    return Double.compare(o1.getLenght(), o2.getLenght()); }
            };
        return comparatorByLenght;
    }

    public  Comparator<DataJPG> setComparatorByDifference(DataJPG newJPG) {
        Comparator<DataJPG> difference = new Comparator<DataJPG>() {
            public int compare(DataJPG o1, DataJPG o2) {
                return Double.compare(o1.getDifference(newJPG), o2.getDifference(newJPG)); }
        };
        return difference;
    }

    public void findNearestNeighbors(Comparator<DataJPG> comparator) {
        Collections.sort(this.images, comparator);
    }
}
