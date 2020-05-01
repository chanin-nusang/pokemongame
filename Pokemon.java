public abstract class Pokemon{
    protected String name;
    protected int hp;
    protected String image;
    
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

    public String getName(){
        return this.name;
    }

    public void setHP(int hp){
        this.hp = hp;
    }

    public int getHP(){
        return this.hp;
    }
    
    public String getImage(){
        return image;
    }

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

    public abstract void attack(Pokemon enemy);

    public String toString(){
        return name;
    }
}