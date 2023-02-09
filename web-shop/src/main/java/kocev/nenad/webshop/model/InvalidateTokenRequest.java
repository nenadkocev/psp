package kocev.nenad.webshop.model;

import lombok.Data;

@Data
public class InvalidateTokenRequest {

    private final String token;
    private final String merchantId;
}
