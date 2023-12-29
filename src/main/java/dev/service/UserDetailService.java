package dev.service;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserDetailService {

    private UserDetailRepository userDetailRepository;

    public UserDetailService(UserDetailRepository userDetailRepository) {
        this.userDetailRepository = userDetailRepository;
    }

    public void create(UserDetail userDetail) {
        userDetailRepository.create(userDetail);
    }

    public List<UserDetail> getAll() {
        return userDetailRepository.getAll();
    }
}
