package pl.mzuchnik.springpracadomowa9;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@SpringBootApplication
public class SpringPracaDomowa9Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringPracaDomowa9Application.class, args);
    }


    /*@Bean
    public DataSource dataSource()
    {
        return DataSourceBuilder.create()
                .username("root")
                .password("qwerty")
                .driverClassName("com.mysql.cj.jdbc.Driver")
                .url("jdbc:mysql://localhost:3306/hibernatetest?serverTimezone=UTC")
                .build();
    }*/

}
