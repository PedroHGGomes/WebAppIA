package br.com.fiap.epictaska.character;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CharacterService {
    private final CharacterRepository repository;
    public List<Character> findAll(){ return repository.findAll(); }
    public Character findById(Long id){ return repository.findById(id).orElseThrow(); }
    public Character save(Character c){ return repository.save(c); }
    public void delete(Long id){ repository.deleteById(id); }
}
