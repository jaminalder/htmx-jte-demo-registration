package com.example.demoreg;

import lombok.Getter;
import org.springframework.util.StringUtils;

@Getter
public class EnterTokenViewModel {
    private final String email;
    private final TextFieldViewModel tokenTextField;

    public EnterTokenViewModel(String email) {
        this.email = email;
        this.tokenTextField = new TextFieldViewModel("Token:", "Enter your token", "tokenTextField");
    }

    public boolean validate() {
        String token = tokenTextField.getValue();
        if (!StringUtils.hasLength(token)) {
            tokenTextField.setError("Please enter the token");
            return false;
        }
        if (!token.matches("[0-9]{4}")) {
            tokenTextField.setError("Token must be 4 digits");
            return false;
        }
        if (!token.equals("1234")) {
            tokenTextField.setError("Wrong token");
            return false;
        }
        return true;
    }

}
