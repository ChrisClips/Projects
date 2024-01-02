/*
Name: Christopher Le
Description: My program allows the user to search for homes under their criteria. The user is able to add and remove homes as well.
Date: 10/11/23
Self grade: A, because I properly input the code that I needed. The program was able to compile and run like the output reference on the assignment. I also made my own driver with different addressed and bed/bath counts.
*/
import java.util.Scanner;
//Do not delete the ZillowLastname 
public class ZillowLe // must change this name to include your last name
{
  // no code here
}

class House implements Comparable<Object>{
   //instance varibales
    private int rooms;
    private int baths;
    private double area;
    private String address;
    private double price;
    public String zipcode;
   
   
   	//constructor
   public House(int rooms, int baths,double area,String address,double price, String zipcode){
         this.rooms = rooms;
        this.baths = baths;
        this.area = area;
        this.address = address;
        this.price = price;
        this.zipcode = zipcode; 
         
   }
   //getter methods	
   public double getPrice() {
      return price;
   }
   public double getArea() {
      return area;
   }
   public int getRooms() {
      return rooms;
   }
   public double getBaths()
   {
      return baths;
   }
   public String getAddress()
   {
      return address;
   }
   public String getZipcode()
   {
      return zipcode;
     
   }
   //setter methods
   public void setRooms(int rooms) {
      this.rooms = rooms;
   }
   public void setBaths(int baths)
   {
      this.baths = baths;
   }
   public void setArea(double area)
   {
       this.area = area;
   }
   public void setPrice(double price)
   {
       this.price = price;
   }
	/*equals method : return true if the two houses have the same address,
    returns false otherwise*/
    	
   public boolean equals(Object o) {
   
            //your code;
      if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        House house = (House) o;
        
        return address.equals(house.address);
   }
   /*
   compareTo method compares the prices of the two houses. This method can be used to list
   the houses based on the proce from low to high
   */
   public int compareTo(Object o) {
   
   //your code
   if (o == null || getClass() != o.getClass()) return -1;
        House house = (House) o;
        
        return Double.compare(this.price, house.price);
   }
	/*represents a house information in a specific format. refer to the sample output*/
   public String toString() {
    return "Rooms: " + rooms + "\nBaths: " + baths + "\nSquare Feet: " + area +
            "\nPrice: $" + price + "\nZipcode: " + zipcode + "\nAddress: " + address + "\n**********************\n";
   }
	
}

class ListNode{
   private House house;
   private ListNode next;
	
   public ListNode(House house) {
      this.house = house;
   }
   public ListNode(House h, ListNode next) {
      this.house = h;
      this.next = next;
   }
   public ListNode()
   {
   
   }
	
   public House getHouse() {
      return house;
   }
   public ListNode getNext() {
      return next;
   }
   public void setNext(ListNode next) {
      this.next = next;
   }
	
}

interface List{
   public void add(int rooms, int baths, double price, double area, String address,String zipcode);  //listing a house, adds a house to the list
   public void add(int rooms, int baths,  double area, String address,double price, String zipcode, int index);//adding  a house to the list at the given index
   public void remove(String address);//removing a house from the list with the given address
   public int size();//returns the number of the houses in the list
   public String toString();//returns  list all the houses
   public String search(int room); //returns the list all the houses with the given number of the rooms 
   public String search(int room, int bath); //returns the  list all the houses with the given number of the rooms and baths 
   public String search(String zipcode);// returns all the houses with the given zipcode
}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

class Zillow implements List
{
   private ListNode head;
   public static int size = 0;
	
   public Zillow() {
      head = null;
   }
  // constructor
   public Zillow(House house) {
      head = new ListNode(house);
      size++;
   }
   /*adds a house to the end of the end of the listlist */
   public void add(int rooms, int baths, double price, double area, String address,String zipcode)
   {
   
     //your code
     
     ListNode newNode = new ListNode(new House(rooms, baths, area, address, price, zipcode));
        if (head == null) {
            head = newNode;
        } else {
            ListNode current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
        size++;
   
   }
   
   /*add a house to the list at the given index*/
   public void add(int rooms, int baths,  double area, String address,double price, String zipcode, int index)
   {
      //your code    	
      if (index < 0 || index > size) {
            // Invalid index, do nothing
            return;
        }

        ListNode newNode = new ListNode(new House(rooms, baths, area, address, price, zipcode));
        if (index == 0) {
            newNode.setNext(head);
            head = newNode;
        } else {
            ListNode current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.getNext();
            }
            newNode.setNext(current.getNext());
            current.setNext(newNode);
        }
        size++;
   }

