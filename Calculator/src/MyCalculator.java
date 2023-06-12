import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.JTextField;

public class MyCalculator extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String operation;
	private double num1,num2,res;
	
	private JButton 
	plusButton, 
	minusButton, 
	multButton, 
	divButton, 
	equButton,
	perButton,
	dotButton,
	clearButton;
	
	private JButton [] numbersButton= new JButton[10];
	private JButton[] operationButtons=new JButton[8];
	
	private JTextField text;
	
	private Font font=new Font("Serif BOLD",18,20);
	private JPanel panel;
	
	
	
	public MyCalculator() {


		text=new  JTextField();
		panel=new JPanel();
	
		text.setBounds(120,20,250,30);
		text.setFont(font);	
		text.setEditable(false);
	
		//creating operator buttons
		plusButton=new JButton("+");
		minusButton=new JButton("-");
		multButton=new JButton("*");
		divButton=new JButton("/");
		perButton=new JButton("%");
		equButton=new JButton("=");
		dotButton=new JButton(".");
		clearButton=new JButton("Clear");
		
		operationButtons[0]= plusButton;
		operationButtons[1]= minusButton;
		operationButtons[2]= multButton;
		operationButtons[3]= divButton;
		operationButtons[4]= perButton;
		operationButtons[5]= equButton;
		operationButtons[6]= dotButton;
		operationButtons[7]= clearButton;
		
		for(int i=0;i<operationButtons.length;i++) {
			operationButtons[i].setFont(font);
			operationButtons[i].setFocusable(false);
			operationButtons[i].addActionListener(new Action());

			operationButtons[i].setSize(100,100);
		}
		//creating number buttons
		for(int i=0;i<numbersButton.length;i++) {
			numbersButton[i]=new JButton(Integer.toString(i));
			numbersButton[i].addActionListener(new Action());
			numbersButton[i].setFont(font);
			numbersButton[i].setFocusable(false);
		}			
		
		//adding numbers to panel
		for(int i=0;i<numbersButton.length;i++) {
			panel.add(numbersButton[i],BorderLayout.EAST);
			}
		
		//adding operators to panel
		for(int i=0;i<operationButtons.length;i++) {
		panel.add(operationButtons[i],BorderLayout.EAST);
		}
		
		panel.setBounds(95,100, 300, 300);
		panel.setBackground(Color.gray);
		
		
	
		this.add(text);
		this.add(panel);
		
		this.setTitle("Calculator");		
		this.setLocation(500, 250);		
		this.setSize(500,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setVisible(true);
		
		
		
	}
	
	private class Action implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			for(int i=0;i<10;i++) {
				if(e.getSource()==numbersButton[i]) {
					text.setText(text.getText().concat(Integer.toString(i)));
				}	
			}
			if(e.getSource()==plusButton) {
				num1=Double.parseDouble(text.getText());
				
				operation="+";
				text.setText("");
				
			}
			if(e.getSource()==minusButton) {
				num1=Double.parseDouble(text.getText());
						
				//text.setText(text.getText().concat("-"));
				operation="-";
				text.setText("");
			}
			if(e.getSource()==multButton) {
				num1=Double.parseDouble(text.getText());
						
				//text.setText(text.getText().concat("*"));
				operation="*";
				text.setText("");
			}
			if(e.getSource()==divButton) {
				num1=Double.parseDouble(text.getText());
						
				//text.setText(text.getText().concat("/"));
				operation="/";

				text.setText("");
			}
			if(e.getSource()==perButton) {

				num1=Double.parseDouble(text.getText());
				
				operation="%";

				text.setText("");
			}
			if(e.getSource()==clearButton) {
				text.setText("");
				//operation="+";
				
			}
			if(e.getSource()==dotButton) {

				num1=Double.parseDouble(text.getText());
				text.setText(text.getText().concat("."));
				//operation=".";
				
			}
			if(e.getSource()==equButton) {
				//text.setText(text.getText().concat("+"));

				num2=Double.parseDouble(text.getText());

				text.setText("");
				switch(operation) {
				case "+":{
					res=num1+num2;
					break;
				}
				case "-":{
					res=num1-num2;
					break;
				}
				case "*":{
					res=num1*num2;
					break;
				}case "/":{
					
					res=num1/num2;
					break;
				}
				case "%":{
					res=num1%num2;
					break;
				}
				
				}
				text.setText(Double.toString(res));
				
			}
			
		}
		
		
		
		
		
		
	}	
}
