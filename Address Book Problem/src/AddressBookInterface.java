import java.io.FileNotFoundException;
import java.io.IOException;
import  java.util.*;
public interface AddressBookInterface {
    public HashMap<String, ArrayList<Person>>  addPerson(String filename);

    public void saveData(String key,ArrayList<Person> personarraylist17) throws IOException;


    public String editPerson(String fileNames) throws FileNotFoundException, IOException ;

    public String deletePerson(String fileName) throws  IOException ;

    public String searchPerson(String fileName) ;

    public String sortByZipPerson(String fileName) ;

    public String sortByNamePerson(String fileName) throws FileNotFoundException, IOException ;

    public String display(String fileName);

}
