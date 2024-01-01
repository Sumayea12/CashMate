package dev.service;

import dev.domain.UserAccount;
import dev.repository.UserAccountRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserAccountService {

    private final UserAccountRepository userAccountRepository;

    public UserAccountService(UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }


    public void update(UserAccount userAccount) {
        userAccountRepository.update(userAccount);
    }

    public UserAccount getById(int accountId) {
        return userAccountRepository.get(accountId);
    }

    // Other methods related to user account if needed

}
