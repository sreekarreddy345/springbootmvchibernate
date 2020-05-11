import com.sreekar.pojo.Student;
import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@lombok.extern.slf4j.Slf4j
public class TestStudentClassRestTemplate {

    // rest template with time out
    RestTemplate restTemplate = new RestTemplate(getClientHttpRequestFactory());

    // rest template with time out
    //Override timeouts in request factory
    private SimpleClientHttpRequestFactory getClientHttpRequestFactory() {

        SimpleClientHttpRequestFactory clientHttpRequestFactory = new SimpleClientHttpRequestFactory();
        //Connect timeout
        clientHttpRequestFactory.setConnectTimeout(10);

        //Read timeout
        clientHttpRequestFactory.setReadTimeout(10_000);
        return clientHttpRequestFactory;
    }

    @Test
    public void getStudentsTest() {

        final String uri = "http://localhost:8085/spring-boot-mvc-jsp-hibernate-Integration/students";
//        List response = restTemplate.getForObject(uri, List.class);
        ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);

        if (response.getStatusCode().value() == 200) {
            String body = response.getBody();
            log.info("get students response - " + body);
        }

       /* HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_XML));
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
        ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
        System.out.println("xml - " + result);*/
    }

    @Test
    public void createStudentsTest() {
        final String uri = "http://localhost:8085/spring-boot-mvc-jsp-hibernate-Integration/saveStudent";
        Student student = new Student(1, "sree", "vaddi", "Chicago");
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.postForObject(uri, student, String.class);
        log.info("add student response - " + response);
    }

}