	/*removes a house from the list with the given address*/
   public void remove(String address)
   {
      //your code
      
      if (head == null) {
            // Empty list, do nothing
            return;
        }

        if (head.getHouse().getAddress().equals(address)) {
            // Remove the first node
            head = head.getNext();
            size--;
            return;
        }

        ListNode current = head;
        while (current.getNext() != null && !current.getNext().getHouse().getAddress().equals(address)) {
            current = current.getNext();
        }

        if (current.getNext() != null) {
            // Remove the node
            current.setNext(current.getNext().getNext());
            size--;
        }
   }

  /*returns the size of the list*/
  	
   public int size()
   {
      return  size;
   }
	/*returns a string with the list of all the houses*/
   public String toString() 
   {
      StringBuilder result = new StringBuilder();
        ListNode current = head;
        while (current != null) {
            result.append(current.getHouse().toString());
            current = current.getNext();
        }
        return result.toString();
   }
      
   
  /*this method searches the list to find all the houses with the given number of the rooms
  create a string of all the houses and returns the string*/
 
   public String search(int rooms) {
      String list = "";
      if(head == null )  { 
         return null; 
      }else {
         ListNode curr = head; 
         while(curr!= null)
         {
            if(curr.getHouse().getRooms() == rooms)
            {
               list = list + curr.getHouse().toString();
            }
            curr = curr.getNext();
               
         }
         return list;
      }
   }
   
   //searches the list to find all all the houses with the specific number of roooms and bath
   public String search(int rooms, int baths) 
   {
   
       //your code
        StringBuilder result = new StringBuilder();
        ListNode current = head;
        while (current != null) {
            if (current.getHouse().getRooms() == rooms && current.getHouse().getBaths() == baths) {
                result.append(current.getHouse().toString());
            }
            current = current.getNext();
        }
        return result.toString();
        
        
   }
   /*Searches the list to find all the houses at the given zipcode*/
   public String search(String zipcode)
   {
      String list = "";
      if(head == null )  { 
         return null; 
      }else {
         ListNode curr = head; 
         while(curr!= null)
         {
            if(curr.getHouse().getZipcode().equals(zipcode))
            {
               list = list + curr.getHouse().toString();  //creating the string
            }
            curr = curr.getNext();
               
         }
         return list;
      }
   
   }
  /*Searches the list to find the most expensive house in the market*/
   public House mostExpensiveHouse()
   {
       if (head == null) {
      return null;
   } else {
      // Make a copy of the head node
      ListNode curr = head;

      // Declare a variable of type House and set it to null
      House mostExpensive = curr.getHouse();

      // While curr.getNext() is not null
      while (curr.getNext() != null) {
         // If the price of the house at the curr node is greater than the mostExpensive
         if (curr.getHouse().getPrice() > mostExpensive.getPrice()) {
            // Set the mostExpensive to the house at the current node
            mostExpensive = curr.getHouse();
         }

         // Curr should be assigned to curr.getNext() 
         curr = curr.getNext();
      }

      return mostExpensive;
   }  
   }
   /*Searches the list to find the least expensive house in the list*/
   public House leastExpensiveHouse() { 
   if (head == null) {
      return null;
   } else {
      // Make a copy of the head node
      ListNode curr = head;
      
      // Declare a variable of type House and set it to null
      House leastExpensive = curr.getHouse(); 
      
      // Declare a variable for the price set it to a max value
      double price = Double.MAX_VALUE;  // Fixed the data type to Double
      
      // While curr.getNext() is not null
      while (curr.getNext() != null) {  // Added parentheses and fixed method call
         // If the price of the house at the curr node is less than the price 
         if (curr.getHouse().getPrice() < price) {
            // Set the leastExpensive to the house at the current node
            leastExpensive = curr.getHouse();
            // Set the price to the price of the house at the curr node
            price = leastExpensive.getPrice();
         }

         // Curr should be assigned to curr.getNext() 
         curr = curr.getNext();
      }
      
      return leastExpensive;
   }  
}
 }  

