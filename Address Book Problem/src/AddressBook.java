import java.util.*;
import java.io.*;
public class AddressBook {
    public static Scanner sc = new Scanner(System.in);
    public static String fileNames;
    public static String path = "F:\\data.txt";
    public static String key;
    public FileReader fr;
    public static int flag=0;
    public static FileWriter fileWriter;
    public static File file;
    public static BufferedWriter bw;
    public static BufferedReader br;
    public static HashMap<String, ArrayList<Person>> personarraylist10 = new HashMap<>(50);
    public static ArrayList<Person> personarraylist11 = new ArrayList<Person>(50);

    public static void main(String[] args) throws IOException {
        AddressBookManger addressBookManager = new AddressBookManger();
        System.out.print("Enter the desired name of your Book: ");
        fileNames = sc.next();
        String fileName = fileNames + ".txt";
        file = new File(path + fileName + ".txt");
        if(file.isFile())
        {
            System.out.println("file already Present");
        }
        else
        {
            file.createNewFile();
            fileWriter = new FileWriter(file, true);
            bw = new BufferedWriter(fileWriter);
            bw.write("FirstName");
            bw.write(",Lastname");
            bw.write(",City");
            bw.write(",State");
            bw.write(",Zipcode");
            bw.write(",PhoneNum");
            bw.newLine();
            System.out.println("Address Book Created ");
            bw.close();
            fileWriter.close();

        }


        while (true) {
            System.out.println("1) Add Person \n" + "2) Save Person \n" + "3) Delete Person \n" + "4) Search Person \n"
                    + "5) Sort ByZip \n" + "6) Sort ByName \n" + "7) Display" + "8) edit Person \n");
            int ch2 = sc.nextInt();
            switch (ch2) {
                case 1:
                    personarraylist10=addressBookManager.addPerson(fileName);
                    Iterator it = personarraylist10.entrySet().iterator();
                    while (it.hasNext()) {
                        Map.Entry pair = (Map.Entry) it.next();
                        key = (String) pair.getKey();
                        personarraylist11 = (ArrayList<Person>) pair.getValue();
                    }
                    break;
                case 2:
                    addressBookManager.saveData(key,personarraylist11);
                    break;
                case 3:
                    addressBookManager.deletePerson(fileName);
                    break;
                case 4:
                    addressBookManager.searchPerson(fileName);
                    break;
                case 5:
                    addressBookManager.sortByZipPerson(fileName);
                    break;
                case 6:
                    addressBookManager.sortByNamePerson(fileName);
                    break;
                case 7:
                    addressBookManager.display(fileName);
                    break;
                case 8:
                    addressBookManager.editPerson(fileNames);
                    break;
                default:
                    System.out.println("Wrong Choice ......");
            }

        }

    }
}