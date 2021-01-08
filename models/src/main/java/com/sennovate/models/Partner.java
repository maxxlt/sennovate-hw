package com.sennovate.models;

import lombok.*;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor @NoArgsConstructor @Getter @Setter @ToString
public class Partner {
    @Id
    private long id;
    private String fname, lname, address, city, state, email;
}
