/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PkgBasic;

import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author Quang Trung
 */
public class Book implements Comparable<Book> {
    protected String code;
    protected String title;
    public Book()
    {
        
    }

    public Book(String code, String title) {
        this.code = code;
        this.title = title;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Book{" + "code=" + code + ", title=" + title + '}';
    }
    
    public void inputBook() {
        Scanner sc;
        boolean lamtiep = true;

        while (lamtiep) {
            try {
                System.out.print("Input code: ");
                sc = new Scanner(System.in);
                code = sc.nextLine();
                if (!code.matches("B[0-9]{1}")) {
                    throw new Exception("Code has format: Bx , x belong to[0-9]");
                }
                lamtiep = false;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        lamtiep=true;
        while (lamtiep) {
            try {
                System.out.println("Input title: ");
                sc = new Scanner(System.in);
                title = sc.nextLine();
                if (title.matches("")) {
                    throw new Exception("Can not empty");
                }
                lamtiep = false;
            } catch (Exception ee) {
                System.out.println(ee.getMessage());
            }
        }
    }

    public void outputBook() {
        System.out.println(this.toString());
    }

    @Override
    public int compareTo(Book o) {
        if (code.compareTo(o.getCode()) > 0)
            return 1; // hoan vi 2 book=> sx tang theo id
        else if(code.compareTo(o.getCode()) < 0)
            return -1;// sx giam dan
        return 0;
    }
     //so sanh 2 Book dua vao name
    public static Comparator<Book> byName= new Comparator<Book>() {
        @Override
        public int compare(Book o1, Book o2) {
            if(o1.getTitle().compareTo(o2.getTitle())>0)
                return 1; //sx tang theo ten
            else
                if(o1.getTitle().compareTo(o2.getTitle())<0)
                    return -1;
            return 0;
        }
    }
            }