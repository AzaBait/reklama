package azamat.demo.controller;

import azamat.demo.dto.AdvertisementDto;
import azamat.demo.model.Advertisement;
import azamat.demo.model.AdvertisementStatus;
import azamat.demo.model.Category;
import azamat.demo.service.AdvertisementService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/advertisement")
public class AdvertisementController {

    private final AdvertisementService advertisementService;
    private final ModelMapper modelMapper;

    public AdvertisementController(AdvertisementService advertisementService, ModelMapper modelMapper) {
        this.advertisementService = advertisementService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/list")
    public List<AdvertisementDto> getAll(){
        List<Advertisement> advertisements = advertisementService.findAll();
        return advertisements.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @GetMapping("/orderByPrice")
    public List<AdvertisementDto> findAllOrderByPriceAsc() {
        List<Advertisement> advertisements = advertisementService.findAllOrderByPriceAsc();
        return advertisements.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @PostMapping("/save")
    public AdvertisementDto save(@RequestBody AdvertisementDto advertisementDto){
        advertisementDto.setStatus(AdvertisementStatus.ACTIVE);
        advertisementDto.setCreatedAt(new Date());
        Advertisement advertisement = convertToEntity(advertisementDto);
        Advertisement advertisementSaved = advertisementService.save(advertisement);
        return convertToDto(advertisementSaved);
    }
    @PutMapping("/update")
    public AdvertisementDto update(@RequestBody AdvertisementDto advertisementDto){
        Advertisement advertisement = convertToEntity(advertisementDto);
        Advertisement advertisementUpdated = advertisementService.update(advertisement);
        return convertToDto(advertisementUpdated);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id ){
        advertisementService.delete(id);
    }

    @GetMapping("/category/{categoryId}")
    public List<AdvertisementDto>getAllByCategory(@PathVariable Long categoryId){

        Category category = new Category();
        category.setId(categoryId);
        List<Advertisement> advertisements = advertisementService.findByCategory(category);
        return advertisements.stream().map(this::convertToDto).collect(Collectors.toList());

    }

    private AdvertisementDto convertToDto(Advertisement advertisement) {
        AdvertisementDto advertisementDto = modelMapper.map(advertisement, AdvertisementDto.class);
        return advertisementDto;
    }

    private Advertisement convertToEntity(AdvertisementDto advertisementDto) {
        Advertisement advertisement = modelMapper.map(advertisementDto, Advertisement.class);
        return advertisement;
    }

}
