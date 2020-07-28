/**
 * 
 * Author: Nirajan Pandey
 * Subject: CS342
 * Instructor: Vic Berry
 * Submission Deadline: Oct 21st, 6:00pm
 *
 *
 * The following program implements a backtracking 
 * algorithm to find a solution to 8 queen problem.
 */
public class QueenDriver {

    public static void main(String[] args) {
       QueenDriver q= new QueenDriver();
        q.doIt();

    }
    public void doIt () {
    	
    	// Object s is instantiated.
        LinkedStack s = new LinkedStack ();

        Node start = new Node();
        
        // (1,1) is passed to a setData() method in Node class.
        start.setData(1,1);
        
        // The first element on the stack is (1,1)
        s.push(start);
        
        // success is set to false initially.
        boolean success = false;

        // While loop, loops around until success is returned true and the 
        // stack is full. 
        while(!success && !s.isEmpty()){
        	
        	
            boolean conflict = false;
            // The most recent item on stack is assigned to 
            // current.
            Node current = s.peek();
            // The item after current is assigned to compared.
            Node compared = current.getNext();
            
            // This checks if the Queen is in the same row, same column 
            // or same diagonal when current node and node after that are not null. 
            // If there is a Queen in same row, column, or diagonal then the 
            // there will be a conflict. 
            while (current!=null){
                while (compared!=null){
                    if(current.getRow() == compared.getRow() ||
                            current.getColumn() == compared.getColumn() ||
                             Math.abs(current.getRow() - compared.getRow()) 
                            		== Math.abs(current.getColumn() - compared.getColumn())){
                        conflict = true;
                        break;
                    }
                    compared = compared.getNext();
                    
                }
                current = current.getNext();
            }
            
            // If there is conflict between queens, the stack is popped until the 
            // queen at the top is found to be placed at 8th column.
            
            if (conflict){
                while (s.peek().getColumn() == 8){
                    s.pop(); 
                }
                
            // After the queen at the 8th column is popped, the current queen at the top of the 
            // stack is moved one step to the next column.
                Node n = s.pop();
                n.setColumn(n.getColumn() + 1);
                s.push(n);
                
            // If stack is full, meaning a solution is found, success is set to true, and the 
            // algorithm is complete.
            }else if(s.isFull()){
                success = true;
             
            // If there is not conflict, a new node [Queen], is placed on the next row, at column 1,
            // and again rechecked for conflicts, as from the previous steps, until a solution is found.
            }else{
                Node n = new Node();
                n.setData(s.size() + 1, 1);
                s.push(n);
            }
        }

        s.display();
    }
}


