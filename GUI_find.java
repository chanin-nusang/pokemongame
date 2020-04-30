import javax.swing.*;
import javax.swing.plaf.BorderUIResource;
import java.awt.*;
import java.awt.event.*;

public class GUI_find extends JFrame{
    protected JFrame frame;

    public GUI_find() {
        findPokemon();
    }

    private void findPokemon(){

        frame = new JFrame("Pokemon Game");
        frame.setResizable(false);
		frame.setBounds(0, 0, 800, 600);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		ImageIcon img = new ImageIcon("image/pokemonicon.png");
        frame.setIconImage(img.getImage());
        
        JButton btn_menu = new JButton("");
		btn_menu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI_MainMenu mn = new GUI_MainMenu();
        		mn.frame.setVisible(true);
				frame.dispose();
			}
		});
		btn_menu.setIcon(new ImageIcon("image/b_menu.png"));
		btn_menu.setBounds(10, 10, 85, 40);
		frame.getContentPane().add(btn_menu);
		
		JLabel Lab_bb = new JLabel("" + Trainer.getBall());
		Lab_bb.setBounds(690, 25, 200, 50);
		Lab_bb.setFont(new Font("Pokemon Solid", Font.PLAIN, 22));
		frame.getContentPane().add(Lab_bb);

        JLabel Lab_pokbag = new JLabel(" ");
		Lab_pokbag.setIcon(new ImageIcon("image/findhead.png"));
		Lab_pokbag.setBounds(200, 30, 400, 105);
		frame.getContentPane().add(Lab_pokbag);


        JLabel Lab_bagbg = new JLabel(" ");
		Lab_bagbg.setIcon(new ImageIcon("image/bg_find.jpg"));
		Lab_bagbg.setBounds(0, 0, 800, 600);
		frame.getContentPane().add(Lab_bagbg);
    }
}