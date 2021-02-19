package models;

import javax.persistence.*;

@Entity
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue
    int clientId;
    String name;
    @ManyToOne
    City city;
    String address;
    int phone;
    @ManyToOne
    Model model;



}
