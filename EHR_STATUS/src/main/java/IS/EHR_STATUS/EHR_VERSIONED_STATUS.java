package IS.EHR_STATUS;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EHR_VERSIONED_STATUS extends MongoRepository<Versioned_Status,String> {

    Versioned_Status findByUidValueAndTimecreatedValue(@Param("uid") String uid, @Param("time") String time);

    Versioned_Status findByTimecreatedValue(@Param("time") String time);

    List<Versioned_Status> findByUidValue(@Param("uid") String uid);

    Versioned_Status findBy_id(@Param("id") String id);

    Versioned_Status findBy_idAndUidValue(@Param("id") String id, @Param("uid") String uid);



}
