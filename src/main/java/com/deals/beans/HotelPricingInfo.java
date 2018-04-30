package main.java.com.deals.beans;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HotelPricingInfo {
	@JsonProperty("totalPriceValue")
    private String totalPriceValue;

	@JsonProperty("averagePriceValue")
    private String averagePriceValue;

	@JsonProperty("originalPricePerNight")
    private String originalPricePerNight;

	@JsonProperty("drr")
    private String drr;

	@JsonProperty("percentSavings")
    private String percentSavings;

	@JsonProperty("currency")
    private String currency;

	@JsonProperty("crossOutPriceValue")
    private String crossOutPriceValue;

	
	@JsonProperty("totalPriceValue")
    public String getTotalPriceValue ()
    {
        return totalPriceValue;
    }

	@JsonProperty("totalPriceValue")
    public void setTotalPriceValue (String totalPriceValue)
    {
        this.totalPriceValue = totalPriceValue;
    }

	@JsonProperty("averagePriceValue")
    public String getAveragePriceValue ()
    {
        return averagePriceValue;
    }

	@JsonProperty("averagePriceValue")
    public void setAveragePriceValue (String averagePriceValue)
    {
        this.averagePriceValue = averagePriceValue;
    }

	@JsonProperty("originalPricePerNight")
    public String getOriginalPricePerNight ()
    {
        return originalPricePerNight;
    }

	@JsonProperty("originalPricePerNight")
    public void setOriginalPricePerNight (String originalPricePerNight)
    {
        this.originalPricePerNight = originalPricePerNight;
    }

	@JsonProperty("drr")
    public String getDrr ()
    {
        return drr;
    }

	@JsonProperty("drr")
    public void setDrr (String drr)
    {
        this.drr = drr;
    }

	@JsonProperty("percentSavings")
    public String getPercentSavings ()
    {
        return percentSavings;
    }

	@JsonProperty("percentSavings")
    public void setPercentSavings (String percentSavings)
    {
        this.percentSavings = percentSavings;
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

	@JsonProperty("crossOutPriceValue")
    public String getCrossOutPriceValue ()
    {
        return crossOutPriceValue;
    }

	@JsonProperty("crossOutPriceValue")
    public void setCrossOutPriceValue (String crossOutPriceValue)
    {
        this.crossOutPriceValue = crossOutPriceValue;
    }

    @Override
    public String toString()
    {
        return "[totalPriceValue = "+totalPriceValue+", averagePriceValue = "+averagePriceValue+", originalPricePerNight = "+originalPricePerNight+", drr = "+drr+", percentSavings = "+percentSavings+", currency = "+currency+", crossOutPriceValue = "+crossOutPriceValue+"]";
    }
}
			
			