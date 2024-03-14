package uz.akbar;

import uz.akbar.service.ServiceImpl;

import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        /*
         * 1. Choose fromSumTo or FromCurrencyToSum
         * 2. Input from amount
         * 3. Choose to currency type: the other two
         * 4. Calculate and show amount
         */

        boolean isOnBoard = true;
        String choice;

        Scanner sc = new Scanner(System.in);
        ServiceImpl service = new ServiceImpl();

        System.out.println();
        System.out.println("#######_Markaziy Bank Valyuta Konvertori_#######");

        while (isOnBoard) {
            System.out.println();
            System.out.println("1.So'mdan valyutaga konvertatsiya");
            System.out.println("2.Valyutadan so'mga konvertatsiya");
            System.out.println("3.Chiqish");
            System.out.print("=> ");

            choice = sc.nextLine();
            switch (choice) {
                case "1":
                    System.out.println();
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    System.out.println("1.So'mdan Dollarga");
                    System.out.println("2.So'mdan Yevroga");
                    System.out.println("3.So'mdan Rublga");
                    System.out.println("4.Orqaga");
                    System.out.print("=> ");
                    choice = sc.nextLine();
                    switch (choice) {
                        case "1":
                            service.sumToDollar();
                            break;
                        case "2":
                            service.sumToEuro();
                            break;
                        case "3":
                            service.sumToRouble();
                            break;
                        case "4":
                            System.out.println();
                            System.out.println("Ortga");
                            break;
                        default:
                            System.out.println("Noto'g'ri tanlov!");
                            break;
                    }
                    break;
                case "2":
                    System.out.println();
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    System.out.println("1.Dollardan so'mga");
                    System.out.println("2.Yevrodan so'mga");
                    System.out.println("3.Rubldan so'mga");
                    System.out.println("4.Orqaga");
                    System.out.print("=> ");
                    choice = sc.nextLine();
                    switch (choice) {
                        case "1":
                            service.dollarToSum();
                            break;
                        case "2":
                            service.euroToSum();
                            break;
                        case "3":
                            service.roubleToSum();
                            break;
                        case "4":
                            System.out.println();
                            System.out.println("Ortga");
                            break;
                        default:
                            System.out.println("Noto'g'ri tanlov!");
                            break;
                    }
                    break;
                case "3":
                    isOnBoard = false;
                    break;
                default:
                    System.out.println("Noto'g'ri tanlov!");
                    break;
            }
        }
    }
}