package azamat.demo.dto;

import azamat.demo.model.Category;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {

    private Long id;
    private String name;
   @JsonIgnore
    private Category parentCategory;
    private List<Category> subCategories;
}
