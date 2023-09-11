

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Task extends JPanel{
	
	JLabel index;
	JTextField taskName;
	JButton done;
	
	private boolean checked;
	
	Task()
	{

        Color lighterRed = new Color(255, 150, 150);
		this.setPreferredSize(new Dimension(400,20));
		this.setBackground(lighterRed);
		
		this.setLayout(new BorderLayout());
		
		checked = false;
		
		index = new JLabel("");
		index.setPreferredSize(new Dimension(20,20));
		index.setHorizontalAlignment(JLabel.CENTER);
		this.add(index,BorderLayout.WEST);

        
	
		taskName = new JTextField("Enter Task");
		taskName.setBorder(BorderFactory.createEmptyBorder());
		taskName.setBackground(lighterRed);

		
		this.add(taskName,BorderLayout.CENTER);
		
		done = new JButton("Done");
		done.setPreferredSize(new Dimension(40,20));
		done.setBorder(BorderFactory.createEmptyBorder());
		done.setFocusPainted(false);
		
		this.add(done,BorderLayout.EAST);
		
	}
	
	public void changeIndex(int num)
	{
		this.index.setText(num+"");
		this.revalidate();
	}
	
	
	public JButton getDone()
	{
		return done;
	}
	
	public boolean getState()
	{
		return checked;
	}
	
	public void changeState()
	{

        Color lighterGreen = new Color(150, 255, 150);
		this.setBackground(lighterGreen);
		taskName.setBackground(lighterGreen);
		checked = true;
		revalidate();
	}
}