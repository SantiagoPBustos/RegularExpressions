package models;
public class Edge {
	
    private final int fromState;
    private final int toState;
    private final char transVal;
    
    public Edge(int fs, char t, int ts) {
        fromState = fs;
        transVal = t;
        toState = ts;
    }

    public Edge(int fs, int ts) {
        fromState = fs;
        transVal = 'e';
        toState = ts;
    }

    public int getFromState() {
        return fromState;
    }

    public int getToState() {
        return toState;
    }

    public char getTransVal() {
        return transVal;
    }

    public void display() {
    	System.out.println("\n d -> (q" + fromState + "," + transVal + ",q" + toState+")");
    }
    
    public int State() {
    	int state =  fromState;
    	return state; 
    }
    
    public char Transition() {
    	char transition = transVal;
    	return transition; 
    }
    
    
    public int Destiny() {
    	int destiny =  toState;
    	return destiny;
    }
}
