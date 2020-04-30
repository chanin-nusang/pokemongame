import javax.swing.*;
import javax.swing.plaf.BorderUIResource;
import javax.swing.text.TabExpander;

import java.awt.*;
import java.awt.event.*;

public class GUI_shop extends JFrame{
	protected JFrame frame;
	protected JDialog dialog;

    public GUI_shop() {
		shopPage();
	}

    private void shopPage(){

		System.out.println(Trainer.getCoin());		

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

		System.out.println("Coin = " + Trainer.getCoin());	
		System.out.println("Ball = " + Trainer.getBall());
		System.out.println("Potion = " + Trainer.getPotion());

		JLabel Lab_coins = new JLabel("" + Trainer.getCoin());
		Lab_coins.setBounds(690, 20, 200, 50);
		Lab_coins.setFont(new Font("Pokemon Solid", Font.PLAIN, 22));
		frame.getContentPane().add(Lab_coins);
        

		JButton btn_item1 = new JButton("80");
		btn_item1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//coi = Trainer.getCoin();
				if(Trainer.getCoin() < 80){
					MyDialogPopup2 dialog = new MyDialogPopup2();
					dialog.setVisible(true);
				}
				else{
					System.out.println("\n" + Trainer.getCoin());
					Trainer.setCoin(Trainer.getCoin() - 80);
					System.out.println("Coin = " + Trainer.getCoin());
					Trainer.setBall(Trainer.getBall() + 20);
					System.out.println("Ball = " + Trainer.getBall());
					Lab_coins.setText("" + Trainer.getCoin());
				}
			}
		});
		btn_item1.setIcon(new ImageIcon("image/b_coins.png"));
		btn_item1.setBounds(155, 270, 110, 40);
		frame.getContentPane().add(btn_item1);
		btn_item1.setFont(new Font("Pokemon Solid", Font.PLAIN, 18));

		JButton btn_item2 = new JButton("350");
		btn_item2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Trainer.getCoin() < 350){
					MyDialogPopup2 dialog = new MyDialogPopup2();
					dialog.setVisible(true);
				}
				else{
					System.out.println("\n" + Trainer.getCoin());
					Trainer.setCoin(Trainer.getCoin() - 350);
					System.out.println("Coin = " + Trainer.getCoin());
					Trainer.setBall(Trainer.getBall() + 100);
					System.out.println("Ball = " + Trainer.getBall());
					Lab_coins.setText("" + Trainer.getCoin());
				}
			}
		});
		btn_item2.setIcon(new ImageIcon("image/b_coins.png"));
		btn_item2.setBounds(330, 270, 110, 40);
		frame.getContentPane().add(btn_item2);
		btn_item2.setFont(new Font("Pokemon Solid", Font.PLAIN, 18));

		JButton btn_item3 = new JButton("600");
		btn_item3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Trainer.getCoin() < 600){
					MyDialogPopup2 dialog = new MyDialogPopup2();
					dialog.setVisible(true);
				}
				else{
					System.out.println("\n" + Trainer.getCoin());
					Trainer.setCoin(Trainer.getCoin() - 600);
					System.out.println("Coin = " + Trainer.getCoin());
					Trainer.setBall(Trainer.getBall() + 200);
					System.out.println("Ball = " + Trainer.getBall());
					Lab_coins.setText("" + Trainer.getCoin());
				}
			}
		});
		btn_item3.setIcon(new ImageIcon("image/b_coins.png"));
		btn_item3.setBounds(510, 270, 110, 40);
		frame.getContentPane().add(btn_item3);
		btn_item3.setFont(new Font("Pokemon Solid", Font.PLAIN, 18));

		JButton btn_item4 = new JButton("800");
		btn_item4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Trainer.getCoin() < 800){
					MyDialogPopup2 dialog = new MyDialogPopup2();
					dialog.setVisible(true);
				}
				else{
					System.out.println("\n" + Trainer.getCoin());
					Trainer.setCoin(Trainer.getCoin() - 800);
					System.out.println("Coin = " + Trainer.getCoin());
					Trainer.setPotion(Trainer.getPotion() + 100);
					System.out.println("Potion = " + Trainer.getPotion());
					Lab_coins.setText("" + Trainer.getCoin());
				}
			}
		});
		btn_item4.setIcon(new ImageIcon("image/b_coins.png"));
		btn_item4.setBounds(155, 480, 110, 40);
		frame.getContentPane().add(btn_item4);
		btn_item4.setFont(new Font("Pokemon Solid", Font.PLAIN, 18));

		JButton btn_item5 = new JButton("1400");
		btn_item5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Trainer.getCoin() < 1400){
					MyDialogPopup2 dialog = new MyDialogPopup2();
					dialog.setVisible(true);
				}
				else{
					System.out.println("\n" + Trainer.getCoin());
					Trainer.setCoin(Trainer.getCoin() - 1400);
					System.out.println("Coin = " + Trainer.getCoin());
					Trainer.setPotion(Trainer.getPotion() + 200);
					System.out.println("Potion = " + Trainer.getPotion());
					Lab_coins.setText("" + Trainer.getCoin());
				}
			}
		});
		btn_item5.setIcon(new ImageIcon("image/b_coins.png"));
		btn_item5.setBounds(330, 480, 110, 40);
		frame.getContentPane().add(btn_item5);
		btn_item5.setFont(new Font("Pokemon Solid", Font.PLAIN, 18));

		JButton btn_item6 = new JButton("2000");
		btn_item6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Trainer.getCoin() < 2000){
					MyDialogPopup2 dialog = new MyDialogPopup2();
					dialog.setVisible(true);
				}
				else{
					System.out.println("\n" + Trainer.getCoin());
					Trainer.setCoin(Trainer.getCoin() - 2000);
					System.out.println("Coin = " + Trainer.getCoin());
					Trainer.setPotion(Trainer.getPotion() + 300);
					System.out.println("Potion = " + Trainer.getPotion());
					Lab_coins.setText("" + Trainer.getCoin());
				}
			}
		});
		btn_item6.setIcon(new ImageIcon("image/b_coins.png"));
		btn_item6.setBounds(510, 480, 110, 40);
		frame.getContentPane().add(btn_item6);
		btn_item6.setFont(new Font("Pokemon Solid", Font.PLAIN, 16));

		JLabel Lab_bagbg = new JLabel(" ");
		Lab_bagbg.setHorizontalAlignment(SwingConstants.CENTER);
		Lab_bagbg.setVerticalAlignment(SwingConstants.CENTER);
		Lab_bagbg.setIcon(new ImageIcon("image/bg_shop.jpg"));
		Lab_bagbg.setBounds(0, 0, 800, 600);
		frame.getContentPane().add(Lab_bagbg);
    }
}

