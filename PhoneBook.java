import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
/**
 *E/13/095
 *M.L.Faliq
 */
public class PhoneBook{

    public static void main(String[] args) throws IOException {


        try {
            BufferedReader br = new BufferedReader(new FileReader("contacts.csv"));
            Scanner in=new Scanner(System.in);

            String line;
            int count=0; //getting a count so we can input elements to a arraylist
            HashMap<String, Contact> phoneBook = new HashMap<>();//hashmap with key as the first name and value as a object with all the details
            ArrayList<Contact> list = new ArrayList<>();//list to keep the object
            while ((line = br.readLine()) != null) {


                String[] item = line.split(",");
                list.add(new Contact(item[0], item[1], item[2], item[3], item[4], item[5]));
                phoneBook.put(item[1],list.get(count));
                count++;
            }
            System.out.println("Enter the name of the person you need to find");
            String name=in.nextLine();

            for(HashMap.Entry<String,Contact> entry: phoneBook.entrySet()){
                if( name.equals(entry.getKey()))//to find the element in hashmap with the specific key
                {
                    System.out.println("Full name :"+entry.getKey()+" "+entry.getValue().getLastName() + "\nContact number :" +entry.getValue().getPhoneNum()+"\nEmail :"+entry.getValue().getEmail()+
                            "\nCompany :"+entry.getValue().getCompany());
                }

            }



        } catch (java.io.FileNotFoundException e) {
            System.out.println("The needed file cannot be found");
        }
    }
}


