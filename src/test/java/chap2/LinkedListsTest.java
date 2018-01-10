package chap2;

import org.junit.Test;

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
}
