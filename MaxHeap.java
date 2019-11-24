import java.util.*;

public class MaxHeap {
    protected int[] Heap;
    protected int size;
    protected int maxsize;

    public MaxHeap(int maxsize) {
        this.size = 0;
        this.maxsize = 2 * maxsize;
        Heap = new int[this.maxsize];
        Heap[0] = Integer.MAX_VALUE;
    }

    private int parent(int pos) {
        return pos / 2;
    }

    private int leftchild(int pos) {
        return (2 * pos);
    }

    private int rightchild(int pos) {
        return (2 * pos + 1);
    }

    private void swap(int fp, int rp) {
        int temp;
        temp = Heap[fp];
        Heap[fp] = Heap[rp];
        Heap[rp] = temp;
    }

    private void MaxHeapify(int pos) {
        if (Heap[pos] < Heap[leftchild(pos)] || Heap[pos] < Heap[rightchild(pos)]) {
            if (Heap[leftchild(pos)] > Heap[rightchild(pos)]) {
                swap(pos, leftchild(pos));
                MaxHeapify(leftchild(pos));
            } else {
                swap(pos, rightchild(pos));
                MaxHeapify(rightchild(pos));
            }
        }
    }

    public int extract() {
        int pop = Heap[1];
        MaxHeapify(1);
        return pop;
    }

    public void print() {
        for (int i = 1; i <= size / 2; i++) {
            System.out.println(
                    "PARENT : " + Heap[i] + " LEFT CHILD : " + Heap[2 * i] + " RIGHT CHILD : " + Heap[2 * i + 1]);
        }
    }

    public void insert(int element) {
        Heap[++size] = element;
        int curr = size;
        while (Heap[curr] > Heap[parent(curr)]) {
            swap(curr, parent(curr));
            curr = parent(curr);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        MaxHeap m = new MaxHeap(100);
        int n;

        do {

            System.out.print("\n\n   1.Insert  \n  2.Insert single element \n  3.Display \n  Enter your choice :: ");
            int ch = sc.nextInt();

            switch (ch) {

            case 1: {

                System.out.println("\n\n  Enter the number of nodes :: ");

                int a = sc.nextInt();
                m.maxsize = a * 2;

                System.out.print("\n\n  Enter the elements :: ");

                while (a != 0) {
                    m.insert(sc.nextInt());
                    a--;
                }
            }
                break;

            case 2: {
                System.out.print("\n\n  Enter the element : ");
                m.insert(sc.nextInt());

            }
                break;

            case 3: {
                m.print();
                System.out.print("\n  Max element : " + m.extract());
                System.out.print("\n");
            }
                break;

            default:
                System.out.print("\n\n  Enter Again !!");

            }
            System.out.print("\n\n  Do you want to continue (if yes press 1) : ");
            n = sc.nextInt();
            System.out.print("\n");

        } while (n == 1);

    }

}
