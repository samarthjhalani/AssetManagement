



package AssetManagement;

class Hardware extends Asset {
    public String model;
    public String purchaseDate;

    public Hardware(int serialNumber, String name, String model, String purchaseDate) {
        super(serialNumber, name);
        this.model = model;
        this.purchaseDate = purchaseDate;
    }

    @Override
    public void display() {
        System.out.println("Serial Number: " + serialNumber);
        System.out.println("Name: " + name);
        System.out.println("model: " + model);
        System.out.println("purchaseDate: " + purchaseDate);
        System.out.println("-----------------------------------");
    }


}

