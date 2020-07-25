
import java.util.*;

 class Person
{
	 
	 String firstName;
	 String lastName;
	 String address;
	 String city;
	 String state;
	 int zipCode;
	 long phoneNo;
	
	public String getfirstName()
	{
		return firstName;
	}
	
	public int getzipCode()
	{
		return zipCode;
	}
	
	
	 public static Comparator<Person> personLastNameComparator = new Comparator<Person>() {

			public int compare(Person p1, Person p2) {
			   String firstName1 = p1.getfirstName().toUpperCase();
			   String firstName2 = p2.getfirstName().toUpperCase();  
			   return firstName1.compareTo(firstName2);
		      }
			};
		 
	public static Comparator<Person> personZipCodeComparator = new Comparator<Person>() {

			public int compare(Person p1, Person p2) {

			   int zipCode1 = p1.getzipCode();
			   int zipCode2 = p2.getzipCode();
			   int result=zipCode1-zipCode2;
			   return result;
		
		}
			};

	   
	 Person(String firstName, String lastName, String address, String city, String state, int zipcode, long phoneNo)
	{
		this.firstName=firstName;
		this.lastName=lastName;
		this.address=address;
		this.city=city;
		this.state=state;
		this.zipCode=zipcode;
		this.phoneNo=phoneNo;
	}
	
}	 

public class AddressBoook {
	static  ArrayList<Person> details=new ArrayList<Person>();
    static Scanner sc=new Scanner(System.in);
	public static void add()
	{
		System.out.println("Enter details of the person ");
		System.out.print("Enter first name:");
		String firstName=sc.next();
		System.out.print("Enter last name:");
		String lastName=sc.next();
		System.out.print("Enter address:");
		String address=sc.next();
		System.out.println("Enter city:");
		String city=sc.next();
		System.out.println("Enter state:");
		String state=sc.next();
		System.out.print("Enter zip:");
		int zipCode=sc.nextInt();
		System.out.print("Enter phone number:");
		long phoneNo=sc.nextLong();
		Person p=new Person(firstName,lastName,address,city,state,zipCode,phoneNo);
		details.add(p);
	}
	
	public static void edit()
	{
		System.out.println("Enter first name  of person:");
		String firstName=sc.next();
		int flag=0;
		for(int i=0;i<details.size();i++)
		{
			Person person=details.get(i);
			if(firstName.equals(person.firstName))
			{
					System.out.println("1.Edit address\n2.Edit city\n3.Edit state\n4.Edit zipCode\n5.Edit phone number");
					System.out.println("Enter your choice:");
					int choice=sc.nextInt();
					switch(choice)
					{
					case 1:
						System.out.println("Enter new address:");
						String address=sc.next();
						person.address=address;
						break;
					case 2:
						System.out.println("Enter new city:");
						String city=sc.next();
						person.city=city;
						break;
					case 3:
						System.out.println("Enter new state:");
						String state=sc.next();
						person.state=state;
						break;
					case 4:
						System.out.println("Enter new zipcode:");
						int zipCode=sc.nextInt();
						person.zipCode=zipCode;
						break;
					case 5:
						System.out.println("Enter new phone number:");
						long phoneNo=sc.nextLong();
						person.phoneNo=phoneNo;
						break;
					default:
						System.out.println("Enter correct choice");
						break;
					}
					System.out.println("Editted the entered details successfully");
					flag=1;
					break;
			}
				
		}
		if(flag==0)
			System.out.println("No such person");
		
	}
	
	public  static void remove()
	{
		System.out.println("Enter first name of person you want to remove");
		System.out.println("Enter first name:");
		String firstName=sc.next();
		
		int flag=0;
		for(int i=0;i<details.size();i++)
		{
			Person person=details.get(i);
			if(firstName.equals(person.firstName)) {
				flag=1;
				details.remove(person);
				break;
			}
		}
		if(flag==0)
			System.out.println("No such person!");
		
	}
	public static void search()
	{
		System.out.println("Enter first name of person you want to search");
		System.out.println("Enter first name:");
		String firstName=sc.next();
		int flag=0;
		for(int i=0;i<details.size();i++)
		{
			Person person=details.get(i);
			if(firstName.equals(person.firstName)) {
				flag=1;
				System.out.println("First name:"+person.firstName);
				System.out.println("Last name:"+person.lastName);
				System.out.println("Address:"+person.address);
				System.out.println("City:"+person.city);
				System.out.println("State:"+person.state);
				System.out.println("ZipCode:"+person.zipCode);
				System.out.println("Phone number:"+person.phoneNo);
			}
		}
		if(flag==0)
			System.out.println("No such person");
	}
	public static void sort() {
		System.out.println("1.sort by name/n 2.sort by zipCode");
		System.out.println("Enter your choice:");
		int choice=sc.nextInt();
		switch(choice) {
		case 1:
			Collections.sort(details,Person.personLastNameComparator);
			System.out.println("Sorting by last name is successful!");
			break;
		case 2:
			Collections.sort(details,Person.personZipCodeComparator);
			System.out.println("Sorting by zioCode is successful!");
			break;
		default:
			System.out.println("Enter the correct choice");
		}
		
	}
	
	public static void printAll()
	{
		System.out.println("Printing the whole address book");
		if(details.size()==0)
		{
			System.out.println("Address book is empty");
		}
		else
		{
			for(int i=0;i<details.size();i++)
			{
			      Person person=details.get(i);
				System.out.println("First name:"+person.firstName);
				System.out.println("Last name:"+person.lastName);
				System.out.println("Address:"+person.address);
				System.out.println("City:"+person.city);
				System.out.println("State:"+person.state);
				System.out.println("ZipCode:"+person.zipCode);
				System.out.println("Phone number:"+person.phoneNo);
			
				
			}
		}
	}
	
	
	
	
	public static void main(String[] args) {
		System.out.println("Welcome to Address Book");
		int choice=0;
		do
		{
		System.out.println("1.Add a person\n2.Edit a person\n3.Delete a person\n4.Search a person\n5.Sort the Adress Book\n6.Print the Address Book\n7.Exit");
		System.out.println("Select your choice:");
		choice=sc.nextInt();
		switch(choice)
		{
		case 1:
			add();
			break;
		case 2:
			edit();
			break;
		case 3:
			remove();
			break;
		case 4:
			search();
			break;
		case 5:
			sort();
			break;
		case 6:
			printAll();
			break;
		
		case 7:
			System.out.println("Take a Exit");
			break;
		default:
			System.out.println("Enter correct choice:");
			break;
		}
		}while(choice!=7);
	}
	}
	

