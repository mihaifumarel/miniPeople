package ro.CensLabs.miniPeople;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import ro.CensLabs.Screen.UI;
import ro.CensLabs.miniPeople.Utils.UIControl;

import com.badlogic.gdx.backends.lwjgl.LwjglAWTCanvas;

public class Main extends JFrame{

    public Main() {
    	
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final Container container = getContentPane();
        container.setLayout(null);
        

        LwjglAWTCanvas canvas = new LwjglAWTCanvas(new miniPeople(), true);
        
        container.add(canvas.getCanvas());
       UI ui = new UI();
		canvas.getCanvas().setBounds(0, 0, 1079, 490);
		UI.menu.setBounds(1080, 0, 200, 490);
       container.add(UI.menu);
        setResizable(false);

        
        
        
        
        pack();
        setVisible(true);
        setSize(1278,518);
        UIControl.updateUI();
        
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main();
            }
        });
    }
}