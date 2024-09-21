package com.reservation.controller;
import ch.qos.logback.core.model.Model;
import com.reservation.entity.User;
import com.reservation.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import static org.thymeleaf.spring6.util.FieldUtils.hasErrors;

@Controller
public class UserController {
    @Autowired
    private UserRepository userRepo;

    @RequestMapping("/showLoginPage")
    public String showingLoginPage() {
        return "login";
    }

    @RequestMapping("/showReg")
    public String showReg() {
        return "showReg";

    }
    @RequestMapping(value = "/showReg", method = RequestMethod.GET)
        public String showRegistrationForm(ModelMap modelMap) {
        modelMap.addAttribute("user", new User());
        return "showReg";
    }

    @RequestMapping("/saveReg")
    public String saveReg(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, ModelMap modelMap) {
        if (bindingResult.hasErrors()) {
            return "showReg";
        }
        try {
            userRepo.save(user);
        } catch (DataIntegrityViolationException e) {
            modelMap.addAttribute("errorMessage", "Email is already exist, please choose a different email.");
            return "showReg";
        }
        return "login";
        
    }
    @RequestMapping("/verifyLogin")
    public String verifyLogin(@RequestParam("emailId")String emailId, @RequestParam("password") String password, ModelMap modelMap){
        User user = userRepo.findByEmail(emailId);
        if(user!= null) {
            if (user.getEmail().equals(emailId) && user.getPassword().equals(password)) {
                return "findFlights";
            } else {
                modelMap.addAttribute("error", "Invalid username/ password");
                return "login";
            }
        }else {
            modelMap.addAttribute("error", "Invalid username/ password");
            return "login";
        }

    }
}
