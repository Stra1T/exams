import acm.graphics.GLine;
import acm.graphics.GObject;
import acm.graphics.GPoint;
import acm.program.GraphicsProgram;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class connection extends GraphicsProgram {
    @Override
    public void init() {
        x = new JTextField(10);
        y = new JTextField(10);
        add(x,SOUTH);
        add(y, SOUTH);
        add = new JButton("add");
        add(add,SOUTH);
        remove = new JButton("remove");
        add(remove,SOUTH);
        addActionListeners();
    }

    int count = 0;
    private JTextField x;
    private JTextField y;
    private JButton add;

    private JButton remove;
    private GLine line;

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == add && !x.getText().equals("") && !y.getText().equals("") && count == 0){
            int X = Integer.parseInt(x.getText());
            int Y = Integer.parseInt(y.getText());
            line = new GLine(X,Y,X,Y);
            add(line);
            count ++;
            return;
        }
        if(e.getSource() == add && !x.getText().equals("") && !y.getText().equals("") && count == 1){
            int X = Integer.parseInt(x.getText());
            int Y = Integer.parseInt(y.getText());
            line.setEndPoint(X,Y);
            count = 0;
        }
        if(e.getSource() == remove && !x.getText().equals("") && !y.getText().equals("")){
            int X = Integer.parseInt(x.getText());
            int Y = Integer.parseInt(y.getText());
            GObject obj = getElementAt(X,Y);
            remove(obj);
            count = 0;
        }
    }
}
