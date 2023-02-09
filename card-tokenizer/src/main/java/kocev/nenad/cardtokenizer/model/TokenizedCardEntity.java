package kocev.nenad.cardtokenizer.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Getter
@Setter
public class TokenizedCardEntity {

    @Id
    private UUID tokenId;

    private String token;

    private String merchantId;
}
