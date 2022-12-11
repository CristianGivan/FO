package com.app.FO.dto.general;

public class NumberDTO {
    private Long number;
    private Long number1;

    public NumberDTO(Long number, Long number1) {
        this.number = number;
        this.number1 = number1;
    }

    @Override
    public String toString() {
        return "NumberDTO{" +
                "number=" + number +
                ", number1=" + number1 +
                '}';
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public Long getNumber1() {
        return number1;
    }

    public void setNumber1(Long number1) {
        this.number1 = number1;
    }
}
