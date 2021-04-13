package com;

import com.config.MongoConfig;
import com.operations.MongoImp;
import java.util.Scanner;
import java.util.logging.Logger;


public class MainImp {

    public static void main(String[] args) {

        do {
            //taking input to perform crud operation
            Scanner input = new Scanner(System.in);
            System.out.println("Employees Details");
            System.out.println("Press 1 Insert data");
            System.out.println("Press 2 View all records");
            System.out.println("Press 3 View by Id");
            System.out.println("Press 4 Delete a record");
            System.out.println("Press 5 Update a record");
            System.out.println("Press 6 Exit");
            System.out.println("Enter your choice");


            int choice;
            do {
                while (!input.hasNextInt()) {
                    System.out.println("That's not a number:\nPlease enter choice");
                    input.next();
                }
                choice = input.nextInt();
            } while (choice <= 0);

            MongoImp mi = new MongoImp();
            switch (choice) {
                case 1:
                    mi.insert(MongoConfig.getConnection());
                    break;
                case 2:
                    mi.viewAll(MongoConfig.getConnection());
                    break;
                case 3:
                    mi.view(MongoConfig.getConnection());
                    break;
                case 4:
                    mi.delete(MongoConfig.getConnection());
                    break;
                case 5:
                    mi.update(MongoConfig.getConnection());
                    break;
                case 6:
                    // exit the console
                    System.exit(0);
                    break;
                default:
                    System.out.println("Enter Valid input\n");
            }
        }
        while (true);
    }
    
}
