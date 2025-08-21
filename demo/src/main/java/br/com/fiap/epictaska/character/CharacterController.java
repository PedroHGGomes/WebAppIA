package br.com.fiap.epictaska.character;

import br.com.fiap.epictaska.character.dto.CharacterForm;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/character")
@RequiredArgsConstructor
public class CharacterController {
    private final CharacterService service;
    private final MessageSource messageSource;
    @GetMapping
    public String index(Model model){
        model.addAttribute("characters", service.findAll());
        return "character/index";
    }
    @GetMapping("/form")
    public String form(@RequestParam(required = false) Long id, Model model){
        if (id != null){
            var c = service.findById(id);
            model.addAttribute("characterForm", CharacterForm.from(c));
        } else {
            model.addAttribute("characterForm", new CharacterForm());
        }
        return "character/form";
    }
    @PostMapping("/form")
    public String create(@Valid @ModelAttribute("characterForm") CharacterForm form,
                         BindingResult result, RedirectAttributes redirect){
        if (result.hasErrors()) return "character/form";
        service.save(form.toModel());
        var msg = messageSource.getMessage("character.saved.success", null, LocaleContextHolder.getLocale());
        redirect.addFlashAttribute("message", msg);
        return "redirect:/character";
    }
    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes redirect){
        service.delete(id);
        var msg = messageSource.getMessage("character.deleted.success", null, LocaleContextHolder.getLocale());
        redirect.addFlashAttribute("message", msg);
        return "redirect:/character";
    }
}
