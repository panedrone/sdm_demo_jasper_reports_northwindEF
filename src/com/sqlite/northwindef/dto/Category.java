package com.sqlite.northwindef.dto;

// This code was generated by a tool. Don't modify it manually.
// http://sqldalmaker.sourceforge.net

public class Category  {

    private Integer categoryID;  // t(CategoryID)
    private String categoryName;  // t(CategoryName)
    private String description;  // t(Description)
    private byte[] picture;  // t(Picture)

    public Integer getCategoryID() {
        return this.categoryID;
    }

    public void setCategoryID(Integer categoryID) {
        this.categoryID = categoryID;
    }

    public String getCategoryName() {
        return this.categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getPicture() {
        return this.picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }
}