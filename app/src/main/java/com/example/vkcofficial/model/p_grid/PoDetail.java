package com.example.vkcofficial.model.p_grid;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PoDetail {

    @SerializedName("pur_doc_num")
    @Expose
    private String purDocNum;
    @SerializedName("article")
    @Expose
    private String article;
    @SerializedName("line_number")
    @Expose
    private String lineNumber;
    @SerializedName("number_of_stichers")
    @Expose
    private String numberOfStichers;
    @SerializedName("number_of_helpers")
    @Expose
    private String numberOfHelpers;
    @SerializedName("gridData")
    @Expose
    private List<GridDatum> gridData = null;

    public String getPurDocNum() {
        return purDocNum;
    }

    public void setPurDocNum(String purDocNum) {
        this.purDocNum = purDocNum;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(String lineNumber) {
        this.lineNumber = lineNumber;
    }

    public String getNumberOfStichers() {
        return numberOfStichers;
    }

    public void setNumberOfStichers(String numberOfStichers) {
        this.numberOfStichers = numberOfStichers;
    }

    public String getNumberOfHelpers() {
        return numberOfHelpers;
    }

    public void setNumberOfHelpers(String numberOfHelpers) {
        this.numberOfHelpers = numberOfHelpers;
    }

    public List<GridDatum> getGridData() {
        return gridData;
    }

    public void setGridData(List<GridDatum> gridData) {
        this.gridData = gridData;
    }

}
