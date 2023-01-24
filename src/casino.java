import acm.program.ConsoleProgram;

import java.util.random.RandomGenerator;

public class casino extends ConsoleProgram {
    @Override
    public void init(){

    }

    @Override
    public void run() {
        int n = 1000;
        int sum = 0;
        for (int i = 0; i < 1000; i++){
            sum = experiment(n);
        }
        println(sum);
    }

    private int experiment(int n){
        int start = n;
        int count = 0;
        while(n > 0){
            int loss = n - start;
            double bet = 1;
            if(loss > 0){
                bet = (double)(loss + 1)/36;
            }
            bet = Math.min(n,bet);
            n = (int) (n- bet);
            count ++;
        }
        return  count;
    }
}
