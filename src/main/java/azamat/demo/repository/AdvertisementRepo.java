package azamat.demo.repository;

import azamat.demo.model.Advertisement;
import azamat.demo.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdvertisementRepo extends JpaRepository <Advertisement,Long>{

    List<Advertisement> findAllByCategory(Category category);

    @Query("FROM Advertisement ORDER BY price ASC")
    List<Advertisement> findAllOrderByPriceAsc();

   @Query("from Advertisement where price between :fromPrice and :toPrice")
    List<Advertisement> findAdvertisementByPriceBetween(Double fromPrice, Double toPrice);


}
