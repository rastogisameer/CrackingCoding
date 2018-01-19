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
    public List<Integer> addList(List<Integer> n1, List<Integer> n2){

        int s1 = n1.size();
        int s2 = n2.size();

        int a = 0;
        for(int i = 0; i < n1.size(); i++){

            a += n1.get(i) * Math.pow(10, s1-i-1);
        }
        int b = 0;
        for(int i = 0; i < n2.size(); i++){

            b += n2.get(i) * Math.pow(10, s2-i-1);
        }
        System.out.println(a);
        System.out.println(b);

        int c = a + b;


        return null;
    }
    public ListNode<String> getLoopNode(ListNode<String> root){

        ListNode<String> n = root;
        ListNode<String> p = root;
        ListNode<String> d = root;

        while(n != null){

            d = n;
            n = n.getNextNode();
            p = p.getNextNode().getNextNode().getNextNode();

            if(n.equals(p)){
                break;
            }
        }
        return d;
    }
}

