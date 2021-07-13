/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PkgBasic;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Quang Trung
 */

    public class DetectiveBook extends Book {

    int price;
    int yearofpublication;

    public DetectiveBook() {

    }

    public DetectiveBook(int price, int yearofpublication) {
        this.price = price;
        this.yearofpublication = yearofpublication;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getYearofpublication() {
        return yearofpublication;
    }

    public void setYearofpublication(int yearofpublication) {
        this.yearofpublication = yearofpublication;
    }

    @Override
    public String toString() {
        return "DetectiveBook{" + " code=" +super.getCode() +", title=" + super.getTitle() +  ", yearofpublication=" + yearofpublication + ", price=" + price +'}';
    }

    @Override
    public void inputBook() {
        super.inputBook();
        Scanner sc;
        boolean lamtiep = true;

        while (lamtiep) {
            try {
                System.out.println("Input price: ");
                sc = new Scanner(System.in);
                price = sc.nextInt();
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
                yearofpublication = sc.nextInt();
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
    }

}
