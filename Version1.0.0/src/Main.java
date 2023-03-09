import lk.ijse.hibernate.embeded.CustName;
import lk.ijse.hibernate.entity.Customer;
import lk.ijse.hibernate.entity.Item;
import lk.ijse.hibernate.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {

//        Customer c1 = new Customer();
//        c1.setName(new CustName("Swarna","Harshana","Jayaweera"));
//        c1.setSalary(500000.00);
//        c1.setAddress("Badulla");
//
//
//        Item I1 = new Item();
//        I1.setCustomer(c1);
//        I1.setName("Sugar");

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

//        session.save(new Item(1,"Sugar",new Customer(1,
//                new CustName("Swarna","Harshana","Jayaweeara"),
//                5000000.00,"Mahiyanagaya")));

//        session.save(c1);
//        session.save(I1);

        Customer customer = new Customer();
        customer.setName(new CustName("Swarna", "Harshana", "Jayaweera"));
        customer.setSalary(500000.00);
        customer.setAddress("Mahiyanganaya");
//        customer.setItems();

        Item item = new Item();
        item.setName("Sugar");
        item.setCustomer(customer);

        Item item1 = new Item();
        item1.setName("Dhal");
        item1.setCustomer(customer);

//        ArrayList<Item> list = new ArrayList<>();
//        list.add(item);
//        list.add(item1);
//
//        customer.setItems(list);

        customer.getItems().add(item);
        customer.getItems().add(item1);

        session.save(customer);
        session.save(item);
        session.save(item1);

        transaction.commit();
        session.close();

    }
}