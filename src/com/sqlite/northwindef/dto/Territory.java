package com.sqlite.northwindef.dto;

// This code was generated by a tool. Don't modify it manually.
// http://sqldalmaker.sourceforge.net

public class Territory  {

    private Integer territoryID;  // t(TerritoryID)
    private String territoryDescription;  // t(TerritoryDescription)
    private Integer regionID;  // t(RegionID)

    public Integer getTerritoryID() {
        return this.territoryID;
    }

    public void setTerritoryID(Integer territoryID) {
        this.territoryID = territoryID;
    }

    public String getTerritoryDescription() {
        return this.territoryDescription;
    }

    public void setTerritoryDescription(String territoryDescription) {
        this.territoryDescription = territoryDescription;
    }

    public Integer getRegionID() {
        return this.regionID;
    }

    public void setRegionID(Integer regionID) {
        this.regionID = regionID;
    }
}