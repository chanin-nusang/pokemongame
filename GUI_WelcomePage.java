import javax.swing.*;
import javax.swing.plaf.BorderUIResource;
import java.awt.*;
import java.awt.event.*;

public class GUI_WelcomePage extends JFrame{

	protected JFrame frame;
	//protected String playerName;

	public GUI_WelcomePage() {
		welcome();
	}

	private void welcome() {
		//super("Pokemon Game");

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
				//System.exit(0);
				frame.dispose();

			}
        });
	}
}

/*public class MainGame extends JFrame{

    private Trainer trainer;
    private JFrame frame;
    

    /*public MainGame(Trainer trainer){
        super("Pokemon Game");

        this.trainer = trainer;


        Container c = getContentPane();
        JLabel trainerNameLabel = new JLabel(this.trainer.getName());
        JLabel pokemonName = new JLabel();


        JButton firstPokemon = new JButton(trainer.getBag().get(0).getName() + " Status");

        c.add(trainerNameLabel);
        c.add(pokemonName);
        c.add(firstPokemon);
        

        c.setLayout(new BoxLayout(c, BoxLayout.Y_AXIS));

        String pName = "Pokemon: ";
        for(Pokemon p: trainer.getBag()){
            pName += p.getName() + ", ";
        }

        pokemonName.setText(pName);

        firstPokemon.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                PokemonStatus ps = new PokemonStatus(trainer.getBag().get(0));
            }
        });

 

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setVisible(true);
        setLocationRelativeTo(null);
    }*/


