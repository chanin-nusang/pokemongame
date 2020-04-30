import java.util.*;

public class Trainer {
    //Attribute
    private static ArrayList<Pokemon> bag = new ArrayList<Pokemon>();
    private Scanner sc;
    private static String name;
    private static int level = 1;
    private static int xp = 0;
    private static int xp_max = 10;
    private static int coin = 3500;
    private static int ball = 10;
    private static int potion = 5;

    //Constructor
    public Trainer(){
        //bag = new ArrayList<Pokemon>();
        //bag.add(new Pikachu("Pikachu of Satochi")); // default pokemon in bag
        //sc = new Scanner(System.in);
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public static int getLevel(){
        return level;
    }

    public void setXP(int xp){
        this.xp = xp;
    }

    public int getXP(){
        return this.xp;
    }

    public int getXPMax(){
        return this.xp_max;
    }

    public static void levelUp(){
        if(xp >= xp_max){
            level++;
            xp_max = xp_max*2;
            coin = coin + (level*1250);
        }
    }

    public static void setCoin(int co){
        coin = co;
    }

    public static int getCoin(){
        return coin;
    }

    public static void setBall(int bal){
        ball = bal;
    }

    public static int getBall(){
        return ball;
    }

    public static void setPotion(int pot){
        potion = pot;
    }

    public static int getPotion(){
        return potion;
    }



    //Method
    public void play(){
        String cmd = "";

        do{
            System.out.print("\n\nEnter cmd: ");
            cmd = sc.nextLine();

            if(cmd.equals("print")){
                System.out.println("\n\nPokemon in bag: ");
                printPokemon(bag);
            }
            else if(cmd.equals("catch")){
                catchPokemon();
            }
        }while(!cmd.equals("quit"));
    }

    public void catchPokemon(){
        System.out.println("Catch Pokemons");
        ArrayList<Pokemon> pokemons = PokemonRandomizer.getPokemons(5); // random pokemon 


        System.out.println("\n\nPokemon around you");
        int no = 0;
        printPokemon(pokemons); // print pokemon from randomizer

        System.out.print("\n\nSelect pokemon number or run(-1): ");
        no = sc.nextInt(); // get pokemon number to 'no' 
        if(no < 0){
            sc.nextLine();
            return;
        }
        Pokemon wildPokemon = pokemons.get(no); // get pokemons from random select to 'wildPokemon' 

        System.out.println("\n\npokemon in bag: ");
        printPokemon(bag); // print pokemon in 'bag'

        System.out.print("\n\nSelect pokemon in bag: ");
        no = sc.nextInt();
        Pokemon myPokemon = bag.get(no); // sent 'no' in bag to 'myPokemon'

        boolean isWin = false;
        do{
            myPokemon.attack(wildPokemon);
            if(wildPokemon.getHP() == 0){
                isWin = true;
                break;
            }
            else{
                wildPokemon.attack(myPokemon);
                if(myPokemon.getHP() == 0){
                    isWin = false;
                    break;
                }
            }

        }while(true); // loop till HP = 0

        if(isWin){ // isWin = true
            System.out.println("You catch: ");
            bag.add(wildPokemon);
        }
        else{ // isWin = false
            System.out.println(wildPokemon.getName() + " win");
        }
        sc.nextLine(); // back to 'play' method
    }

    public void printPokemon(ArrayList<Pokemon> pokemons){
        int number = 0;
        for(Pokemon p: pokemons){
            System.out.println("" + number + " " + p + " HP: " + p.getHP()); // print pokemon in pokemons ArrayList
            number++;
        }
    }
    public static ArrayList<Pokemon> getBag(){
        return bag;
    }
    public void setPokemonName(String n, int ind) { // (ArrayList<Pokemon> bgg, int ind){
        bag.get(ind).setName(n);
    }

}