package dev.rest;

import dev.domain.SendMoney;
import dev.domain.UserAccount;
import dev.service.SendMoneyService;
import dev.service.UserAccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class SendMoneyRestController {

    private final SendMoneyService sendMoneyService;
    private final UserAccountService userAccountService;

    public SendMoneyRestController(SendMoneyService sendMoneyService, UserAccountService userAccountService) {
        this.sendMoneyService = sendMoneyService;
        this.userAccountService = userAccountService;
    }

    @GetMapping("/AllSendMoney")
    public List<SendMoney> getSendMoney() {
        return sendMoneyService.getAll();
    }

    @PostMapping("/SendMoney/{sender_id}/{receiver_id}")
    public String createSendMoney(@RequestBody SendMoney sendMoney,
                                  @PathVariable int sender_id, @PathVariable int receiver_id) {
        UserAccount senderAccount = userAccountService.getById(sender_id);
        UserAccount receiverAccount = userAccountService.getById(receiver_id);

        sendMoney.setSenderAccount(senderAccount);
        sendMoney.setReceiverAccount(receiverAccount);

        sendMoneyService.create(sendMoney);

        return "Successful";
    }
}
