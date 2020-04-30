public class PokDrogonite extends Pokemon {
    //Constructor
    public PokDrogonite(String name){
        super(name, 150, "image/p_drogonite.gif");
    }

    //Abstract Method from Pokemon class 
    public void attack(Pokemon enemy){
        System.out.println("Pokemon " + name + " attack " + enemy.getName());
        enemy.damage(100);
    }
}