import acm.graphics.GLabel;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.*;

public class cubeGame extends GraphicsProgram {

    public void init() {
        add(left,SOUTH);
        add(right,SOUTH);
        addActionListeners();
        Blue.setFilled(true);
        Blue.setColor(Color.BLUE);
        add(Blue,x,y);
        Yellow.setFilled(true);
        Yellow.setColor(Color.YELLOW);
        add(Yellow, getWidth()/2.0- Yellow.getWidth()/2, getHeight()/2.0-Yellow.getHeight()/2);
    }
    int x = 1;
    int y = 1;
    double Xdirection = 3.0;
    double Ydirection = 0.0;
    GRect Yellow = new GRect(30,30);
    GRect Blue = new GRect(30,30);
    private RandomGenerator rg = new RandomGenerator();
    public void run(){
        int count = 0;
        while(true){
            Blue.move(Xdirection,Ydirection);
            pause(100);
            count ++;
            if(checkTouch()){
                removeAll();
                youLost();
                return;
            }
            if (Blue.getX() + Blue.getWidth() >= getWidth() && Xdirection > 0) {
                Xdirection = Xdirection * -1;
            }
            if (Blue.getX() <= 0 && Xdirection < 0) {
                Xdirection = Xdirection * -1;
            }
            if (Blue.getY() <= 0 && Ydirection < 0) {
                Xdirection = Xdirection * -1;
            }
            if (Blue.getY() + Blue.getHeight() >= getHeight() && Ydirection > 0) {
                Xdirection = Xdirection * -1;
            }
            if(count == 30){
                change();
                count = 0;
            }
        }
    }
    private void youLost(){
        setBackground(Color.RED);
        GLabel looser= new GLabel("LOOSER");
        looser.setColor(Color.blue);
        looser.setFont("ALK Katerina-30");
        add(looser, getWidth()/2.0-looser.getWidth()/2,getHeight()/2.0+looser.getAscent()/2);
    }
    private boolean checkTouch(){
        int count = 0;
        if(Blue.getY() >= Yellow.getY()-Blue.getHeight() && Blue.getY() <= Yellow.getY()+Yellow.getHeight()){
            count++;
        }
        if(Blue.getX() >= Yellow.getX()-Blue.getWidth()&& Blue.getX() <= Yellow.getX()+ Yellow.getWidth()){
            count++;
        }
        return count == 2;
    }
    private void change(){
        Xdirection = rg.nextDouble(0, 3.0);
        Ydirection = 3.0 -  Xdirection;
        if(rg.nextBoolean()){
            Xdirection = Xdirection* -1;
        }
        if(rg.nextBoolean()){
            Ydirection = Ydirection* -1;
        }
    }
    private JButton left = new JButton("Left");
    private JButton right = new JButton("Right");

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == left){
            if(Yellow.getX() >= 0) {
                double X = Yellow.getX() - 3;
                Yellow.setLocation(X, Yellow.getY());
            }
        }
        if(e.getSource() == right){
            if(Yellow.getX()+Yellow.getWidth() <= getWidth()) {
                double X = Yellow.getX() + 3;
                Yellow.setLocation(X, Yellow.getY());
            }
        }
    }
}
