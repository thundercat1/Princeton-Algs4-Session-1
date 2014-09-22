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
        StdOut.println(String.valueOf(n/1000) + "k calls to SelectionSort");
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
    }

    public static <Type extends Comparable<Type>> void insertionSortForLoop(Type[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (SortHelper.less(arr[j], arr[j-1])) {
                    SortHelper.exchange(arr, j, j-1);
                }
                else break;
            }
        }
    }

    public static <Type extends Comparable<Type>> void shellSort(Type[] arr) {
        int N = arr.length;
        int h = 1;
        while (h < N/3) h = 3*h + 1;
        int n = 0;
        while (h >= 1) {
            for (int k = h; k < N; k++) {
                int j = k;
                while (j >= h && SortHelper.less(arr[j], arr[j-h])) {
                    SortHelper.exchange(arr, j, j-h);
                    j-= h;
                    n++;
                }
            }
        h = h/3;
        }
    }

}