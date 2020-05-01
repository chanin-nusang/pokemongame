public class PokDrogonite extends Pokemon {
    
    public PokDrogonite(String name){
        super(name, 150, "image/p_drogonite.gif");
    }

    public void attack(Pokemon enemy){
        System.out.println("Pokemon " + name + " attack " + enemy.getName());
        enemy.damage(10);
    }
}