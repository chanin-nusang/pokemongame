public class PokNidoking extends Pokemon {

    public PokNidoking (String name){
        super(name, 200, "image/p_nidoking.gif");
    }

    public void attack(Pokemon enemy){
        System.out.println("Pokemon " + name + " attack " + enemy.getName());
        enemy.damage(100);
    }

}