package com.example.demoreg;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.web.context.annotation.SessionScope;

import java.io.Serializable;

import static com.example.demoreg.RegistrationState.*;

@Component
@SessionScope
@Slf4j
public class RegistrationDomain implements Serializable {
    @Getter
    private String email;
    private String password;
    private RegistrationState state;

    public RegistrationDomain() {
        state = INITIAL;
    }

    public void enterEmail(String email) {
        this.email = email;
        this.password = null;
        this.state = EMAIL_ENTERED;
    }

    public void acceptToc() {
        Assert.state(state == EMAIL_ENTERED, "TOC must be accepted after email has been entered");
        this.state = TOC_ACCEPTED;
    }

    public void confirmEmail() {
        Assert.state(state == TOC_ACCEPTED, "TOC must be accepted before confirming email");
        this.state = EMAIL_CONFIRMED;
    }

    public void enterPassword(String password) {
        Assert.state(state == EMAIL_CONFIRMED, "Email must be confirmed before entering password");
        this.state = PASSWORD_ENTERED;
    }

    public void createAccount() {
        Assert.state(state == PASSWORD_ENTERED, "Password must be present to create account");
        log.info("Creating account...");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        log.info("Account created for email: {}", email);
        this.state = ACCOUNT_CREATED;
    }

}
