package com.fayupable.elkstack.repository;

import com.fayupable.elkstack.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface IUserRepository extends JpaRepository<UserInfo, UUID> {
    Optional<UserInfo> findByEmail(String email);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);
}
