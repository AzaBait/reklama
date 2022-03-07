package azamat.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "adv_categories")
public class Category {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    private String name;


    @ManyToOne
    private Category parentCategory;


    @OneToMany(mappedBy = "parentCategory")
    private List<Category> subCategories;



}
