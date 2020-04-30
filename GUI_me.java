import javax.swing.*;
import javax.swing.plaf.BorderUIResource;
import java.awt.*;
import java.awt.event.*;

public class GUI_me extends JFrame{
    protected JFrame frame;
    protected JDialog dialog;
    //public String sName;
    //Trainer nameTrainer;
    //Trainer tn = new Trainer();

    

    public GUI_me() {
        
        meInfo(); //(new Trainer().getName());  //(tn.getName());
    }

    private void meInfo(){ //(String nameTn){
    //public GUI_me(){
        
        //String nameTn;

        Trainer tnn = new Trainer();
        //nameTn = tnn.getName();
        System.out.println(tnn.getName());

        //System.out.println(nameTn);
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

        JLabel Lab_name = new JLabel(tnn.getName()); 
        Lab_name.setBounds(250, 205, 200, 50);
        Lab_name.setFont(new Font("Pokemon Solid", Font.PLAIN, 16));
        frame.getContentPane().add(Lab_name);

        JButton btn_edit = new JButton("");
		btn_edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyDialogPopup dialog = new MyDialogPopup();
				dialog.setModal(true);
                dialog.setVisible(true);
				
				Lab_name.setText(tnn.getName());
			}
		});
		btn_edit.setIcon(new ImageIcon("image/b_edit.png"));
		btn_edit.setBounds(425, 220, 60, 25);
        frame.getContentPane().add(btn_edit);

        JLabel Lab_lv = new JLabel(" " + tnn.getLevel());
        Lab_lv.setBounds(330, 315, 200, 50);
        Lab_lv.setFont(new Font("Pokemon Solid", Font.PLAIN, 36));
        frame.getContentPane().add(Lab_lv);

        JLabel Lab_xp = new JLabel(tnn.getXP() + " / " + tnn.getXPMax());
        Lab_xp.setHorizontalAlignment(JLabel.CENTER);
        Lab_xp.setBounds(240, 345, 150, 200);
        Lab_xp.setFont(new Font("Pokemon Solid", Font.PLAIN, 24));
        frame.getContentPane().add(Lab_xp);

        JLabel Lab_tn = new JLabel(" ");
		Lab_tn.setIcon(new ImageIcon("image/trn.gif"));
		Lab_tn.setBounds(480, 50, 264, 450);
        frame.getContentPane().add(Lab_tn);

        JLabel Lab_meinfo = new JLabel(" ");
		Lab_meinfo.setIcon(new ImageIcon("image/meinfo.png"));
		Lab_meinfo.setBounds(90, 150, 600, 370);
        frame.getContentPane().add(Lab_meinfo);
        
        JLabel Lab_pokbag = new JLabel(" ");
		Lab_pokbag.setIcon(new ImageIcon("image/me.png"));
		Lab_pokbag.setBounds(270, 30, 243, 100);
		frame.getContentPane().add(Lab_pokbag);

        JLabel Lab_bagbg = new JLabel(" ");
		Lab_bagbg.setIcon(new ImageIcon("image/bg_me.png"));
		Lab_bagbg.setBounds(0, 0, 800, 600);
		frame.getContentPane().add(Lab_bagbg);
    }

}

class MyDialogPopup extends JDialog {

    public String sName;

		public MyDialogPopup() {

            Trainer tn2 = new Trainer();

			setBounds(100, 100, 296, 175);
			setTitle("Rename");
            setLocationRelativeTo(null);
            ImageIcon dia = new ImageIcon("image/pokemonicon.png");
            setIconImage(dia.getImage());
            getContentPane().setLayout(null);
            setBackground(Color.YELLOW);
            
			
			// Create Input 
			final JTextField name = new JTextField(tn2.getName());
			name.setBounds(57, 36, 175, 30);
            getContentPane().add(name);
            name.setFont(new Font("Pokemon Solid", Font.PLAIN, 16));
			
			// Button OK
			JButton btnOK = new JButton();
			btnOK.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
                    sName = name.getText();
                    tn2.setName(name.getText());
					dispose();
				}
            });
            btnOK.setIcon(new ImageIcon("image/b_ok.png"));
			btnOK.setBounds(35, 93, 100, 30);
			getContentPane().add(btnOK);
			
			// Button Cancel
			JButton btnCancel = new JButton();
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
                    sName = tn2.getName();
					dispose();
				}
            });
            btnCancel.setIcon(new ImageIcon("image/b_cancel.png"));
			btnCancel.setBounds(145, 93, 100, 30);
            getContentPane().add(btnCancel);
            
            JLabel Lab_editbg = new JLabel(" ");
		    Lab_editbg.setIcon(new ImageIcon("image/editnamedialog.png"));
		    Lab_editbg.setBounds(0, 0, 296, 175);
            getContentPane().add(Lab_editbg);
			
		}
}