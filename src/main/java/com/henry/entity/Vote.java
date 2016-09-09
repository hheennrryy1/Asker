package com.henry.entity;

public class Vote extends VoteKey {
    private Boolean mode;
    
    public Vote(){};

	public Boolean getMode() {
        return mode;
    }

    public void setMode(Boolean mode) {
        this.mode = mode;
    }
}