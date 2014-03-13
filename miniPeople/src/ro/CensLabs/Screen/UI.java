package ro.CensLabs.Screen;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.lwjgl.LwjglAWTCanvas;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import ro.CensLabs.miniPeople.miniPeople;
import ro.CensLabs.miniPeople.Utils.Constants;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import java.awt.Font;
import javax.swing.border.EtchedBorder;
import javax.swing.JToolBar;

public class UI extends JFrame {

	 public static JPanel menu;
	 public static JTextField blue_gold;
	 public static JTextField blue_metal;
	 public static JTextField blue_stone;
	 public static JTextField blue_wood;
	 public static JTextField red_wood;
	 public static JTextField red_stone;
	 public static JTextField red_metal;
	 public static JTextField red_gold;
	 private JLabel label_1;
	 private JLabel label_2;
	 private JLabel label_3;
	 private JLabel label_4;


	/**
	 * Create the frame.
	 * 
	 * 
	 */
	public UI() {
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {
		    // If Nimbus is not available, fall back to cross-platform
		    try {
		        UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		    } catch (Exception ex) {
		        // not worth my time
		    }
		}
		    menu = new JPanel();
			menu.setLayout(new BorderLayout(0, 0));
			
			JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			tabbedPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			menu.add(tabbedPane);
			JPanel resourcePanel = new JPanel();
			
			tabbedPane.addTab("",new ImageIcon(getClass().getResource("resource.png")), resourcePanel);
			resourcePanel.setLayout(null);
			
			JPanel panel = new JPanel();
			panel.setBackground(Color.GRAY);
			panel.setBounds(0, 0, 189, 464);
			resourcePanel.add(panel);
			panel.setLayout(null);
			
			blue_metal = new JTextField();
			blue_metal.setEditable(false);
			blue_metal.setColumns(10);
			blue_metal.setBounds(44, 95, 102, 22);
			panel.add(blue_metal);
			
						
						blue_metal.setFont(new Font("SansSerif", Font.BOLD, 12));
						blue_metal.setBackground(new Color(0,0,0,0));
						blue_metal.setOpaque(false);
						blue_metal.setForeground(Color.WHITE);
						blue_metal.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
			
			blue_gold = new JTextField();
			blue_gold.setEditable(false);
			blue_gold.setFont(new Font("SansSerif", Font.BOLD, 12));
			blue_gold.setBounds(44, 60, 102, 22);
			panel.add(blue_gold);
			blue_gold.setColumns(10);
			
			
			
			
			
			
			
			
			
			
			
			
			blue_gold.setBackground(new Color(0,0,0,0));
			blue_gold.setOpaque(false);
			
			blue_gold.setForeground(Color.WHITE);
			
			blue_gold.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
			
			blue_stone = new JTextField();
			blue_stone.setEditable(false);
			blue_stone.setColumns(10);
			blue_stone.setBounds(44, 129, 102, 22);
			panel.add(blue_stone);
			blue_stone.setFont(new Font("SansSerif", Font.BOLD, 12));
			blue_stone.setBackground(new Color(0,0,0,0));
			blue_stone.setOpaque(false);
			blue_stone.setForeground(Color.WHITE);
			blue_stone.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
			
			red_wood = new JTextField();
			red_wood.setEditable(false);
			red_wood.setColumns(10);
			red_wood.setBounds(44, 299, 102, 22);
			panel.add(red_wood);
			
			blue_wood = new JTextField();
			blue_wood.setEditable(false);
			blue_wood.setColumns(10);
			blue_wood.setBounds(44, 163, 102, 22);
			panel.add(blue_wood);
			blue_wood.setFont(new Font("SansSerif", Font.BOLD, 12));
			blue_wood.setBackground(new Color(0,0,0,0));
			blue_wood.setOpaque(false);
			blue_wood.setForeground(Color.WHITE);
			blue_wood.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
			
			red_stone = new JTextField();
			red_stone.setEditable(false);
			red_stone.setColumns(10);
			red_stone.setBounds(44, 334, 102, 22);
			panel.add(red_stone);
			
			red_metal = new JTextField();
			red_metal.setEditable(false);
			red_metal.setColumns(10);
			red_metal.setBounds(44, 368, 102, 22);
			panel.add(red_metal);
			
			red_gold = new JTextField();
			red_gold.setEditable(false);
			red_gold.setColumns(10);
			red_gold.setBounds(44, 402, 102, 22);
			panel.add(red_gold);
			menu.setBounds(1080, 0, 190, 520);
			red_gold.setFont(new Font("SansSerif", Font.BOLD, 12));
			red_metal.setFont(new Font("SansSerif", Font.BOLD, 12));
			red_stone.setFont(new Font("SansSerif", Font.BOLD, 12));
			red_wood.setFont(new Font("SansSerif", Font.BOLD, 12));
			red_gold.setBackground(new Color(0,0,0,0));
			red_gold.setOpaque(false);
			red_metal.setBackground(new Color(0,0,0,0));
			red_metal.setOpaque(false);
			red_stone.setBackground(new Color(0,0,0,0));
			red_stone.setOpaque(false);
			red_wood.setBackground(new Color(0,0,0,0));
			red_wood.setOpaque(false);
			red_gold.setForeground(Color.WHITE);
			red_metal.setForeground(Color.WHITE);
			red_stone.setForeground(Color.WHITE);
			red_wood.setForeground(Color.WHITE);
			red_gold.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
			red_metal.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
			red_stone.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
			red_wood.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
			
			label_1 = new JLabel("");
			label_1.setIcon(new ImageIcon(getClass().getResource("Gold2.png")));
			label_1.setBounds(48, 405, 16, 16);
			panel.add(label_1);
			
			label_2 = new JLabel("");
			label_2.setIcon(new ImageIcon(getClass().getResource("avatar_d3df4b95483d_16.png")));
			label_2.setBounds(48, 371, 16, 16);
			panel.add(label_2);
			
			label_3 = new JLabel("");
			label_3.setIcon(new ImageIcon(getClass().getResource("8LXB8yE.png")));
			label_3.setBounds(48, 337, 16, 16);
			panel.add(label_3);
			
			label_4 = new JLabel("");
			label_4.setIcon(new ImageIcon(getClass().getResource("logside.png")));
			label_4.setBounds(48, 302, 16, 16);
			panel.add(label_4);
			
			JLabel label_5 = new JLabel("");
			label_5.setBounds(48, 166, 16, 16);
			panel.add(label_5);
			
			
			
			JLabel label_6 = new JLabel("");
			label_6.setBounds(48, 132, 16, 16);
			panel.add(label_6);
			
			
			JLabel label_7 = new JLabel("");
			label_7.setBounds(48, 98, 16, 16);
			panel.add(label_7);
			
			
			JLabel label_8 = new JLabel("");
			label_8.setBounds(48, 63, 16, 16);
			panel.add(label_8);
			label_5.setIcon(new ImageIcon(getClass().getResource("logside.png")));
			label_7.setIcon(new ImageIcon(getClass().getResource("avatar_d3df4b95483d_16.png")));
			label_6.setIcon(new ImageIcon(getClass().getResource("8LXB8yE.png")));
			label_8.setIcon(new ImageIcon(getClass().getResource("Gold2.png")));
			
			JLabel label = new JLabel("");
			label.setIcon(new ImageIcon(getClass().getResource("UI resources simple.png")));
			label.setBounds(0, 0, 189, 464);
			panel.add(label);
		
	}
}
