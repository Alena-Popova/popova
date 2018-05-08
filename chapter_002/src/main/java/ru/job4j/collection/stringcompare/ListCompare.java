package popova.collection.stringcompare;

import java.util.Comparator;

import static java.lang.reflect.Array.getChar;

public class ListCompare implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        char[] value = o1.toCharArray();
        char[] other = o2.toCharArray();
        int len1 = value.length;
        int len2 = other.length;

        int lim = Math.min(len1, len2);
        for (int k = 0; k < lim; k++) {
            if (value[k] != other[k]) {
                return getChar(value, k) - getChar(other, k);
            }
        }
        return len1 - len2;
    }
}
