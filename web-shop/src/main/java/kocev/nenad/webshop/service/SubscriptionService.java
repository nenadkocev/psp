package kocev.nenad.webshop.service;

import kocev.nenad.webshop.model.AddSubscriptionCommand;
import kocev.nenad.webshop.model.RenewSubscriptionCommand;
import kocev.nenad.webshop.model.SubscriptionEntity;
import kocev.nenad.webshop.model.TokenizedCard;
import kocev.nenad.webshop.repository.SubscriptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class SubscriptionService {

    private final TokenizerService tokenizerService;
    private final SubscriptionRepository subscriptionRepository;

    public void addSubscription(AddSubscriptionCommand addSubscriptionCommand) {
        TokenizedCard tokenForCard = tokenizerService.getTokenForCard(addSubscriptionCommand);

        SubscriptionEntity subscriptionEntity = new SubscriptionEntity();
        subscriptionEntity.setUsername(addSubscriptionCommand.getUsername());
        subscriptionEntity.setCardToken(tokenForCard.getToken());

        subscriptionRepository.save(subscriptionEntity);
    }

    public void renewSubscription(RenewSubscriptionCommand renewSubscriptionCommand) {

    }
}
