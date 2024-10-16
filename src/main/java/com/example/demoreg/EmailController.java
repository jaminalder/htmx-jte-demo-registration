package com.example.demoreg;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Slf4j
@Controller
public class EmailController {

    private final RegistrationDomain registrationDomain;
    private final TokenController tokenController;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/enter-email-form")
    public String enterEmailForm(Model model) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        bindViewModel(new EnterEmailViewModel(), model);
        return "enter-email-form";
    }

    @PostMapping("/enter-email")
    public String enterEmail(EnterEmailViewModel enterEmailViewModel, Model model) {
        if (!enterEmailViewModel.validate()) {
            bindViewModel(enterEmailViewModel, model);
            return "enter-email-form";
        }
        registrationDomain.enterEmail(enterEmailViewModel.getEmailTextField().getValue());
        registrationDomain.acceptToc();
        return tokenController.enterTokenForm(model);
    }

    private static void bindViewModel(EnterEmailViewModel enterEmailViewModel, Model model) {
        model.addAttribute("model", enterEmailViewModel);
    }

}
