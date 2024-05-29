package teste.piProject.util;
import org.springframework.stereotype.Component;

@Component
public class IPConfig {
    String ipApi = System.getenv("ENV_API");
    public String getIpApi() {
        if ("prod".equals(ipApi)) {
            return "api";
        } else {
            return "localhost:8080";
        }
    }
}
