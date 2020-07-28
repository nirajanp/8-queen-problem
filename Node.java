
// This class has getters and setters methods of the private variable. 

public class Node {

    private int row;
    private int column;
    private Node next;

    
    public int getRow() {
        return this.row;
    }

    public int getColumn () {
        return this.column;
    }

    public Node getNext() {
        return this.next;
    }
    public void setNext(Node next) {
        this.next = next;
    }

    public void setData(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setColumn(int column) {
        this.column = column;
    }
}
