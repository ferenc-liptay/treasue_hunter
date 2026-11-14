package lf.sb_treasure_hunter_rest.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import lf.sb_treasure_hunter_rest.model.User;

public interface UserRepository extends CrudRepository<User, Integer>{

	@Query("SELECT * FROM game_userdb.user WHERE username = :username AND password = :pwd")
	User getUserNameAndPassword(@Param("username") String username, @Param("pwd") String pwd);
}
