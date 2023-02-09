package kocev.nenad.cardtokenizer.controller;

import kocev.nenad.cardtokenizer.model.InvalidateTokenCommand;
import kocev.nenad.cardtokenizer.model.RequestForTokenCommand;
import kocev.nenad.cardtokenizer.model.TokenizedCard;
import kocev.nenad.cardtokenizer.service.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller which tokenizes cards.
 */
@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class TokenizeCardController {

    private final TokenService tokenService;

    @GetMapping(path = "/ping")
    public ResponseEntity<String> ping() {
        return ResponseEntity.ok("pong");
    }

    @PostMapping(path = "/tokenize", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TokenizedCard> tokenizeCard(@RequestBody RequestForTokenCommand requestForTokenCommand) {
        return ResponseEntity.ok(tokenService.tokenizeCard(requestForTokenCommand));
    }

    @DeleteMapping(path = "/invalidate", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> invalidateToken(@RequestBody InvalidateTokenCommand invalidateTokenCommand) {
        tokenService.invalidateToken(invalidateTokenCommand);
        return ResponseEntity.ok().build();
    }
}
