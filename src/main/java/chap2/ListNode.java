package chap2;

public class ListNode<T> {

    private T element;

    private ListNode nextNode;

    public ListNode(T element) {
        this.element = element;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public ListNode getNextNode() {
        return nextNode;
    }

    public void setNextNode(ListNode nextNode) {
        this.nextNode = nextNode;
    }

    @Override
    public String toString(){
        return (String) element;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ListNode<?> listNode = (ListNode<?>) o;

        return element != null ? element.equals(listNode.element) : listNode.element == null;
    }

    @Override
    public int hashCode() {
        return element != null ? element.hashCode() : 0;
    }
}
