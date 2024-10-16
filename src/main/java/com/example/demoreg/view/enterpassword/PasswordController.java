package com.example.demoreg.view.enterpassword;

import com.example.demoreg.domain.RegistrationDomain;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@RequiredArgsConstructor
@Controller
public class PasswordController {

    private final RegistrationDomain registrationDomain;

    @GetMapping("/enter-password-form")
    public String enterPasswordForm(Model model) {
        return bindModelAndShowForm(new EnterPasswordViewModel(), model);
    }

    @PostMapping("/enter-password")
    public String enterEmail(EnterPasswordViewModel enterPasswordViewModel, Model model) {
        if(!enterPasswordViewModel.validate()) {
            return bindModelAndShowForm(enterPasswordViewModel, model);
        }
        registrationDomain.enterPassword(enterPasswordViewModel.getPasswordTextField().getValue());
        registrationDomain.createAccount();
        return "success-view";
    }

    private static String bindModelAndShowForm(EnterPasswordViewModel enterPasswordViewModel, Model model) {
        model.addAttribute("model", enterPasswordViewModel);
        return "enter-password-form";
    }
}
