package pl.mzuchnik.springpracadomowa9;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.springframework.stereotype.Service;
import pl.mzuchnik.springpracadomowa9.document.UserDocument;
import pl.mzuchnik.springpracadomowa9.entity.UserEntity;
import pl.mzuchnik.springpracadomowa9.jdbc.UserJdbc;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class FakeDataService {


    public static List<UserEntity> getListOfUserEntity() throws IOException {

        CsvMapper mapper = new CsvMapper();

        CsvSchema sclema = mapper.schemaFor(UserEntity.class)
                .withSkipFirstDataRow(true)
                .withColumnSeparator(',').withoutQuoteChar();


        MappingIterator<UserEntity> userIter = new CsvMapper().readerFor(UserEntity.class).with(sclema).readValues(new File("/home/mzuchnik/IdeaProjects/spring-praca-domowa9/src/main/resources/static/MOCK_DATA.csv"));

        return userIter.readAll();
    }

    public static List<UserDocument> getListOfUserDocument() throws IOException {

        CsvMapper mapper = new CsvMapper();

        CsvSchema sclema = mapper.schemaFor(UserDocument.class)
                .withSkipFirstDataRow(true)
                .withColumnSeparator(',').withoutQuoteChar();


        MappingIterator<UserDocument> userIter = new CsvMapper().readerFor(UserDocument.class).with(sclema).readValues(new File("/home/mzuchnik/IdeaProjects/spring-praca-domowa9/src/main/resources/static/MOCK_DATA.csv"));

        return userIter.readAll();
    }

    public static List<UserJdbc> getListOfUserJdbc() throws IOException {

        CsvMapper mapper = new CsvMapper();

        CsvSchema sclema = mapper.schemaFor(UserJdbc.class)
                .withSkipFirstDataRow(true)
                .withColumnSeparator(',').withoutQuoteChar();


        MappingIterator<UserJdbc> userIter = new CsvMapper().readerFor(UserJdbc.class).with(sclema).readValues(new File("/home/mzuchnik/IdeaProjects/spring-praca-domowa9/src/main/resources/static/MOCK_DATA.csv"));

        return userIter.readAll();
    }

}
