import acm.program.ConsoleProgram;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class unityOfHashMaps extends ConsoleProgram {
    @Override
    public void run() {
        HashMap<String, Integer> n1 = new HashMap<>();
        HashMap<String, Integer> n2 = new HashMap<>();
        unite(n1, n2);
    }
    private void unite(HashMap<String, Integer> n1, HashMap<String,Integer> n2){
        HashMap<String, ArrayList<Integer>> united = new HashMap<>();
        Iterator<String> itN1 = n1.keySet().iterator();

        while(itN1.hasNext()){
            String member = itN1.next();
            ArrayList<Integer> scores = new ArrayList<>();
            scores.add(n1.get(member));
            united.put(member,scores);
        }
        addSecondHashMap(n2, united);
    }

    private void addSecondHashMap(HashMap<String,Integer> n2, HashMap<String, ArrayList<Integer>> united){
        Iterator<String> itN2 = n2.keySet().iterator();
        while(itN2.hasNext()){
            String member = itN2.next();
            if(united.containsKey(member)){
                united.get(member).add(n2.get(member));
            }
            else {
                ArrayList<Integer> scores = new ArrayList<>();
                scores.add(n2.get(member));
                united.put(member,scores);
            }
        }
    }
}
