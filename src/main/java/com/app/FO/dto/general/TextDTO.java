package com.app.FO.dto.general;

public class TextDTO {
    private String text;
    private String text1;

    public TextDTO(String text, String text1) {
        this.text = text;
        this.text1 = text1;
    }

    public TextDTO(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "TextDTO{" +
                "text='" + text + '\'' +
                '}';
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
