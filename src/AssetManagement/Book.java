package AssetManagement;

class Book extends Asset {
    public String author;
    public String dateOfPublish;

    public Book(int serialNumber, String name, String author, String dateOfPublish) {
        super(serialNumber, name);
        this.author = author;
        this.dateOfPublish = dateOfPublish;
    }


    @Override
    public void display() {
            System.out.println("Serial Number: " + serialNumber);
            System.out.println("Name :" + name);
            System.out.println("Author :" + author);
            System.out.println("Date Of Publish: " + dateOfPublish);
            System.out.println("-----------------------------------");
    }

}
