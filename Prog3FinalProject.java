import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class project4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // cases for the menu
        while (true) {
            System.out.println("Menu of Searching and Sorting Testbed.");
            System.out.println();
            printMenu();

            String input = scanner.nextLine();

            if (input.length() == 1) {
                char choice = input.charAt(0);

                switch (choice) {
                    case '1':
                        linearSearch(scanner);
                        System.out.println();
                        break;
                    case '2':
                        binarySearchMenu(scanner);
                        System.out.println();
                        break;
                    case '3':
                        insertionSortMenu();
                        System.out.println();
                        break;
                    case '4':
                        quicksortMenu();
                        System.out.println();
                        break;
                    case 'q':
                    case 'Q':
                        System.out.println("Exiting the program. Goodbye!");
                        System.exit(0);
                    default:
                        System.out.println("Choice " + choice + " not implemented");
                        System.out.println();
                        break;
                }
            } else {
                System.out.println("Choice " + input + " not implemented");
                System.out.println();
            }
        }
    }

    // menu
    private static void printMenu() {
        System.out.println("1) Linear Searching");
        System.out.println("2) Binary Searching");
        System.out.println("3) (O(n^2)) type of sorting");
        System.out.println("4) (O(n*log(n))) type of sorting");
        System.out.println("5) Sorting performance");
        System.out.println();
        System.out.println("q/Q) Quit");
        System.out.println();
        System.out.print("Your choice: ");
    }

    // linear search
    private static void linearSearch(Scanner scanner) {
        int[] values = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.print("In the list are values 0, ... 9; which value would you like to search with linear search? ");
        int searchValue = scanner.nextInt();
        scanner.nextLine();

        if (linearSearchValue(values, searchValue)) {
            System.out.println("\nFound");
            System.out.println();
        } else {
            System.out.println("\nNot found");
            System.out.println();
        }
    }

    private static boolean linearSearchValue(int[] values, int target) {
        for (int value : values) {
            if (value == target) {
                return true;
            }
        }
        return false;
    }

    // binary search
    private static void binarySearchMenu(Scanner scanner) {
        int[] values = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.print("In the list are values 0, ... 9; which value would you like to search with binary search? ");
        int searchValue = scanner.nextInt();
        scanner.nextLine();

        if (binarySearchValueInternal(values, searchValue)) {
            System.out.println("\nFound");
        } else {
            System.out.println("\nNot found");
        }
    }

    private static boolean binarySearchValueInternal(int[] values, int target) {
        int left = 0;
        int right = values.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (values[mid] == target) {
                return true;
            } else if (values[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }

    // O(n^2) sorting
    private static void insertionSortMenu() {
        int arraySize = 10;
        int[] values = generateRandomArray(arraySize);

        System.out.println("Data set before insertion sorting: " + Arrays.toString(values));

        insertionSort(values);

        System.out.println("Data set after insertion sorting: " + Arrays.toString(values));
    }

    private static int[] generateRandomArray(int arraySize) {
        Random random = new Random();
        int[] randomArray = new int[arraySize];

        for (int i = 0; i < arraySize; i++) {
            randomArray[i] = random.nextInt(201) - 100;
        }

        return randomArray;
    }

    private static void insertionSort(int[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    // O(n*log(n)) sorting
    private static void quicksortMenu() {
        int arraySize = 10;
        int[] values = generateRandomArray(arraySize);

        System.out.println("Data set before quicksorting:");
        System.out.println(Arrays.toString(values));
        quickSort(values);
        System.out.println("Data set after quicksorting:");
        System.out.println(Arrays.toString(values));
    }

    private static void quickSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        int mid = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);

        quickSort(left);
        quickSort(right);

        merge(arr, left, right);
    }

    private static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

        while (i < left.length) {
            arr[k++] = left[i++];
        }

        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }
}
