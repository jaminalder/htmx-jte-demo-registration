package com.example.demoreg.view.shared;

import lombok.Getter;
import lombok.Setter;

@Getter
public class TextFieldViewModel {
    private final String label;
    private final String placeholder;
    private final String name;

    @Setter
    private String value;
    @Setter
    private String hint;
    @Setter
    private String error;


    public TextFieldViewModel(String label, String placeholder, String name) {
        this.label = label;
        this.placeholder = placeholder;
        this.name = name;
    }
}
