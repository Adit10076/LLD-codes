package creational_pattern.prototype_pattern;

import java.util.*;

interface Enemy{
    Enemy clone();
}

class Goblin implements Enemy{
    public String name;
    public int health;
    
    public Goblin(String name , int health){
        this.name = name;
        this.health = health;
    }

    public Goblin(Goblin source){
        this.name = source.name;
        this.health = source.health;
    }

    @Override
    public Goblin clone(){
        return new Goblin(this);
    }

}

class EnemyRegistry{
    private final Map<String , Enemy>registry = new HashMap<>();

    public void register(String key , Enemy e){
        registry.put(key, e);
    }
    public Enemy spawn(String key){
        return registry.get(key).clone();
    }
}

public class Main {
    public static void main(String[] args) {
        EnemyRegistry registry = new EnemyRegistry();
        registry.register("goblin", new Goblin("Goblin" , 100));
        Goblin g1 = (Goblin) registry.spawn("goblin");
        g1.name = "Bhayanakar";
        g1.health = 80;

        Goblin g2 = (Goblin) registry.spawn("goblin");
        g2.name = "Suar";
        g2.health = 100;

        System.out.println(g1.name + g1.health);
        System.out.println(g2.name + g2.health);

    }
}
