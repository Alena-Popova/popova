package popova.collection.convert;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ConvertList2Array {

    public int[][] toArray(List<Integer> list, int rows) {
        int cells = (int)Math.ceil(list.size()/(double)rows);
        int[][] result = new int[rows][cells];
        if(list.size() > 0 && list.size() >= rows) {
            for (int i = 0; i < rows; i++) {
                result[i] = i * cells + cells <= list.size() ?
                        Arrays.copyOf(list.subList(i* cells, i * cells + cells).stream().mapToInt(Integer::intValue).toArray(),rows) :
                        Arrays.copyOf(list.subList(i*cells, list.size()).stream().mapToInt(Integer::intValue).toArray(),rows);
            }
        } else {
            throw new UnsupportedOperation("Неподдерживаемая операция!");
        }
        return result;
    }

}
