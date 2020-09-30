package Zoo;
import Animals.Animal;
import Zoo.Employee.ZooEmployee;
import Zoo.Employee.Type.ZooAnnouncer;

import java.util.*;
import java.util.Map.Entry;

public class Zoo {
    // animals are supposed to be public to all classes
    public HashMap<String, Animal> animals = new HashMap<String, Animal>();
    private HashMap<Integer, ZooEmployee> employees = new HashMap<Integer, ZooEmployee>();
    private String type = this.getClass().getSimpleName();
    private ZooClock zoo_clock;
    ZooAnnouncer announcer;

    public Zoo(ZooClock zoo_clock) {
        this.zoo_clock = zoo_clock;
    }

    public String get_type() {
        return this.type;
    }

    // store only animal instance
    public void add_animal(Animal animal) {
        if (!(animal instanceof Animal)) {
            System.out.println("#[Zoo] add animal failed, only accept animal.");
            return;
        }

        if (this.animals.get(animal.get_name()) != null) {
            System.out.println("#[Zoo] add animal failed, duplicated animal name.");
            return;
        }

        this.animals.put(animal.get_name(), animal);
        System.out.println(String.format("#[Zoo] add animal <name: %s> <type: %s> succeed.", animal.get_name(),
                animal.get_type()));
    }

    // store only exployee instance
    public void add_employee(ZooEmployee employee) {
        if (!(employee instanceof ZooEmployee)) {
            System.out.println("#[Zoo] add employee failed, only accept employee.");
            return;
        }

        if (this.employees.get(employee.get_identity()) != null) {
            System.out.println("#[Zoo] add employee failed, duplicated employee identity.");
            return;
        }

        this.employees.put(employee.get_identity(), employee);
        System.out.println(String.format("#[Zoo] add employee  <name: %s> <type: %s> <identity: %d>  succeed.",
                employee.get_name(), employee.get_type(), employee.get_identity()));
    }

    public void start_operation(int days) {
        
        for (Entry<Integer, ZooEmployee> employee_set : this.employees.entrySet())
        {
            ZooEmployee employee = employee_set.getValue();
            if ( employee instanceof ZooAnnouncer )
            {
                announcer = (ZooAnnouncer)employee;
            }
        }

        this.zoo_clock.perform_daily_routing(days, announcer);
    }
}