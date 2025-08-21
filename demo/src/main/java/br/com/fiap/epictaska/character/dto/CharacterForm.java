package br.com.fiap.epictaska.character.dto;

import br.com.fiap.epictaska.character.Character;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class CharacterForm {
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
    public Character toModel(){
        return Character.builder()
                .id(id).name(name).archetype(archetype).alignment(alignment)
                .backstory(backstory).intelligence(intelligence).strength(strength)
                .avatarUrl(avatarUrl).build();
    }
    public static CharacterForm from(Character c){
        CharacterForm f = new CharacterForm();
        f.setId(c.getId()); f.setName(c.getName()); f.setArchetype(c.getArchetype());
        f.setAlignment(c.getAlignment()); f.setBackstory(c.getBackstory());
        f.setIntelligence(c.getIntelligence()); f.setStrength(c.getStrength());
        f.setAvatarUrl(c.getAvatarUrl());
        return f;
    }
}
