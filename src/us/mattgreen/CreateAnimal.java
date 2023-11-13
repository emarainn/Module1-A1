package us.mattgreen;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class CreateAnimal {
    private final static FileOutput outFile = new FileOutput("animals.txt");
    private final static FileInput inFile = new FileInput("animals.txt");
    public static void CreateAnimal(){
        /*
            Ask the user what type of animal they want to create
            Accept the input(s) necessary to instantiate that type of object
            Create an object of that type
            Add the object to the ArrayList
        */

        System.out.println("\n------------------------------------" +
                "\nWelcome To Animal Creation");
        GetType();


    }

    public static void GetType(){
        Scanner sc = new Scanner(System.in);
        String animalType = null;

        do{
            System.out.print("Available Animal Types: " +
                    "\n\t1. Cat" +
                    "\n\t2. Dog" +
                    "\nEnter 1 or 2 to Choose Animal: ");
            animalType = sc.nextLine();

            if (Objects.equals(animalType, "1")){
                CreateCat();
                break;
            }else if (Objects.equals(animalType, "2")){
                CreateDog();
                break;
            }else {
                System.out.println("\n** Must Enter Num 1 - 2 **");
            }
        }while (Objects.equals(animalType, "") || animalType != "1" ||
                animalType != "2");
    }
    public static void CreateCat() {
        var zoo = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        String name = null;
        do {
            System.out.print("\nAnimal's Name: ");
            name = sc.nextLine();

            if (name == "") {
                System.out.println("\n** Must Enter Animal Name **");
            }
        } while (name == "");

        int mousesKilled = 0;

        do {
            System.out.print("\nNum Mouses Killed: ");
            mousesKilled = sc.nextInt();

            if (!(mousesKilled >= 0)) {
                System.out.println("** Must Enter Num >= 0 **");
            }

        } while (!(mousesKilled >= 0));


        zoo.add(new Cat(mousesKilled, name));


        for (Object thing : zoo) {

            System.out.println("Item Added to List: " + thing);
        }
    }
    public static void CreateDog() {
        var zoo = new ArrayList<Talkable>();

        Scanner sc = new Scanner(System.in);
        String name = null;
        do {
            System.out.print("\nAnimal's Name: ");
            name = sc.nextLine();

            if (name == "") {
                System.out.println("\n** Must Enter Animal Name **");
            }
        } while (name == "");

        String friendlyAns = null;
        Boolean friendly = null;

        do {
            System.out.print("\nFriendly (Y / N): ");
            friendlyAns = sc.nextLine().toUpperCase();

            if (friendlyAns.equals("Y")) {
                friendly = true;
                break;
            }else if (friendlyAns.equals("N")){
                friendly = false;
                break;
            }else {
                System.out.println("** Must Enter Y or N **");
            }

        } while (friendlyAns == "" || friendlyAns != "Y" || friendlyAns != "N");


        zoo.add(new Dog(friendly, name));

        for (Object thing : zoo) {

            System.out.println("Item Added to List: " + thing);
        }

    }

}