/*Do not delete the Driver class
Your program will be graded based on the running of the given Driver. Make sure that the output of your code matches 
exactly the given output. Otherwise a lot of points will be lost*/
class Driver
{
   public static void main(String[] args)
   {
      Zillow  list = new Zillow();
   // public House(int rooms, int baths,double area,String address,double price, String zipcode){
   //add(int rooms, int baths, double price, double area, String address,String zipcode) {
      list.add(2,3,710000,1200,"Sahnnan Bay Drive", "95677");
      list.add(4,3,1700000,3000,"Miners Cir", "95677");
      list.add(2,2,650000,1400,"Albatroos Way", "95677");
      list.add(2,3,600000,1200,"Halidon Drive", "95630");
      list.add(2,3,750000,12500,"Taylor St", "95630");
      list.add(2,3,700000,1100,"Canyon Drive", "95762");
      list.add(5,4,1650000,2300,"Ridge View Drive", "95762");
      list.add(3,2,722000,2300,"Vila Flor", "95630");
      
     // System.out.println(list);
      Scanner kb = new Scanner(System.in);
      while(true)
      {
         choice();
         System.out.print("Select an option: ");
         int option = kb.nextInt();
         switch(option)
         {
            case 1: System.out.print("Enter the zipcode: ");
               String zip = kb.next();
               String s = list.search(zip);
               if (s.length() != 0)
                  System.out.println(s);
               else
                  System.out.println("No house wasfound");   
               break;
            case 2: System.out.print("Enter the number of the rooms: ");
               int rooms = kb.nextInt();
               s = list.search(rooms);
               if (s.length() != 0)
                  System.out.println(s);
               else
                  System.out.println("No house wasfound");
               break;
            case 3: System.out.print("Enter the number of the rooms and the number of the baths: ");
               rooms = kb.nextInt();
               int baths = kb.nextInt();
               s = list.search(rooms, baths);
               if (s.length() != 0)
                  System.out.println(s);
               else
                  System.out.println("No house wasfound");
               break;
            case 4:System.out.print("Enter the adress of the house: ");
               kb.nextLine();
               String address  = kb.nextLine();
               list.remove(address);
                   //if (s.length() != 0)
                     // System.out.println(s);
                  // else
                      //System.out.println("No house wasfound");
               break;
            case 5:System.out.print("Enter the number of the rooms: ");
               rooms = kb.nextInt();
               System.out.print("Enter the number of the baths: ");
               baths = kb.nextInt();
               System.out.print("Enter the price of the house: ");
               double price = kb.nextDouble();
               System.out.print("Enter the sqaure feet of the house: ");
               double area = kb.nextDouble();
               System.out.print("Enter the zip code: ");
               zip = kb.next();
               kb.nextLine();
               System.out.print("Enter the address: ");
               address = kb.nextLine();
                    //int rooms, int baths, double price, double area, String address,String zipcode)
               list.add(rooms, baths,price,area,address,zip);
               break;
             
            case 6: System.out.println(list);
               break;
             
             
            case 7:System.out.println(list.mostExpensiveHouse()); 
               break;
             
            case 8: System.out.println(list.leastExpensiveHouse()); 
               break;   
         
            
                          
         } 
      }
      
       
   }
   public static void choice()
   {
      System.out.println("\n*********************************************************\n");
      System.out.println("Enter 1 to list the houses based on the zipcode");
      System.out.println("Enter 2 to list the houses based on the number of the rooms");
      System.out.println("Enter 3 to list the houses with the number of rooms and baths");
      System.out.println("Enter 4 to remove a house from the list");
      System.out.println("Enter 5 to add a house to the list");
      System.out.println("Enter 6 to list all the houses");
      System.out.println("Enter 7 to list the most expensive house");
      System.out.println("Enter 8 to list the least expensive house");
      System.out.println("***************************************************\n");
   }
   
   
}
	
 
