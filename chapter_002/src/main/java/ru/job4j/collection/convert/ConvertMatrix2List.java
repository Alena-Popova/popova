package popova.collection.convert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ConvertMatrix2List {

    public List<Integer> toList(int[][] array) {
        List<Integer> result = new ArrayList<>();
        if ( array.length != 0) {
            for (int i = 0; i < array.length; i++)
                 result.addAll(Arrays.stream(array[i]).boxed().collect(Collectors.toList()));
        } else {
            throw new UnsupportedOperation("Неподдерживаемая операция!");
        }
        return result;
    }

    public List<Integer> convert (List<int[]> list) {
        List<Integer> result = new ArrayList<>();
        for (int[] mass : list) {
            result.addAll(Arrays.stream(mass).boxed().collect(Collectors.toList()));
        }
        return result;
    }

    //внутренний и внешний foreach
    public List<Integer> toListByForeach(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int[] mass : array) {
            for (int i = 0; i < mass.length; i++) {
                list.add(mass[i]);
            }
        }
        return list;
    }

    public List<Integer> toListbyForeach(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int[] mass : array) {
            for (int step : mass) {
                list.add(mass[step]);
            }
        }
        return list;
    }
}
