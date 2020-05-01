import java.util.*;

public class Trainer {
    private static ArrayList<Pokemon> bag = new ArrayList<Pokemon>();
    private static String name;
    private static int level = 1;
    private static int xp = 0;
    private static int xp_max = 10;
    private static int coin = 3500;
    private static int ball = 10;
    private static int potion = 5;

    public Trainer(){
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

    public static void setXP(int xpp){
        xp = xpp;
    }

    public static int getXP(){
        return xp;
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

    public static String catchPokemon(int wildPok, int myPok){
        
        Pokemon wildPokemon = GUI_find.pk.get(wildPok); 
        Pokemon myPokemon = Trainer.getBag().get(myPok); 

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

        }while(true); 

        if(isWin){ 
            System.out.println("You catch: ");
            bag.add(wildPokemon);
            return "You catch : " + GUI_find.pk.get(wildPok).getName();
        }
        else{ 
            System.out.println(wildPokemon.getName() + " win");
            return GUI_find.pk.get(wildPok).getName() + " win";
        }
    }

    public static ArrayList<Pokemon> getBag(){
        return bag;
    }
    public void setPokemonName(String n, int ind) {
        bag.get(ind).setName(n);
    }

}