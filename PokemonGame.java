public class PokemonGame {
    public static void main(String[] args){
        System.out.println("Hello Pokemon Game");
        Trainer.getBag().add(new PokArcanine("Arcanine"));
        GUI_WelcomePage wc = new GUI_WelcomePage();
        wc.frame.setVisible(true);
    }
}