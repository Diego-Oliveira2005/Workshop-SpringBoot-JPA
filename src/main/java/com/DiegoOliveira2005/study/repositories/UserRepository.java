package com.DiegoOliveira2005.study.repositories;

import com.DiegoOliveira2005.study.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {


}
