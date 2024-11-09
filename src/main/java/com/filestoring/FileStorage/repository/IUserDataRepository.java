package com.filestoring.FileStorage.repository;

import com.filestoring.FileStorage.entity.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserDataRepository extends JpaRepository<UserData,Long> {

    Optional<UserData> findByUsernameAndUserId(String username,long userId);

}
