package sk.umb.example.security.db.authentication.dal;

import antlr.Token;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TokenRepository extends CrudRepository<TokenEntity, Long> {
    Optional<TokenEntity> findByToken(String token);
}
