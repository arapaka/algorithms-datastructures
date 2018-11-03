package datastrutures.linkedlists.datastructuredefinitions;

import java.util.LinkedHashMap;

/**
 * Created by archithrapaka on 2/5/17.
 * List nODE CLASS FOR LINKED LIST
 */
public class ListNode<T> {
    public T data;
    public ListNode<T> next;

    public ListNode() {

    }

    public ListNode(T data) {
        this.data = data;
    }

    LinkedHashMap map = new LinkedHashMap();
}
