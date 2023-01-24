import acm.program.ConsoleProgram;

import java.util.Arrays;

public class badSort extends ConsoleProgram {
    @Override
    public void run() {
        int [] n = new int[9];
        n[1] = 7;
        n[8] = 9;
        n[5] = 8;
        n[4] = 127;
        n[3] = 54;
        n[2] = 6;
        println(Arrays.toString(n));
        badSort(n);
        println(Arrays.toString(n));
    }
    private void badSort(int [] numbers){
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i+1; j < numbers.length; j++) {
                if(numbers[i] > numbers[j]){
                    int temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }
    }
}
