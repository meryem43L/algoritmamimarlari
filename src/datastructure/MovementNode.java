package datastructure;

import model.StockMovement;

public class MovementNode {
    public StockMovement data;
    public MovementNode prev;
    public MovementNode next;

    public MovementNode(StockMovement data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}