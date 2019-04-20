import java.util.*;
import java.time.*;

class insertionsort {
    int b;
    int[] a;
    Random random;

    Instant start, end;

    insertionsort() {
        random = new Random();
        a = new int[1000];
        b = 1000;
    }

    void enter() {

        Scanner sc = new Scanner(System.in);
        System.out.print("\n\n  Enter the number of elements you want to insert : ");
        b = sc.nextInt();
        a = new int[b];
        System.out.print("\n\n  Enter the elements : ");
        for (int i = 0; i < b; i++)
            a[i] = sc.nextInt();
        System.out.print("\n\n  Elements added sucessfully \n");

    }

    void fillrandom() {

        for (int i = 0; i < 1000; i++)
            a[i] = random.nextInt(9000) + 999;
    }

    void fillasc() {
        for (int i = 0; i < 1000; i++)
            a[i] = i;
    }

    void filldsc() {
        for (int i = 0, j = 1000; i < 1000; i++, j--)
            a[i] = j;
    }

    long Time() {
        long dur = Duration.between(start, end).toNanos();
        return (dur / 1000);
    }

    void averagetime() {
        long avgtime[] = new long[3];
        avgtime[0] = 0;
        avgtime[1] = 0;
        avgtime[2] = 0;

        for (int i = 0; i < 25; i++) {
            fillasc();
            insertion();
            avgtime[0] += Time();
        }

        for (int i = 0; i < 25; i++) {
            filldsc();
            insertion();
            avgtime[1] += Time();
        }

        for (int i = 0; i < 25; i++) {
            fillrandom();
            insertion();
            avgtime[2] += Time();
        }

        System.out.println("Average time for ascending array sorting : " + avgtime[0] / 25 + " microseconds");
        System.out.println("Average time for descending array sorting : " + avgtime[1] / 25 + " microseconds");
        System.out.println("Average time for random array sorting : " + avgtime[2] / 25 + " microseconds");

    }

    void insertion() {
        int i, j, key;
        start = Instant.now();
        for (i = 1; i < b; i++) {
            key = a[i];
            j = i - 1;

            while (j >= 0 && a[j] > key) {
                a[j + 1] = a[j];
                j = j - 1;
            }
            a[j + 1] = key;
        }
        end = Instant.now();
    }

    void print() {
        System.out.print("\n\n  Your sorted array : \n\n");
        for (int i = 0; i < b; i++)
            System.out.print(a[i] + " ");
        System.out.print("\n\n");
    }

}