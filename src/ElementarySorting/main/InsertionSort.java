public class InsertionSort{

    public static <Type extends Comparable<Type>> void selectionSort(Type[] arr) {
        int n = 0;
        for (int i = 0; i < arr.length; i++) {
            int smallest = i;
            for (int j = i; j < arr.length; j++) {
                n++;
                if (SortHelper.less(arr[j], arr[smallest])) smallest = j;
            }
            SortHelper.exchange(arr, i, smallest);
        }
        StdOut.println(String.valueOf(n/1000) + "k calls to .less");
    }

    public static <Type extends Comparable<Type>> void insertionSort(Type[] arr) {
        int n = 0;
        for (int i = 0; i < arr.length; i++) {
            int j = i;
            while (j > 0 && SortHelper.less(arr[j], arr[j-1])) {
                n++;
                SortHelper.exchange(arr, j, j-1);
                j--;
            }
        }
        StdOut.println(String.valueOf(n/1000) + "k calls to .less");
    }

}