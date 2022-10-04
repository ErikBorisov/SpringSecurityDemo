package net.proselyte.springsecuritydemo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Developer {
    private int id;
    private String firstName;
    private String lastName;
}
