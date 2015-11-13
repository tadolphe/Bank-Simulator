
import java.util.*;
/*
Terrick Adolphe

Purpose of program: Maintain a LinkedList of records
containing names (last and first), phone numbers and
a balance. The program will prompt the user for a command
to be chosen from a menu list, execute the command, then 
prompt the user for another command.

Algorithm used: for a few of the modifications to the 
records, I first saved the information to a temp variable.
Afterwards, I changed the temp variable attributes then input
the temp variable to replace the old one. 

A few of the algorithms, such as changeFirstName, just make
the modifications to the exiting Linkedlist record instead of
creating a temp variable.

Description of how to use the program:
The user is presented a menu that request that he/she 
enter a number between 1-10. Depending on the number, 
the program will compare the number to the existing
commands corresponding to each number. For example,
if she enters  "2", the "deleteRecord" method will be 
called and will delete the current record while the 
program is executing. 


*****IMPORTANT*****
The user must continuously select the current user after every action
in order to imitate security!
*******************

 */


public class bankRecords {
   //declare the attributes' data type
	String firstName;
	String lastName;
	double balance;
        String phoneNumber;
   // constructor for the attributes set to null by default
	public bankRecords(){
	firstName = null;
	lastName = null;
	balance = 0.0;
        phoneNumber = null;
	}
	// constructor with given parameters including name, balance, and #
	public bankRecords(String fname, String lname, double bal, String phNum){
            firstName = fname;
            lastName = lname;
            balance = bal;
            phoneNumber = phNum;
	}
	//getters and setters
	public void setFirstName(String fname){
		firstName = fname;
	}
	
	public void setLastName(String lname){
		lastName = lname;
	}
	
	public void setBalance(double bal){
		balance = bal;
	}
        public void setPhoneNumber (String newNum){
                phoneNumber = newNum;
        }
	
	public String getFirstName(){
		return firstName;
	}

	public String getLastName(){
		return lastName;
	}
	public double getBalance(){
                return balance;
        }
        public String getPhoneNumber(){
                return phoneNumber;
        }
        //simple add/withdraw methods with one "double" input for ammount
	public double addBalance(double bal){
		balance +=bal;
                return balance;
	}
        public double withdraw(double bal){
		balance -=bal;
                return balance;
	}
        
