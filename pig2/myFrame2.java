import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class myFrame2 extends JFrame implements ActionListener{
	
	JButton button;
	JTextField name;
	int times;
	
	myFrame2(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		
		button = new JButton("Submit");
		button.addActionListener(this);
		
		name = new JTextField("Player 1");
		name.setPreferredSize(new Dimension(100,20));
		
		this.add(button);
		this.add(name);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		times = 0;
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==button){
			if(times == 0){
				myFrame.player1.setText(name.getText() + ": 0");
				myFrame.player1s = name.getText();
				myFrame.turnField.setText(name.getText() + "'s turn");
				name.setText("Player 2");
				times = 1;
			}else{
				myFrame.player2.setText(name.getText() + ": 0");
				myFrame.player2s = name.getText();
				myFrame.button1.setEnabled(true);
				myFrame.button2.setEnabled(true);
				this.setVisible(false);
			}
		}
	}
}