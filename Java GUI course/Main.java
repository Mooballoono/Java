import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;

public class Main{
	
	public static void main(String[]args){
		
		ImageIcon image = new ImageIcon("STARE.png"); //create an ImageIcon
		Border border = BorderFactory.createLineBorder(Color.green,3);
		
		JLabel label = new JLabel(); //create a label
		label.setText("Bro, do you even code?"); //set text of label
		label.setIcon(image);
		label.setHorizontalTextPosition(JLabel.CENTER); //set text LEFT,CENTER,RIGHT of imageicon
		label.setVerticalTextPosition(JLabel.TOP); //set text TOP,CENTER,BOTTOM of imageicon
		label.setForeground(new Color(0x00FF00)); //set font color of text
		label.setFont(new Font("MV Boli",Font.PLAIN,50)); //set font of text
		label.setIconTextGap(-25); //set gap of text to image
		label.setBackground(Color.black); //set background color
		label.setOpaque(true); //display background color
		label.setBorder(border);
		label.setVerticalAlignment(JLabel.CENTER); //set vertical position of icon+text within label
		label.setHorizontalAlignment(JLabel.CENTER); //set horizontal position of icon+text within label
		//label.setBounds(100,100,350,350); //set x,y position within frame as well as dimension
		
		
		JFrame frame = new JFrame();
		frame.setTitle("JFrame title goes here"); //sets title of frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit out of application
		frame.setResizable(true); //prevent frame from being resized
		//frame.setSize(500,500); // sets the x-dimension, and y-dimension of frame
		//frame.setLayout(null);
		frame.setVisible(true); //make frame visible
		frame.add(label);
		frame.pack();
		
		frame.setIconImage(image.getImage()); //change icon of frame
		frame.getContentPane().setBackground(new Color(0x189bcc)); //change color of background
	}
}