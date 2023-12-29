package dev.service;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserAddressService {

    private UserAddressRepository userAddressRepository;

    public UserAddressService(UserAddressRepository userAddressRepository) {
        this.userAddressRepository = userAddressRepository;
    }

    public void create(UserAddress userAddress) {
        userAddressRepository.create(userAddress);
    }

    public List<UserAddress> getAll() {
        return userAddressRepository.getAll();
    }
}
