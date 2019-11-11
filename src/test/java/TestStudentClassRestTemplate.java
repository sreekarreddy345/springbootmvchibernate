import com.sreekar.pojo.Student;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class TestStudentClassRestTemplate {
    @Test
    @Ignore
    public void getStudentsTest() {

        final String uri = "http://localhost:8085/spring-boot-mvc-jsp-hibernate-Integration/students";

        RestTemplate restTemplate = new RestTemplate();
        List forObject = restTemplate.getForObject(uri, List.class);


        System.out.println(forObject);
        System.out.println("Size - " + forObject.size());
       /* HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_XML));
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);

        ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);

        System.out.println("xml - " + result);*/
    }

    @Test
    @Ignore
    public void createStudentsTest() {

        final String uri = "http://localhost:8085/spring-boot-mvc-jsp-hibernate-Integration/saveStudent";

        Student student = new Student(1, "sree", "vaddi", "Chicago");

        RestTemplate restTemplate = new RestTemplate();

        String response = restTemplate.postForObject(uri, student, String.class);
        System.out.println(response);
    }

}
