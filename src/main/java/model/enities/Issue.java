package model.enities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class Issue {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDate createdDate;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private Client clientId;
    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "worker_id", referencedColumnName ="id")
    private Worker workerId;

}
