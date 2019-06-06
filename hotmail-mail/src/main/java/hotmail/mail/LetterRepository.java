package hotmail.mail;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface LetterRepository extends MongoRepository<LetterEntity, UUID> {
}
