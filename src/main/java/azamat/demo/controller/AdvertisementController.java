package azamat.demo.controller;

import azamat.demo.model.Advertisement;
import azamat.demo.model.Category;
import azamat.demo.service.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/advertisement")
public class AdvertisementController {
    @Autowired
    private AdvertisementService advertisementService;

    @GetMapping("/list")
    public List<Advertisement> getAll() {
        return advertisementService.findAll();
    }

    @PostMapping("/save")
    public Advertisement save(@RequestBody Advertisement advertisement){
        return advertisementService.save(advertisement);
    }
    @PutMapping("/update")
    public Advertisement update(@RequestBody Advertisement advertisement){
        return advertisementService.update(advertisement);
    }
}
