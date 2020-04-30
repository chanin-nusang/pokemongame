public class PokVenusaur extends Pokemon {

    public PokVenusaur (String name){
        super(name, 80, "image/p_venusaur.gif");
    }

    public void attack(Pokemon enemy){
        System.out.println("Pokemon " + name + " attack " + enemy.getName());
        enemy.damage(1200);
    }

}