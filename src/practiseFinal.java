import acm.program.ConsoleProgram;
import acm.program.GraphicsProgram;

import javax.swing.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class practiseFinal extends ConsoleProgram {
    @Override
    public void init() {

    }

    @Override
    public void run() {
        String x = readLine("enter: ");
        domino(x);
    }
    ArrayList<String> words = new ArrayList<>();
    ArrayList<String> wordsSorted = new ArrayList<>();
    private StringTokenizer tk;
    private JFrame frame;
    private void domino(String x){
        tk = new StringTokenizer(x," ");
        while(tk.hasMoreTokens()){
            words.add(tk.nextToken());
        }
        sort();
        for (int i = 0; i <wordsSorted.size() ; i++) {
            println(wordsSorted.get(i));
        }
    }
    private void sort(){
        wordsSorted.add(words.get(0));
        int k = 0;
        for(int i = 0; i<words.size(); i++){
            for (int j = 1; j < words.size(); j++) {
                if (words.get(k).substring(words.get(0).length() - 2).equals(words.get(j).substring(0, 2))) {
                    wordsSorted.add(words.get(k));
                    k = j;
                }
            }
        }
    }
}
