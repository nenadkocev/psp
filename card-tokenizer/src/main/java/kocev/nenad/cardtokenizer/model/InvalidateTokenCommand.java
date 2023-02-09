package kocev.nenad.cardtokenizer.model;

import lombok.Data;

@Data
public class InvalidateTokenCommand {

    private final String token;
    private final String merchantId;
}
