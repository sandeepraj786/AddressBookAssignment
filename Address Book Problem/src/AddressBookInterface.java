import java.io.IOException;
import  java.util.*;
public interface AddressBookInterface {
    public HashMap<String, ArrayList<Person>>  addPerson(String filename);

    public void saveData(String key,ArrayList<Person> personarraylist17) throws IOException;


    public String editPerson() ;

    public String deletePerson() ;

    public String searchPerson() ;

    public String sortByZipPerson() ;

    public String sortByNamePerson() ;

    public String display();

}
