import acm.graphics.GLine;
import acm.graphics.GObject;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

import java.awt.*;
import java.awt.event.MouseEvent;

public class grid extends GraphicsProgram {

    private GRect rect;
    public void run() {
        setBackground(Color.black);
        int width = getHeight()/10;
        int height = width;


        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                rect = new GRect(width,height);
                double x = rect.getWidth()*j;
                double y = rect.getHeight()*i;
                rect.setFilled(true);
                rect.setColor(Color.WHITE);
                add(rect,x,y);
            }
        }
        for (int i = 0; i < 10; i++) {
            double x = width*i;
            GLine line = new GLine(x,0,x,getHeight());
            add(line);
        }
        for (int i = 0; i < 10; i++) {
            double y = width*i;
            GLine line = new GLine(0,y,getWidth(),y);
            add(line);
        }
        addMouseListeners();
    }
    int count = 0;
    GObject prev = null;
    public void mouseClicked(MouseEvent e){
        count ++;
        GObject obj = getElementAt(e.getX(),e.getY());

        GObject cur = obj;

        if(obj.getColor().equals(Color.WHITE)){
            count++;
            if(count <= 2){
                cur.setColor(Color.BLUE);
            }
            else{
                cur.setColor(Color.BLUE);
                prev.setColor(Color.WHITE);
            }
        }
        prev = cur;

    }
}
