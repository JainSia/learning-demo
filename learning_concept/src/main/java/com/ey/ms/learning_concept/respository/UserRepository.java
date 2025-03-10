package com.ey.ms.learning_concept.respository;

import com.ey.ms.learning_concept.data.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
