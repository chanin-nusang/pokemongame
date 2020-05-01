public class PokExeggutor extends Pokemon {

    public PokExeggutor (String name){
        super(name, 90, "image/p_exeggutor.gif");
    }

    public void attack(Pokemon enemy){
        System.out.println("Pokemon " + name + " attack " + enemy.getName());
        enemy.damage(10);
    }

}