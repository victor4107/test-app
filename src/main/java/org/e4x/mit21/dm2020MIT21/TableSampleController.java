/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.e4x.mit21.dm2020MIT21;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author 38068
 */
@Controller
public class TableSampleController {

    private final TableSampleRepository tableSampleRepository;

    @Autowired
    public TableSampleController(TableSampleRepository tableSampleRepository) {
        this.tableSampleRepository = tableSampleRepository;
    }

    @GetMapping("/")
    public String showIndex(Model model) {
        model.addAttribute("tableRows", tableSampleRepository.findAll());
        return "index";
    }

    @GetMapping("/signup")
    public String showAddForm(TableSample tableSample) {
        return "add-rows";
    }

    @PostMapping("/addrows")
    public String addUser(@Valid TableSample tableSample, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-rows";
        }

        tableSampleRepository.save(tableSample);
        model.addAttribute("tableRows", tableSampleRepository.findAll());
        return "index";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
        TableSample tableSample = tableSampleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid row Id:" + id));

        model.addAttribute("tableRows", tableSample);
        return "update-rows";
    }

    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") int id, @Valid TableSample tableSample,
            BindingResult result, Model model) {
        if (result.hasErrors()) {
            tableSample.setId(id);
            model.addAttribute("tableRows", tableSample);
            return "update-rows";
        }
        tableSampleRepository.save(tableSample);
        model.addAttribute("tableRows", tableSampleRepository.findAll());
        return "index";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") int id, Model model) {
        TableSample tableSample = tableSampleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        tableSampleRepository.delete(tableSample);
        model.addAttribute("tableRows", tableSampleRepository.findAll());
        return "index";
    }
}
