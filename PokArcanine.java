public class PokArcanine extends Pokemon {

    public PokArcanine (String name){
        super(name, 70, "image/p_arcanine.gif");
    }

    public void attack(Pokemon enemy){
        System.out.println("Pokemon " + name + " attack " + enemy.getName());
        enemy.damage(10);
    }

}