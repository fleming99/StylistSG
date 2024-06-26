package com.fleming99.StylistSG.core.validation;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {

    @Size(min = 2, message = "mínimo duas letras")
    private String customerFirstName;

    @Size(min = 2, message = "mínimo duas letras")
    private String customerLastName;

    private LocalDate customerBirthDate;

    private int customerAge;

    @NotNull(message = "não pode estar vazio.")
    private String customerPhoneNumber;

    @Pattern(regexp= "^[_a-z0-9-+]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9]+)*(\\.[a-z]{2,})$", message = "formato inválido (exemplo@email.com)")
    private String customerEmail;

    private String customerStreetName;

    private String customerNeighborhood;

    private String customerHouseNumber;

    private String customerCity;

    private String customerState;

    private String customerCountry;
}
