/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PkgExtend;

import PkgBasic.Book;
import java.util.Scanner;

/**
 *
 * @author Quang Trung
 */
public class ScienceBook extends Book {

    private String type;

    public ScienceBook() {

    }

    public ScienceBook(String type, String Code, String Title) {
        super(Code, Title);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "ScienceBook{" + " code=" +super.getCode() +", title=" + super.getTitle() + ", type=" + type + '}';
    }

    @Override
    public void inputBook() {
        super.inputBook();
        Scanner sc = new Scanner(System.in);
        boolean lamtiep = true;

        while (lamtiep) {
            try {
                System.out.println("Input type: ");
                sc = new Scanner(System.in);
                type = sc.nextLine();
                if (!type.matches("physical") && !type.matches("mathematic") && !type.matches("chemistry")) {
                    throw new Exception("Type belong to physical,  mathematic, chemistry");
                }
                lamtiep = false;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
    }
}
