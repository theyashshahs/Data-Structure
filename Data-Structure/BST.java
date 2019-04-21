import java.util.*;

import javax.lang.model.util.ElementScanner6;

//import org.graalvm.compiler.graph.Node;

public class BST {

    class BSTnode {
        int element;
        BSTnode left, right;

        public BSTnode(int item) {
            element = item;
            left = right = null;
        }
    }

    BSTnode root;

    void insert(int theElement) {
        root = insertrec(root, theElement);
    }

    BSTnode insertrec(BSTnode root, int theElement) {
        if (root == null) {
            root = new BSTnode(theElement);
            return root;
        }

        if (theElement < root.element)
            root.left = insertrec(root.left, theElement);

        else if (theElement > root.element)
            root.right = insertrec(root.right, theElement);

        return root;
    }

    void delete(int theElement) {
        root = deleterec(root, theElement);
    }

    BSTnode deleterec(BSTnode root, int theElement) {
        if (root == null) {
            return root;
        }

        if (theElement < root.element)
            root.left = deleterec(root.left, theElement);

        else if (theElement > root.element)
            root.right = deleterec(root.right, theElement);

        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            root.key = minvalue(root.right);

            root.right = deleterec(root.right, root.element);
        }

        return root;
    }

    int minvalue(BSTnode root) {
        int min = root.element;
        while (root.left != null) {
            minv = root.left.element;
            root = root.left;
        }
        return min;
    }

    boolean search(int val) {
        return searchrec(root, val);
    }

    boolean searchrec(BSTnode r, int val) {
        boolean found = false;
        while (r != null) {
            if (r.element > val)
                r = r.left;

            else if (r.element < val)
                r = r.right;

            else {
                found = true;
                break;
            }
        }

        return found;
    }

    void inorder() {
        inorderRec(root);
    }

    void inorderRec(BSTnode root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.println("  " + root.element);
            inorderRec(root.right);
        }

    }

    public static void main(String[] args) {
        BST tree = new BST();
        Scanner sc = new Scanner(System.in);
        int d;

        do {
            System.out.print("\n\n  MENU  \n\n  1.Add \n  2.Search\n\n  Enter your choice :: ");

            switch (sc.nextInt()) {
            case 1:
                System.out.print("\n  Enter the number of elements you want to add :: ");
                int a = sc.nextInt();
                int i = 0;
                System.out.println("\n\n  Enter the element :: ");
                while (i < a) {
                    System.out.print("  ");
                    tree.insert(sc.nextInt());
                    i++;
                }
                System.out.println("\n\n  Elements added successfully\n\n");

                tree.inorder();
                break;

            case 2:
                System.out.print("\n\n  Enter the element you want to be searched :: ");
                System.out.print("\n\n  " + tree.search(sc.nextInt()));

                break;

            default:
                System.out.print("\n\n  Wrong choice !!");
            }
            System.out.print("\n\n  Do you want to continue if yes please press 1 :: ");
            d = sc.nextInt();

        } while (d == 1);

    }

}
