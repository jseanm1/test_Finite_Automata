package CSE100040X;

import java.util.LinkedList;

public class State {
    LinkedList<Transition> tr = new LinkedList<Transition>();
    boolean finalState = false;
    
    public void add(char ch, State state){
        Transition t = new Transition();
        t.c = ch;
        t.nxt = state;
        tr.add(t);
    }
    
    public State retrn(char ch){
        Transition t;
        State s = null;
        for(int i=0;i<tr.size();i++){
            t = tr.get(i);
            if(t.c == ch){
                s = t.nxt;                
            }
        }
        return s;
    }
}
