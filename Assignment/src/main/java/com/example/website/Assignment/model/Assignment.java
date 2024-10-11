

package com.example.website.Assignment.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "assignments")
public class Assignment {
    @Id
    private String id; 

    private String userId; 

    private String task; 

    private String admin; 

    private LocalDateTime createdAt = LocalDateTime.now();

    private String status; 
}
