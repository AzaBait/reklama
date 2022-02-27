package azamat.demo.controller;

import azamat.demo.model.Advertisement;
import azamat.demo.model.AdvertisementStatus;
import azamat.demo.model.Category;
import azamat.demo.service.AdvertisementService;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/advertisement")
public class AdvertisementController {

    private final AdvertisementService advertisementService;

    public AdvertisementController(AdvertisementService advertisementService) {
        this.advertisementService = advertisementService;
    }

    @GetMapping("/list")
    public List<Advertisement> getAll() {
        return advertisementService.findAll();
    }

    @GetMapping("/orderByPrice")
    public List<Advertisement> findAllOrderByPriceAsc() {
        return advertisementService.findAllOrderByPriceAsc();
    }

    @PostMapping("/save")
    public Advertisement save(@RequestBody Advertisement advertisement){
        advertisement.setStatus(AdvertisementStatus.ACTIVE);
        advertisement.setCreatedAt(new Date());
        return advertisementService.save(advertisement);
    }
    @PutMapping("/update")
    public Advertisement update(@RequestBody Advertisement advertisement){
        return advertisementService.update(advertisement);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id ){
        advertisementService.delete(id);
    }

    @GetMapping("/category/{categoryId}")
    public List<Advertisement>getAllByCategory(@PathVariable Long categoryId){
        Category category = new Category();
        category.setId(categoryId);
        return advertisementService.findByCategory(category);
    }

}
