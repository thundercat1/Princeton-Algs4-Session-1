
public class SortHelper {

    public static <Type extends Comparable<Type>> boolean less(Type a, Type b) {
        return a.compareTo(b) < 0;
    }

    public static <Type extends Comparable<Type>> boolean isSorted(Type[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (less(arr[i], arr[i-1])) return false;
        }
        return true;
    }
}
