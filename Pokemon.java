public abstract class Pokemon{
    //Attribute
    protected static String name;
    protected static int hp;
    protected static String image;
    
    //Constructor
    public Pokemon(String name){
        this.name = name;
        this.hp = 0;
        this.image = "";
    }

    public Pokemon(String name, int maxHP, String image){
        this.name = name;
        this.hp = (int)(Math.random()*maxHP);
        this.image = image;
    }

    public void setName(String name){
        this.name = name;
    }
    //Accessor Method
    public String getName(){
        return name;
    }

    public void setHP(int hp){
        this.hp = hp;
    }
    public static int getHP(){
        return hp;
    }
    
    public String getImage(){
        return image;
    }


    //Mutator Method
    public boolean damage(int value){
        if(hp == 0){
            return false;
        }
        int currentHP = hp - value;
        if(currentHP >= 0){
            this.hp = currentHP;
        }
        else{
            this.hp = 0;
        }
        return true;

    }

    //Abstract Method
    public abstract void attack(Pokemon enemy);

    //Method
    public String toString(){
        return name;
    }
}