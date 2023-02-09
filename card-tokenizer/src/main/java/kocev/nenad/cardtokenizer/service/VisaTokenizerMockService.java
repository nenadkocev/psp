package kocev.nenad.cardtokenizer.service;

import kocev.nenad.cardtokenizer.model.RequestForTokenCommand;
import kocev.nenad.cardtokenizer.model.TokenizedCard;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;

@Service
public class VisaTokenizerMockService {

    public TokenizedCard tokenizeCard(RequestForTokenCommand requestForTokenCommand) {
        return TokenizedCard.builder()
                .token(generateToken(requestForTokenCommand))
                .build();
    }

    private String generateToken(RequestForTokenCommand requestForTokenCommand) {
        SecureRandom secureRandom = new SecureRandom(requestForTokenCommand.toString().getBytes());
        return String.valueOf(secureRandom.nextLong(4000000000000000L, 4999999999999999L));
    }
}
