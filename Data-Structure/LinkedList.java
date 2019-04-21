import java.util.*;


public class LinkedList extends Node
{
    protected Node firstNode;
    protected int size;


public LinkedList()
{
    firstNode = null;
    size = 0;

}

public boolean isEmpty()
{
    return size==0;
}

public int size()
{
    return size;
}

void checkinput(int index)
{
    if(index<0 || index>=size)
        throw new IndexOutOfBoundsException("Error");

}

public Object get(int index)
{
    checkinput(index);

    Node currentNode = firstNode;
    for(int i=0;i<index;i++)
        currentNode = currentNode.next;

        return currentNode.data;
}
public int search(Object theElement)
{
    
    Node currentNode = firstNode;
    int index = 0;
    while(currentNode!=null && !currentNode.equals(theElement))
    {
        currentNode = currentNode.next;
        index++;
    }

    if(currentNode == null)
        return -1;

    else
        return index;
}

public Object remove(int index)
{
    checkinput(index);
    Object removedElement;
    if(index==0)
    {
        removedElement = firstNode.data;
        firstNode = firstNode.next;
    }

    else
    {
        Node currentNode = firstNode;
        for(int i=0;i<=index-2;i++)
            currentNode = currentNode.next;
        
        removedElement = currentNode.next.data;
        currentNode.next = currentNode.next.next;
    }
    size--;
    return removedElement;
}

public void add(int index, Object theElement)
{

    if(index==0)
        firstNode = new Node (theElement,firstNode);
    
    else
    {
        Node currentNode = firstNode;
        for(int i=0;i<=index-2;i++)
            currentNode = currentNode.next;
        
        currentNode.next = new Node(theElement, currentNode.next);
    }

    size++;
}

public void display()
{   System.out.print("\n\n  Elements are :- \n\n");
    Node currentNode = firstNode;
    for(int i=0;i<size;i++)
    {
        System.out.print(currentNode.data + " ");
        currentNode = currentNode.next;
    }
}

public static void main(String[] args) {
    int f;
    Scanner sc = new Scanner(System.in);
    LinkedList a = new LinkedList();


    do
    {
    System.out.print("*********MENU*********\n\n  1.Add an element \n\n  2.Add 'n' elements \n\n  3.Remove an element  \n\n  4.Display \n\n Enter your response :: ");

    switch (sc.nextInt())
    {
        case 1:
            System.out.println("\n  Enter the index and the element respectively :: ");
            a.add(sc.nextInt(), sc.nextInt());
            System.out.println("  **Element added successfully**");
        
        break;

        case 2:
            System.out.println("\n  Enter the number of elements you want to add :: ");
            int d = sc.nextInt();
            int c=0;
            System.out.println("\n  Enter the elements : ");
            while(c<d)
            {   
                a.add(c, sc.nextInt());
                c++;
            }
            System.out.println("\n  Elements added successfully");
            break;

        case 3:
            System.out.println("\n  Enter the position of the element to be removed : ");
            System.out.println("\n  Element removed : " + a.remove(sc.nextInt()));

            break;
        
        case 4:
            a.display();
            break;

        default:
            System.out.println("\n\nWrong Choice !!");    
    }
    System.out.println("\n\n  Do you want to continue if yes press 1 :  ");
    f = sc.nextInt();

}while(f==1);
    
}


}
