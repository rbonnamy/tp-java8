package java8.ex02;

import java8.data.Account;
import java8.data.Data;
import java8.data.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * Exercice 02 - Map
 */
public class Lambda_02_Test {
    
    interface PersonToObjectMapper<T> {
        T map(Person p);
    }
    
    private <T> List<T> map(List<Person> personList, PersonToObjectMapper<T> mapper) {
        List<T> objects = new ArrayList<>();
        for (Person p: personList){
        	objects.add(mapper.map(p));
        }
        return objects;
    }
    
    interface PersonToStringMapper {
        String map(Person p);
    }
    
    interface PersonToAccountMapper {
        Account map(Person p);
    }
    
    private List<Account> map(List<Person> personList, PersonToAccountMapper mapper) {
        List<Account> objects = new ArrayList<>();
        for (Person p: personList){
        	objects.add(mapper.map(p));
        }
        return objects;
    }
    
    private List<String> map(List<Person> personList, PersonToStringMapper mapper) {
        List<String> objects = new ArrayList<>();
        for (Person p: personList){
        	objects.add(mapper.map(p));
        }
        return objects;
    }


    // tag::test_map_person_to_account[]
    @Test
    public void test_map_person_to_account() throws Exception {

        List<Person> personList = Data.buildPersonList(100);

        // TODO transformer la liste de personnes en liste de comptes
        // TODO tous les objets comptes ont un solde à 100 par défaut
        
        PersonToObjectMapper<Account> mapper = p -> new Account();
        
        List<Account> result = map(personList, mapper);

        assert result.size() == personList.size();
        for (Account account : result) {
            assert account.getBalance().equals(100);
            assert account.getOwner() != null;
        }
    }
    // end::test_map_person_to_account[]

    // tag::test_map_person_to_firstname[]
    @Test
    public void test_map_person_to_firstname() throws Exception {

        List<Person> personList = Data.buildPersonList(100);

        // TODO transformer la liste de personnes en liste de prénoms
        PersonToObjectMapper<String> mapper = p -> p.getFirstname();
        
        List<String> result = map(personList, mapper);

        assert result.size() == personList.size();
        for (String firstname : result) {
            assert firstname.startsWith("first");
        }
    }
    // end::test_map_person_to_firstname[]
}
