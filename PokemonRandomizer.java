import java.util.*;

public class PokemonRandomizer {

    public static ArrayList<Pokemon> getPokemons(int num) {

        ArrayList<Pokemon> pokemons = new ArrayList<Pokemon>();
        
        if(num < 1){
            return pokemons;
        }

        int pokemonNumber = (int)(Math.random()*num) + 1;
        
        for(int i=0; i<pokemonNumber ; ++i){
            int type = (int)(Math.random()*3);
            if(type==0)
                pokemons.add(new PokDrogonite("Drogonite"));
            else if(type==1)
                pokemons.add(new PokArcanine("Arcanine"));
            else if(type==2)
                pokemons.add(new PokExeggutor("Exeggutor"));
            else if(type==3)
                pokemons.add(new PokVaporeon("Vaporeon"));
            else if(type==4)
                pokemons.add(new PokCharizard("Charizard"));
            else if(type==5)
                pokemons.add(new PokBlastoise("Blastoise"));
            else if(type==6)
                pokemons.add(new PokVenusaur("Venusaur"));
            else if(type==7)
                pokemons.add(new PokFlareon("Flareon"));
            else if(type==8)
                pokemons.add(new PokNidoking("Nidoking"));
            else if(type==9)
                pokemons.add(new PokVictreebel("Victreebel"));
        }

        return pokemons;
    }
    
}