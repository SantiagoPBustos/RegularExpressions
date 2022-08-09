package models;
import java.util.*;

import NFA.Nfa;

public class Nfa {

    private final ArrayList<Edge> edges;
    private final int stateCount;

    public Nfa() {
        stateCount = 1;
        edges = new ArrayList();
        Edge e = new Edge(0, 1);
        edges.add(e);
    }

    public Nfa(char ch) {
        stateCount = 1;
        edges = new ArrayList();
        Edge e = new Edge(0, ch, 1);
        edges.add(e);
    }

    public Nfa(ArrayList<Edge> es, int c) {
        edges = es;
        stateCount = c;
    }

    public ArrayList<Edge> getEdges() {
        return edges;
    }

    public int getStateCount() {
        return stateCount;
    }

    public static Nfa union(Nfa a, Nfa b) {
        ArrayList<Edge> edgesa = new ArrayList<>(a.getEdges());
        ArrayList<Edge> edgesb = new ArrayList<>(b.getEdges());
        ArrayList<Edge> edgesc = new ArrayList<>();
        int acount = a.getStateCount();
        int bcount = b.getStateCount();

        for (Edge e : edgesa) {
            Edge p = new Edge(e.getFromState() + 1, e.getTransVal(), e.getToState() + 1);
            edgesc.add(p);
        }

        Edge starttoa = new Edge(0, 1);
        edgesc.add(starttoa);

        for (Edge e : edgesb) {
            Edge p = new Edge(e.getFromState() + acount + 2, e.getTransVal(), e.getToState() + acount + 2);
            edgesc.add(p);
        }

        Edge starttob = new Edge(0, acount + 2);
        edgesc.add(starttob);

        Edge atoend = new Edge(acount + 1, acount + bcount + 3);
        edgesc.add(atoend);

        Edge btoend = new Edge(acount + bcount + 2, acount + bcount + 3);
        edgesc.add(btoend);

        Nfa c = new Nfa(edgesc, acount + bcount + 3);
        return c;
    }

    public static Nfa concat(Nfa a, Nfa b) {
        ArrayList<Edge> edgesa = new ArrayList<>(a.getEdges());
        ArrayList<Edge> edgesb = new ArrayList<>(b.getEdges());
        ArrayList<Edge> edgesc = new ArrayList<>();

        int acount = a.getStateCount();
        int bcount = b.getStateCount();

        for (Edge e : edgesa) {
            Edge p = new Edge(e.getFromState(), e.getTransVal(), e.getToState());
            edgesc.add(p);
        }
        for (Edge e : edgesb) {
            Edge p = new Edge(e.getFromState() + acount, e.getTransVal(), e.getToState() + acount);
            edgesc.add(p);
        }

        Nfa c = new Nfa(edgesc, acount + bcount);
        return c;
    }

    public static Nfa closure(Nfa a) {
        ArrayList<Edge> edgesa = new ArrayList<>(a.getEdges());
        ArrayList<Edge> edgesc = new ArrayList<>();
        int acount = a.getStateCount();

        for (Edge e : edgesa) {
            Edge p = new Edge(e.getFromState() + 1, e.getTransVal(), e.getToState() + 1);
            edgesc.add(p);
        }

        Edge endtostart = new Edge(acount + 1, 1);
        edgesc.add(endtostart);

        Edge nstarttostart = new Edge(0, 1);
        edgesc.add(nstarttostart);

        Edge endtonend = new Edge(acount + 1, acount + 2);
        edgesc.add(endtonend);

        Edge nstarttonend = new Edge(0, acount + 2);
        edgesc.add(nstarttonend);

        Nfa c = new Nfa(edgesc, acount + 2);

        return c;
    }

    public void display() {
        System.out.println("************************Nfa************************");
        System.out.println("\nS0: q0");
        System.out.println("\nQs: q" + stateCount);
        edges.forEach((edge) -> edge.display());
    }
    
    public String startState() {
        return "q0";
    }
    
    public String finalState() {
        return "q" + stateCount;
    }

    public ArrayList<Object> allState() {
    	ArrayList<Object> ss = new ArrayList<>();
    	for(int i=0; i<=stateCount; i++) {
    		ss.add("q"+i);
    	}
        return ss;
    }
    
    public ArrayList<Object> State() {
    	ArrayList<Object> states = new ArrayList<>();
    	edges.forEach((edge) -> states.add("q"+edge.State()));
    	return states;
    }
    
    public ArrayList<Character> Transition() {
    	ArrayList<Character> transition = new ArrayList<>();
    	edges.forEach((edge) -> transition.add(edge.Transition()));
    	return transition;
    }
    
    public ArrayList<Object> Destiny() {
    	ArrayList<Object> destiny = new ArrayList<>();
    	edges.forEach((edge) -> destiny.add("q"+edge.Destiny()));
    	return destiny;
    }
    
    public ArrayList<Object> automata(String str) {
    	Nfa c = Nfa.reToNfa(str);
    	ArrayList<Object> lista = new ArrayList<>();
    	lista.add( c.startState());
    	lista.add( c.finalState());
    	lista.add( c.State());
    	lista.add( c.Transition());
    	lista.add( c.Destiny());
    	return lista;
    }
    
    public Nfa(String str) {
        Nfa c = Nfa.reToNfa(str);
        edges = c.getEdges();
        stateCount = c.getStateCount();
    }

    private static Nfa reToNfa(String re) {
        re = "(" + re + ")";
        Stack<Object> stack = new Stack<>();
        for (int i = 0; i < re.length(); i++) {
            switch (re.charAt(i)) {
                case '(':
                    stack.push('(');
                    break;
                case '|':
                    stack.push('|');
                    break;
                case '*':
                    Nfa x = Nfa.closure((Nfa) stack.pop());
                    stack.push(x);
                    break;
                case ')':
                    Stack<Object> hold = new Stack<>();
                    Object r = stack.pop();
                    while (r instanceof Nfa || (char) r != '(') {
                        hold.push(r);
                        r = stack.pop();
                    }
                    Object p = hold.pop();
                    while (!hold.empty()) {
                        Object q = hold.pop();
                        if (!(q instanceof Nfa)) {
                            p = Nfa.union((Nfa) p, (Nfa) hold.pop());
                        } else {
                            p = Nfa.concat((Nfa) p, (Nfa) q);
                        }
                    }
                    stack.push((Nfa) p);
                    break;
                default:
                    Nfa one = new Nfa(re.charAt(i));
                    stack.push(one);
                    break;
            }
        }
        return (Nfa) stack.pop();
    }
}
