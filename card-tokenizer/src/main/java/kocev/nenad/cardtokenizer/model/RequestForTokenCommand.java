package kocev.nenad.cardtokenizer.model;

import lombok.Data;

@Data
public class RequestForTokenCommand {

    private final String merchantId;
    private final String cardholderAccountNumber;
    private final String expirationDate;
    private final String cvv;
}
