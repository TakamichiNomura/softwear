import java.util.*;
/**
 * Write a description of class Library here.
 *
 * @author (your name)
 * @version (2019/11/21)
 */
public class Library
{
    private String name;
    TreeSet<Book> books;
    static TreeSet<Borrower> borrowers;
    Book book;
    public Library(String name){
        this.name = name;
    }

    public Library(int catalogueNumber,String title,String auther){
        book = new Book(catalogueNumber,auther,title);
        books = new TreeSet<Book>();
    }

    public void RegisterOneBorrower(String name){
        this.name = name;
        borrowers = new TreeSet<Borrower>();
        Iterator<Borrower> iterator = borrowers.iterator();
        while(iterator.hasNext()){
            String dish = iterator.next().toString();
            if(this.name.equals(dish)){
                System.out.println("이 이용자는 이미 등록되고 있습니다.");
                break;
            }
        }   
        if(iterator.hasNext() == false){
            Borrower user = new Borrower(this.name);
            borrowers.add(user);
            System.out.println("등록되었습니다");
        }
    }

    public String RequestOneBook(){
        books = new TreeSet<Book>();
        Iterator<Book> iterator = books.iterator();
        while(iterator.hasNext()){
            Book dish = iterator.next();
            if(book.equals(dish)){
                System.out.println("이미 등록되어 있는 책입니다.");
                return " ";
            }
        }
        books.add(book);
        System.out.println("신청되었습니다.");
        return " ";
    }

    public void DisplayBooksForLoan(){
        
    }

    public void DisplayBooksOnLoan(){
        
    }

    public void LendOneBook(int catalogueNumber,String author,String title){
        FindBook(catalogueNumber, author, title);
    }

    public void RetrunOneBook(int catalogueNumber,String auther,String title){
        book.detachBorrower(catalogueNumber,auther,title);
    }
    
    public void RegisterOneBook(String title, String author, int catalogueNumber){
        book = new Book(catalogueNumber, author, title);
        book.BookList(catalogueNumber, author, title);
        book.BookAdd(catalogueNumber, author, title);
    }
    
    public String FindBook(int catalogueNumber,String author,String title){
        Book book = new Book(catalogueNumber, author, title);
        Iterator<Book> iterator = books.iterator();
        while(iterator.hasNext()){
            Book dish = iterator.next();
            if(book.equals(dish)){
                System.out.println("catalogueNumber,title,auther"+
                    book);
                return " ";
            }
        }
        System.out.println("찾으신 책이 없습니다.");
        return " ";
    }
    
}