        public String changeNumber(String phNum){
		phoneNumber = phNum;
                return phoneNumber;
	}
        //to indicate which record is being used
        public static int currentRecord;
        //linked list is declared
        public static LinkedList<bankRecords> record = new LinkedList<>();
      
         
        public static void main (String[] args){
        //sample record    
         bankRecords myAccount = new bankRecords("Terrick", "Adolphe", 500.0, "654345865");
       //adding the account to the record linked list database
        record.add(myAccount);     
        bankRecords currentRecord = new bankRecords();   
        
            //loop continues on forever
        while(true){
        System.out.println("\n\n1. Show all records");
        System.out.println("2. Delete the current record");
        System.out.println("3. Change the first name in the current record");
        System.out.println("4. Change the last name in the current record");
        System.out.println("5. Add a new record");
        System.out.println("6. Change the phone number in the current record");
        System.out.println("7. Add a deposit to the current "
                +"balance in the current record");
        System.out.println("8. Make a withdrawal from the current "
                    + "record if sufficient funds are available.");
        System.out.println("9. Select a record from the record "
                + "list to become the current record ");        
        System.out.println("10. Quit");
        System.out.println("");
        System.out.println("Enter a command from the list above (10 to quit)");
        
        //user's input for the command
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
       
        //switch statement issues commands based on user's numerical input
        switch(num){
               
                case 1:{
                    showAllRecords();
                    try{
                        Thread.sleep(1000);        //sleep thread to prevent 
                    }                                //overwhelming text                                  
                    catch(Exception e){                       
                    }
                    break;
                }
                case 2:{
                    deleteRecord(record, currentRecord);
                    break;
                }
                case 3:{
                    currentRecord = changeLastName(record, currentRecord);
                    break;
                }
                case 4:{
                   currentRecord = changeFirstName(record, currentRecord);
                    break; 
                }
                case 5:{
                    addNewRecord();
                    break;
                }
                case 6:{
                    currentRecord = changePhoneNumber(record, currentRecord);
                    break;
                }
                case 7:{
                    currentRecord = deposit(record, currentRecord);
                    break;
                }
                case 8: {
                    currentRecord = withdraw(record, currentRecord);
                    break;
                }         
                case 9:{
                   currentRecord = selectRecord(record); 
                   break;
                }
                case 10:{
                    System.exit(1);
                }
     
        
        }}
        }
        //first method to edit the first name of the current record
    public static bankRecords changeLastName(LinkedList<bankRecords> record, bankRecords h){
        if (h.getFirstName()==null){
            System.out.println("No record picked.");
            return null;
        }
        int index = record.indexOf(h);
   
        System.out.println("New first name? ");
        Scanner first = new Scanner(System.in);
        String newFirstName = first.nextLine();
        record.get(index).setFirstName(newFirstName);
        
        System.out.println("Current record: " + record.get(index));
            return null;
    }
       //method to alter the last name of the current record    
    public static bankRecords changeFirstName(LinkedList<bankRecords> record, bankRecords h){
     
        if (h.getLastName()==null){
            System.out.println("No record picked.");
            return null;
        }
        int index = record.indexOf(h);
   
        System.out.println("New last name? ");
        Scanner last = new Scanner(System.in);
        String newLastName = last.nextLine();
        record.get(index).setFirstName(newLastName);
        
        System.out.println("Current record: " + record.get(index));
            return null;
    }
    //for loop to print all exitisng records
    public static void showAllRecords(){
        for (int i = 0; i < record.size(); i++){
            bankRecords temp = new bankRecords();
            temp = (bankRecords) record.get(i);
            System.out.println("Current record #:" + i +
                    " - " + "\nFirst name: "+temp.getFirstName() + "\nLast Name: " + 
                    temp.getLastName() + "\nBalance: " + temp.getBalance()+"\nPhone Number: "
            + temp.getPhoneNumber() + "\n") ;
        }     
    }
    //changes current record's phone number
    public static bankRecords changePhoneNumber(LinkedList<bankRecords> record, bankRecords h){
         if (h.getPhoneNumber()==null){
            System.out.println("No record picked.");
            return null;
        }
        int index = record.indexOf(h);
   
        System.out.println("New phone number? ");
        Scanner sc = new Scanner(System.in);
        String PHNum= sc.nextLine();
        record.get(index).setPhoneNumber(PHNum);
        
        System.out.println("Current record: " + record.get(index));
            return null;
    }
    //deposit user's numerical input into existing balance
    public static bankRecords deposit(LinkedList<bankRecords> record, bankRecords h){
       if (h.getLastName()==null){
            System.out.println("No record picked.");
            return null;
        }
        int index = record.indexOf(h);
   
        System.out.println("Amount to deposit? ");
        Scanner last = new Scanner(System.in);
        double depo = last.nextDouble();
        record.get(index).addBalance(depo);
        
        System.out.println("Current record: " + record.get(index));
            return null;
    }
    //withdraw from exisiting balance
    public static bankRecords withdraw(LinkedList<bankRecords> record, bankRecords h){
       if (h.getFirstName()==null){
            System.out.println("No record picked.");
            return null;
        }
        int index = record.indexOf(h);
   
        System.out.println("Amount to withdraw? ");
        Scanner last = new Scanner(System.in);
        double with = last.nextDouble();
        if (record.get(index).balance > with){
            record.get(index).withdraw(with);
            System.out.println("Current record: " + record.get(index));
        }   return null;
}
    //method to sort the linked list
    public static void addToRightPlace(String fname, String lname, double bal, String PHNum){
        int insertPosition = 0;
       	bankRecords temp = new bankRecords();
	for (int i = 0; i < record.size(); i++){
            temp = (bankRecords) record.get(i);	
		}
		bankRecords newAccount = new bankRecords(fname, lname, bal, PHNum);
		record.add(insertPosition, newAccount);
    }   
    //add a new record to the linked list database
    public static void addNewRecord(){
		currentRecord++;
		Scanner s = new Scanner(System.in);
		System.out.println("First name: ");
		String fname = s.nextLine();
		System.out.println("Last name: ");
		String lname = s.nextLine();
		System.out.println("Balance: ");
                double bal=0;
                try{
		bal = s.nextDouble();
                }catch(InputMismatchException e){
                    System.out.println("Please write a valid number");
                    System.out.println("Balance: ");
                    bal = s.nextDouble();
                }
                
                Scanner s1 = new Scanner(System.in);
		System.out.println("Phone number: ");
                String PHNum = s1.nextLine();
		addToRightPlace(fname, lname, bal, PHNum);
	}
    //method to delete the current record
    public static void deleteRecord(LinkedList<bankRecords> record, bankRecords h){
        if (h.getFirstName()==null){
            System.out.println("No record picked.");
         
        }
        bankRecords temp = h;
        record.remove(h);
        System.out.println("Deleted: " + temp.getFirstName() + " "
        + temp.getLastName() + " " + temp.getBalance() + " " 
                + temp.getPhoneNumber());
        
    }
    //method to select the record as current record
    public static bankRecords selectRecord(LinkedList<bankRecords> rec){
         Scanner input = new Scanner(System.in);
        System.out.println("(case sensitive)");
        System.out.println("Enter first name: ");
        String fName = input.next();
        
        System.out.println("Enter last name: ");
        String lName = input.next();
        
            //for loop to search through linked list
            for (bankRecords rec1 : rec) {
                if (rec1.getLastName().compareTo(lName) == 0) {
                    if (rec1.getFirstName().compareTo(fName) == 0) {
                        System.out.println("Current record is: " + rec1.getFirstName() + " " + rec1.getLastName() + " " + rec1.getPhoneNumber());
                        return rec1;
                    }
                }
            }
        System.out.println("No matching record found.");
        return null;
    }

}