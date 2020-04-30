import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PokemonStatus extends JFrame{
    
    Pokemon pokemon;
    public PokemonStatus(Pokemon pokemon){
        super("Pokemon Status: " + pokemon.getName());
        this.pokemon = pokemon;

        Container c = getContentPane();
        JLabel name = new JLabel(pokemon.getName());
        JLabel hp = new JLabel("HP: " + pokemon.getHP());

        c.add(name);
        c.add(hp);
        
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setVisible(true);
        setLocationRelativeTo(null);
    }
}