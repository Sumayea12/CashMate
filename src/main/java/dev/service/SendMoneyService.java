package dev.service;

import dev.domain.SendMoney;
import dev.domain.UserAccount;
import dev.repository.SendMoneyRepository;
import dev.repository.UserAccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SendMoneyService {

    private final SendMoneyRepository sendMoneyRepository;
    private final UserAccountRepository userAccountRepository;

    public SendMoneyService(SendMoneyRepository sendMoneyRepository, UserAccountRepository userAccountRepository) {
        this.sendMoneyRepository = sendMoneyRepository;
        this.userAccountRepository = userAccountRepository;
    }

    public void create(SendMoney sendMoney) {
        sendMoneyRepository.create(sendMoney);

        UserAccount senderAccount = sendMoney.getSenderAccount();
        UserAccount receiverAccount = sendMoney.getReceiverAccount();

        int sendAmount = sendMoney.getAmount();

        int senderCurrentBalance = senderAccount.getAccountBalance();
        int receiverCurrentBalance = receiverAccount.getAccountBalance();

        senderAccount.setAccountBalance(senderCurrentBalance - sendAmount);
        receiverAccount.setAccountBalance(receiverCurrentBalance + sendAmount);

        userAccountRepository.update(senderAccount);
        userAccountRepository.update(receiverAccount);
    }

    public List<SendMoney> getAll() {
        return sendMoneyRepository.getAll();
    }
}
