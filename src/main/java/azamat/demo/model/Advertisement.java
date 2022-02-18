package azamat.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "adv_advertisements")
public class Advertisement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private  String description;
    private Double price;
    @Column(name = "created_at")
    private Date createdAt;
    @Enumerated
    private AdvertisementStatus status;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

}
