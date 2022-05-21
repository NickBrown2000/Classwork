import java.lang.Integer;

public class Links
{



    public static void main(String[] args)
    {
        Node pos1 = null;
        Node pos2 = null;
        pos1 = new Node(new Integer(13));
        pos1.setNext(new Node(new Integer(15), null));
        pos2 = new Node(new Integer(11), null);
        pos2.setNext(pos1);
        printList(pos2);
        System.out.println(getCount(pos2));
        System.out.println(getMax(pos2));
    }

    private static void printList(Node head)
    {
        if (head != null)
        {
            System.out.println(head.getItem());
            printList(head.getNext());
        }
    }

    private static int getMax(Node head)
    {
        Node temp = head;
        int max = 0;
        while(temp != null){
            if((int)temp.getItem()>max){
                max=(int)temp.getItem();
            }
            temp = temp.getNext();
        }
        return max;
    }

    public static int getCount(Node head)
    {
        int count = 0;
        Node temp = head;
        if (temp != null)
        {
            count = (getCount(temp.getNext())+1);
        }
        return count;
    }
}