import daoimpl.PersonDaoImpl;
import entities.Person;

import java.util.List;

/**
 * Created by Ivelin Stoyanov on 20.2.2018 г..
 */
public class App {
    public static void main(String [] args) {

        PersonDaoImpl pdi = new PersonDaoImpl();

       /**Create table**/
 //       pdi.createPersonTable();

        /**Insert a new record**/
 //       Person person = new Person("John","Johnson");
 //       pdi.insert(person);

        /**Select by id**/
 //       Person personSelect = pdi.selectById(2);
 //       System.out.println(person.getId()+", "+person.getFirstName()+", "+person.getLastName());

        /**Delete person by id**/
 //       pdi.delete(3);

        /**Update person**/
 //       Person personUpdate = new Person("Tom","Johnson");
 //       pdi.update(personUpdate,1);

        /**Select all persons**/
        List<Person> persons = pdi.selectAll();
        for(Person p : persons) {
            System.out.println(p.getId()+", "+p.getFirstName()+", "+p.getLastName());
        }

    }
}
