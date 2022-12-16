package com.app.FO.dto.general;

import com.fasterxml.jackson.annotation.JsonCreator;

public class TextDTO {
    private String text;


    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public TextDTO(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "TextDTO{" +
          //      "text='" + text + '\'' +
                '}';
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
