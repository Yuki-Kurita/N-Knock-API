package com.good.tyotto.nknock.api.service;

import com.good.tyotto.nknock.api.domain.User;
import com.good.tyotto.nknock.api.domain.UserSelector;
import com.good.tyotto.nknock.api.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User find(UserSelector selector) {
        return this.userRepository.find(selector);
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void add(User user) {
        this.userRepository.insert(user);
    }
}
