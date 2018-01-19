package chap2;

import org.junit.Test;

import java.util.LinkedList;

public class LinkedListsTest {

    private ListNode<Integer> createList(){
        ListNode<Integer> t1 = new ListNode<Integer>(10);
        ListNode<Integer> t2 = new ListNode<Integer>(50);

        t1.setNextNode(t2);

        ListNode<Integer> t3 = new ListNode<Integer>(30);
        t2.setNextNode(t3);

        ListNode<Integer> t4 = new ListNode<Integer>(20);
        t3.setNextNode(t4);

        ListNode<Integer> t42 = new ListNode<Integer>(20);
        t4.setNextNode(t42);

        ListNode<Integer> t5 = new ListNode<Integer>(60);
        t42.setNextNode(t5);

        ListNode<Integer> t6 = new ListNode<Integer>(10);
        t5.setNextNode(t6);

        return t1;
    }
    @Test
    public void testRemoveDuplicates(){

        LinkedLists lists = new LinkedLists();

        ListNode<Integer> t1 = createList();

        lists.removeDuplicates(t1);

        lists.showList(t1);

    }
    @Test
    public void testGetNToLast(){

        LinkedLists lists = new LinkedLists();

        ListNode<Integer> t1 = createList();

        ListNode<Integer> tn = lists.getNToLast(t1, 5);

        System.out.println(tn.getElement());

    }
    @Test
    public void testDeleteMiddle(){

        ListNode<Integer> t1 = new ListNode<Integer>(10);
        ListNode<Integer> t2 = new ListNode<Integer>(50);

        t1.setNextNode(t2);

        ListNode<Integer> t3 = new ListNode<Integer>(30);
        t2.setNextNode(t3);

        ListNode<Integer> t4 = new ListNode<Integer>(20);
        t3.setNextNode(t4);

        ListNode<Integer> t42 = new ListNode<Integer>(20);
        t4.setNextNode(t42);

        ListNode<Integer> t5 = new ListNode<Integer>(60);
        t42.setNextNode(t5);

        ListNode<Integer> t6 = new ListNode<Integer>(10);
        t5.setNextNode(t6);

        LinkedLists lists = new LinkedLists();
        lists.deleteMiddle(t4);
        lists.showList(t1);
    }
    @Test
    public void testAddList(){

        LinkedLists l = new LinkedLists();

        LinkedList<Integer> n1 = new LinkedList<Integer>();
        n1.add(5);n1.add(1);n1.add(3);

        LinkedList<Integer> n2 = new LinkedList<Integer>();
        n2.add(2);n2.add(9);n2.add(5);

        l.addList(n1,n2);
    }
    @Test
    public void testGetLoopNode(){

        LinkedLists l = new LinkedLists();
        ListNode<String> a = new ListNode<String>("A");
        ListNode<String> b = new ListNode<String>("B");
        ListNode<String> c = new ListNode<String>("C");
        ListNode<String> d = new ListNode<String>("D");
        ListNode<String> e = new ListNode<String>("E");

        a.setNextNode(b);
        b.setNextNode(c);
        c.setNextNode(d);
        d.setNextNode(e);
        e.setNextNode(c);

        System.out.println(l.getLoopNode(a));
    }
}
