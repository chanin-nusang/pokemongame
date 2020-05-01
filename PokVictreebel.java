public class PokVictreebel extends Pokemon {

    public PokVictreebel (String name){
        super(name, 170, "image/p_victreebel.gif");
    }

    public void attack(Pokemon enemy){
        System.out.println("Pokemon " + name + " attack " + enemy.getName());
        enemy.damage(10);
    }

}