package com.example.b_b_d_d_no_s_q_l.controller;

import com.example.b_b_d_d_no_s_q_l.model.ConstructorStandingsDTO;
import com.example.b_b_d_d_no_s_q_l.service.ConstructorStandingsService;
import com.example.b_b_d_d_no_s_q_l.util.WebUtils;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/constructorStandingss")
public class ConstructorStandingsController {

    private final ConstructorStandingsService constructorStandingsService;

    public ConstructorStandingsController(
            final ConstructorStandingsService constructorStandingsService) {
        this.constructorStandingsService = constructorStandingsService;
    }

    @GetMapping
    public String list(final Model model) {
        model.addAttribute("constructorStandingses", constructorStandingsService.findAll());
        return "constructorStandings/list";
    }

    @GetMapping("/add")
    public String add(
            @ModelAttribute("constructorStandings") final ConstructorStandingsDTO constructorStandingsDTO) {
        return "constructorStandings/add";
    }

    @PostMapping("/add")
    public String add(
            @ModelAttribute("constructorStandings") @Valid final ConstructorStandingsDTO constructorStandingsDTO,
            final BindingResult bindingResult, final RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "constructorStandings/add";
        }
        constructorStandingsService.create(constructorStandingsDTO);
        redirectAttributes.addFlashAttribute(WebUtils.MSG_SUCCESS, WebUtils.getMessage("constructorStandings.create.success"));
        return "redirect:/constructorStandingss";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable(name = "id") final Long id, final Model model) {
        model.addAttribute("constructorStandings", constructorStandingsService.get(id));
        return "constructorStandings/edit";
    }

    @PostMapping("/edit/{id}")
    public String edit(@PathVariable(name = "id") final Long id,
            @ModelAttribute("constructorStandings") @Valid final ConstructorStandingsDTO constructorStandingsDTO,
            final BindingResult bindingResult, final RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "constructorStandings/edit";
        }
        constructorStandingsService.update(id, constructorStandingsDTO);
        redirectAttributes.addFlashAttribute(WebUtils.MSG_SUCCESS, WebUtils.getMessage("constructorStandings.update.success"));
        return "redirect:/constructorStandingss";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable(name = "id") final Long id,
            final RedirectAttributes redirectAttributes) {
        constructorStandingsService.delete(id);
        redirectAttributes.addFlashAttribute(WebUtils.MSG_INFO, WebUtils.getMessage("constructorStandings.delete.success"));
        return "redirect:/constructorStandingss";
    }

}
