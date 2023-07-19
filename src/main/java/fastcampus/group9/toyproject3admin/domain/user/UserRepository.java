package fastcampus.group9.toyproject3admin.domain.user;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRepository {

    User findByUsername(String username);
}
