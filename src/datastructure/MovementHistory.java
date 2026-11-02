package datastructure;

import java.util.ArrayList;
import java.util.List;
import model.StockMovement;

public class MovementHistory {
    private MovementNode head;
    private MovementNode tail; 
    private int size;

    public MovementHistory() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    
    public void push(StockMovement movement) {
        MovementNode newNode = new MovementNode(movement);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    
    public StockMovement pop() {
        if (isEmpty()) return null;

        StockMovement removed = tail.data;
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        size--;
        return removed;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int getSize() {
        return size;
    }

    
    public List<StockMovement> getMovementsNewestFirst() {
        List<StockMovement> list = new ArrayList<>();
        MovementNode current = tail;
        while (current != null) {
            list.add(current.data);
            current = current.prev;
        }
        return list;
    }

    
    public List<StockMovement> getMovementsOldestFirst() {
        List<StockMovement> list = new ArrayList<>();
        MovementNode current = head;
        while (current != null) {
            list.add(current.data);
            current = current.next;
        }
        return list;
    }
}