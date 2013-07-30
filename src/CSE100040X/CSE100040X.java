package CSE100040X;

import java.util.Scanner;


public class CSE100040X {
    State[] state;
    char[] c = {'c','i','l','s','t','e','l','a','r','a','y','a','n','i','p','l','n','k','l','r','o','g','a','o','n','a',' ','b','i','a','n','e'};
        
    public CSE100040X(){
        state = new State[28];
        for(int i=0;i<28;i++){
            state[i] = new State();
        }
        for(int i=0;i<5;i++){
            state[0].add(c[i],state[i+1]);
        }
        for(int i=1;i<14;i++){
            state[i].add(c[i+4],state[i+5]);
        }
        state[14].add(c[18],state[3]);
        for(int i=15;i<20;i++){
            state[i].add(c[i+4],state[i+4]);
        }
        state[20].add(c[24],state[22]);
        state[21].add(c[25],state[24]);
        state[22].add(c[26],null);
        state[22].finalState = true;
        state[23].add(c[27],state[25]);
        state[24].add(c[28],state[22]);
        state[25].add(c[29],state[26]);
        state[26].add(c[30],state[27]);
        state[27].add(c[31],state[22]);
        
    }

    public static void main(String[] args) {
        CSE100040X dfa = new CSE100040X();
        //System.out.println(dfa.c.length);
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        dfa.input_dfa(str);
//        String[] str = {"srilanka","Srilanka","taprobane","tabropane"};
//        
//        for(int i=0;i<str.length;i++){
//            System.out.println(str[i]);
//            dfa.input_dfa(str[i]);
//        }       
    }
    
    public void input_dfa(String str){
        try{
            State s = state[0].retrn(str.charAt(0));
            for(int i=1;i<str.length();i++){
                s = s.retrn(str.charAt(i));
                str.charAt(i);
            }
            if(s.finalState){
                System.out.println("ACCEPTED!!!");
            }
            else System.out.println("REJECTED!!!");
        }catch (Exception e){
            System.out.println("Rejected!!!");
        }
    }
}
