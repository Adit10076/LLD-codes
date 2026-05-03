package structural_design_pattern.decorator_pattern;

interface Warrior{
    public String getDescription();
    public int getPower();
}
class BaseWarrior implements Warrior{

    @Override
    public String getDescription(){
        return "Base Warrior";
    }

    @Override
    public int getPower(){
        return 10;
    }
}

abstract class WarriorDecorator implements Warrior{
    protected Warrior warrior;

    WarriorDecorator(Warrior warrior){
        this.warrior = warrior;
    }
}

class Sword extends WarriorDecorator{

    public Sword(Warrior warrior){
        super(warrior);
    }
    @Override
    public String getDescription(){
        return warrior.getDescription() + "Sword";
    }

    @Override
    public int getPower(){
        return warrior.getPower() + 20;
    }
}

class Armor extends WarriorDecorator{
    public Armor(Warrior warrior){
        super(warrior);
    }

    @Override
    public String getDescription(){
        return warrior.getDescription() + "Armor";
    }
    @Override
    public int getPower(){
        return warrior.getPower() + 30;
    }
}
public class Main {
    public static void main(String[] args) {

        Warrior warrior = new BaseWarrior();
        System.out.println(warrior.getDescription());
        System.out.println(warrior.getPower());

        warrior = new Armor(warrior);
        System.out.println(warrior.getDescription());
        System.out.println(warrior.getPower());

        warrior = new Sword(warrior);
        System.out.println(warrior.getDescription());
        System.out.println(warrior.getPower());

        warrior = new Armor(warrior);
        System.out.println(warrior.getDescription());
        System.out.println(warrior.getPower());

    }
}
