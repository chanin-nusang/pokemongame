import javax.swing.*;
import javax.swing.plaf.BorderUIResource;
import javax.swing.table.*;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GUI_find extends JFrame{
	protected JFrame frame;
	private final Color alphaZero = new Color(0, true);
	public static ArrayList<Pokemon> pk = new ArrayList<Pokemon>();
	


    public GUI_find() {
        findPokemon();
    }

    private void findPokemon(){

		//Trainer fi = new Trainer();
		pk = PokemonRandomizer.getPokemons(30);

		Object[][] data = new Object[pk.size()][4];

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
				Trainer.levelUp();
				GUI_MainMenu mn = new GUI_MainMenu();
        		mn.frame.setVisible(true);
				frame.dispose();
			}
		});
		btn_menu.setIcon(new ImageIcon("image/b_menu.png"));
		btn_menu.setBounds(10, 10, 85, 40);
		frame.getContentPane().add(btn_menu);
		
		

		for(int i=0 ; i < pk.size() ; i++){
			System.out.println(i + " " + pk.get(i).getName() + "\tHP : " + pk.get(i).getHP());// print pokemon in pokemons ArrayList
			data[i][0]  = pk.get(i).getName();
			data[i][1]  = "HP : " + pk.get(i).getHP();
			data[i][2]  = "";
			data[i][3]  = "";
		}

		String columnHeaders[] =  {" "," "," "," "};

		JTable table=new JTable(data,columnHeaders);
			  
		table.getColumnModel().getColumn(2).setCellRenderer(new ButtonRenderer4());;
		table.getColumnModel().getColumn(3).setCellRenderer(new ButtonRenderer5());;
  
		table.getColumnModel().getColumn(3).setCellEditor(new ButtonEditor5(new JTextField()));

		JScrollPane pane = new JScrollPane(table);
		pane.setBounds(50, 150, 800, 410);
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

class ButtonRenderer4 extends JButton implements  TableCellRenderer
{
	

  //CONSTRUCTOR
  public ButtonRenderer4() {
    //SET BUTTON PROPERTIES
	setOpaque(true);
	//setIcon(new ImageIcon("image/editnamepok.png"));
  }
  @Override
  public Component getTableCellRendererComponent(JTable table, Object obj, boolean selected, boolean focused, int row, int col) {

    //SET PASSED OBJECT AS BUTTON TEXT
      setText((obj==null) ? "":obj.toString());
	  int r = row;
	  ImageIcon icon = new ImageIcon(getClass().getResource(GUI_find.pk.get(r).getImage()));    
	  setIcon(icon);
	  setOpaque(false);
		setContentAreaFilled(false);
		setBorderPainted(false);
	return this;
  }

}

class ButtonRenderer5 extends JButton implements  TableCellRenderer
{

  //CONSTRUCTOR
  public ButtonRenderer5() {
    //SET BUTTON PROPERTIES
	setOpaque(true);
	setIcon(new ImageIcon("image/b_catch.png"));
  }
  @Override
  public Component getTableCellRendererComponent(JTable table, Object obj, boolean selected, boolean focused, int row, int col) {

    //SET PASSED OBJECT AS BUTTON TEXT
	  setText((obj==null) ? "":obj.toString());
	  setOpaque(false);
		setContentAreaFilled(false);
		setBorderPainted(false);
    return this;
  }

}

//BUTTON EDITOR CLASS
class ButtonEditor5 extends DefaultCellEditor
{
  protected JButton btn;
   private String lbl;
   protected int rw;
   private Boolean clicked;

   public ButtonEditor5(JTextField txt) {
    super(txt);

    btn=new JButton();
	btn.setOpaque(true);
	btn.setIcon(new ImageIcon("image/b_catch.png"));
	btn.setOpaque(false);
		btn.setContentAreaFilled(false);
		btn.setBorderPainted(false);


    //WHEN BUTTON IS CLICKED
    btn.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {

        fireEditingStopped();
      }
    });
  }

   //OVERRIDE A COUPLE OF METHODS
   @Override
  public Component getTableCellEditorComponent(JTable table, Object obj,
      boolean selected, int row, int col) {

      //SET TEXT TO BUTTON,SET CLICKED TO TRUE,THEN RETURN THE BTN OBJECT
	 lbl=(obj==null) ? "":obj.toString();
	 rw = row;
	 
	 btn.setText(lbl);
     clicked=true;
    return btn;
  }

  //IF BUTTON CELL VALUE CHNAGES,IF CLICKED THAT IS
   @Override
  public Object getCellEditorValue() {

     if(clicked)
      {
      //SHOW US SOME MESSAGE
		//JOptionPane.showMessageDialog(btn, lbl+" Clicked");
		SelectPokemonPopup dialog = new SelectPokemonPopup(rw);
		dialog.setModal(true);
		dialog.setVisible(true);


		//Lab_name.setText(tnn.getName());
      }
    //SET IT TO FALSE NOW THAT ITS CLICKED
    clicked=false;
    return new String(lbl);
  }

   @Override
  public boolean stopCellEditing() {

         //SET CLICKED TO FALSE FIRST
	  clicked=false;

    return super.stopCellEditing();
  }

   @Override
  protected void fireEditingStopped() {
    // TODO Auto-generated method stub
    super.fireEditingStopped();
  }
}

class SelectPokemonPopup extends JDialog {
		
	public SelectPokemonPopup(int ind) {

		ArrayList<Pokemon> mybag = new ArrayList<Pokemon>();
		mybag = Trainer.getBag();

		setBounds(100, 100, 300, 200);
		setTitle("Select your Pokemon in bag");
		setLocationRelativeTo(null);
		ImageIcon dia = new ImageIcon("image/pokemonicon.png");
		setIconImage(dia.getImage());
		getContentPane().setLayout(null);
		setBackground(Color.YELLOW);

		// Combobox
		String[] pokStrings = new String[mybag.size()];

		for(int i=0 ; i < mybag.size(); i++){
			pokStrings[i] = (i+1) + " " + mybag.get(i).getName() + "  HP : " + mybag.get(i).getHP();
		}

		final JComboBox comboBox = new JComboBox(pokStrings);
		//comboBox.setModel(new DefaultComboBoxModel<>(pokStrings));
		comboBox.setSelectedIndex(0);
		comboBox.setBounds(45, 60, 200, 25);
		getContentPane().add(comboBox);
		
		
		// Button OK
		JButton btnOK = new JButton();
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,
					Trainer.catchPokemon(ind, comboBox.getSelectedIndex()));

				Trainer.setBall(Trainer.getBall()-1);
				Trainer.setXP(Trainer.getXP()+2);
				System.out.println("Ball = " + Trainer.getBall());
				dispose();
			}
		});
		btnOK.setIcon(new ImageIcon("image/b_ok.png"));
		btnOK.setBounds(95, 100, 100, 30);
		getContentPane().add(btnOK);

		JLabel Lab_enough = new JLabel("Select your Pokemon in bag : ");
		Lab_enough.setBounds(5, 15, 280, 50);
		Lab_enough.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(Lab_enough);
		Lab_enough.setFont(new Font("Pokemon Solid", Font.PLAIN, 16));
		
		JLabel Lab_enoughbg = new JLabel(" ");
		Lab_enoughbg.setIcon(new ImageIcon("image/editnamedialog.png"));
		Lab_enoughbg.setBounds(0, 0, 296, 175);
		getContentPane().add(Lab_enoughbg);
		
	}
}