import javax.swing.*;
import javax.swing.table.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GUI_bag extends JFrame{
	public static  JFrame frame;
	private final Color alphaZero = new Color(0, true);
	JButton button = new JButton();

    public GUI_bag() {
        pokemoninBag();
    }

    private void pokemoninBag(){

		Trainer pp = new Trainer();
		Object[][] data = new Object[pp.getBag().size()][5];

		ArrayList<Pokemon> pok = pp.getBag();

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
				pp.levelUp();
				GUI_MainMenu mn = new GUI_MainMenu();
        		mn.frame.setVisible(true);
				frame.dispose();
			}
		});
		btn_menu.setIcon(new ImageIcon("image/b_menu.png"));
		btn_menu.setBounds(10, 10, 85, 40);
		frame.getContentPane().add(btn_menu);
	
		System.out.println("Bag size : " + pok.size());

		for(int i=0 ; i < pok.size() ; i++){
			System.out.println(i + " " + pok.get(i).getName() + "\tHP : " + pok.get(i).getHP());
			data[i][0]  = pok.get(i).getName();
			data[i][1]  = "HP : " + pok.get(i).getHP();
			data[i][2]  = "";
			data[i][3]  = "";
			data[i][4]  = "";
		}

		String columnHeaders[] =  {" "," "," "," "," "};

		JTable table=new JTable(data,columnHeaders);
			  
		table.getColumnModel().getColumn(2).setCellRenderer(new ButtonRenderer());;
		table.getColumnModel().getColumn(3).setCellRenderer(new ButtonRenderer1());;
		table.getColumnModel().getColumn(4).setCellRenderer(new ButtonRenderer2());;

		table.getColumnModel().getColumn(3).setCellEditor(new ButtonEditor1(new JTextField()));
		table.getColumnModel().getColumn(4).setCellEditor(new ButtonEditor2(new JTextField()));

		JScrollPane pane = new JScrollPane(table);
		pane.setBounds(0, 150, 800, 410);
		pane.setOpaque(false);
		pane.setViewportView(table);
		pane.getViewport().setOpaque(false);
		pane.setBorder(BorderFactory.createEmptyBorder());
		frame.getContentPane().add(pane);

		table.getTableHeader().setFont(new Font("Pokemon Solid", Font.PLAIN, 16));
		table.getTableHeader().setForeground(Color.blue);
		table.getTableHeader().setBackground(alphaZero);
		table.getTableHeader().setResizingAllowed(false);
		table.setForeground(Color.black);
		table.setOpaque(false);
		((DefaultTableCellRenderer)table.getDefaultRenderer(Object.class)).setOpaque(false);
		table.setShowGrid(false);
		table.setRowHeight(150);
		table.setFont(new Font("Pokemon Solid", Font.PLAIN, 16));
		table.setEnabled(true);
		UIManager.getDefaults().put("TableHeader.cellBorder" , BorderFactory.createEmptyBorder(0,0,0,0));
			  
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		centerRenderer.setOpaque(false);
		table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);

		JLabel Lab_po = new JLabel("" + Trainer.getPotion());
		Lab_po.setBounds(690, 25, 200, 50);
		Lab_po.setFont(new Font("Pokemon Solid", Font.PLAIN, 22));
		frame.getContentPane().add(Lab_po);

		JLabel Lab_pobg = new JLabel(" ");
		Lab_pobg.setIcon(new ImageIcon("image/potions.png"));
		Lab_pobg.setBounds(625, 5, 246, 82);
		frame.getContentPane().add(Lab_pobg);
	
        JLabel Lab_pokbag = new JLabel(" ");
		Lab_pokbag.setIcon(new ImageIcon("image/pokemoninbag.png"));
		Lab_pokbag.setBounds(200, 30, 400, 80);
		frame.getContentPane().add(Lab_pokbag);

        JLabel Lab_bagbg = new JLabel(" ");
		Lab_bagbg.setIcon(new ImageIcon("image/bg_bag.gif"));
		Lab_bagbg.setBounds(0, 0, 800, 600);
		frame.getContentPane().add(Lab_bagbg);

	}
}

class ButtonRenderer extends JButton implements  TableCellRenderer
{
	Trainer pp = new Trainer();
	ArrayList<Pokemon> pok = pp.getBag();

  public ButtonRenderer() {
	setOpaque(true);
  }
  @Override
  public Component getTableCellRendererComponent(JTable table, Object obj, boolean selected, boolean focused, int row, int col) {

      setText((obj==null) ? "":obj.toString());
	  int r = row;
	  ImageIcon icon = new ImageIcon(getClass().getResource(pok.get(r).getImage()));    
	  setIcon(icon);
	  setOpaque(false);
		setContentAreaFilled(false);
		setBorderPainted(false);
	return this;
  }

}

class ButtonRenderer1 extends JButton implements  TableCellRenderer
{
	public ButtonRenderer1() {
		setOpaque(true);
		setIcon(new ImageIcon("image/editnamepok.png"));
  	}
  	@Override
  	public Component getTableCellRendererComponent(JTable table, Object obj, boolean selected, boolean focused, int row, int col) {
		setText((obj==null) ? "":obj.toString());
	  	setOpaque(false);
		setContentAreaFilled(false);
		setBorderPainted(false);
    	return this;
  	}
}

class ButtonEditor1 extends DefaultCellEditor
{
	protected JButton btn;
   	private String lbl;
   	protected int rw;
   	private Boolean clicked;

