import java.util.*;
import java.time.*;

/**
 * bubblesort
 */
public class bubblesort {

    public int n;
    public int[] a;
    Instant start, end;

    void enter() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\n\n  Enter the number of elements : ");
        n = sc.nextInt();
        a = new int[n];
        System.out.print("\n\n  Enter the element : ");
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        System.out.print("\n\n  Element added succesfully  ");

    }

    void Time() {
        long dur = Duration.between(start, end).toNanos();
        System.out.println("\n  Duration : " + dur / 1000);
    }

    void bubble(int size, int[] arr) {
        start = Instant.now();
        int temp;
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
        end = Instant.now();
    }

    void print(int arr[]) {

        System.out.print("\n  Sorted array : ");
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");

    }
}