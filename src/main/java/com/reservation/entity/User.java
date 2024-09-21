package com.reservation.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.validator.constraints.Email;
@Entity
@Data
public class User extends AbstractEntity {

        @Column(nullable = false)
        @Size(min = 3, message = "First name atleast 20 characters")
        private String firstName;

        @Column(nullable = false)
        @Size(max = 20, message = "Last name cannot atleast characters")
        private String lastName;

        @Email
        @Column(unique = true, nullable = false)
        private String email;

        @Column(nullable = false)
        @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$",
                message = "Password must contain at least one uppercase letter, one lowercase letter, one digit, and be at least 8 characters long")
        private String password;





}
