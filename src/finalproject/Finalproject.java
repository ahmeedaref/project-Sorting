package finalproject;

import java.util.Scanner;

public class Finalproject {

    public void printarray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + " ");
        }

    }

    public void sort(int[] arr, int[] temp, int low, int high) {
        if (low < high) {//base case
            int mid = low + (high - low) / 2;
            sort(arr, temp, low, mid);
            sort(arr, temp, mid + 1, high);
            merge(arr, temp, low, mid, high);
        }
    }

    private void merge(int[] arr, int[] temp, int low, int mid, int high) {
        for (int i = low; i <= high; i++) {
            temp[i] = arr[i];
        }
        int i = low;
        int j = mid + 1;
        int k = low;

        while (i <= mid && j <= high) {
            if (temp[i] < temp[j]) {
                arr[k] = temp[i];
                i++;
            } else {
                arr[k] = temp[j];
                j++;
            }
            k++;
        }
        while (i <= mid) {
            arr[k] = temp[i];
            k++;
            i++;
        }
    }

    public static int divide(int[] arr, int n, int r) {

        int pivot = arr[r];
        int i = n - 1;
        for (int j = n; j < r; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[r];
        arr[r] = temp;

        return i + 1;
    }

    public static void quick(int[] arr, int left, int right) {
        if (left < right) {
            int x = divide(arr, left, right);
            quick(arr, left, x - 1);
            quick(arr, x + 1, right);
        }
    }

    public int[] compare(int[] arr1, int[] arr2, int n) {

        int[] result = new int[n];
        n = arr1.length;

        int i = 0, j = 0, k = 0;
        while (i < n) {

            if (arr1[i] <= arr2[j]) {
                result[k] = arr1[i];
                i++;
                j++;
            } else {
                result[k] = arr2[j];
                j++;
                i++;
            }
            k++;
        }

        return result;
    }

    public static void binarysearch(int[] result, int[] arr1, int[] arr2) {

        int key;
        int beg = 0;
        int end = result.length - 1;
        int mid = (beg + end) / 2;

        System.out.println("enter the key to search");
        Scanner n = new Scanner(System.in);
        key = n.nextInt();

        while (beg <= end) {

            if (key == result[mid]) {
                System.out.println("the item found at index : " + mid);
                if (key == arr1[mid])//if key at arr1 
                {
                    System.out.println("at array 1");
                } else {//if key at arr2 
                    System.out.println("at array 2 ");
                }
                break;
            }
            if (key < result[mid]) {
                end = mid - 1;
            } else {
                beg = mid + 1;
            }
            mid = (beg + end) / 2;

        }
        if (beg > end) {
            System.out.println("item not found");
        }
    }

    public static void main(String[] args) {
        Finalproject f = new Finalproject();

        int arr_size;

        Scanner s = new Scanner(System.in);
        System.out.println("enter size of arrays ");
        arr_size = s.nextInt();

        int[] arr1 = new int[arr_size];

        System.out.println("enter elements to be sorted in megrge");

        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = s.nextInt();
        }
        f.sort(arr1, new int[arr1.length], 0, arr1.length - 1);
        System.out.println("after sorting\n");
        f.printarray(arr1);

        //array 2 for quicksort
        int[] arr2 = new int[arr_size];

        System.out.println("enter elements to be sorted in quicksort");
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = s.nextInt();
        }

        f.quick(arr2, 0, arr2.length - 1);
        System.out.println("after sorting\n");
        f.printarray(arr2);

        int[] result = f.compare(arr1, arr2, arr1.length);
        System.out.println("after comparing\n");
        f.printarray(result);
        f.binarysearch(result, arr1, arr2);

    }

}
