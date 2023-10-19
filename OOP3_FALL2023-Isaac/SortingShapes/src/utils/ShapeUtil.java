package utils;
import shapes.*;
import java.util.PriorityQueue;
import java.util.Comparator;

public class ShapeUtil {

    public static void bubbleSort(Shape[] arr, Comparator<Shape> comparator) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                int comparison = comparator != null ? comparator.compare(arr[j], arr[j + 1]) : arr[j].compareTo(arr[j+1]);
                if (comparison > 0) {
                    Shape temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    public static void insertionSort(Shape[] arr, Comparator<Shape> comparator) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            Shape key = arr[i];
            int j = i - 1;
            while (j >= 0) {
                int comparison = comparator != null ? comparator.compare(arr[j], key) : arr[j].compareTo(key);
                if (comparison > 0) {
                    arr[j + 1] = arr[j];
                    j = j - 1;
                } else {
                    break;
                }
            }
            arr[j + 1] = key;
        }
    }

    public static void selectionSort(Shape[] arr, Comparator<Shape> comparator) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            int minIdx = i;
            for (int j = i+1; j < n; j++) {
                int comparison = comparator != null ? comparator.compare(arr[j], arr[minIdx]) : arr[j].compareTo(arr[minIdx]);
                if (comparison < 0) {
                    minIdx = j;
                }
            }
            Shape temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
    }

    public static void mergeSort(Shape[] arr, Comparator<Shape> comparator) {
        int n = arr.length;
        if (n < 2) return;
        int mid = n / 2;
        Shape[] l = new Shape[mid];
        Shape[] r = new Shape[n - mid];

        System.arraycopy(arr, 0, l, 0, mid);
        System.arraycopy(arr, mid, r, 0, n - mid);

        mergeSort(l, comparator);
        mergeSort(r, comparator);
        merge(arr, l, r, comparator);
    }
    
    private static void merge(Shape[] arr, Shape[] l, Shape[] r, Comparator<Shape> comparator) {
        int i = 0, j = 0, k = 0;
        while (i < l.length && j < r.length) {
            int comparison = comparator != null ? comparator.compare(l[i], r[j]) : l[i].compareTo(r[j]);
            if (comparison <= 0) {
                arr[k++] = l[i++];
            } else {
                arr[k++] = r[j++];
            }
        }
        while (i < l.length) {
            arr[k++] = l[i++];
        }
        while (j < r.length) {
            arr[k++] = r[j++];
        }
    }
    public static void quickSort(Shape[] arr, Comparator<Shape> comparator) {
        quickSort(arr, 0, arr.length - 1, comparator);
    }

    private static void quickSort(Shape[] arr, int low, int high, Comparator<Shape> comparator) {
        if (low < high) {
            int pi = partition(arr, low, high, comparator);
            quickSort(arr, low, pi - 1, comparator);
            quickSort(arr, pi + 1, high, comparator);
        }
    }

    private static int partition(Shape[] arr, int low, int high, Comparator<Shape> comparator) {
        Shape pivot = arr[high];
        int i = low;
        for (int j = low; j < high; j++) {
            int comparison = comparator != null ? comparator.compare(arr[j], pivot) : arr[j].compareTo(pivot);
            if (comparison < 0) {
                Shape temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
        }
        Shape temp = arr[i];
        arr[i] = arr[high];
        arr[high] = temp;
        return i;
    }

    public static void heapSort(Shape[] arr, Comparator<Shape> comparator) {
        PriorityQueue<Shape> heap = new PriorityQueue<>(comparator);
        for (Shape shape : arr) {
            heap.add(shape);
        }

        int i = 0;
        while (!heap.isEmpty()) {
            arr[i++] = heap.poll();
        }
    }
}
