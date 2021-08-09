package au.com.formis.springbootdemo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import static org.assertj.core.api.Assertions.assertThat;




// @SpringBootTest
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class JavaSpringBootDemoApplicationTests {

//    @Test
//    void contextLoads() {
//    }

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void apiTest01() throws Exception {
        assertThat(restTemplate.getForObject("http://localhost:" + port + "/motorVehicles?make=Toyota&model=Prius&generation=saloon",
                String.class)).contains("\"numberOfRecords\" : 2");
    }

    @Test
    public void apiTest02() throws Exception {
        assertThat(restTemplate.getForObject("http://localhost:" + port + "/motorVehicles?make=BMW&model=3-Series&generation=Saloon+2005",
                String.class)).contains("\"numberOfRecords\" : 8");
    }

    @Test
    public void apiTest03() throws Exception {
        assertThat(restTemplate.getForObject("http://localhost:" + port + "/motorVehicles?make=BMW&model=X6",
                String.class)).contains("\"numberOfRecords\" : 12");
    }


}
