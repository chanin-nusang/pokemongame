public class PokVaporeon extends Pokemon {

    public PokVaporeon (String name){
        super(name, 120, "image/p_vaporeon.gif");
    }

    public void attack(Pokemon enemy){
        System.out.println("Pokemon " + name + " attack " + enemy.getName());
        enemy.damage(10);
    }

}