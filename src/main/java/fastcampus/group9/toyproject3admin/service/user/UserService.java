package fastcampus.group9.toyproject3admin.service.user;

import fastcampus.group9.toyproject3admin.domain.user.User;
import fastcampus.group9.toyproject3admin.domain.user.UserRepository;
import fastcampus.group9.toyproject3admin.web.dto.UserRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public User findById(Long id) {
        return userRepository.findById(id);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public void roleUpdate(UserRequestDTO.UpdateDTO updateDTO) {
        userRepository.updateById(updateDTO);
    }


}
