/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PkgExtend;

import PkgBasic.Book;
import PkgBasic.DetectiveBook;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

/**
 *
 * @author Quang Trung
 */
public class BookList {  
    private TreeSet<Book> arr;
    final int MAX = 100;
    
    public BookList() {
        arr = new TreeSet<>();
    }
    
    public boolean addBook(Book b) {
        if (arr.add(b)) {
            return true;
        }
        
        return false;
    }
    
    public void displayAll() {
        Iterator<Book> tmp = arr.iterator();
        while (tmp.hasNext()) //tam #null
        {
            Book b = tmp.next();
            System.out.println(b.toString());
        }
    }
    
    public Book searchBook(String code) {
        for (Book book : arr) {
            if (book.getCode().equals(code)) {
                return book;
            }
        }
        return null;
    }
    
    public boolean updateBook(String code) {
        Book rs = searchBook(code);
        boolean lamtiep = true;
        Scanner sc;
        if (rs != null) {
            while(lamtiep)
        {
            try
            {
                System.out.println("Input title: ");
                sc = new Scanner(System.in);
                String title = sc.nextLine();
                if(title.matches(""))
                    throw new Exception("Can not empty");
                rs.setTitle(title);
                lamtiep = false;                       
            }
            catch(Exception ee)
            {
                System.out.println(ee.getMessage());
            }
        }
            if (rs instanceof DetectiveBook) {
                lamtiep = true;
                while (lamtiep) {
                    try {
                        System.out.println("Input price: ");
                        sc = new Scanner(System.in);
                        ((DetectiveBook) rs).setPrice(sc.nextInt());
                        
                        lamtiep = false;
                    } catch (InputMismatchException a) {
                        System.out.println("Input price is integer");
                    }
                }
                
                lamtiep = true;
                while (lamtiep) {
                    try {
                        System.out.println("Input yearofpublication: ");
                        sc = new Scanner(System.in);
                        int yearofpublication = sc.nextInt();
                        ((DetectiveBook) rs).setYearofpublication(yearofpublication);
                        if (yearofpublication > 9999 || yearofpublication < 1000) {
                            throw new Exception("Input year with 4 numbers");
                        }
                        lamtiep = false;
                    } catch (InputMismatchException a) {
                        System.out.println("Input yearofpublication is integer");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    
                }
            } else if (rs instanceof ScienceBook) {
                lamtiep = true;
                while (lamtiep) {
                    try {
                        System.out.println("Input type: ");
                        sc = new Scanner(System.in);
                        String type = sc.nextLine();
                        
                        if (!type.matches("physical") && !type.matches("mathematic") && !type.matches("chemistry")) {
                            throw new Exception("Type belong to physical,  mathematic, chemistry");
                        }
                        ((ScienceBook) rs).setType(type);
                        lamtiep = false;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    
                }
            }
            return true;
        }
        return false;
    }
    
    public boolean deleteBook(String code) {
        Book rs = searchBook(code);
        //ta chia thanh 2 TH thay va khong thay
        if (rs == null) {
            return false;
        }
        arr.remove(rs);
        return true;
    }
    
    public void displayDetectiveBooks() {
        if(arr.isEmpty()) {
            System.out.println("Empty list");
            return;
        }
        Iterator<Book> tmp = arr.iterator();
        Book b;
        while (tmp.hasNext()) //tam #null
        {
            if ((b = tmp.next()) instanceof DetectiveBook) {
                b.outputBook();
            }
        }
        
    }
    
    public void displayScienceBooks() {
        if(arr.isEmpty()) {
            System.out.println("Empty list");
            return ;
        }
        Iterator<Book> tmp = arr.iterator();
        Book b;
        while (tmp.hasNext()) //tam #null
        {
            if ((b = tmp.next()) instanceof ScienceBook) {
                b.outputBook();
            }
        }
        
    }
    
    public TreeSet<Book> Search(int YearOfPublish) {
        TreeSet<Book> b = new TreeSet<>();
        for (Book book : arr) {
            if (book instanceof DetectiveBook) {
                if (((DetectiveBook) book).getYearofpublication() == YearOfPublish) {
                    b.add(book);
                }
            }
        }
        return b;
    }
    
    public boolean search(String title) {
        for (Book book : arr) {
            if (book.getTitle().equals(title)) {
                System.out.print("Found: ");
                book.outputBook();
                return true;
            }
        }
        return false;
    }
    
}
