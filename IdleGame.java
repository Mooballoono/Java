import javax.swing.*;
import java.awt.event.*;

public class IdleGame{
	public static int clicks = 0;
	public static void main(String[]args){
		boolean loop = true;
		JFrame meow = new JFrame("Clicker Game");
		meow.setSize(800,600);
		meow.setLayout(null);
		meow.setVisible(true);
		meow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton button = new JButton("click");
		button.setBounds(350,285,100,30);
		meow.add(button);
		button.addActionListener(new Action());
		
		JLabel label = new JLabel();
		label.setBounds(400,315,100,50);
		meow.add(label);
		
		while(loop){
			label.setText(String.valueOf(clicks));
		}
	}
	
	static class Action implements ActionListener{
		public void actionPerformed(ActionEvent e){
			clicks++;
		}
	}
}