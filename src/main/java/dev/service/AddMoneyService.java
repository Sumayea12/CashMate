
package dev.service;


import dev.domain.AddMoney;
import dev.domain.UserAccount;
import dev.repository.AddMoneyRepository;
import dev.repository.UserAccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AddMoneyService {

    private AddMoneyRepository addMoneyRepository;
    private UserAccountRepository userAccountRepository;
    public AddMoneyService(AddMoneyRepository addMoneyRepository,UserAccountRepository userAccountRepository)
    {this.addMoneyRepository = addMoneyRepository; this.userAccountRepository = userAccountRepository;}

    public void create(AddMoney addMoney){

        addMoneyRepository.create(addMoney);

        UserAccount userAccount = addMoney.getAccount();
        int addMoneyAmount = addMoney.getAmount();
        int currentBalance = userAccount.getAccountBalance();
        userAccount.setAccountBalance(currentBalance + addMoneyAmount);

        userAccountRepository.update(userAccount);
    }

    public List<AddMoney> getAAll(){
        return addMoneyRepository.getAAll();
    }
}

