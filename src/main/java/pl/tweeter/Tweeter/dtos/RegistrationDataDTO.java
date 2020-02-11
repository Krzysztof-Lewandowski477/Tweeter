package pl.tweeter.Tweeter.dtos;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class RegistrationDataDTO {
    private Long id;
    @NotBlank
    @Size(min=3, max=12)
    private String firstName;
    @NotBlank
    @Size(min=3, max=12)
    private String lastName;
    @NotBlank @Email
    private String email;
    @NotBlank @Size(min = 4, max=12)
    private String password;
    @NotBlank @Size(min = 4, max=12)
    private String rePassword;
    @NotNull
    @AssertTrue
    private Boolean termsAcceptance;
}



