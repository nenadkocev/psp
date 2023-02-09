package kocev.nenad.webshop.controller;

import kocev.nenad.webshop.model.AddSubscriptionCommand;
import kocev.nenad.webshop.model.DeleteSubscriptionCommand;
import kocev.nenad.webshop.model.RenewSubscriptionCommand;
import kocev.nenad.webshop.service.SubscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/subscription")
@RequiredArgsConstructor
public class SubscriptionController {

    private final SubscriptionService subscriptionService;

    @PostMapping(path = "/add")
    public ResponseEntity<Void> addSubscription(@RequestBody AddSubscriptionCommand addSubscriptionCommand) {
        subscriptionService.addSubscription(addSubscriptionCommand);
        return ResponseEntity.ok().build();
    }

    @PostMapping(path = "/renew")
    public ResponseEntity<Void> renewSubscription(@RequestBody RenewSubscriptionCommand renewSubscriptionCommand) {
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(path = "/delete")
    public ResponseEntity<Void> deleteSubscription(@RequestBody DeleteSubscriptionCommand deleteSubscriptionCommand) {
        return ResponseEntity.ok().build();
    }
}
