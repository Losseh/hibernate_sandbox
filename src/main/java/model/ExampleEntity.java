package model;

import javax.persistence.*;

@Entity
@Table(name = "example_entity")
public class ExampleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    public ExampleEntity()
    {

    }


}
