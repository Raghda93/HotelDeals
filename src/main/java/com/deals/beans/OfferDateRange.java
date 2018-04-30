package main.java.com.deals.beans;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OfferDateRange
{
	@JsonProperty("travelEndDate")
    private String[] travelEndDate;
	@JsonProperty("lengthOfStay")
    private String lengthOfStay;
	@JsonProperty("travelStartDate")
    private String[] travelStartDate;

	@JsonProperty("travelEndDate")
    public String[] getTravelEndDate ()
    {
        return travelEndDate;
    }

	@JsonProperty("travelEndDate")
    public void setTravelEndDate (String[] travelEndDate)
    {
        this.travelEndDate = travelEndDate;
    }

	@JsonProperty("lengthOfStay")
    public String getLengthOfStay ()
    {
        return lengthOfStay;
    }

	@JsonProperty("lengthOfStay")
    public void setLengthOfStay (String lengthOfStay)
    {
        this.lengthOfStay = lengthOfStay;
    }

	@JsonProperty("travelStartDate")
    public String[] getTravelStartDate ()
    {
        return travelStartDate;
    }

	@JsonProperty("travelStartDate")
    public void setTravelStartDate (String[] travelStartDate)
    {
        this.travelStartDate = travelStartDate;
    }

    @Override
    public String toString()
    {
        return "[travelEndDate = "+travelEndDate+", lengthOfStay = "+lengthOfStay+", travelStartDate = "+travelStartDate+"]";
    }
}
			
			
