package sk.umb.example.security.db.authentication.dal;

import org.springframework.data.repository.CrudRepository;

public interface TokenRepository extends CrudRepository<TokenEntity, Long> {

}
