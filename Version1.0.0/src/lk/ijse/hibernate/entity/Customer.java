package lk.ijse.hibernate.entity;

import lk.ijse.hibernate.embeded.CustName;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer {
    @Id
    @OrderBy("id asc")
    @Column(name = "Cust_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "Cust_Name")
    private CustName name;
    @Column(name = "Cust_Salary")
    private double salary;
    @Column(name = "Cust_Address")
    private String address;
    @OneToMany(mappedBy = "customer")
    private List<Item> items = new ArrayList<>();

    public Customer() {
    }

    public Customer(int id, CustName name, double salary, String address, List<Item> items) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.address = address;
        this.items = items;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CustName getName() {
        return name;
    }

    public void setName(CustName name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name=" + name +
                ", salary=" + salary +
                ", address='" + address + '\'' +
                ", items=" + items +
                '}';
    }
}
