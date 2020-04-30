import javax.swing.*;
import javax.swing.plaf.BorderUIResource;
import java.awt.*;
import java.awt.event.*;

public class GUI_MainMenu extends JFrame{

    protected JFrame frame;
	protected String playerName;
	protected JTextField t1;
	//Trainer tnn;

    public GUI_MainMenu() {
		menu();
	}

	private void menu(){

		Trainer tn3 = new Trainer();
		
        //nameTn = tn.getName();
        //System.out.println(Trainer.getName());
		
        frame = new JFrame("Pokemon Game");
        frame.setResizable(false);
		frame.setBounds(0, 0, 800, 600);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		ImageIcon img = new ImageIcon("image/pokemonicon.png");
        frame.setIconImage(img.getImage());

        JLabel Lab_logo = new JLabel(" ");
		Lab_logo.setHorizontalAlignment(SwingConstants.CENTER);
		Lab_logo.setIcon(new ImageIcon("image/pokemongamelogo1.png"));
		Lab_logo.setBounds(0, 20, 784, 214);
		frame.getContentPane().add(Lab_logo);

		JLabel Lab_lv = new JLabel("" + Trainer.getLevel());
		Lab_lv.setBounds(215, 12, 200, 50);
		Lab_lv.setFont(new Font("Pokemon Solid", Font.PLAIN, 16));
		frame.getContentPane().add(Lab_lv);

		JLabel Lab_coin = new JLabel("" + Trainer.getCoin());
		Lab_coin.setBounds(330, 12, 200, 50);
		Lab_coin.setFont(new Font("Pokemon Solid", Font.PLAIN, 16));
		frame.getContentPane().add(Lab_coin);

		JLabel Lab_ball = new JLabel("" + Trainer.getBall());
		Lab_ball.setBounds(480, 12, 200, 50);
		Lab_ball.setFont(new Font("Pokemon Solid", Font.PLAIN, 16));
		frame.getContentPane().add(Lab_ball);

		JLabel Lab_po = new JLabel("" + Trainer.getPotion());
		Lab_po.setBounds(605, 12, 200, 50);
		Lab_po.setFont(new Font("Pokemon Solid", Font.PLAIN, 16));
		frame.getContentPane().add(Lab_po);

		JLabel Lab_sta = new JLabel(" ");
		Lab_sta.setHorizontalAlignment(SwingConstants.CENTER);
		Lab_sta.setIcon(new ImageIcon("image/mainstatus.png"));
		Lab_sta.setBounds(145, 5, 520, 60);
		frame.getContentPane().add(Lab_sta);
        
        JButton btn_bag = new JButton("");
		btn_bag.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI_bag bag = new GUI_bag();
        		bag.frame.setVisible(true);
				frame.dispose();
			}
		});
		btn_bag.setIcon(new ImageIcon("image/b_bag.png"));
		btn_bag.setBounds(340, 230, 120, 50);
        frame.getContentPane().add(btn_bag);
        
        JButton btn_find = new JButton("");
		btn_find.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI_find find = new GUI_find();
        		find.frame.setVisible(true);
				frame.dispose();
			}
		});
		btn_find.setIcon(new ImageIcon("image/b_find.png"));
		btn_find.setBounds(340, 290, 120, 50);
        frame.getContentPane().add(btn_find);
        
        JButton btn3 = new JButton("");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUI_shop shop = new GUI_shop();
        		shop.frame.setVisible(true);
				frame.dispose();
			}
		});
		btn3.setIcon(new ImageIcon("image/b_shop.png"));
		btn3.setBounds(340, 350, 120, 50);
        frame.getContentPane().add(btn3);
        
        JButton btn4 = new JButton("");
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tn3.levelUp();
				GUI_me me = new GUI_me();
        		me.frame.setVisible(true);
				frame.dispose();
			}
		});
		btn4.setIcon(new ImageIcon("image/b_me.png"));
		btn4.setBounds(340, 410, 120, 50);
        frame.getContentPane().add(btn4);
        
        JButton btn_exit = new JButton("");
		btn_exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btn_exit.setIcon(new ImageIcon("image/b_exit.png"));
		btn_exit.setBounds(340, 470, 120, 50);
        frame.getContentPane().add(btn_exit);
        
        JLabel Lab_menubg = new JLabel(" ");
		Lab_menubg.setIcon(new ImageIcon("image/mainmenu.gif"));
		Lab_menubg.setBounds(0, 0, 800, 600);
		frame.getContentPane().add(Lab_menubg);

    }

}