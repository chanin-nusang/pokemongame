import javax.swing.*;
import java.awt.event.*;

public class GUI_WelcomePage extends JFrame{

	protected JFrame frame;

	public GUI_WelcomePage() {
		welcome();
	}

	private void welcome() {

        frame = new JFrame("Pokemon Game");
        frame.setResizable(false);
		frame.setBounds(0, 0, 800, 600);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		ImageIcon img = new ImageIcon("image/pokemonicon.png");
		frame.setIconImage(img.getImage());
		
		JLabel Label1 = new JLabel(" ");
		Label1.setHorizontalAlignment(SwingConstants.CENTER);
		Label1.setIcon(new ImageIcon("image/pokemongamelogo1.png"));
		Label1.setBounds(0, 102, 784, 214);
		frame.getContentPane().add(Label1);
		
		JLabel Label2 = new JLabel(" ");
		Label2.setIcon(new ImageIcon("image/welcome.gif"));
		Label2.setBounds(0, 0, 800, 600);
		frame.getContentPane().add(Label2);
		
		frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if( e.getKeyCode() == KeyEvent.VK_ESCAPE);
				GUI_EnterPlayerName pn = new GUI_EnterPlayerName();
        		pn.frame.setVisible(true);
				frame.dispose();
			}
        });
	}
}