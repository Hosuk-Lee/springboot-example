package hs.springboot.example.api;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OneRepository extends JpaRepository<OneEntity,Long> {

}