   	public ButtonEditor1(JTextField txt) {
    	super(txt);
    	btn=new JButton();
		btn.setOpaque(true);
		btn.setIcon(new ImageIcon("image/editnamepok.png"));
		btn.setOpaque(false);
		btn.setContentAreaFilled(false);
		btn.setBorderPainted(false);
	    btn.addActionListener(new ActionListener() {
      	@Override
      	public void actionPerformed(ActionEvent e) {
			fireEditingStopped();
      	}
    });
}

	@Override
  	public Component getTableCellEditorComponent(JTable table, Object obj,
    	boolean selected, int row, int col) {
	 		lbl=(obj==null) ? "":obj.toString();
	 		rw = row;
	 		btn.setText(lbl);
     		clicked=true;
    		return btn;
  		}

	@Override
  	public Object getCellEditorValue() {
     	if(clicked){
			RenamePokemon dialog = new RenamePokemon(rw);
			dialog.setModal(true);
			dialog.setVisible(true);
    	}
    clicked=false;
    return new String(lbl);
	}

	@Override
  	public boolean stopCellEditing() {
		clicked=false;
    	return super.stopCellEditing();
 	}

	@Override
	protected void fireEditingStopped() {
    	super.fireEditingStopped();
	}
}

class ButtonRenderer2 extends JButton implements  TableCellRenderer{

	public ButtonRenderer2() {
		setOpaque(true);
		setIcon(new ImageIcon("image/potionplus.png"));
	}
  	@Override
  	public Component getTableCellRendererComponent(JTable table, Object obj, boolean selected, boolean focused, int row, int col) {
	  	setText((obj==null) ? "":obj.toString());
	  	setOpaque(false);
		setContentAreaFilled(false);
		setBorderPainted(false);
		return this;
	}
}

class ButtonEditor2 extends DefaultCellEditor{
	protected JButton btn;
   	private String lbl;
   	protected int rw;
   	private Boolean clicked;

   	public ButtonEditor2(JTextField txt) {
    	super(txt);
    	btn=new JButton();
		btn.setOpaque(true);
		btn.setIcon(new ImageIcon("image/potionplus.png"));
		btn.setOpaque(false);
		btn.setContentAreaFilled(false);
		btn.setBorderPainted(false);
	    btn.addActionListener(new ActionListener() {
			@Override
      		public void actionPerformed(ActionEvent e) {
				fireEditingStopped();
      		}
    	});
	}

	@Override
  	public Component getTableCellEditorComponent(JTable table, Object obj,boolean selected, int row, int col) {
		lbl=(obj==null) ? "":obj.toString();
	 	btn.setFont(new Font("Pokemon Solid", Font.PLAIN, 18));
	 	clicked=true;
	 	rw = row;
    	return btn;
  	}

   	@Override
  	public Object getCellEditorValue() {
     	if(clicked){
			if(Trainer.getPotion() <= 0){
				MyDialogPopup3 dialog = new MyDialogPopup3();
				dialog.setVisible(true);		
			}
			else{
				Trainer.getBag().get(rw).setHP(Trainer.getBag().get(rw).getHP()+10);
				Trainer.setPotion(Trainer.getPotion()-1);
				Trainer.setXP(Trainer.getXP() + 1);
				GUI_bag.frame.dispose();
				GUI_bag mn = new GUI_bag();
				mn.frame.setVisible(true);
			}
      	}
    	clicked=false;
    	return new String(lbl);
  	}

   	@Override
  	public boolean stopCellEditing() {
      	clicked=false;
    	return super.stopCellEditing();
  	}

   	@Override
  	protected void fireEditingStopped() {
    	super.fireEditingStopped();
  	}
}

class RenamePokemon extends JDialog {

    public String sName;

	public RenamePokemon(int ind) {

		Trainer tn5 = new Trainer();

		setBounds(100, 100, 296, 175);
		setTitle("Rename Pokemon");
		setLocationRelativeTo(null);
		ImageIcon dia = new ImageIcon("image/pokemonicon.png");
		setIconImage(dia.getImage());
		getContentPane().setLayout(null);
		setBackground(Color.YELLOW);
		
		final JTextField name = new JTextField(tn5.getBag().get(ind).getName()); 
		name.setBounds(57, 36, 175, 30);
		getContentPane().add(name);
		name.setFont(new Font("Pokemon Solid", Font.PLAIN, 16));
		
		JButton btnOK = new JButton();
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sName = name.getText();
				tn5.getBag().get(ind).setName(sName);
				System.out.println("Name Change : " + tn5.getBag().get(ind).getName());
				GUI_bag.frame.dispose();
				GUI_bag mn = new GUI_bag();
				mn.frame.setVisible(true);
				dispose();
			}
		});
		btnOK.setIcon(new ImageIcon("image/b_ok.png"));
		btnOK.setBounds(35, 93, 100, 30);
		getContentPane().add(btnOK);
		
		JButton btnCancel = new JButton();
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sName = tn5.getBag().get(ind).getName();
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

class MyDialogPopup3 extends JDialog {
		
	public MyDialogPopup3() {

		setBounds(100, 100, 300, 175);
		setTitle("Warning!");
		setLocationRelativeTo(null);
		ImageIcon dia = new ImageIcon("image/pokemonicon.png");
		setIconImage(dia.getImage());
		getContentPane().setLayout(null);
		setBackground(Color.YELLOW);
		
		JButton btnOK = new JButton();
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnOK.setIcon(new ImageIcon("image/b_ok.png"));
		btnOK.setBounds(90, 80, 100, 30);
		getContentPane().add(btnOK);

		JLabel Lab_enough = new JLabel("Potion is not enough.");
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