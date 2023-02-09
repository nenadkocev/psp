package kocev.nenad.webshop.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RequestForTokenRequest {

    private final String merchantId;
    private final String cardholderAccountNumber;
    private final String expirationDate;
    private final String cvv;
}
