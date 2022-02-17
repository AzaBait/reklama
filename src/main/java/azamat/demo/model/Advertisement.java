package azamat.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
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

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

}
