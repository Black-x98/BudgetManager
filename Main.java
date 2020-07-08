package budget;

import java.util.ArrayList;
import java.util.Scanner;


class BudgetManager{

    double total = 0;
    Scanner sc;
    double Balance;
    ArrayList<String> ListOfPurchases = new ArrayList<String>();

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

        sc = new Scanner(System.in);
        int choice = 999;

        while(true){
            System.out.println("Choose your action:\n" +
                    "1) Add income\n" +
                    "2) Add purchase\n" +
                    "3) Show list of purchases\n" +
                    "4) Balance\n" +
                    "0) Exit");

            choice = sc.nextInt();
            sc.nextLine();
            System.out.println();

            if(choice==1){
                System.out.println("Enter income:");
                Balance += sc.nextDouble();
                System.out.println("Income was added!");
            }
            else if(choice==2){
                System.out.println("Enter purchase name:");
                String PurchaseName = sc.nextLine() + "";
                System.out.println("Enter its price:");
                double price = sc.nextDouble();
                Balance -= price;
                ListOfPurchases.add(PurchaseName + " $" + price);
                System.out.println("Purchase was added!");
            }
            else if(choice==3){
                if(ListOfPurchases.size()==0){
                    System.out.println("Purchase list is empty");
                }
                for(int i=0;i<ListOfPurchases.size();i++){
                    System.out.println(ListOfPurchases.get(i));
                }
            }
            else if(choice==4){
                System.out.printf("Balance: $%.2f\n", Balance);
            }
            else if(choice==0){
                System.out.println("Bye!");
                break;
            }
            else{
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
