package project.vapeshop.models;

import org.example.annotation.Component;
import org.example.annotation.Value;

@Component
public class ParametersHolder {
    @Value("info.message")
    private String someText;

    public String getSomeText() {
        return someText;
    }
}
