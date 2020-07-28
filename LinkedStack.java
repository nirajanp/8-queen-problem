
public class LinkedStack {

    private Node top;
    private int count;

    public LinkedStack () {
        clearStack();
    }
    
    private void clearStack () {
        top = null;
        count = 0;
    }
    
    // Pushes an item onto the top of the stack.
    public boolean push(Node n) {
        if(!isFull()){
            n.setNext(top);
            top = n;
            count++;
            return true;
        }
        return false;
    }

    // Removes the object from top of the stack.
    public Node pop() {
        if (isEmpty()) {
            return null;
        }
        Node tmp = top;
        top = top.getNext(); // Changing the value of
        count--;
        return tmp;
    }

    // This method returns a node
    public Node getAtIndex(int index){
        if(index >=0 && index <=size()){
            Node n = peek();
            for (int i = 0; i<index; i++){
                n = n.getNext();
            }
            return n;
        }
        return null;
    }
    
    // This method returns the value of count.
    public int size() {
        return count;
    }
    
    
    // Looks at the object at top of the stack without removing
    // removing it.
    public Node peek() {
        if (isEmpty()) {
            return null;
        } else {
            return top;
        }
    }
    
    // The stack is full, if there are 8 elements. 
    public boolean isFull () {
        return (count == 8);
    }
    
    // This checks if there is any node on stack or not.
    public boolean isEmpty() {
        return (count == 0);
    }
    
    // This displays the solution of 8 queen. 
    public void display(){
    
        for (int i=7; i>=0; i--){
        	// This prints +--- on every every row.
           for (int j = 0; j<8; j++){
             System.out.print("+---");
          }
           System.out.print("+\n");
           // If safe position is found the | Q is printed in console 
           //else just a bar with space "|   " is  printed.
          for (int j = 7; j>=0; j--){
                if(8-i == getAtIndex(i).getRow() && 8-j == getAtIndex(i).getColumn()) {
                   System.out.print("| Q ");
                }
                else {
                   System.out.print("|   ");
                }
            }
           System.out.print("|\n");

        }

        for (int j = 0; j<8; j++){
            System.out.print("+---");
        }
       System.out.print("+\n");

     }
    
}
