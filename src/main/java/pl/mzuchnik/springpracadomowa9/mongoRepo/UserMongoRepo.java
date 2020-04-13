package pl.mzuchnik.springpracadomowa9.mongoRepo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.mzuchnik.springpracadomowa9.document.UserDocument;

@Repository
public interface UserMongoRepo extends MongoRepository<UserDocument, String> {
}
