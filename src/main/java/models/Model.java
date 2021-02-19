package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "models")
public class Model {
    @Id
    @GeneratedValue
    int modelId;
    String name;
    String version;
    int price;
    String dataRegister;
    String data_content;
}