class MyDialogPopup2 extends JDialog {
		
		public MyDialogPopup2() {

			setBounds(100, 100, 300, 175);
			setTitle("Warning!");
            setLocationRelativeTo(null);
            ImageIcon dia = new ImageIcon("image/pokemonicon.png");
            setIconImage(dia.getImage());
            getContentPane().setLayout(null);
			setBackground(Color.YELLOW);
			
			// Button OK
			JButton btnOK = new JButton();
			btnOK.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
            });
            btnOK.setIcon(new ImageIcon("image/b_ok.png"));
			btnOK.setBounds(90, 80, 100, 30);
			getContentPane().add(btnOK);

			JLabel Lab_enough = new JLabel("Your coins is not enough.");
			Lab_enough.setBounds(5, 30, 280, 50);
			Lab_enough.setHorizontalAlignment(SwingConstants.CENTER);
			getContentPane().add(Lab_enough);
			Lab_enough.setFont(new Font("Pokemon Solid", Font.PLAIN, 16));
            
            JLabel Lab_enoughbg = new JLabel(" ");
		    Lab_enoughbg.setIcon(new ImageIcon("image/editnamedialog.png"));
		    Lab_enoughbg.setBounds(0, 0, 296, 175);
            getContentPane().add(Lab_enoughbg);
			
		}
}