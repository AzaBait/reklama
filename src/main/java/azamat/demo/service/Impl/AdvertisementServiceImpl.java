package azamat.demo.service.Impl;

import azamat.demo.model.Advertisement;
import azamat.demo.model.Category;
import azamat.demo.repository.AdvertisementRepo;
import azamat.demo.service.AdvertisementService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdvertisementServiceImpl implements AdvertisementService {

    private AdvertisementRepo advertisementRepo;

    public AdvertisementServiceImpl(AdvertisementRepo advertisementRepo) {
        this.advertisementRepo = advertisementRepo;
    }

    @Override
    public List<Advertisement> findAll() {
        return advertisementRepo.findAll();
    }

    @Override
    public Advertisement save(Advertisement advertisement) {
        return advertisementRepo.save(advertisement);
    }

    @Override
    public Advertisement update(Advertisement advertisement) {
        return advertisementRepo.save(advertisement);
    }

    @Override
    public List<Advertisement> findByCategory(Category category) {
        return advertisementRepo.findAllByCategory(category);
    }

    @Override
    public void delete(Long id) {
    advertisementRepo.deleteById(id);
    }
}
