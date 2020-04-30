public class PokFlareon extends Pokemon {

    public PokFlareon (String name){
        super(name, 115, "image/p_flareon.gif");
    }

    public void attack(Pokemon enemy){
        System.out.println("Pokemon " + name + " attack " + enemy.getName());
        enemy.damage(100);
    }

}