
import java.util.*;
public class libraryFramework{
}
class Book implements Comparable
{
   private String title;
   private String author;
   private String ISBN;
   private double price;
   public Book(String title, String author, String ISBN,double price)
   {
      this.title = title;
      this.author = author;
      this.ISBN = ISBN;
      this.price = price;
   }
   public String getTitle()
   {
      return title;
   }
   public String getAuthor()
   {
      return author;
   }
   public String getISBN()
   {
      return ISBN;
   }
   public double getPrice()
   {
      return price;
   }
   public void setTitle(String t)
   {
      title = t;
   }
   public void setPrice(double p)
   {
      price = p;
   }
   public void setIsbn(String sb)
   {
      ISBN = sb;
   }
   public String toString()
   {
      return title+ ", " + author+", "+price+", "+ISBN;
   }
   public boolean equals(Book other) {
      return this.ISBN.equals(other.ISBN);
   }
   public int compareTo(Object o) {
      //if object o is a book, then return 0 if o and this book have the same title
      if(o instanceof Book){
         Book mb = (Book)o;
         return this.title.compareTo(mb.title);
      }
      return 1;
   }
   public int compares(Book b){
      //return whether this book and b have the same author
      return this.author.compareTo(b.author);
   }
   public double compare(Book b){
      //if b's other is equal to this book's author return difference in price else just return whether they have same author
      if(this.author.compareTo(b.author) == 0){
         return this.price - b.price;
      }
      else{
         return author.compareTo(b.author);
      }
   }
}
class BookStore
{
   private ArrayList<Book> books;
   public BookStore()
   {
      books = new ArrayList<Book>();
   }
   public void add(String title, String author, double price, String isbn)
   {
      books.add(new Book(title, author,isbn, price));
   }
   public String toString()
   {
      String s = "";
      for(int i = 0; i < books.size(); i++)
      {
         s= s+ books.get(i).toString()+"\n";
      }
      return s;
   }
   public boolean delete(String isbn)
   {
      for(int i = 0; i < books.size(); i++)
      {
         if (books.get(i).getISBN().equals(isbn))
         {
            books.remove(i);
            return true;
         }
      }
      return false;
   }
   public void selectionSort(){
      //iterates through list and sorts by selection sorting algorithm using title of book.
      for(int i = 0; i <books.size(); i++)
      {
         int index = 0;
         boolean s = false;
         Book b1 =books.get(i);
         for(int j = i+1; j < books.size(); j++)
         {
            if(books.get(j).compareTo(b1) < 0)
            {
               index = j;
               b1 = books.get(j);
               s = true;
            }
         }
         if(s)
         {
            Book temp = books.get(i);
            books.set(i,books.get(index));
            books.set(index ,temp);
         }
      }
            
    }

   public  void insertionSort( ){
      //iterates through list, books, and uses insertion sorting algorithm to sort based on author.
      for(int z = 0; z < books.size() -1; z++)
      {
         int k = z+1;
         Book n = books.get(k);
         while(k > 0 && n.compares(books.get(k-1)) < 0)
         {
            books.set(k,books.get(k-1));
            k--;
         }
         books.set(k,n);
      }
   }
   public void bubbleSort(){
      //iterates through list and uses bubble sorting algorithm to sort by author as well as price
      for(int a = 0; a <books.size() ; a++)
      {
         for(int d = 0 ; d <books.size() -1 - a; d++)
         {
            if(books.get(d+1).compare(books.get(d)) < 0)
            {
               Book temp = books.get(d) ;
               books.set(d,  books.get(d+1));
               books.set(d+1, temp);
            }
         }
      }
   }
   public Book binarySearch(String title)
   //searches through list of books using binary search to find book using title
   {
      selectionSort();
      int temp1 = 0;
      int temp2 = books.size() -1;
      int bk = (temp1 + temp2)/2;
      while (temp1 <= temp2)
      {
         if(books.get(bk).getTitle().equalsIgnoreCase(title))
            return books.get(bk);
         if(title.compareTo(books.get(bk).getTitle()) > 0)
            temp1 = bk + 1;
         else
            temp2 = bk -1;
         bk =( temp1 + temp2)/2  ;
      }
      return null;
   }

}
   
class Driver
{
   public static void main(String[] args)
   {
      Scanner kb = new Scanner(System.in);
      BookStore myStore = new BookStore();
      myStore.add("Java","Zoie",23.56,"12345678");
      myStore.add("Python","Elina",23.56,"2");
    
      myStore.add("Advance Java","Stewart",98,"767676576");
      myStore.add("Build Java","Liang",45,"56786565y76");
      myStore.add("Zip lining", "Stewart",12,"1234566576");
      myStore.add("C++","Elina",23.56,"2645556");
      myStore.add("Programming Java","Stewart",124,"75465666");
      myStore.add("Humanity","Smith",100.56,"234545657");
      boolean b = true;
      while(b)
      {
         System.out.println("Enter 1 to sort based on the title");
         System.out.println("Enter 2 to sort based on the author");
         System.out.println("Enter 3 to sort based on the author, and the price");
         System.out.print("Enter your choice: ");
         int option = kb.nextInt();
         System.out.println("\n*************");
         if(option == 1)
         {
            System.out.println("Sorted based on the title\n");
            myStore.selectionSort();
         }
         else if (option == 2)
         {
            System.out.println("Sorted based on the author\n");
            myStore.insertionSort();
         } 
         
         else  
         {
            System.out.println("Sorted based on the author and price\n");
            myStore.bubbleSort();
         }   
         System.out.println(myStore);
         System.out.println("\n     **************     ");
         System.out.println("Enter the title of the book to search for it: ");
         kb.nextLine();
         String t = kb.nextLine();
         
         Book book = myStore.binarySearch(t);
         if(book != null)
            System.out.println(book);
         else
           System.out.println("Book not found");   
         System.out.println("\n");
            
      }  
   
   }
}
class YourDriver
{
   public static void main(String[] args)
   {
         Scanner kb = new Scanner(System.in);
         BookStore myStore = new BookStore();
         myStore.add("Egypt","Salah",19.52,"19222011");
         myStore.add("Senegal","Mane",20.22,"1443");
         myStore.add("yay","woo",100,"123145");
         myStore.add("Sac State","Hornet",21,"0987");
         myStore.add("Bees", "Honey",15,"5748290");
         myStore.add("Computer Science","Java Python",1000,"10982374");
         boolean b = true;
         while(b) {
            System.out.println("Enter 1 to sort based on the title");
            System.out.println("Enter 2 to sort based on the author");
            System.out.println("Enter 3 to sort based on the author, and the price");
            System.out.print("Enter your choice: ");
            int option = kb.nextInt();
            System.out.println("\n*************");
            if (option == 1) {
               System.out.println("Sorted based on the title\n");
               myStore.selectionSort();
            } else if (option == 2) {
               System.out.println("Sorted based on the author\n");
               myStore.insertionSort();
            } else {
               System.out.println("Sorted based on the author and price\n");
               myStore.bubbleSort();
            }
            System.out.println(myStore);
            System.out.println("\n     **************     ");
            System.out.println("Enter the title of the book to search for it: ");
            kb.nextLine();
            String t = kb.nextLine();

            Book book = myStore.binarySearch(t);
            if (book != null)
               System.out.println(book);
            else
               System.out.println("Book not found");
            System.out.println("\n");
         }
   }
}