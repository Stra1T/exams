import acm.program.ConsoleProgram;

public class addSpace extends ConsoleProgram {
    @Override
    public void run() {
        String a = "EnjoyYourExam";
        int[] place = new int [2];
        place[0] = 5;
        place[1] = 9;
        println(a);
        println(addSpaces(a,place));
    }

    private String addSpaces(String sentance, int[] place) {
        String edited = "";
        int a = 0;
        for (int i = 0; i < sentance.length(); i++) {
            if (i != place[a]) {
                edited += sentance.charAt(i);
            } else {
                edited += " ";
                edited += sentance.charAt(i);
                if (a + 1 != place.length)
                    a++;
            }
        }
        return edited;
    }

}
