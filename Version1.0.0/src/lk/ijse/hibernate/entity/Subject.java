package lk.ijse.hibernate.entity;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Subject {
    private int id;
    private String name;

    private List<Lecturer> lecturerList = new ArrayList<>();
}
