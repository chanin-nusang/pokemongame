public class PokBlastoise extends Pokemon {

    public PokBlastoise (String name){
        super(name, 160, "image/p_blastoise.gif");
    }

    public void attack(Pokemon enemy){
        System.out.println("Pokemon " + name + " attack " + enemy.getName());
        enemy.damage(100);
    }

}