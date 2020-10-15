import java.io.*;
import java.util.*;

    public class AddressBookManger implements AddressBookInterface {

        public String firstName;
        public String lastName;
        public String city;
        public String state;
        public String zip;
        public String phoneNum;
        public String str;
        public String num,find;
        int flag = 0;
        public  Scanner sc = new Scanner(System.in);
        public String fileName;
        public  String path = "F:\\data.txt";
        public FileReader fr;
        public  FileWriter fileWriter;
        public  File file;
        public  BufferedWriter bw;
        public  BufferedReader br;
        public ArrayList<Person> personarraylist1 = new ArrayList<Person>(50);
        public HashMap<String, ArrayList<Person>> personarraylist2 = new HashMap<>(50);

        @Override
        public HashMap<String, ArrayList<Person>> addPerson(String fileName) {
            System.out.println("How many data want to save in AddressBook :" + fileName);
            int n = sc.nextInt();
            for (int i = 1; i <= n; i++) {
                System.out.println("Enter First Name :");
                firstName = sc.next();
                System.out.println("Enter Last Name :");
                lastName = sc.next();
                System.out.println("Enter City :");
                city = sc.next();
                System.out.println("Enter State :");
                state = sc.next();
                System.out.println("Enter Zip Code :");
                zip = sc.next();
                System.out.println("Enter Phone Number :");
                phoneNum = sc.next();

                personarraylist1.add(
                        new Person(firstName + ",", lastName + ",", city + ",", state + ",", zip, "," + phoneNum));
                personarraylist2.put(fileName, personarraylist1);
            }
            return personarraylist2;
        }





        @Override
        public void saveData(String key, ArrayList<Person> personarraylist3) throws IOException {
            fileWriter = new FileWriter(path + key + ".txt", true);
            bw = new BufferedWriter(fileWriter);
            for (int J = 0; J < personarraylist3.size(); J++) {
                num = personarraylist3.get(J).getPhoneNumber().trim();
                System.out.println("checking with number " + num + " any data present or not");
                System.out.println("---------");
                System.out.println("------------");
                File input = new File((path + key + ".txt"));
                fr = new FileReader(input);
                br = new BufferedReader(fr);
                while ((str = br.readLine()) != null) {
                    if (str.contains(num)) {
                        flag++;
                        find = str;
                    }
                }
                br.close();
                if (flag == 0) {
                    bw.write(personarraylist3.get(J).toString() + "\n");
                    System.out.println("Data not present with " + num + " And Data Saved in AddressBook :" + key + ".txt");
                } else {
                    System.out.println("Already Data present with same Number so try with different one -->" + find);
                }

            }
            bw.close();
            fileWriter.close();
        }


    @Override
    public String editPerson (String fileName) throws FileNotFoundException, IOException {
        System.out.println("Enter number for edit person data\n");
        String lineToFind = sc.next();
        File inFile = new File((path + fileName + ".txt"));
        File tempFile = new File(path + fileName + ".tmp");
        BufferedReader br = new BufferedReader(new FileReader(inFile));
        bw = new BufferedWriter(new FileWriter(tempFile));
        String line = null;
        while ((line = br.readLine()) != null) {
            if (line.trim().contains(lineToFind)) {
                System.out.println("Data found for given number\n" + line);
                String[] persondrtails = line.split(",");
                String firstname = persondrtails[0];
                String lastname = persondrtails[1];
                System.out.println("enter the city");
                String c = sc.next();
                System.out.println("enter the State");
                String s = sc.next();
                System.out.println("enter the Zipcode");
                String z = sc.next();
                String phonenumber = persondrtails[5];
                bw.write(firstname);
                bw.write("," + lastname);
                bw.write("," + c);
                bw.write("," + s);
                bw.write("," + z);
                bw.write("," + phonenumber);
                bw.newLine();
                flag++;
            } else {
                bw.write(line);
                bw.newLine();
            }

        }
        bw.close();
        br.close();
        inFile.delete();
        tempFile.renameTo(inFile);
        if (flag == 0) {
            System.out.println("Data not found in AddressBook :" + fileName);
        } else {
            System.out.println("Data Modified Successfully..");
        }

        return null;

    }




        @Override
        public String deletePerson (String fileName) throws  IOException{
            System.out.println("Enter Name for Delete");
            String lineToRemove = sc.next();
            File inFile = new File((path + fileName + ".txt"));
            File tempFile = new File(path + fileName + ".tmp");
            BufferedReader br = new BufferedReader(new FileReader(inFile));
            PrintWriter pw = new PrintWriter(new FileWriter(tempFile));

            String line = null;
            while ((line = br.readLine()) != null) {
                if (!line.trim().contains(lineToRemove)) {
                    pw.println(line);
                    pw.flush();
                }
            }
            pw.close();
            br.close();

            inFile.delete();
            System.out.println("Data deleted From AddressBook");
            tempFile.renameTo(inFile);
            System.out.println(" ");
            return null;
        }

    @Override
    public String searchPerson(String fileName) {
        return null;
    }

    @Override
    public String sortByZipPerson(String fileName) {
        return null;
    }


        @Override
        public String sortByNamePerson (String fileName) throws FileNotFoundException, IOException {
            File inFile = new File((path + fileName + ".txt"));
            File inFile2 = new File((path + fileName + "SortByName.txt"));
            BufferedReader reader = new BufferedReader(new FileReader(inFile));
            ArrayList<Person> lines = new ArrayList<Person>();
            String currentLine1 = reader.readLine(); // for ignore the first Line
            BufferedWriter writer = new BufferedWriter(new FileWriter(inFile2));
            writer.write(currentLine1);
            writer.newLine();
            String currentLine = reader.readLine();
            while (currentLine != null) {
                String[] persondrtails = currentLine.split(",");
                String firstname = persondrtails[0];
                String lastname = persondrtails[1];
                String city = persondrtails[2];
                String state = persondrtails[3];
                int zipcode = Integer.valueOf(persondrtails[4]);
                String phonenumber = persondrtails[5];
                lines.add(new Person(firstname, lastname, city, state, zip, phonenumber));
                currentLine = reader.readLine();
            }
            Collections.sort(lines, new SortByName());
            System.out.println("Data after Sort By Name: ");
            for (Person P : lines) {
                System.out.println(P.getFirstName() + " " + P.getLastName() + " " + P.getCity() + " " + P.getState() + " "
                        + P.getZipCode() + " " + P.getPhoneNumber());
                writer.write(P.firstName);
                writer.write("," + P.lastName);
                writer.write("," + P.city);
                writer.write("," + P.state);
                writer.write("," + P.zip);
                writer.write("," + P.phoneNum);
                writer.newLine();
            }
            System.out.println("");
            writer.close();
            reader.close();

            return null;
        }


        @Override
    public String display(String fileName) {
        return null;
    }
}
