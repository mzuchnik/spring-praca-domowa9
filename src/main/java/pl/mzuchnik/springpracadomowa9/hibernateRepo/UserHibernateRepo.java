package pl.mzuchnik.springpracadomowa9.hibernateRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.mzuchnik.springpracadomowa9.entity.UserEntity;

@Repository
public interface UserHibernateRepo extends JpaRepository<UserEntity, Long> {
}
