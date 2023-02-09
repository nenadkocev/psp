package kocev.nenad.cardtokenizer.repository;

import kocev.nenad.cardtokenizer.model.TokenizedCardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface TokenRepository extends JpaRepository<TokenizedCardEntity, UUID> {

    Optional<TokenizedCardEntity> findByTokenAndMerchantId(String token, String merchantId);
}
