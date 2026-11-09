/**
 * Main class of the campus cafe ordering system.
 * It creates customers, menu items, and orders, then prints two receipts.
 *
 * @author Christoff Allen B. Jumapit
 * @version 1.0
 */
public class CafeApp {

    /**
     * Starts the program.
     *
     * @param args the command-line arguments (not used)
     */
    public static void main(String[] args) {
        // Two customers made with different constructors
        Customer ana = new Customer("Ana Reyes", true);
        Customer ben = new Customer("Ben Cruz");

        // ----- Order #1001 (parameterized constructors) -----
        Beverage icedLatte = new Beverage("Iced Latte", 95.0, "B-01", "L");
        Pastry ensaymada = new Pastry("Ensaymada", 45.0, "P-01", true);
        Meal chickenAdobo = new Meal("Chicken Adobo", 110.0, "M-01", true, 1);

        // Cookie uses the default Pastry constructor, then setters
        Pastry cookie = new Pastry();
        cookie.setName("Cookie");
        cookie.setBasePrice(30.0);
        cookie.setItemCode("P-02");

        Order order1 = new Order("1001", ana);
        order1.addItem(icedLatte);
        order1.addItem(ensaymada);
        order1.addItem(chickenAdobo);
        // Fourth item: the order is full, so it is rejected
        order1.addItem(cookie);
        order1.printReceipt();
        System.out.println();

        // ----- Order #1002 (default constructors and setters) -----
        Beverage hotChocolate = new Beverage();
        hotChocolate.setName("Hot Chocolate");
        // Invalid data: the setter rejects the negative price
        hotChocolate.setBasePrice(-5);
        hotChocolate.setBasePrice(80);
        hotChocolate.setItemCode("B-02");
        hotChocolate.setSize("M");

        Meal beefTapa = new Meal();
        beefTapa.setName("Beef Tapa");
        beefTapa.setBasePrice(130.0);
        beefTapa.setItemCode("M-02");

        Order order2 = new Order("1002", ben);
        order2.addItem(hotChocolate);
        order2.addItem(beefTapa);
        // Print the receipt with a 20 peso voucher
        order2.printReceipt(20.0);
    }
}
