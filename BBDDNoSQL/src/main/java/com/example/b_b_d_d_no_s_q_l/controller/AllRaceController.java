package com.example.b_b_d_d_no_s_q_l.controller;

import com.example.b_b_d_d_no_s_q_l.model.AllRaceDTO;
import com.example.b_b_d_d_no_s_q_l.service.AllRaceService;
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
@RequestMapping("/allRaces")
public class AllRaceController {

    private final AllRaceService allRaceService;

    public AllRaceController(final AllRaceService allRaceService) {
        this.allRaceService = allRaceService;
    }

    @GetMapping
    public String list(final Model model) {
        model.addAttribute("allRaces", allRaceService.findAll());
        return "allRace/list";
    }

    @GetMapping("/add")
    public String add(@ModelAttribute("allRace") final AllRaceDTO allRaceDTO) {
        return "allRace/add";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("allRace") @Valid final AllRaceDTO allRaceDTO,
            final BindingResult bindingResult, final RedirectAttributes redirectAttributes) {
        if (!bindingResult.hasFieldErrors("id") && allRaceDTO.getId() == null) {
            bindingResult.rejectValue("id", "NotNull");
        }
        if (!bindingResult.hasFieldErrors("id") && allRaceService.idExists(allRaceDTO.getId())) {
            bindingResult.rejectValue("id", "Exists.allRace.id");
        }
        if (bindingResult.hasErrors()) {
            return "allRace/add";
        }
        allRaceService.create(allRaceDTO);
        redirectAttributes.addFlashAttribute(WebUtils.MSG_SUCCESS, WebUtils.getMessage("allRace.create.success"));
        return "redirect:/allRaces";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable(name = "id") final String id, final Model model) {
        model.addAttribute("allRace", allRaceService.get(id));
        return "allRace/edit";
    }

    @PostMapping("/edit/{id}")
    public String edit(@PathVariable(name = "id") final String id,
            @ModelAttribute("allRace") @Valid final AllRaceDTO allRaceDTO,
            final BindingResult bindingResult, final RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "allRace/edit";
        }
        allRaceService.update(id, allRaceDTO);
        redirectAttributes.addFlashAttribute(WebUtils.MSG_SUCCESS, WebUtils.getMessage("allRace.update.success"));
        return "redirect:/allRaces";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable(name = "id") final String id,
            final RedirectAttributes redirectAttributes) {
        allRaceService.delete(id);
        redirectAttributes.addFlashAttribute(WebUtils.MSG_INFO, WebUtils.getMessage("allRace.delete.success"));
        return "redirect:/allRaces";
    }

}
