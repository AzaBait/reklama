package azamat.demo.repository;

import azamat.demo.model.Advertisement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdvertisementRepo extends JpaRepository <Advertisement,Long>{



}
