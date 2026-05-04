package structural_design_pattern.composite_pattern;
import java.util.*;

interface OrgComponent{
    public String getName();
    public int getSalary();
}
class Employee implements OrgComponent{
    private String name;
    private String role;
    private int salary;

    Employee(String name , String role , int salary){
        this.name = name;
        this.role = role;
        this.salary = salary;
    }
    @Override
    public String getName(){
        return name;
    }

    @Override
    public int getSalary(){
        return salary;
    }
}
class Department implements OrgComponent{
    private String name;
    private List<OrgComponent>members = new ArrayList<>();
    private int salary;

    public Department(String name){
        this.name = name;
    }

    public void add(OrgComponent component){
        members.add(component);
    }

    @Override
    public String getName(){
        return name;
    }
    @Override
    public int getSalary(){
        int total = 0;

        for(OrgComponent member:members){
            total+=member.getSalary();
        }
        return total;
    }

}
public class Main {
    public static void main(String[] args) {
        Employee rahul = new Employee("Rahul" , "Backend Dev" , 100000);
        Employee ankit = new Employee("Ankit" , "Backend Dev" , 100000);
        Department engineering = new Department("Engineering");
        engineering.add(rahul);
        engineering.add(ankit);

        Employee priya = new Employee("Priya","HR",50000);
        Employee neha = new Employee("Neha" , "HR" , 60000);
        Department hr = new Department("HR");
        hr.add(priya);
        hr.add(neha);

        Department TechBrosPvtLtd = new Department("TechBros");
        TechBrosPvtLtd.add(engineering);
        TechBrosPvtLtd.add(hr);

        System.out.println("Total salary spent on engineering dept: "+ engineering.getSalary());
        System.out.println("Total salary spent on HR dept: "+ hr.getSalary());
        System.out.println("Total salary spent by TechBrosPvtLtd: "+TechBrosPvtLtd.getSalary());

    }
}
