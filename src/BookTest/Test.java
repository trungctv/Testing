/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BookTest;

import PkgBasic.Book;
import PkgBasic.DetectiveBook;
import PkgExtend.BookList;
import PkgExtend.ScienceBook;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

/**
 *
 * @author Quang Trung
 */
public class Test {
    public static void main(String[] args) {
        // TODO code application logic here
        BookList ml = new BookList();
        Scanner scn;
        int choice = 0;
        do {
            System.out.println("1. Add a Detective Book");
            System.out.println("2. Add a ScienceBook");
            System.out.println("3. Delete a book");
            System.out.println("4. Update a book");
            System.out.println("5. Display All DetectiveBooks");
            System.out.println("6. Display All ScienceBooks");
            System.out.println("7. Search by code");
            System.out.println("8. Search by title");
            System.out.println("9. Search and display all books by yearofpublish");
            System.out.println("10. Exit");
            boolean lamtiep = true;
            while (lamtiep) {
                try {
                    scn = new Scanner(System.in);
                    System.out.println("Input choice: ");
                    choice = scn.nextInt();
                    lamtiep = false;
                } catch (InputMismatchException a) {
                    System.out.println("Choice is an integer");
                }
            }

            switch (choice) {
                case 1:
                    DetectiveBook w = new DetectiveBook();
                    w.inputBook();
                    if (ml.addBook(w)) {
                        System.out.println("Added ");
                    } else {
                        System.out.println("Add fail");
                    }
                    break;
                case 2:
                    ScienceBook e = new ScienceBook();
                    e.inputBook();
                    if (ml.addBook(e)) {
                        System.out.println("Added ");
                    } else {
                        System.out.println("Add fail");
                    }
                    break;
                case 3:
                    String dBook = "";
                    lamtiep = true;
                    while (lamtiep) {
                        try {
                            System.out.println("Input a book code need delete: ");
                            scn = new Scanner(System.in);
                            dBook = scn.nextLine();
                            if (!dBook.matches("B[0-9]{1}")) {
                                throw new Exception("Code has format: Bx , x belong to[0-9]");
                            }
                            lamtiep = false;
                        } catch (Exception t) {
                            System.out.println(t.getMessage());
                        }
                    }

                    if (ml.deleteBook(dBook)) {
                        System.out.println("Deleted");
                    } else {
                        System.out.println("Do not have a book");
                    }
                    break;
                case 4:
                    String updateCode = "";
                    lamtiep = true;
                    while (lamtiep) {
                        try {
                            System.out.println("Input update a book code: ");
                            scn = new Scanner(System.in);
                            updateCode = scn.nextLine();
                            if (!updateCode.matches("B[0-9]{1}")) {
                                throw new Exception("Code has format: Bx , x belong to[0-9]");
                            }
                            lamtiep = false;
                        } catch (Exception t) {
                            System.out.println(t.getMessage());
                        }
                    }
                    if (ml.updateBook(updateCode)) {
                        System.out.println("Updated");
                    } else {
                        System.out.println("Not found");
                    }
                    break;
                case 5:
                    ml.displayDetectiveBooks();
                    break;
                case 6:
                    ml.displayScienceBooks();
                    break;
                case 7:
                    String searchCode = "";
                    lamtiep = true;
                    while (lamtiep) {
                        try {
                            System.out.println("Input code need search: ");
                            scn = new Scanner(System.in);
                            searchCode = scn.nextLine();
                            if (!searchCode.matches("B[0-9]{1}")) {
                                throw new Exception("Code has format: Bx , x belong to[0-9]");
                            }
                            lamtiep = false;
                        } catch (Exception t) {
                            System.out.println(t.getMessage());
                        }
                    }
                    Book rs = ml.searchBook(searchCode);
                    if (rs != null) {
                        System.out.print("Found: ");
                        rs.outputBook();
                    } else {
                        System.out.println("Not found");
                    }
                    break;
                case 8:
                    String searchTitle = "";
                    lamtiep = true;
                    while (lamtiep) {
                        try {
                            System.out.println("Input title need search: ");
                            scn = new Scanner(System.in);
                            searchTitle = scn.nextLine();
                            if (searchTitle.matches("")) {
                                throw new Exception("Can not empty");
                            }
                            lamtiep = false;
                        } catch (Exception ee) {
                            System.out.println(ee.getMessage());
                        }
                    }
                    boolean check = ml.search(searchTitle);
                    if (!check) {
                        System.out.println("Not Found");
                    }
                    break;
                case 9:
                    int year = 0;
                    lamtiep = true;
                    while (lamtiep) {
                        try {
                            System.out.println("Input year need search: ");
                            scn = new Scanner(System.in);
                            year = scn.nextInt();
                            if (year > 9999 || year < 1000) {
                                throw new Exception("Input year with 4 numbers");
                            }
                            lamtiep = false;
                        } catch (InputMismatchException a) {
                            System.out.println("Input year is integer");
                        } catch (Exception b) {
                            System.out.println(b.getMessage());
                        }
                    }
                    TreeSet<Book> b = ml.Search(year);
                    if (b.isEmpty()) {
                        System.out.println("Not found");
                    } else {
                        System.out.println("Found: ");
                        Iterator<Book> tmp = b.iterator();
                        Book book;
                        while (tmp.hasNext()) {
                            if ((book = tmp.next()) instanceof DetectiveBook) {
                                book.outputBook();
                            }
                        }
                    }
                    break;
                case 10:
                    System.out.println("Good bye");
                    return;
            }
            if (choice < 1 || choice > 10) {
                System.out.println("Please enter from 1 to 10");
            }
            System.out.println("");
        } while (choice >= 1 || choice <= 10);
    }
}
