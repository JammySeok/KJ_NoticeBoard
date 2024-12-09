package com.example.KJ_NoticeBoard.service;

import com.example.KJ_NoticeBoard.dto.UserDTO;
import com.example.KJ_NoticeBoard.repository.LoginRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class LoginService {
    private final LoginRepository loginRepository;

    public UserDTO getList(String id) {
        return loginRepository.getList(id);
    }

    public void save(UserDTO userDTO) {
        loginRepository.save(userDTO);

    }

    public boolean successLogin(String id, String password) {
        UserDTO user = getList(id);
        System.out.println(user);
        if (user == null) {
            return false;
        }
        return user.getPassword().equals(password);
    }

}
