package br.com.fiap.epictaska.character;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Character {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank @Size(min = 2, max = 120)
    private String name;
    @NotBlank @Size(min = 2, max = 80)
    private String archetype;
    @NotBlank @Size(min = 3, max = 20)
    private String alignment;
    @Size(max = 2000)
    private String backstory;
    @NotNull @Min(1) @Max(100)
    private Integer intelligence;
    @NotNull @Min(1) @Max(100)
    private Integer strength;
    @Size(max = 255)
    private String avatarUrl;
}
