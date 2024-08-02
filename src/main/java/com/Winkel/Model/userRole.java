package com.Winkel.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "user_role")
public class userRole {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String roleName;
    private LocalDateTime createAt;
    private LocalDateTime updatedAt;
}
