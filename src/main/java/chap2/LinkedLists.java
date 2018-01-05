package chap2;

import java.util.LinkedList;
import java.util.List;

public class LinkedLists {

    public void removeDuplicates(ListNode<Integer> tail){

        ListNode<Integer> ptr = tail;
        ListNode<Integer> nptr = ptr;
        ListNode<Integer> pnptr = ptr;

        while(ptr != null){

            nptr = ptr.getNextNode();
            pnptr = ptr;

            while(nptr != null){

                if(ptr.getElement().equals(nptr.getElement())){

                    ListNode<Integer> dup = nptr;
                    pnptr.setNextNode(dup.getNextNode());
                    dup = null;

                }
                pnptr = pnptr.getNextNode();
                nptr = nptr.getNextNode();
            }
            ptr = ptr.getNextNode();
        }

    }
    public void showList(ListNode<Integer> tail){
        while(tail != null){

            System.out.println(tail.getElement());
            tail = tail.getNextNode();
        }
    }
    public ListNode<Integer> getNToLast(ListNode<Integer> tail, int n){
        ListNode<Integer> ptr = tail;
        ListNode<Integer> pptr = ptr;

        int c = 0;

        while(ptr != null){

            if(ptr.getNextNode() == null){
                return pptr;
            }
            ptr = ptr.getNextNode();
            c++;
            if(c==n){
                pptr = pptr.getNextNode();
                c = 1;
            }

        }
        return null;
    }
    public void deleteMiddle(ListNode mid){
        ListNode<Integer> ptr = mid;

        while(ptr != null){

            ptr = ptr.getNextNode();
            if(ptr == null)
                break;
            mid.setElement(ptr.getElement());
            mid = ptr;

        }
    }
}
