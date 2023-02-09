package kocev.nenad.webshop.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

import java.time.LocalDateTime;
import java.util.UUID;

@RedisHash("Subscription")
@Data
@NoArgsConstructor
public class SubscriptionEntity {

    private UUID id = UUID.randomUUID();

    private LocalDateTime validUntil = LocalDateTime.now().plusMonths(1);

    private String username;

    private String cardToken;
}
