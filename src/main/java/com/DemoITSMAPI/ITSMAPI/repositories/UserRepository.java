package com.DemoITSMAPI.ITSMAPI.repositories;

import com.DemoITSMAPI.ITSMAPI.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel, String> {

}
