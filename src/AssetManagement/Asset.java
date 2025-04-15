package AssetManagement;


abstract class Asset {
    public int serialNumber;
    public String name;

    public Asset(int serialNumber, String name) {
        this.serialNumber = serialNumber;
        this.name = name;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public abstract void display();
}
