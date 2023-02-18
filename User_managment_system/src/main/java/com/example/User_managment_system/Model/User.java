package com.example.User_managment_system.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.executable.ValidateOnExecution;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;
import org.hibernate.validator.constraints.Length;
import org.springframework.context.annotation.Bean;
import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tbl_user")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer user_id;
  @NotBlank(message = "Username required")
    private String username;

  @NotBlank(message ="date must be required")
  @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String date_ofbirth;
    private String email;

    @NotBlank(message = "phone number must be required")
    @Size(min=12,max = 12,message= "size must be 10")
    private String phone_number;


    private String date;
    private String time;
}
