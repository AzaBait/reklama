package azamat.demo.service;

import azamat.demo.model.Advertisement;
import azamat.demo.model.Category;

import java.util.List;

public interface AdvertisementService {

    List<Advertisement> findAll();
    Advertisement save(Advertisement advertisement);
    Advertisement update(Advertisement advertisement);
    List<Advertisement> findByCategory(Category category);
    List<Advertisement> findAllOrderByPriceAsc();
    void delete(Long id);
}
