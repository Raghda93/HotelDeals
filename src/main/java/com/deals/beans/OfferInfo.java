package main.java.com.deals.beans;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OfferInfo
{
	@JsonProperty("siteID")
    private String siteID;
	@JsonProperty("userSelectedCurrency")
    private String userSelectedCurrency;
	@JsonProperty("language")
    private String language;
	@JsonProperty("currency")
    private String currency;

	@JsonProperty("siteID")
    public String getSiteID ()
    {
        return siteID;
    }

	@JsonProperty("siteID")
    public void setSiteID (String siteID)
    {
        this.siteID = siteID;
    }

	@JsonProperty("userSelectedCurrency")
    public String getUserSelectedCurrency ()
    {
        return userSelectedCurrency;
    }

	@JsonProperty("userSelectedCurrency")
    public void setUserSelectedCurrency (String userSelectedCurrency)
    {
        this.userSelectedCurrency = userSelectedCurrency;
    }

	@JsonProperty("language")
    public String getLanguage ()
    {
        return language;
    }

	@JsonProperty("language")
    public void setLanguage (String language)
    {
        this.language = language;
    }

	@JsonProperty("currency")
    public String getCurrency ()
    {
        return currency;
    }

	@JsonProperty("currency")
    public void setCurrency (String currency)
    {
        this.currency = currency;
    }

    @Override
    public String toString()
    {
        return "[siteID = "+siteID+", userSelectedCurrency = "+userSelectedCurrency+", language = "+language+", currency = "+currency+"]";
    }
}