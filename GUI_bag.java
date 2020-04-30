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

		//Object[][] data = new Object[Trainer.getBag().size()][5];
	
		System.out.println("Bag size : " + pok.size());
		
		/*for(int i=0 ; i < pok.size() ; i++){
				ImageIcon icon = new ImageIcon(getClass().getResource(pok.get(i).getImage()));
				data[i][2] = icon; 
		}*/

		for(int i=0 ; i < pok.size() ; i++){
			System.out.println(i + " " + pok.get(i).getName() + "\tHP : " + pok.get(i).getHP());// print pokemon in pokemons ArrayList
			data[i][0]  = pok.get(i).getName();
			data[i][1]  = "HP : " + pok.get(i).getHP();
			data[i][2]  = "";
			data[i][3]  = "";
			data[i][4]  = "";
		}

		
			//COLUMN HEADERS
			String columnHeaders[] =  {" "," "," "," "," "};

			//ImageIcon icon=new ImageIcon(getClass().getResource("exit.png"));
			//Object[][] rows={{1,4,icon},{2,7,icon}};

			/*DefaultTableModel model = new DefaultTableModel(data, columnHeaders) {
    			@Override
   				public Class<?> getColumnClass(int column) {
            			if(column == 2) return ImageIcon.class;
            			return Object.class;
    			}
			};*/

			//CREATE OUR TABLE AND SET HEADER
			JTable table=new JTable(data,columnHeaders);
			  
			//SET CUSTOM RENDERER TO TEAMS COLUMN
			table.getColumnModel().getColumn(2).setCellRenderer(new ButtonRenderer());;
			table.getColumnModel().getColumn(3).setCellRenderer(new ButtonRenderer1());;
			table.getColumnModel().getColumn(4).setCellRenderer(new ButtonRenderer2());;

		  
			//SET CUSTOM EDITOR TO TEAMS COLUMN
			//table.getColumnModel().getColumn(2).setCellEditor(new ButtonEditor(new JTextField()));
			table.getColumnModel().getColumn(3).setCellEditor(new ButtonEditor1(new JTextField()));
			table.getColumnModel().getColumn(4).setCellEditor(new ButtonEditor2(new JTextField()));

			

		  
			//SCROLLPANE,SET SZE,SET CLOSE OPERATION
			JScrollPane pane = new JScrollPane(table);
			pane.setBounds(0, 150, 800, 410);
			pane.setOpaque(false);
			pane.setViewportView(table);
			pane.getViewport().setOpaque(false);
			pane.setBorder(BorderFactory.createEmptyBorder());
			frame.getContentPane().add(pane);
			

			/*
			table.getTableHeader().setBackground(alphaZero);
			table.setFocusable(false);
			table.setOpaque(false);
			table.setShowGrid(false);
			table.setRowHeight(150);
			table.getTableHeader().setFont(new Font("Pokemon Solid", Font.PLAIN, 16));
			table.getTableHeader().setForeground(Color.blue);
			table.getTableHeader().setBackground(alphaZero);
			table.getTableHeader().setResizingAllowed(false);*/

			
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
			  
		
		// Table
		//JTable table = new JTable();
		//table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		/*
		// ScrollPane for Table
		JScrollPane scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(0, 150, 800, 350);
		scrollPane.setViewportView(table);
		scrollPane.setOpaque(false);
		scrollPane.getViewport().setOpaque(false);
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		frame.getContentPane().add(scrollPane);
			  */

		/*
		ArrayList<Pokemon> list = new ArrayList<Pokemon>();
        Raichu u1 = new Raichu("LNA", 45);
        Raichu u2 = new Raichu("LNB", 50);
        Raichu u3 = new Raichu("LNC", 65);
        Raichu u4 = new Raichu("LND", 21);
        Raichu u5 = new Raichu("LNE", 96);
        Raichu u6 = new Raichu("LNF", 33);
        list.add(u1);
        list.add(u2);
        list.add(u3);
        list.add(u4);
        list.add(u5);
        list.add(u6);
		//return list;
		
		//pp.printPokemon(Trainer.getBag());
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		//model.addRow(new Object[0]);

		
		/*int number = 0;
        for(Pokemon p: pok){
			System.out.println(number + " " + p.getName()); // print pokemon in pokemons ArrayList
			model.addColumn("HP : " + p.getHP());
			model.setValueAt("" + p.getName(), 0, number);
			table.getColumnModel().getColumn(number).setWidth(200); 
			number++;
        }
		*/
		
		/*
		//table.getTableHeader().setOpaque(false);
		table.getTableHeader().setFont(new Font("Pokemon Solid", Font.PLAIN, 16));
		table.getTableHeader().setForeground(Color.blue);
		table.getTableHeader().setBackground(alphaZero);
		table.getTableHeader().setResizingAllowed(false);
		//table.getTableHeader().setBorder(BorderFactory.createEmptyBorder());
		table.setForeground(Color.black);
		table.setCellSelectionEnabled(false);
		table.setFocusable(false);
		table.setOpaque(false);
		((DefaultTableCellRenderer)table.getDefaultRenderer(Object.class)).setOpaque(false);
		table.setShowGrid(false);
		table.setRowHeight(150);
		//table.setRowHeight(1, 200); 
		table.setFont(new Font("Pokemon Solid", Font.PLAIN, 16));
		table.setEnabled(false);
		UIManager.getDefaults().put("TableHeader.cellBorder" , BorderFactory.createEmptyBorder(0,0,0,0)); 
*/
		

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		centerRenderer.setOpaque(false);
		table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		//table.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);

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

