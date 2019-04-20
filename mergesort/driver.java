import java.util.*;
import java.lang.*;

public class driver extends mergesort {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        mergesort i = new mergesort();
        do {

            System.out.print(
                    "\n  1. Ascending Array \n  2. Descending Array \n  3. Random Array \n  4. Print sorted elements  \n  5. Avearge time \n  6. Exit  \n\n  Enter your choice : ");

            switch (s.nextInt()) {

            case 1:
                i.fillasc();
                break;

            case 2:
                i.filldsc();
                break;

            case 3:
                i.fillrandom();
                break;

            case 4:
                i.sort(0, i.a.length - 1);
                i.print();
                System.out.print("\n\n  Execution Time : " + i.Time() + " microseconds \n\n");
                break;

            case 5:
                i.averagetime();
                break;

            case 6:
                System.exit(0);

            default:
                System.out.println("\n\n  Wrong choice ");
                break;
            }

            // System.out.print("Do you want to continue, if yes press Y|y : ");
            // c = sc.next().charAt(0);

        } while (true);

    }

}