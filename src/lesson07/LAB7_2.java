package lesson07;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LAB7_2 {

    static List<Book> bookList = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isContinuing = true;
        while (isContinuing){
            System.out.println("========Menu==========");
            System.out.println("1. To add a new book");
            System.out.println("2. To retrieve book");
            System.out.println("3. Exit");
            int userOption = scanner.nextInt();
            switch (userOption){
                case 3:
                    System.out.println("Thank you!");
                    isContinuing = false;
                    break;
                case 1:
                    addBook();
                    break;
                case 2:
                    System.out.println("Input the book ISBN: ");
                    String ISBN = scanner.next();
                    retrieveBookInfo(ISBN);
                    break;
                default:
                    System.out.println("Wrong option!");
                    break;
            }
        }
        
    }

    private static void retrieveBookInfo(String ISBN) {
        for (Book book : bookList) {
            if(book.getISBN().equals(ISBN)){
                System.out.println(book.toString());
                return;
            }
            System.out.println("There is no book has ISBN " + ISBN + ". Please try again!!!");
        }
    }

    private static void addBook() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Book ISBN: ");
        String bookISBN = scanner.nextLine();


        System.out.println("Book Title: ");
        String bookTitle = scanner.nextLine();

        Book book = new Book.Builder().ISBN(bookISBN).title(bookTitle).build();
        bookList.add(book);
        System.out.println(book.getISBN() + " | " + book.getTitle());
    }
}
