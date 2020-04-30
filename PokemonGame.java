import java.util.ArrayList;

public class PokemonGame {
    public static void main(String[] args){
        System.out.println("Hello Pokemon Game");
        //Trainer t = new Trainer("REALCHANIN");
        
        //MainGame mg = new MainGame();

        //GUI_WelcomePage wc = new GUI_WelcomePage();
        //wc.frame.setVisible(true);

        //GUI_MainMenu mm = new GUI_MainMenu();
        //mm.frame.setVisible(true);

        //Trainer.getBag().add(new Pikachu("Pikachu of Satochi"));
        //Trainer.getBag().add(new Raichu("Pikachu of Raichu"));
        Trainer.getBag().add(new PokArcanine("Arcanine"));

        GUI_find fi = new GUI_find();
        fi.frame.setVisible(true);

        //GUI_bag bag = new GUI_bag();
        //bag.frame.setVisible(true);

        //GUI_shop sh = new GUI_shop();
        //sh.frame.setVisible(true);

        //GUI_me me = new GUI_me();
        //me.frame.setVisible(true);
                
        //EnterPlayerName pn = new EnterPlayerName();
        //pn.frame.setVisible(true);
        //t.play();
        System.out.println("End Pokemon Game");
    }
}