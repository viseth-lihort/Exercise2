interface DiscountRate {
    double getProductDiscountRate(String type);
    double getServiceDiscountRate(String type);

}

class Customer implements DiscountRate {
    private String name;
    private String type;

    public Customer(String name, String type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public double getServiceDiscountRate(String type) {
        switch (type) {
            case "Premium": return 0.20;
            case "Gold": return 0.15;
            case "Silver": return 0.10;
            default: return 0.0;
        }
    }

    @Override
    public double getProductDiscountRate(String type) {
        switch (type) {
            case "Premium": return 0.10;
            case "Gold": return 0.10;
            case "Silver": return 0.10;
            default: return 0.0;
        }
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
}


class Sale {
    private Customer customer;
    private String date;
    private double serviceExpense;
    private double productExpense;

    public Sale(Customer customer, String date) {
        this.customer = customer;
        this.date = date;
    }

    public double getServiceExpense() {
        return serviceExpense;
    }

    public void setServiceExpense(double serviceExpense) {
        this.serviceExpense = serviceExpense;
    }

    public double getProductExpense() {
        return productExpense;
    }

    public void setProductExpense(double productExpense) {
        this.productExpense = productExpense;
    }

    public void displayInfo() {
        System.out.println("Date: " + date);
        System.out.println("Cus Name: " + customer.getName());
        System.out.println("Cus Type: " + customer.getType());
        System.out.println("Service Expense: $" + serviceExpense);
        System.out.println("Product Expense: $" + productExpense);
        System.out.println("Bill: $" + getTotalBill());
        System.out.println("Discount: $" + getTotalDiscount());

    }

    public double getServiceDiscount() {
        return serviceExpense * customer.getServiceDiscountRate(customer.getType());
    }

    public double getProductDiscount() {
        return productExpense * customer.getProductDiscountRate(customer.getType());
    }
    public double getTotalDiscount() {
        return getServiceDiscount() + getProductDiscount();
    }

    public double getTotalBill() {
        return serviceExpense + productExpense - getTotalDiscount();
    }
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


}

public class Main {
    public static void main(String[] args) {
        Customer c1 = new Customer("Heng", "Normal");
        Customer c2 = new Customer("vitou", "Premium");
        Customer c3 = new Customer("Sophea", "Gold");
        Customer c4 = new Customer("Vimean", "Silver");

        Sale sale_c1 = new Sale(c1, "2024-02-11");
        Sale sale_c2 = new Sale(c2, "2024-02-12");
        Sale sale_c3 = new Sale(c3, "2024-02-13");
        Sale sale_c4 = new Sale(c4, "2024-02-14");

        sale_c1.setProductExpense(100);
        sale_c1.setServiceExpense(100);
        sale_c1.displayInfo();

        sale_c2.setProductExpense(100);
        sale_c2.setServiceExpense(100);
        sale_c2.displayInfo();

        sale_c3.setProductExpense(100);
        sale_c3.setServiceExpense(100);
        sale_c3.displayInfo();

        sale_c4.setProductExpense(100);
        sale_c4.setServiceExpense(100);
        sale_c4.displayInfo();
    }
}



