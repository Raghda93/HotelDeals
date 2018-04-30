package main.java.com.deals.beans;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Destination
{
	@JsonProperty("province")
    private String province;

	@JsonProperty("longName")
    private String longName;

	@JsonProperty("nonLocalizedCity")
    private String nonLocalizedCity;

	@JsonProperty("tla")
    private String tla;

	@JsonProperty("shortName")
    private String shortName;

	@JsonProperty("associatedMultiCityRegionId")
    private String associatedMultiCityRegionId;
	
	@JsonProperty("regionID")
    private String regionID;

	@JsonProperty("city")
    private String city;

	@JsonProperty("country")
    private String country;

	
	@JsonProperty("province")
    public String getProvince ()
    {
        return province;
    }

	@JsonProperty("province")
    public void setProvince (String province)
    {
        this.province = province;
    }

	@JsonProperty("longName")
    public String getLongName ()
    {
        return longName;
    }

	@JsonProperty("longName")
    public void setLongName (String longName)
    {
        this.longName = longName;
    }

	@JsonProperty("nonLocalizedCity")
    public String getNonLocalizedCity ()
    {
        return nonLocalizedCity;
    }

	@JsonProperty("nonLocalizedCity")
    public void setNonLocalizedCity (String nonLocalizedCity)
    {
        this.nonLocalizedCity = nonLocalizedCity;
    }

	@JsonProperty("tla")
    public String getTla ()
    {
        return tla;
    }

	@JsonProperty("tla")
    public void setTla (String tla)
    {
        this.tla = tla;
    }

	@JsonProperty("shortName")
    public String getShortName ()
    {
        return shortName;
    }

	@JsonProperty("shortName")
    public void setShortName (String shortName)
    {
        this.shortName = shortName;
    }

	@JsonProperty("associatedMultiCityRegionId")
    public String getAssociatedMultiCityRegionId ()
    {
        return associatedMultiCityRegionId;
    }

	@JsonProperty("associatedMultiCityRegionId")
    public void setAssociatedMultiCityRegionId (String associatedMultiCityRegionId)
    {
        this.associatedMultiCityRegionId = associatedMultiCityRegionId;
    }

	@JsonProperty("regionID")
    public String getRegionID ()
    {
        return regionID;
    }

	@JsonProperty("regionID")
    public void setRegionID (String regionID)
    {
        this.regionID = regionID;
    }

	@JsonProperty("city")
    public String getCity ()
    {
        return city;
    }

	@JsonProperty("city")
    public void setCity (String city)
    {
        this.city = city;
    }

	@JsonProperty("country")
    public String getCountry ()
    {
        return country;
    }

	@JsonProperty("country")
    public void setCountry (String country)
    {
        this.country = country;
    }

    @Override
    public String toString()
    {
        return "[province = "+province+", longName = "+longName+", nonLocalizedCity = "+nonLocalizedCity+", tla = "+tla+", shortName = "+shortName+", associatedMultiCityRegionId = "+associatedMultiCityRegionId+", regionID = "+regionID+", city = "+city+", country = "+country+"]";
    }
}
