package pl.mzuchnik.springpracadomowa9.jdbc;

import java.util.List;

public interface UserJdbcService {

    void saveAll(List<UserJdbc> user);

    List<UserJdbc> getUsers();
}
