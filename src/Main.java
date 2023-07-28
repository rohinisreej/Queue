import java.util.Scanner;
class Node
{
    int value;
    Node next;
    public Node(int value)
    {
        this.value=value;
    }
}
class Queue
{
    static Node first;
    static Node last;
    static int length;
    Queue(int value) {
        Node newnode = new Node(value);
        first= newnode;
        last=newnode;
        length = 1;
    }
    void print()
    {
        Node temp = first;
        while(temp!= null)
        {
            System.out.println(temp.value);
            temp = temp.next;
        }

    }
    public static void Enqueue(int value)
    {
        Node newnode=new Node(value);
        if(length ==0)
        {
            first=newnode;
            last=newnode;
        }
        else {
            last.next=newnode;
            last=newnode;
        }
        length++;
    }
    public static Node dequeue()
    {
        if(length ==0)
        {
            return null;
        }
        Node temp=first;
        if(length ==1)
        {
            first = null;
            last = null;
        }
        else
        {
            first=first.next;
            temp.next=null;
        }
        length--;
        return temp;
    }




}
public class Main {
    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the  value");
        int num= scanner.nextInt();
        Queue q=new Queue(num);
        System.out.println("Enter the value(enter -1 to finish): ");
        while (true)
        {
            num = scanner.nextInt();
            if(num==-1)
            {
                break;
            }
            q.Enqueue(num);

        }
        q.print();
        System.out.println("Elements are Enqueued");
        q.dequeue();
        System.out.println("Elements are removed");

    }
}