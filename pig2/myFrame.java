import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class myFrame extends JFrame implements ActionListener{
	
	public static JTextField player1;
	public static JTextField player2;
	public static String player1s;
	public static String player2s;
	public static JButton button1;
	public static JButton button2;
	public static JTextField turnField;
	JLabel d1;
	JLabel d2;
	JTextField points;
	boolean turn;
	int die1;
	int die2;
	int total;
	int p1;
	int p2;
	
	myFrame(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setSize(500,500);
		this.setLocationRelativeTo(null);
		
		player1 = new JTextField();
		player1.setBounds(0,0,100,20);
		player1.setEditable(false);
		
		player2 = new JTextField();
		player2.setBounds(400,0,100,20);
		player2.setEditable(false);
		
		d1 = new JLabel();
		d1.setBounds(75,50,150,150);
		d1.setBorder(BorderFactory.createLineBorder(Color.black));
		d1.setFont(new Font("Serif",Font.PLAIN,100));
		d1.setHorizontalAlignment(JLabel.CENTER);
		d1.setVerticalAlignment(JLabel.CENTER);
		
		d2 = new JLabel();
		d2.setBounds(275,50,150,150);
		d2.setBorder(BorderFactory.createLineBorder(Color.black));
		d2.setFont(new Font("Serif",Font.PLAIN,100));
		d2.setHorizontalAlignment(JLabel.CENTER);
		d2.setVerticalAlignment(JLabel.CENTER);
		
		turnField = new JTextField();
		turnField.setHorizontalAlignment(JTextField.CENTER);
		turnField.setBounds(200,0,100,20);
		turnField.setEditable(false);
		
		points = new JTextField();
		points.setHorizontalAlignment(JTextField.CENTER);
		points.setBounds(200,220,100,20);
		points.setEditable(false);
		
		button1 = new JButton("Roll");
		button1.addActionListener(this);
		button1.setBackground(Color.green);
		button1.setBounds(100,300,100,100);
		button1.setEnabled(false);
		
		button2 = new JButton("Stop");
		button2.addActionListener(this);
		button2.setBackground(Color.red);
		button2.setBounds(300,300,100,100);
		button2.setEnabled(false);
		
		this.add(player1);
		this.add(player2);
		this.add(turnField);
		this.add(button1);
		this.add(button2);
		this.add(points);
		this.add(d1);
		this.add(d2);
		this.setVisible(true);
		
		p1 = 0;
		p2 = 0;
		turn = true;
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		
		if(e.getSource() == button1){
			die1 = (int)(Math.round(Math.random()*6));
			if(die1 == 0){
				die1 = 6;
			}
			die2 = (int)(Math.round(Math.random()*6));
			if(die2 == 0){
				die2 = 6;
			}
			total += die1 + die2;
			d1.setText(Integer.toString(die1));
			d2.setText(Integer.toString(die2));
			if(die1 == 1 && die2 == 1){
				total = 0;
				if(turn){
					turn = false;
					turnField.setText(player2s + "'s turn");
					p1 = 0;
					player1.setText(player1s + ": " + p1);
				}else{
					turn = true;
					turnField.setText(player1s + "'s turn");
					p2 = 0;
					player2.setText(player2s + ": " + p2);
				}
			}else if(die1 == 1 || die2 == 1){
				total = 0;
				if(turn){
					turn = false;
					turnField.setText(player2s + "'s turn");
				}else{
					turn = true;
					turnField.setText(player1s + "'s turn");
				}
			}
			points.setText("total: " + total);
		}
		if(e.getSource() == button2){
			if(turn){
				p1 += total;
				player1.setText(player1s + ": " + p1);
				turn = false;
				turnField.setText(player2s + "'s turn");
			}else{
				p2 += total;
				player2.setText(player2s + ": " + p2);
				turn = true;
				turnField.setText(player1s + "'s turn");
			}
			total = 0;
			points.setText("total: " + total);
			if(p1 >= 100){
				points.setBounds(100,220,300,60);
				points.setText(player1s + " wins!\nclose game");
				button1.setEnabled(false);
				button2.setEnabled(false);
			}
			if(p2 >= 100){
				points.setBounds(100,220,300,60);
				points.setText(player2s + " wins!\nclose game");
				button1.setEnabled(false);
				button2.setEnabled(false);
			}
		}
	}
}