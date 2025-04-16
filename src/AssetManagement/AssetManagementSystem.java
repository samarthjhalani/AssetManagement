package AssetManagement;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AssetManagementSystem {
    static Scanner sc = new Scanner(System.in);
    static List<Book> books = new ArrayList<>();
    static List<Software> softwareLicens = new ArrayList<>();
    static List<Hardware> hardwares = new ArrayList<>();
    static List<User> user = new ArrayList<>();

    public static void main(String[] args) {
        System.out.print("Enter your username: ");
        String uname = sc.nextLine();

        System.out.print("Enter your role (admin / manager / viewer): ");
        String role = sc.next();

        User currentUser = new User(uname, role);
        user.add(currentUser);


        int choice;
        do {
            System.out.println("\nwelcome," + currentUser.username + "(" + currentUser.role + ")");
            if (currentUser.role.equals("admin")) {
                System.out.println("\n1. Add an asset");
                System.out.println("2. Search an asset");
                System.out.println("3. Update an asset");
                System.out.println("4. Delete an asset");

                System.out.println("5 view all assets");

                System.out.println("6.Logout");
            }
            if (currentUser.role.equals("manager")) {
                System.out.println("\n1. Add an asset");
                System.out.println("2. Search an asset");
                System.out.println("3. Update an asset");
                System.out.println("4. Delete an asset");
                System.out.println("6.Logout");

            }
            if (currentUser.role.equals("viewer")) {
                System.out.println("1. view all assets");
                System.out.println("6.Logout");

            }
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    if (currentUser.role.equals("admin") || currentUser.role.equals("manager")) addAsset();
                    else {
                        System.out.println("Access denied ");
                    }
                    break;
                case 2:
                    if (currentUser.role.equals("admin") || currentUser.role.equals("manager")) searchAsset();
                    else {
                        System.out.println("access denied");
                    }
                    break;
                case 3:
                    if (currentUser.role.equals("admin") || currentUser.role.equals("manager")) updateAsset();
                    else {
                        System.out.println("access denied ");
                    }
                    break;
                case 4:
                    if (currentUser.role.equals("admin") || currentUser.role.equals("manager")) deleteAsset();
                    else {
                        System.out.println("access deined");
                    }
                    break;
                case 5:
                    listAssets();
                    break;
                case 6:
                    if (currentUser.role.equals("admin")) viewUsers();
                    else {
                        System.out.println("Logging out...");
                        main(null);
                        return;
                    }
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (true);
    }

    static void addAsset() {
        System.out.println("Select type of asset to add:\n1. Book\n2. Software License\n3. Hardware\n4.exit");
        int type = sc.nextInt();
        if (type==4){
            return;
        }
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
                System.out.print("Enter license key:");
                String licensekey = sc.nextLine();
                System.out.print("Enter Date of Publish (dd-mm-yyyy): ");
                String sdate = sc.nextLine();
                softwareLicens.add(new Software(serialNumber,name,licensekey,sdate));
                break;
            case 3:
                System.out.print("Enter Model: ");
                String model = sc.nextLine();
                System.out.print("Enter Purchase Date (dd-mm-yyyy): ");
                String pdate = sc.nextLine();
                hardwares.add(new Hardware(serialNumber, name, model, pdate));
                break;
            case 4:{
                System.out.println("return me to add assert");
                return;

                }

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
                for (Software s : softwareLicens) {
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
        switch (type) {
            case 1:
                for (Book b : books) {
                    if (b.getSerialNumber() == serialNumber) {
                        System.out.println("Enter the name");
                        String name = sc.nextLine();
                        System.out.println("Enter the author");
                        String author = sc.nextLine();
                        System.out.println("Enter the date of publish ");
                        String dateOfPublish = sc.nextLine();

                        found = true;

                    }

                }
                break;
            case 2:
                for (Software s : softwareLicens) {
                    if (s.getSerialNumber() == serialNumber) {
                        System.out.println("Enter the name");
                        String name = sc.nextLine();
                        System.out.print("Enter Model: ");
                        String model = sc.nextLine();
                        System.out.print("Enter Purchase Date (dd-mm-yyyy): ");
                        String pdate = sc.nextLine();
                    }
                }
                break;
            case 3:
                for (Hardware h : hardwares) {
                    if (h.getSerialNumber() == serialNumber) {
                        System.out.println("Enter the name");
                        String name = sc.nextLine();
                        System.out.print("Enter Model: ");
                        String model = sc.nextLine();
                        System.out.print("Enter Purchase Date (dd-mm-yyyy): ");
                        String pdate = sc.nextLine();

                    }
                }
                break;

        }
        if (!found) System.out.println("Asset not found.");
    }

    static void deleteAsset() {
        System.out.println("Select type of asset to update:\n1. Book\n2. Software License\n3. Hardware");
        int type = sc.nextInt();
        System.out.println("Enter the serial number to Delete");
        int serialNumber = sc.nextInt();
        boolean found = false;

        switch (type) {
            case 1:
                books.removeIf(b -> b.getSerialNumber() == serialNumber);
                break;
            case 2:
                softwareLicens.removeIf(s -> s.getSerialNumber() == serialNumber);
                break;
            case 3:
                hardwares.removeIf(h -> h.getSerialNumber() == serialNumber);
                break;
            default:
                System.out.println("Invalid asset type.");
        }
        System.out.println("Asset deleted if it existed.");
    }

    static void listAssets() {
        if (!books.isEmpty()) {
            System.out.println("Books:");
            for (Book b : books) b.display();
        }
        if (!softwareLicens.isEmpty()) {
            System.out.println("Software Licenses:");
            for (Software s : softwareLicens) s.display();
        }
        if (!hardwares.isEmpty()) {
            System.out.println("Hardwares:");
            for (Hardware h : hardwares) h.display();
        }
    }

    static void viewUsers() {
        System.out.println("List of Users:");
        for (User u : user) {
            System.out.println("Username: " + u.username + " | Role: " + u.role);
        }
    }
}
