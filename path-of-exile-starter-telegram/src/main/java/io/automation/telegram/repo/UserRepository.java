package io.automation.telegram.repo;

import io.automation.telegram.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

  UserEntity findById(long id);
}