//BUTTON RENDERER CLASS
class ButtonRenderer extends JButton implements  TableCellRenderer
{
	Trainer pp = new Trainer();
	ArrayList<Pokemon> pok = pp.getBag();

  //CONSTRUCTOR
  public ButtonRenderer() {
    //SET BUTTON PROPERTIES
	setOpaque(true);
	//setIcon(new ImageIcon("image/editnamepok.png"));
  }
  @Override
  public Component getTableCellRendererComponent(JTable table, Object obj, boolean selected, boolean focused, int row, int col) {

    //SET PASSED OBJECT AS BUTTON TEXT
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



//**************************************************************************************** 
//BUTTON RENDERER CLASS
class ButtonRenderer1 extends JButton implements  TableCellRenderer
{

  //CONSTRUCTOR
  public ButtonRenderer1() {
    //SET BUTTON PROPERTIES
	setOpaque(true);
	setIcon(new ImageIcon("image/editnamepok.png"));
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
		RenamePokemon dialog = new RenamePokemon(rw);
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


// ********************************************************************************************


//BUTTON RENDERER CLASS
class ButtonRenderer2 extends JButton implements  TableCellRenderer
{

  //CONSTRUCTOR
  public ButtonRenderer2() {
    //SET BUTTON PROPERTIES
	setOpaque(true);
	setIcon(new ImageIcon("image/potionplus.png"));
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
class ButtonEditor2 extends DefaultCellEditor
{
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
	 //btn.setText(lbl);
	 btn.setFont(new Font("Pokemon Solid", Font.PLAIN, 18));
	 clicked=true;
	 rw = row;
    return btn;
  }

  //IF BUTTON CELL VALUE CHNAGES,IF CLICKED THAT IS
   @Override
  public Object getCellEditorValue() {

     if(clicked)
      {
      //SHOW US SOME MESSAGE
		if(Trainer.getPotion() <= 0){
			MyDialogPopup3 dialog = new MyDialogPopup3();
			dialog.setVisible(true);		}
		else{
			Trainer.getBag().get(rw).setHP(Trainer.getBag().get(rw).getHP()+10);
			Trainer.setPotion(Trainer.getPotion()-1);
			Trainer.setXP(Trainer.getXP() + 1);
			GUI_bag.frame.dispose();
			GUI_bag mn = new GUI_bag();
			mn.frame.setVisible(true);
		}

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

class RenamePokemon extends JDialog {

    public String sName;

		public RenamePokemon(int ind) {

            //ArrayList<Pokemon> bb = new ArrayList<Pokemon>();
			Trainer tn5 = new Trainer();
			//Pokemon aa = new Pokemon();

			setBounds(100, 100, 296, 175);
			setTitle("Rename Pokemon");
            setLocationRelativeTo(null);
            ImageIcon dia = new ImageIcon("image/pokemonicon.png");
            setIconImage(dia.getImage());
            getContentPane().setLayout(null);
            setBackground(Color.YELLOW);
            
			
			// Create Input 
			final JTextField name = new JTextField(tn5.getBag().get(ind).getName()); //(bb.get(ind).getName());
			name.setBounds(57, 36, 175, 30);
            getContentPane().add(name);
            name.setFont(new Font("Pokemon Solid", Font.PLAIN, 16));
			
			// Button OK
			JButton btnOK = new JButton();
			btnOK.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
                    sName = name.getText();
					//tn5.setPokemonName(sName, ind);
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
			
			// Button Cancel
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