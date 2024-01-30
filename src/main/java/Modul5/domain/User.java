package Modul5.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
    private static Integer sequence = 0;
    {
        sequence++;
    }
    @Builder.Default private Integer id = sequence;
    private String name;
    private String username;
    private String password;
    private Integer age;
}
