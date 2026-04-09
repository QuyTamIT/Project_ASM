import java.util.List;

public class Sort {
    public static void bubbleSort(List<Student> list, int criteria) {
        int n = list.size();
        boolean swapped ;
        for (int i =0; i < n-1; i++) {
            swapped = false;
            for (int j = 0; j< n-i-1; j++){
                if (criteria == 1 ) {
                    if(list.get(j).getMarks() > list.get(j + 1).getMarks()){
                        Student temp = list.get(j);
                        list.set(j, list.get(j + 1));
                        list.set(j + 1, temp);
                        swapped = true;
                    }
                }
                else if (criteria == 2) {
                    if (list.get(j).getMarks() < list.get(j + 1).getMarks()){
                        Student temp = list.get(j);
                        list.set(j, list.get(j + 1));
                        list.set(j + 1, temp);
                        swapped = true;
                    }
                }
            }
            if (!swapped) {
                break;
            }
        }
    }
    public static void insertionSort(List<Student> list, int criteria) {
        int n = list.size();

        for (int i = 1; i < n; i++) {
            Student key = list.get(i);
            int j = i - 1;

            if (criteria == 1) {
                while (j >= 0 && list.get(j).getMarks() > key.getMarks()) {
                    list.set(j + 1, list.get(j));
                    j--;
                }
            } else if (criteria == 2) {
                while (j >= 0 && list.get(j).getMarks() < key.getMarks()) {
                    list.set(j + 1, list.get(j));
                    j--;
                }
            }

            list.set(j + 1, key);
        }
    }

    public static void quickSort(List<Student> list, int criteria) {
        quickSortHelper(list, 0, list.size() - 1, criteria);
    }
    private static void quickSortHelper(List<Student> list, int low, int high, int criteria) {
        if (low < high) {
            int pi = partition(list, low, high, criteria);

            quickSortHelper(list, low, pi - 1, criteria);
            quickSortHelper(list, pi + 1, high, criteria);
        }
    }
    private static int partition(List<Student> list, int low, int high, int criteria) {
        Student pivot = list.get(high);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            boolean condition;

            if (criteria == 1) {
                condition = list.get(j).getMarks() < pivot.getMarks();
            } else {
                condition = list.get(j).getMarks() > pivot.getMarks();
            }

            if (condition) {
                i++;
                swap(list, i, j);
            }
        }
        swap(list, i + 1, high);
        return i + 1;
    }

    public static void mergeSort(List<Student> list, int criteria) {
        if (list.size() <= 1) {
            return;
        }
        int mid = list.size() / 2;

        List<Student> left = new java.util.ArrayList<>(list.subList(0, mid));
        List<Student> right = new java.util.ArrayList<>(list.subList(mid, list.size()));

        mergeSort(left, criteria);
        mergeSort(right, criteria);
        merge(list, left, right, criteria);
    }

    private static void merge(List<Student> list, List<Student> left, List<Student> right, int criteria) {
        int i = 0, j = 0, k = 0;

        while (i < left.size() && j < right.size()) {
            boolean condition;

            if (criteria == 1) {
                condition = left.get(i).getMarks() <= right.get(j).getMarks();
            } else {
                condition = left.get(i).getMarks() >= right.get(j).getMarks();
            }

            if (condition) {
                list.set(k++, left.get(i++));
            } else {
                list.set(k++, right.get(j++));
            }
        }

        while (i < left.size()) {
            list.set(k++, left.get(i++));
        }

        while (j < right.size()) {
            list.set(k++, right.get(j++));
        }
    }

    public static void heapSort(List<Student> list, int criteria) {
        int n = list.size();

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(list, n, i, criteria);
        }

        for (int i = n - 1; i > 0; i--) {
            swap(list, 0, i);
            heapify(list, i, 0, criteria);
        }
    }

    private static void heapify(List<Student> list, int n, int i, int criteria) {
        int extreme = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (criteria == 1) {
            if (left < n && list.get(left).getMarks() > list.get(extreme).getMarks()) {
                extreme = left;
            }

            if (right < n && list.get(right).getMarks() > list.get(extreme).getMarks()) {
                extreme = right;
            }
        } else if (criteria == 2) {
            if (left < n && list.get(left).getMarks() < list.get(extreme).getMarks()) {
                extreme = left;
            }

            if (right < n && list.get(right).getMarks() < list.get(extreme).getMarks()) {
                extreme = right;
            }
        }

        if (extreme != i) {
            swap(list, i, extreme);
            heapify(list, n, extreme, criteria);
        }
    }

    private static void swap(List<Student> list, int i, int j) {
        Student temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}
