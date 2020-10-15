
import java.util.*;
import java.io.*;
public class AddressBook {
    public static Scanner sc = new Scanner(System.in);
    public static String fileName;
    public static String path = "F:\\data.txt";
    public static String key;
    public FileReader fr;
    public static int flag=0;
    public static FileWriter fileWriter;
    public static File file;
    public static BufferedWriter bw;
    public static BufferedReader br;
    public static HashMap<String, ArrayList<Person>> personarraylist1o = new HashMap<>(100);
    public static ArrayList<Person> personarraylist17 = new ArrayList<Person>(100);
    public static void main(String[] args) {
        AddressBookManger addressBookManager = new AddressBookManger();
        while (true) {
            System.out.println("1) Add Person \n" + "2) Edit Person \n" + "3) Delete Person \n" + "4) Search Person \n"
                    + "5) Sort ByZip \n" + "6) Sort ByName \n" + "7) Display");
            int ch2 = sc.nextInt();
            switch (ch2) {
                case 1:
                    personarraylist1o=addressBookManager.addPerson(fileName);
                    Iterator it = personarraylist1o.entrySet().iterator();
                    while (it.hasNext()) {
                        Map.Entry pair = (Map.Entry) it.next();
                        key = (String) pair.getKey();
                        personarraylist17 = (ArrayList<Person>) pair.getValue();

                    }
                    break;
                case 2:
                    addressBookManager.editPerson();
                    break;
                case 3:
                    addressBookManager.deletePerson();
                    break;
                case 4:
                    addressBookManager.searchPerson();
                    break;
                case 5:
                    addressBookManager.sortByZipPerson();
                    break;
                case 6:
                    addressBookManager.sortByNamePerson();
                    break;
                case 7:
                    addressBookManager.display();
                    break;
                default:
                    System.out.println("Wrong Choice ...");
            }

        }
    }
}
