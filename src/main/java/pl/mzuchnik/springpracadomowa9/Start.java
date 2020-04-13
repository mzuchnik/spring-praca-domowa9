package pl.mzuchnik.springpracadomowa9;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pl.mzuchnik.springpracadomowa9.advice.GetProcessingTime;
import pl.mzuchnik.springpracadomowa9.document.UserDocument;
import pl.mzuchnik.springpracadomowa9.entity.UserEntity;
import pl.mzuchnik.springpracadomowa9.hibernateRepo.UserHibernateRepo;
import pl.mzuchnik.springpracadomowa9.jdbc.UserJdbc;
import pl.mzuchnik.springpracadomowa9.jdbc.UserJdbcService;
import pl.mzuchnik.springpracadomowa9.mongoRepo.UserMongoRepo;

import java.io.IOException;
import java.util.List;

@Component
public class Start {

    private UserMongoRepo userMongoRepo;

    private UserHibernateRepo userHibernateRepo;

    private UserJdbcService userJdbcService;

    @Autowired
    public Start(UserMongoRepo userMongoRepo, UserHibernateRepo userHibernateRepo, UserJdbcService userJdbcService) {
        this.userMongoRepo = userMongoRepo;
        this.userHibernateRepo = userHibernateRepo;
        this.userJdbcService = userJdbcService;
    }

    @GetProcessingTime(name = "Zapis JDBC")
    @EventListener(ApplicationReadyEvent.class)
    public void saveToJdbc() {
        List<UserJdbc> listOfUserJdbc = null;
        try {
            listOfUserJdbc = FakeDataService.getListOfUserJdbc();
        } catch (IOException e) {
            e.printStackTrace();
        }
        userJdbcService.saveAll(listOfUserJdbc);
    }

    @EventListener(ApplicationReadyEvent.class)
    @GetProcessingTime(name = "Zapis MongoDB")
    public void saveToMongoDB() {
        List<UserDocument> listOfUserDocument = null;
        try {
            listOfUserDocument = FakeDataService.getListOfUserDocument();
        } catch (IOException e) {
            e.printStackTrace();
        }
        userMongoRepo.saveAll(listOfUserDocument);
    }

    @GetProcessingTime(name = "Zapis Hibernate")
    @EventListener(ApplicationReadyEvent.class)
    public void saveToHibernate() {
        List<UserEntity> listOfUserEntity = null;
        try {
            listOfUserEntity = FakeDataService.getListOfUserEntity();
        } catch (IOException e) {
            e.printStackTrace();
        }

        userHibernateRepo.saveAll(listOfUserEntity);
    }

    @EventListener(ApplicationReadyEvent.class)
    @GetProcessingTime(name = "Odczyt JDBC")
    public void readDataJdbc() {
        List<UserJdbc> users = userJdbcService.getUsers();
    }

    @EventListener(ApplicationReadyEvent.class)
    @GetProcessingTime(name = "Odczyt MongoDB")
    public void readDataMongoDB() {
        userMongoRepo.findAll();
    }

    @EventListener(ApplicationReadyEvent.class)
    @GetProcessingTime(name = "Odczyt Hibernate")
    public void readDataHibernate() {
        userHibernateRepo.findAll();
    }

}
