import java.util.*;
/**
 * Write a description of class Library here.
 *
 * @author (your name)
 * @version (2019/11/28)
 */
public class Library
{
    private String name;
    static TreeSet<Book> books;
    static HashSet<Borrower> borrowers;
    Book book;
    public Library(String name){
        this.name = name;
    }

    public Library(int catalogNumber,String title,String auther){
        book = new Book(catalogNumber,auther,title);
        books = new TreeSet<Book>();
    }

    public void RegisterOneBorrower(String name){
        this.name = name;
        borrowers = new HashSet<Borrower>();
        Iterator<Borrower> iterator = borrowers.iterator();
        while(iterator.hasNext()){
            Borrower dish = iterator.next();
            dish.toString();
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

    public void LendOneBook(String name,int catalogNumber,String auther,String title){
        this.name = name;
        this.book = new Book(catalogNumber,auther,title);
        book.attachBorrower(this.name,this.book);
    }

    public void RetrunOneBook(int catalogNumber,String auther,String title){
        book.detachBorrower(catalogNumber,auther,title);
    }

    public String FindBook(){
        Iterator<Book> iterator = books.iterator();
        while(iterator.hasNext()){
            Book dish = iterator.next();
            if(book.equals(dish)){
                System.out.println("catalogNumber,title,auther"+
                    book);
                return " ";
            }
        }
        System.out.println("찾으신 책이 없습니다.");
        return " ";
    }
}
