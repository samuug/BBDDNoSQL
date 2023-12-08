package com.example.b_b_d_d_no_s_q_l.controller;

import com.example.b_b_d_d_no_s_q_l.model.DriverStandingsDTO;
import com.example.b_b_d_d_no_s_q_l.service.DriverStandingsService;
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
@RequestMapping("/driverStandingss")
public class DriverStandingsController {

    private final DriverStandingsService driverStandingsService;

    public DriverStandingsController(final DriverStandingsService driverStandingsService) {
        this.driverStandingsService = driverStandingsService;
    }

    @GetMapping
    public String list(final Model model) {
        model.addAttribute("driverStandingses", driverStandingsService.findAll());
        return "driverStandings/list";
    }

    @GetMapping("/add")
    public String add(
            @ModelAttribute("driverStandings") final DriverStandingsDTO driverStandingsDTO) {
        return "driverStandings/add";
    }

    @PostMapping("/add")
    public String add(
            @ModelAttribute("driverStandings") @Valid final DriverStandingsDTO driverStandingsDTO,
            final BindingResult bindingResult, final RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "driverStandings/add";
        }
        driverStandingsService.create(driverStandingsDTO);
        redirectAttributes.addFlashAttribute(WebUtils.MSG_SUCCESS, WebUtils.getMessage("driverStandings.create.success"));
        return "redirect:/driverStandingss";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable(name = "id") final Long id, final Model model) {
        model.addAttribute("driverStandings", driverStandingsService.get(id));
        return "driverStandings/edit";
    }

    @PostMapping("/edit/{id}")
    public String edit(@PathVariable(name = "id") final Long id,
            @ModelAttribute("driverStandings") @Valid final DriverStandingsDTO driverStandingsDTO,
            final BindingResult bindingResult, final RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "driverStandings/edit";
        }
        driverStandingsService.update(id, driverStandingsDTO);
        redirectAttributes.addFlashAttribute(WebUtils.MSG_SUCCESS, WebUtils.getMessage("driverStandings.update.success"));
        return "redirect:/driverStandingss";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable(name = "id") final Long id,
            final RedirectAttributes redirectAttributes) {
        driverStandingsService.delete(id);
        redirectAttributes.addFlashAttribute(WebUtils.MSG_INFO, WebUtils.getMessage("driverStandings.delete.success"));
        return "redirect:/driverStandingss";
    }

}
