import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI_EnterPlayerName extends JFrame{

	protected JFrame frame;
	protected String playerName;
	protected JTextField t1;

	public GUI_EnterPlayerName() {
        player();
    }
    private void player() {
		
		Trainer tn = new Trainer();

		frame = new JFrame("Pokemon Game");
		frame.setResizable(false);
		frame.setBounds(0, 0, 800, 600);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		ImageIcon img = new ImageIcon("image/pokemonicon.png");
		frame.setIconImage(img.getImage());

		t1 = new JTextField();
		t1.setHorizontalAlignment(JTextField.CENTER);
		t1.setBounds(275, 280, 250,40);
		frame.getContentPane().add(t1);
		t1.setFont(new Font("Pokemon Solid", Font.PLAIN, 16));
		t1.setBackground(Color.YELLOW);
		t1.setColumns(10);

		JButton btn = new JButton("");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tn.setName(t1.getText());
				System.out.println(tn.getName());
				GUI_MainMenu mn = new GUI_MainMenu();
        		mn.frame.setVisible(true);
				frame.dispose();
			}
		});
		btn.setIcon(new ImageIcon("image/b_enter.png"));
		btn.setBounds(340, 342, 120, 50);
		frame.getContentPane().add(btn);

		JLabel Label3 = new JLabel(" ");
		Label3.setIcon(new ImageIcon("image/playernameenter.jpg"));
		Label3.setBounds(0, 0, 800, 600);
		frame.getContentPane().add(Label3);

	}
}