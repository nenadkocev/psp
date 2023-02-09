package kocev.nenad.webshop.model;

import lombok.Data;

@Data
public class DeleteSubscriptionCommand {
    private final String username;
}
