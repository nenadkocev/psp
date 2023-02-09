package kocev.nenad.webshop.model;

import lombok.Data;

@Data
public class AddSubscriptionCommand {
    private final String username;
    private final String cardholderAccountNumber;
    private final String expirationDate;
    private final String cvv;
}
