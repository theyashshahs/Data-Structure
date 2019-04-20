import java.util.*;
import java.lang.*;

public class driver extends insertionsort {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        insertionsort i = new insertionsort();
        do {

            System.out.print(
                    "\n  1. Add elements manually \n  2. Ascending Array \n  3. Descending Array \n  4. Random Array \n  5. Print sorted elements  \n  6. Avearge time \n  7. Exit  \n\n  Enter your choice : ");

            switch (s.nextInt()) {
            case 1:
                i.enter();
                break;

            case 2:
                i.fillasc();
                break;

            case 3:
                i.filldsc();
                break;

            case 4:
                i.fillrandom();
                break;

            case 5:
                i.insertion();
                i.print();
                System.out.print("\n\n  Execution Time : " + i.Time() + " microseconds \n\n");
                break;

            case 6:
                i.averagetime();
                break;

            case 7:
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