package com.backend.backendApp.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Product {

    @Id
    private String Id;

    @NotBlank(message = "product title is required!")
    @Size(min=3 , max=20 , message = "product title mustbe atleast 3 characters !")
    private String title;

    @NotBlank(message = "product descriptions is required!")
    @Size(min=50 , max=500 , message = "product title mustbe atleast 50 characters !")
    private String descriptions;
}
