package fr.ul.miage.clickandcollect.products;

import javax.persistence.*;

@Entity
@Table(name = "PRODUCT", schema = "clickandcollect")
public class Product {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

}
