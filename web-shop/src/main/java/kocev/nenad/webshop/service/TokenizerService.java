package kocev.nenad.webshop.service;

import kocev.nenad.webshop.model.AddSubscriptionCommand;
import kocev.nenad.webshop.model.RequestForTokenRequest;
import kocev.nenad.webshop.model.TokenizedCard;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TokenizerService {

    @Value("${tokenizer.url}")
    private String tokenizerUrl;

    public TokenizedCard getTokenForCard(AddSubscriptionCommand addSubscriptionCommand) {
        RequestForTokenRequest requestForToken = RequestForTokenRequest.builder()
                .merchantId("Netflix")
                .expirationDate(addSubscriptionCommand.getExpirationDate())
                .cvv(addSubscriptionCommand.getCvv())
                .cardholderAccountNumber(addSubscriptionCommand.getCardholderAccountNumber())
                .build();


        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<TokenizedCard> tokenizedCard = restTemplate.postForEntity(tokenizerUrl + "/tokenize", requestForToken, TokenizedCard.class);
        return tokenizedCard.getBody();
    }
}
