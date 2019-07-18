package api.engine.files.domain.reader;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import api.engine.files.domain.EngineFilesApplication.TesteFileReader;

@SpringBootTest
@RunWith(SpringRunner.class)
public class FileReaderTest {

    private TesteFileReader testeFileReader;

    @Before
    public void setUp() throws Exception {
        testeFileReader = new TesteFileReader();
    }
}