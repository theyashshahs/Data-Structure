import java.util.*;
public class ArraylinearList
{
    protected Object [] element;
    protected int size;


public ArraylinearList(int initialCapacity)
{
    if(initialCapacity<1)
    throw new IllegalArgumentException("initialCapacity must be greater than or equal to 1");
    element = new Object[initialCapacity];   
}    

public ArraylinearList() 
{
    this(10);    
}

public boolean isEmpty()
{
    return size==0;
}

public int size()
{
    return size;
}

void checkIndex(int index)
{
    if(index<0 || index>=size)
    throw new IndexOutOfBoundsException("Error Sar");

}

public Object get(int index)
{
    checkIndex(index);
    return element[index];
}

public int indexOf(Object theElement)
{
    for(int i=0;i<size;i++)
        if(element[i].equals(theElement))
        return i;
    return -1;
}

public Object remove(int index)
{
    checkIndex(index);
    Object removedElement = element[index];
    for(int i=index+1;i<size;i++)
        element[i-1] = element[i];
    size-=1;
    element[size]=null;
    return removedElement;
}

public void add(int index, Object theElement)

{
	if(index<0 || index>size )
		throw new IndexOutOfBoundsException("index = " + index + "size = " + size);
	
	if(index==element.length)
		element = Arrays.copyOf(element,2*size);
	
	for(int i=size-1;i>=index;i++)
		
		element[i+1]=element[i];
	
	element[index]=theElement;
	
	size++;
}


public String toString() 
{
    StringBuffer s = new StringBuffer("[");
    for(int i=0;i<size;i++)
        if(element[i]==null)
            s.append("null,");
        else 
            s.append(element[i].toString()+",");
    if(size>0)
        s.delete(s.length()-1,s.length());
        s.append("]");
    
    return new String(s);
}

public static void main(String[] args) 
{
    Scanner sc = new Scanner(System.in);
    ArraylinearList a = new ArraylinearList();    
    int ch,c,e;
    do 
    {
        System.out.println("1.Add \n2.Remove \n3.Display\n");
        System.out.println("Enter your choice :: ");
        ch = sc.nextInt();
        
        switch(ch) 
        {
            case 1:
                System.out.println("Enter the number of elements you want to add : ");
                int d = sc.nextInt();
                int i=0;
                System.out.println("Enter the elements : ");
                while(i<d)
                {   
                    
                    a.add(i,sc.nextInt());
                    i++;
                }
                break;
            case 2:
                System.out.println("Enter the position of the element you want to remove : ");
                a.remove(sc.nextInt());
                break;
            
            case 3:
                System.out.println("The Array Linear List is :: \n");
                System.out.println(a.toString());
                break;

            default:
                System.out.println("WRONG CHOICE!!"); 
        }
        System.out.println("Do you want to continue, if(yes) press 1 ");
        e = sc.nextInt();

    } while (e==1);

}

}

