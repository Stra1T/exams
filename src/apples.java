import acm.program.GraphicsProgram;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class apples extends GraphicsProgram {


    public void run() {
        int[][] matrix = new int[][]{new int[]{0,0,0,0},new int[]{1,1,2,1},new int[]{0,1,2,1},new int[]{0,2,0,0}};
        ArrayList<String> inst = new ArrayList<>();
        inst.add("move");
        inst.add("left");
        inst.add("left");
        inst.add("left");
        inst.add("move");
        inst.add("move");
        inst.add("move");
        inst.add("left");
        inst.add("left");
        inst.add("left");
        inst.add("move");
        inst.add("left");
        inst.add("left");
        inst.add("left");
        inst.add("move");
        println(appples(matrix, inst));
    }

    private int appples(int[][] matrix, ArrayList<String> orders ){
        int applesCount = 0;

        for (int i = 0; i < orders.size(); i++) {
            if(orders.get(i).equals("left")){
                changeDirectino();
            }
            if(orders.get(i).equals("move")){
                if(directionCount % 4 == 0){
                    moveEast(matrix);
                }
                if(directionCount % 4 == 1){
                    moveNorth(matrix);
                }
                if(directionCount % 4 == 2){
                    moveWest(matrix);
                }
                if(directionCount % 4 == 3){
                    moveSouth(matrix);
                }
                if(matrix[y][x] == 1) {
                    matrix[y][x] = 0;
                    applesCount ++;
                }
            }
        }

        return applesCount;
    }
    int x = 0;
    int y = 0;
    int directionCount = 0;

    private void changeDirectino(){
        directionCount ++;
    }
    private boolean OutOfWorldx( int x,int[][] matrix){
        return x>matrix[1].length;
    }
    private boolean OutOfWorldy( int x,int[][] matrix){
        return y>matrix.length;
    }
    private void moveEast(int[][] matrix){
        if(matrix[y][x+1] != 2 && !OutOfWorldx(x+1, matrix)){
            x += 1;
        }
    }
    private void moveNorth(int[][] matrix){
        if(matrix[y-1][x] != 2 && !OutOfWorldy(y-1, matrix)){
            y -= 1;
        }
    }
    private void moveWest(int[][] matrix){
        if(matrix[y][x-1] != 2 && !OutOfWorldx(x-1, matrix)){
            x -= 1;
        }
    }
    private void moveSouth(int[][] matrix){
        if(matrix[y+1][x] != 2 && !OutOfWorldy(y+1, matrix)){
            y += 1;
        }
    }

}
