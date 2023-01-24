import acm.program.ConsoleProgram;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class test extends ConsoleProgram {

    private StringTokenizer tk;
    private BufferedReader rd;
    private HashSet<String> subjects;
    private HashMap<String, ArrayList<String>> accordance;

    public void init() {
        try {
            rd = new BufferedReader(new FileReader("x.txt"));
            String subject;
            while ((subject = rd.readLine()) != null){
                tk = new StringTokenizer(subject,":");
                subject = tk.nextToken();
                subjects.add(subject);
            }
        } catch (IOException e) {
            println("wrong file");
            throw new RuntimeException(e);
        }
        accordanceMethod();
    }
    private void accordanceMethod(){
        try {
            rd = new BufferedReader(new FileReader("x.txt"));
            String subject;
            Iterator<String> it = subjects.iterator();
            while (it.hasNext()){
                String A = it.next();
                ArrayList<String> list = new ArrayList<>();
                while ((subject = rd.readLine())!= null){
                    tk = new StringTokenizer(subject,":");
                    subject = tk.nextToken();
                    if(A.equals(subject)){
                        list.add(tk.nextToken());
                    }
                }
                accordance.put(A, list);
            }
        } catch (IOException e) {
            println("wrong file");
            throw new RuntimeException(e);
        }
    }
    public void run() {
        int count = 0;
        Iterator<String> it = accordance.keySet().iterator();
        while (it.hasNext()) {
            String part = it.next();
            for (int i = 0; i < accordance.get(part).size(); i++) {
                accordance.remove(part);
                accordance.remove(accordance.get(part).get(i));
            }
            it = accordance.keySet().iterator();
            count ++;
        }
        println(count);
    }

}
