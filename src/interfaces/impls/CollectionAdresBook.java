package interfaces.impls;

import interfaces.AdresBook;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import object.Person;

public class CollectionAdresBook implements AdresBook {

    private ObservableList<Person> personList = FXCollections.observableArrayList();

    @Override
    public void add(Person person) {personList.add(person);}

    @Override
    public void update(Person person) {    }

    @Override
    public void delete(Person person) { personList.remove(person);}

    public ObservableList<Person> getPersonList(){return personList;}


    public void print(){
        int number=0;
        System.out.println();
        for (Person person : personList){
            number++;
            System.out.println(number+") fio= " + person.getFio()+ "; phone = "+ person.getPhone());
        }
    }


    public void fillTestData() {
        personList.add(new Person("Иван Печкин", "45662145525"));
        personList.add(new Person("Роман Романов", "56561654946"));
        personList.add(new Person("Антон Иванов", "6355132654"));
        personList.add(new Person("Джон Маклейн", "5465464454654"));
        personList.add(new Person("ДЖек Воробей", "8979856161254"));
        personList.add(new Person("Алиса Иванова", "321326546849"));
        personList.add(new Person("Боб Свегер", "321635468798654"));
    }

}
