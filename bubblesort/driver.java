import java.util.*;
import java.lang.*;

/**
 * driver
 */
public class driver extends bubblesort {

    public static void main(String[] args) {

        Scanner read = new Scanner(System.in);
        bubblesort s = new bubblesort();

        do {
            System.out
                    .print("\n\n  1. Add elements \n  2. Print sorted array \n  3. Exit \n\n    Enter your choice : ");

            switch (read.nextInt()) {
            case 1:
                s.enter();
                break;

            case 2:
                s.bubble(s.n, s.a);

                s.print(s.a);

                s.Time();

                break;

            case 3:
                System.exit(0);
                break;

            default:
                System.out.print("\n\n  Wrong choice");
            }

        } while (true);
    }

}