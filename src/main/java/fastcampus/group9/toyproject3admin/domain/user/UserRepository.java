package fastcampus.group9.toyproject3admin.domain.user;

import fastcampus.group9.toyproject3admin.web.dto.UserRequest;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserRepository {

    User findByUsername(String username);

    List<User> findAll();

    void updateById(UserRequest.UpdateDTO updateDTO);
}
