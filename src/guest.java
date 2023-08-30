import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class guest {
	
	SQLoperations manage;
	int[] opt;
	int k;
	
	public void guestView(String surveyCode) throws SQLException {
		
		manage = new SQLoperations();
		ResultSet rst = manage.getQuestions(surveyCode);
		opt = new int[50];
		
		Font options = new Font("Times New Roman", Font.BOLD, 15);
		
		JFrame frame = new JFrame();
		frame.setSize(800, 600);
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);

		JLabel start = new JLabel("ATTENDING THE QUIZ");
		start.setBounds(0, 50, 800, 50);
		start.setHorizontalAlignment(JLabel.CENTER);
		start.setFont(new Font("Times New Roman", Font.BOLD, 40));
		frame.add(start);
		
		JLabel ques = new JLabel("Question Here!!!");
		ques.setBounds(80, 200, 500, 30);
		ques.setFont(new Font("Times New Roman", Font.BOLD, 18));
		frame.add(ques);
		
		JRadioButton op1 = new JRadioButton("Option1");
		JRadioButton op2 = new JRadioButton("Option2");
		JRadioButton op3 = new JRadioButton("Opyion3");
		JRadioButton op4 = new JRadioButton("Option4");
		
		ButtonGroup bgroup = new ButtonGroup();
		bgroup.add(op1);
		bgroup.add(op2);
		bgroup.add(op3);
		bgroup.add(op4);
		
		op1.setBounds(100, 250, 500, 30);
		op2.setBounds(100, 300, 500, 30);
		op3.setBounds(100, 350, 500, 30);
		op4.setBounds(100, 400, 500, 30);
		
		op1.setFont(options);
		op2.setFont(options);
		op3.setFont(options);
		op4.setFont(options);
		
		if(rst.next()) {
			ques.setText(rst.getString("question"));
			op1.setText(rst.getString("option1"));
			op2.setText(rst.getString("option2"));
			op3.setText(rst.getString("option3"));
			op4.setText(rst.getString("option4"));
		}
		
		frame.add(op1);
		frame.add(op2);
		frame.add(op3);
		frame.add(op4);
		k=0;
		
		JButton nextButton = new JButton("NEXT");
		nextButton.setBounds(100, 470, 600, 50);
		frame.add(nextButton);
		nextButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int x;
				if(op1.isSelected()) {
					x=1;
				}
				else if(op2.isSelected()) {
					x=2;
				}
				else if(op3.isSelected()) {
					x=3;
				}
				else if(op4.isSelected()) {
					x=4;
				}
				else
					x=0;
				
				if(x!=0) {		
					opt[k] = x;
					k++;
					try {
						if(rst.next()) {
							ques.setText(rst.getString("question"));
							op1.setText(rst.getString("option1"));
							op2.setText(rst.getString("option2"));
							op3.setText(rst.getString("option3"));
							op4.setText(rst.getString("option4"));
						}
						else {
							for(int j=0; j<k; j++) {
								manage.answerUpdt(surveyCode, j+1, opt[j]);
							}
							JOptionPane.showMessageDialog(frame, "Quiz Completed. Thank You.", "Congradulations", JOptionPane.PLAIN_MESSAGE);
							manage.addTotal();
							frame.dispose();
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
				else {
					JOptionPane.showMessageDialog(frame, "Select an option!", "Warning", JOptionPane.WARNING_MESSAGE);
				}
				bgroup.clearSelection();
			}
		});
		
		
		frame.setVisible(true);
		
	}
}
