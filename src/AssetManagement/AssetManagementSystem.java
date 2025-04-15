package AssetManagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AssetManagementSystem {
    static Scanner sc = new Scanner(System.in);
    static List<Book> books = new ArrayList<>();
    static List<SoftwareLicense> softwareLicenses = new ArrayList<>();
    static List<Hardware> hardwares = new ArrayList<>();
    static List<User> user = new ArrayList<>();

    public static void main(String[] args) {
        System.out.print("Enter your username: ");
        String uname = sc.nextLine();

        System.out.print("Enter your role (Admin / Manager / Viewer): ");
        String role = sc.next();

        User currentUser = new User(uname, role);
        user.add(currentUser);


        int choice;
        do {
            System.out.println("welcome" + currentUser.username + currentUser.role);
            if (currentUser.role.equals("admin")) {
                System.out.println("\n1. Add an asset");
                System.out.println("2. Search an asset");
                System.out.println("3. Update an asset");
                System.out.println("4. Delete an asset");

                System.out.println("5 view all assets");

                System.out.println("7.Logout");
            }
            if (currentUser.role.equals("manager")) {
                System.out.println("\n1. Add an asset");
                System.out.println("2. Search an asset");
                System.out.println("3. Update an asset");
                System.out.println("4. Delete an asset");

            }
            if (currentUser.role.equals("viewer")) {
                System.out.println("5 view all assets");

            } else {
                System.out.println("invalid");
            }

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    if (currentUser.role.equals("admin") || currentUser.role.equals("Manager")) addAsset();
                    else {
                        System.out.println("Access denied ");
                    }
                    break;
                case 2:
                    if (currentUser.role.equals("admin") || currentUser.role.equals("Manager")) searchAsset();
                    else {
                        System.out.println("access denied");
                    }
                    break;
                case 3:
                    if (currentUser.role.equals("admin") || currentUser.role.equals("Manager")) updateAsset();
                    else {
                        System.out.println("access denied ");
                    }
                    break;
                case 4:
                    if (currentUser.role.equals("admin") || currentUser.role.equals("Manager")) ;
                    else {
                        System.out.println("access deined");
                    }
                    break;
                case 5:
//            listAssets();

                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (true);
    }

    static void addAsset() {
        System.out.println("Select type of asset to add:\n1. Book\n2. Software License\n3. Hardware");
        int type = sc.nextInt();
        System.out.print("Enter Serial Number: ");
        int serialNumber = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        switch (type) {
            case 1:
                System.out.print("Enter Author: ");
                String author = sc.nextLine();
                System.out.print("Enter Date of Publish (dd-mm-yyyy): ");
                String dop = sc.nextLine();
                books.add(new Book(serialNumber, name, author, dop));
                break;
            case 2:

            case 3:
                System.out.print("Enter Model: ");
                String model = sc.nextLine();
                System.out.print("Enter Purchase Date (dd-mm-yyyy): ");
                String pdate = sc.nextLine();
                hardwares.add(new Hardware(serialNumber, name, model, pdate));
                break;
            default:
                System.out.println("Invalid asset type.");
        }
    }

    static void searchAsset() {
        System.out.println("Select type of asset to update:\n1. Book\n2. Software License\n3. Hardware");
        int type = sc.nextInt();
        System.out.print("Enter Serial Number to search: ");
        int serialNumber = sc.nextInt();
        boolean found = false;
        switch (type) {
            case 1:
                for (Book b : books) {
                    if (b.getSerialNumber() == serialNumber) {
                        b.display();
                        found = true;
                    }
                }
                break;
            case 2:
                for (SoftwareLicense s : softwareLicenses) {
                    if (s.getSerialNumber() == serialNumber) {
                        s.display();
                        found = true;
                    }
                }
                break;
            case 3:
                for (Hardware h : hardwares) {
                    if (h.getSerialNumber() == serialNumber) {
                        h.display();
                        found = true;
                    }
                }
                break;
        }
        if (!found) System.out.println("Asset not found.");
    }

    static void updateAsset() {
        System.out.println("Select type of asset to update:\n1. Book\n2. Software License\n3. Hardware");
        int type = sc.nextInt();
        System.out.println("Enter the serial number to update");
        int serialNumber = sc.nextInt();
        boolean found = false;
        switch(type){

        }
    }
}
