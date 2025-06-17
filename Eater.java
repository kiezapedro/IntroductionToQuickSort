import java.util.Scanner;

public class Eater {

    static class Apple {
        int x, y, index;

        Apple(int x, int y, int index) {
            this.x = x;
            this.y = y;
            this.index = index;
        }
    }

    static void quickSort(Apple[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    static int partition(Apple[] arr, int low, int high) {
        Apple pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j].x < pivot.x || (arr[j].x == pivot.x && arr[j].y < pivot.y)) {
                i++;
                Apple temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        Apple temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.print("Enter the number of apples: ");
        int N = scn.nextInt();
        Apple[] apples = new Apple[N];

        System.out.println("Enter the coordinates of each apple (x y):");
        for (int i = 0; i < N; i++) {
            System.out.print("Apple " + (i + 1) + ": ");
            int x = scn.nextInt();
            int y = scn.nextInt();
            apples[i] = new Apple(x, y, i);
        }

        // Sort apples by row (x), then column (y)
        quickSort(apples, 0, N - 1);

        int[] result = new int[N];
        int count = 0;

        for (int i = 0; i < N;) {
            int currentRow = apples[i].x;
            int j = i;

            while (j < N && apples[j].x == currentRow) {
                j++;
            }

            for (int k = i; k < j; k++) {
                result[apples[k].index] = count++;
            }

            i = j;
        }

        System.out.println("Number of apples eaten before each apple: ");
        for (int i = 0; i < N; i++) {
            System.out.println("Apple " + (i + 1) + ": " + result[i]);
        }
    }
}