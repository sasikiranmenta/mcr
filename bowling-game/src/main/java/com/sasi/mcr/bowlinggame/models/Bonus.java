package com.sasi.mcr.bowlinggame.models;

public enum Bonus {
    STRIKE(10), SPARE(5), NORMAL(0);

    private int bonusValue;

    Bonus(int val) {
        this.bonusValue = val;
    }

    public int getBonusValue() {
        return this.bonusValue;
    }
}
