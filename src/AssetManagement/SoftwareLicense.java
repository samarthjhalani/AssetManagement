package AssetManagement;

class SoftwareLicense extends Asset {
    public String licenseKey;
    public String expiryDate;

    public SoftwareLicense(int serialNumber, String name, String licenseKey, String expiryDate) {
        super(serialNumber, name);
        this.licenseKey = licenseKey;
        this.expiryDate = expiryDate;
    }

    @Override
    public void display() {
        System.out.println("Serial Number: " + serialNumber);
        System.out.println("Name: " + name);
        System.out.println("license key: " + licenseKey);
        System.out.println("expiry date: " + expiryDate);
        System.out.println("-----------------------------------");
    }


}
