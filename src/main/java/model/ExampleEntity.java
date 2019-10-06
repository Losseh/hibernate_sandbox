package model;

import javax.persistence.*;

@Entity
@Table(name = "example")
public class ExampleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "data")
    private String data;

    // it must exist for hibernate
    public ExampleEntity()
    {}

    public ExampleEntity(final String data)
    {
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public String getData() {
        return data;
    }
}
