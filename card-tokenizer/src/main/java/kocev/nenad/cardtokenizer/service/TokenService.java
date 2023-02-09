package kocev.nenad.cardtokenizer.service;

import kocev.nenad.cardtokenizer.model.InvalidateTokenCommand;
import kocev.nenad.cardtokenizer.model.RequestForTokenCommand;
import kocev.nenad.cardtokenizer.model.TokenizedCard;
import kocev.nenad.cardtokenizer.model.TokenizedCardEntity;
import kocev.nenad.cardtokenizer.repository.TokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TokenService {

    private final VisaTokenizerMockService visaTokenizerMockService;

    private final TokenRepository tokenRepository;

    public TokenizedCard tokenizeCard(RequestForTokenCommand requestForTokenCommand) {
        TokenizedCard tokenizedCard = visaTokenizerMockService.tokenizeCard(requestForTokenCommand);
        tokenRepository.save(createTokenEntity(tokenizedCard, requestForTokenCommand.getMerchantId()));
        return tokenizedCard;
    }

    public void invalidateToken(InvalidateTokenCommand invalidateTokenCommand) {
        Optional<TokenizedCardEntity> tokenToInvalidate = tokenRepository.findByTokenAndMerchantId(
                invalidateTokenCommand.getToken(), invalidateTokenCommand.getMerchantId());
        tokenToInvalidate.ifPresent(tokenRepository::delete);
    }

    private TokenizedCardEntity createTokenEntity(TokenizedCard tokenizedCard, String merchantId) {
        TokenizedCardEntity entity = new TokenizedCardEntity();
        entity.setTokenId(UUID.randomUUID());
        entity.setToken(tokenizedCard.getToken());
        entity.setMerchantId(merchantId);
        return entity;
    }
}
