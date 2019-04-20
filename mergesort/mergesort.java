import java.util.*;
import java.time.*;

class mergesort {
    int b;
    int[] a;
    Random random;

    Instant start, end;

    mergesort() {
        random = new Random();
        a = new int[1000];
        b = 1000;
    }

    void fillrandom() {

        for (int i = 0; i < b; i++)
            a[i] = random.nextInt(9000) + 999;
    }

    void fillasc() {
        for (int i = 0; i < b; i++)
            a[i] = i;
    }

    void filldsc() {
        for (int i = 0, j = b; i < b; i++, j--)
            a[i] = j;
    }

    long Time() {
        long dur = Duration.between(start, end).toNanos();
        return (dur / a.length);
    }

    void averagetime() {
        long avgtime[] = new long[3];
        avgtime[0] = 0;
        avgtime[1] = 0;
        avgtime[2] = 0;

        for (int i = 0; i < 250; i++) {
            filldsc();
            sort(0, a.length - 1);
            avgtime[1] += Time();
        }

        for (int i = 0; i < 250; i++) {
            fillrandom();
            sort(0, a.length - 1);
            avgtime[2] += Time();
        }

        for (int i = 0; i < 250; i++) {
            fillasc();
            sort(0, a.length - 1);
            avgtime[0] += Time();
        }

        System.out.println("Average time for ascending array sorting : " + avgtime[0] / 250 + " microseconds");
        System.out.println("Average time for descending array sorting : " + avgtime[1] / 250 + " microseconds");
        System.out.println("Average time for random array sorting : " + avgtime[2] / 250 + " microseconds");

    }

    void sort(int l, int r) {
        int m;
        start = Instant.now();
        if (l < r) {

            m = (l + r) / 2;
            sort(l, m);
            sort(m + 1, r);
            merge(l, m, r);

        }
        end = Instant.now();

    }

    void merge(int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int L[] = new int[n1];
        int R[] = new int[n2];

        for (int i = 0; i < n1; i++)
            L[i] = a[l + i];
        for (int j = 0; j < n2; j++)
            R[j] = a[m + 1 + j];

        int i = 0, j = 0;

        int k = l;

        while (i < n1 && j < n2) {

            if (L[i] <= R[j]) {
                a[k] = L[i];
                i++;
            } else {
                a[k] = R[j];
                j++;
            }
            k++;

        }

        while (i < n1) {
            a[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            a[k] = R[j];
            j++;
            k++;
        }

    }

    void print() {
        System.out.print("\n\n  Your sorted array : \n\n");
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.print("\n\n");
    }

}