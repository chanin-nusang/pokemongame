public class PokCharizard extends Pokemon {

    public PokCharizard (String name){
        super(name, 250, "image/p_charizard.gif");
    }

    public void attack(Pokemon enemy){
        System.out.println("Pokemon " + name + " attack " + enemy.getName());
        enemy.damage(100);
    }

}