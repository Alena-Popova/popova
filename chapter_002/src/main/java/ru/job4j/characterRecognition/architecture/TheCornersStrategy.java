package popova.characterRecognition.architecture;

import java.util.ArrayList;
import java.util.List;

public class TheCornersStrategy {
    private List<DataJPG> images = new ArrayList<>();

    public TheCornersStrategy(List<DataJPG> images) {
        this.images = images;
    }

    /**
     * Находит вектор с которым newJPG имеет наименьший угол
     * @param newJPG
     * @return
     */
    public int getMinNeighborbyCos(DataJPG newJPG) {
        DataJPG minJPG = this.images.get(0);
        for(int index = 1; index < this.images.size();index++) {
            if (this.images.get(index).getCos(newJPG) < minJPG.getCos(newJPG)) {
                minJPG = this.images.get(index);
            }
        }
        return minJPG.getLable();
    }



}
