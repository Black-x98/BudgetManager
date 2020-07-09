package budget;

import java.util.ArrayList;
import java.util.Scanner;


class BudgetManager{

    double total = 0;
    Scanner sc;
    double Balance;
    ArrayList<String>[] ListOfPurchases = new ArrayList[4];

    void calculateTotal(){

        sc = new Scanner(System.in);
        while(sc.hasNext()){
            String line = sc.nextLine();
            System.out.println(line);
            String[] arr = line.split("\\$");
            double price = Double.parseDouble(arr[1]);
            total += price;
        }
        System.out.println("Total: $" + total);
    }

    void menu(){

        for (int i=0; i<ListOfPurchases.length; i++) {
            ListOfPurchases[i] = new ArrayList<>();
        }
        sc = new Scanner(System.in);
        int choice = 999;
        int NumOfPurchase = 0;

        while(true){
            System.out.println("Choose your action:\n" +
                    "1) Add income\n" +
                    "2) Add purchase\n" +
                    "3) Show list of purchases\n" +
                    "4) Balance\n" +
                    "0) Exit");

            choice = sc.nextInt();
            String garbage = sc.nextLine();
            System.out.println();

            if(choice==1){ // add income
                System.out.println("Enter income:");
                Balance += sc.nextDouble();
                System.out.println("Income was added!");
            }
            else if(choice==2){ // add purchase
                while(true){
                    System.out.println("\nChoose the type of purchases\n" +
                            "1) Food\n" +
                            "2) Clothes\n" +
                            "3) Entertainment\n" +
                            "4) Other\n" +
                            "5) Back");
                    int category = sc.nextInt();
                    garbage = sc.nextLine();
                    if(category!=5){
                        System.out.println();
                    }
                    if(category==5){
                        break;
                    }
                    else{
                        System.out.println("Enter purchase name:");
                        String PurchaseName = sc.nextLine() + "";
                        System.out.println("Enter its price:");
                        double price = sc.nextDouble();
                        Balance -= price;
                        ListOfPurchases[category-1].add(PurchaseName + " $" + price);
                        System.out.println("Purchase was added!");
                        NumOfPurchase += 1;
                    }
                }
            }
            else if(choice==3){ // show purchase
                int category = 0;
                if(NumOfPurchase==0){
                    System.out.println("Purchase list is empty");
                }
                else{
                    while(category!=6){
                        System.out.println("Choose the type of purchases\n" +
                                "1) Food\n" +
                                "2) Clothes\n" +
                                "3) Entertainment\n" +
                                "4) Other\n" +
                                "5) All\n" +
                                "6) Back");
                        category = sc.nextInt();
                        sc.nextLine();
                        if(category!=6){
                            System.out.println();
                        }
                        if(category==1){ // food
                            if(ListOfPurchases[category-1].size()==0){
                                System.out.println("Purchase list is empty");
                            }
                            else{
                                System.out.println("Food:");
                                double sum = 0;
                                for (int j = 0; j < ListOfPurchases[category-1].size(); j++) {
                                    String temp = ListOfPurchases[category-1].get(j);
                                    System.out.println(temp);
                                    String[] arr = temp.split("\\$");
                                    double price = Double.parseDouble(arr[1]);
                                    sum += price;
                                }
                                System.out.println("Total sum: $" + sum + "\n");
                            }
                        }
                        else if(category==2){ // clothes
                            if(ListOfPurchases[category-1].size()==0){
                                System.out.println("Purchase list is empty");
                            }
                            else{
                                System.out.println("Clothes:");
                                double sum = 0;
                                for (int j = 0; j < ListOfPurchases[category-1].size(); j++) {
                                    String temp = ListOfPurchases[category-1].get(j);
                                    System.out.println(temp);
                                    String[] arr = temp.split("\\$");
                                    double price = Double.parseDouble(arr[1]);
                                    sum += price;
                                }
                                System.out.println("Total sum: $" + sum + "\n");
                            }
                        }
                        else if(category==3){ // entertainment
                            if(ListOfPurchases[category-1].size()==0){
                                System.out.println("Purchase list is empty");
                            }
                            else{
                                System.out.println("Entertainment:");
                                double sum = 0;
                                for (int j = 0; j < ListOfPurchases[category-1].size(); j++) {
                                    String temp = ListOfPurchases[category-1].get(j);
                                    System.out.println(temp);
                                    String[] arr = temp.split("\\$");
                                    double price = Double.parseDouble(arr[1]);
                                    sum += price;
                                }
                                System.out.println("Total sum: $" + sum + "\n");
                            }
                        }
                        else if(category==4){ // other
                            if(ListOfPurchases[category-1].size()==0){
                                System.out.println("Purchase list is empty");
                            }
                            else{
                                System.out.println("Other:");
                                double sum = 0;
                                for (int j = 0; j < ListOfPurchases[category-1].size(); j++) {
                                    String temp = ListOfPurchases[category-1].get(j);
                                    System.out.println(temp);
                                    String[] arr = temp.split("\\$");
                                    double price = Double.parseDouble(arr[1]);
                                    sum += price;
                                }
                                System.out.println("Total sum: $" + sum + "\n");
                            }
                        }
                        else if(category==5){ // all
                            if(NumOfPurchase==0){
                                System.out.println("Purchase list is empty");
                            }
                            else{
                                System.out.println("All:");
                                double sum = 0;
                                for(int i=0;i<ListOfPurchases.length;i++){
                                    for (int j = 0; j < ListOfPurchases[i].size(); j++) {
                                        String temp = ListOfPurchases[i].get(j);
                                        System.out.println(temp);
                                        String[] arr = temp.split("\\$");
                                        double price = Double.parseDouble(arr[1]);
                                        sum += price;
                                    }
                                }
                                System.out.println("Total sum: $" + sum + "\n");
                            }
                        }
                    }
                }


            }
            else if(choice==4){ // see balance
                System.out.printf("Balance: $%.2f\n", Balance);
            }
            else if(choice==0){ // exit the program
                System.out.println("Bye!");
                break;
            }
            else{ // you made a boo-boo :v
                System.out.println("Invalid choice");
            }
            System.out.println();
        }
    }
}

public class Main {

    public static void main(String[] args) {
        BudgetManager bm = new BudgetManager();
        //bm.calculateTotal();
        bm.menu();
    }

}
