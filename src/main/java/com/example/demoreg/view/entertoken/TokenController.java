package com.example.demoreg.view.entertoken;

import com.example.demoreg.view.enterpassword.PasswordController;
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
public class TokenController {

    private final RegistrationDomain registrationDomain;
    private final PasswordController passwordController;

    @GetMapping("/enter-token-form")
    public String enterTokenForm(Model model) {
        return bindModelAndShowForm(new EnterTokenViewModel(registrationDomain.getEmail()), model);
    }

    @PostMapping("/enter-token")
    public String enterToken(EnterTokenViewModel enterTokenViewModel, Model model) {
        if(enterTokenViewModel.validate()) {
            registrationDomain.confirmEmail();
            return passwordController.enterPasswordForm(model);
        } else {
            enterTokenViewModel.setEmail(registrationDomain.getEmail());
            return bindModelAndShowForm(enterTokenViewModel, model);
        }
    }

    private static String bindModelAndShowForm(EnterTokenViewModel enterTokenViewModel, Model model) {
        model.addAttribute("model", enterTokenViewModel);
        return "enter-token-form";
    }
}
