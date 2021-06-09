package IS.EHR_STATUS;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EHR_VERSIONED_STATUS extends MongoRepository<Versioned_Status,String> {


}
