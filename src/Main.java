import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.FlowLayout;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JFrame obj = new JFrame();
	
		
		Gameplay gameplay = new Gameplay();
		
		
		
		obj.setBounds(10, 10 , 905, 700);
		obj.setBackground(Color.DARK_GRAY);
		obj.setResizable(false);
		obj.setVisible(true);
		obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		obj.add(gameplay);
		
		
		
	}
}
