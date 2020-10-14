import java.util.*;
public class AddressBook {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        AddressBookManger addressBookManager = new AddressBookManger();
        while (true) {
            System.out.println("1) Add Person \n" + "2) Edit Person \n" + "3) Delete Person \n" + "4) Search Person \n"
                    + "5) Sort ByZip \n" + "6) Sort ByName \n" + "7) Display");
            int ch2 = sc.nextInt();
            switch (ch2) {
                case 1:
                    addressBookManager.addPerson();
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
