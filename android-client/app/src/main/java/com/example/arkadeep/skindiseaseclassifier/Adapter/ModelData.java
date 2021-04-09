package com.example.arkadeep.skindiseaseclassifier.Adapter;

public class ModelData {

    String probability,label;

    public ModelData() {
    }

    public ModelData(String probability, String label) {
        this.probability = probability;
        this.label = label;
    }

    public String getProbability() {
        return probability;
    }

    public void setProbability(String probability) {
        this.probability = probability;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
