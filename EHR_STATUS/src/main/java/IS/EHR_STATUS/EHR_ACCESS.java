package IS.EHR_STATUS;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EHR_ACCESS extends MongoRepository<Access,String> {

    Access findByWorkerAndEhr(@Param("worker") String worker, @Param("ehr") String ehr);

}
