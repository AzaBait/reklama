package azamat.demo.dto;

import azamat.demo.model.AdvertisementStatus;
import azamat.demo.model.Category;
import lombok.*;

import java.util.Date;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AdvertisementDto {

    private Long id;
    private String title;
    private  String description;
    private Double price;
    private Date createdAt;
    private AdvertisementStatus status;
    private CategoryDto category;

}
