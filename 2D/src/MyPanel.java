import javax.swing.JPanel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyPanel extends JPanel implements ActionListener{
	
	final int PANEL_WIDTH = 500;
	final int PANEL_HEIGHT = 500;
	Image enemy;
	Image backgroundImage;
	Timer timer;
	int xVelocity = 15;
	int yVelocity = 20;
	int x = 0;
	int y = 0;
	
	
	MyPanel(){
		this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
		this.setBackground(Color.green);
		enemy = new ImageIcon("pilka.png").getImage();
		timer = new Timer(2, this);
		timer.start();
		
	}
	
	public void paint(Graphics g) {
		
		super.paint(g);
		Graphics2D g2D = (Graphics2D) g;
		g2D.drawImage(enemy, x, y, null);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(x>=PANEL_WIDTH-enemy.getWidth(null) || x<0) {
			xVelocity = xVelocity * (-1);
		}
		
		x = x + xVelocity;
		repaint();
		
		if(y>=PANEL_HEIGHT-enemy.getHeight(null) || y<0) {
			yVelocity = yVelocity * (-1);
		}
		
		y= y + yVelocity;
		repaint();
		
	}
}
