package IS.EHR_STATUS;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EHR_STATUS extends MongoRepository<Status,String> {

    Status findBy_id(@Param("id") String id);
}
