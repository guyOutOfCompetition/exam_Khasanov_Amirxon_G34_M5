package Modul5.domain;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class DateApi {
    private String text;
    private Integer year;
    private Integer number;
    private Boolean found;
    private String type;

}
