

package com.example.website.Assignment.model;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssignmentRequest {

    @NotBlank(message = "Task description is mandatory")
    private String task;

    @NotBlank(message = "Admin is mandatory")
    private String admin;
}
