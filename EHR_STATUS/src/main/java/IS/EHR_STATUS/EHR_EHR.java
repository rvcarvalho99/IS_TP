package IS.EHR_STATUS;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EHR_EHR extends MongoRepository<EHR,String> {

    EHR findBy_id(@Param("id") String id);


}
