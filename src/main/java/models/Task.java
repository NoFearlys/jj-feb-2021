package models;

import javax.persistence.*;

@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue
    int taskId;
    @ManyToOne
    Client client;
    int quantity;
    int trackNumberIn;
    int getTrackNumberOut;
    Status status;
}
