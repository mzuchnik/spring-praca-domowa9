package pl.mzuchnik.springpracadomowa9.jdbc;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import pl.mzuchnik.springpracadomowa9.Gender;

import java.sql.*;
import java.util.List;

@Service
public class UserJdbcServiceImpl implements UserJdbcService{

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public UserJdbcServiceImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void saveAll(List<UserJdbc> userJdbcList) {
        String sql = "INSERT INTO UserJdbc(firstName, lastName, email, gender, ipAddress) VALUES (?,?,?,?,?)";

        try {
            Connection c = null;
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/hibernatetest?useServerPrepStmts=false&rewriteBatchedStatements=true&serverTimezone=UTC", "root", "qwerty");
            c.setAutoCommit(false);
            PreparedStatement pstmt = c.prepareStatement(sql);

            Object[] vals = userJdbcList.toArray();

            for (int i = 0; i < vals.length; i++) {
                pstmt.setString(1,userJdbcList.get(i).getFirstName());
                pstmt.setString(2,userJdbcList.get(i).getLastName());
                pstmt.setString(3,userJdbcList.get(i).getEmail());
                pstmt.setString(4,userJdbcList.get(i).getGender().name());
                pstmt.setString(5,userJdbcList.get(i).getIpAddress());
                pstmt.addBatch();
            }

            pstmt.executeBatch();
            c.setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<UserJdbc> getUsers() {
        String sql = "SELECT id, firstName, lastName, email, gender, ipAddress FROM UserJdbc";

        return jdbcTemplate.query(sql, new RowMapper<UserJdbc>() {
            @Override
            public UserJdbc mapRow(ResultSet rs, int i) throws SQLException {
                return new UserJdbc(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4), Gender.valueOf(rs.getString(5)), rs.getString(6));
            }
        });
    }
}
