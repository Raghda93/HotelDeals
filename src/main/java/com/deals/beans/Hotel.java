package main.java.com.deals.beans;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Hotel
{
	@JsonProperty("offerDateRange")
    private OfferDateRange offerDateRange;
	@JsonProperty("hotelUrls")
    private HotelUrls hotelUrls;
	@JsonProperty("hotelInfo")
    private HotelInfo hotelInfo;
	@JsonProperty("hotelPricingInfo")
    private HotelPricingInfo hotelPricingInfo;
	@JsonProperty("destination")
    private Destination destination;

	@JsonProperty("offerDateRange")
    public OfferDateRange getOfferDateRange ()
    {
        return offerDateRange;
    }

	@JsonProperty("offerDateRange")
    public void setOfferDateRange (OfferDateRange offerDateRange)
    {
        this.offerDateRange = offerDateRange;
    }

	@JsonProperty("hotelUrls")
    public HotelUrls getHotelUrls ()
    {
        return hotelUrls;
    }

	@JsonProperty("hotelUrls")
    public void setHotelUrls (HotelUrls hotelUrls)
    {
        this.hotelUrls = hotelUrls;
    }

	@JsonProperty("hotelInfo")
    public HotelInfo getHotelInfo ()
    {
        return hotelInfo;
    }

	@JsonProperty("hotelInfo")
    public void setHotelInfo (HotelInfo hotelInfo)
    {
        this.hotelInfo = hotelInfo;
    }

	@JsonProperty("hotelPricingInfo")
    public HotelPricingInfo getHotelPricingInfo ()
    {
        return hotelPricingInfo;
    }

	@JsonProperty("hotelPricingInfo")
    public void setHotelPricingInfo (HotelPricingInfo hotelPricingInfo)
    {
        this.hotelPricingInfo = hotelPricingInfo;
    }

	@JsonProperty("destination")
    public Destination getDestination ()
    {
        return destination;
    }

	@JsonProperty("destination")
    public void setDestination (Destination destination)
    {
        this.destination = destination;
    }

    @Override
    public String toString()
    {
        return "[offerDateRange = "+offerDateRange+", hotelUrls = "+hotelUrls+", hotelInfo = "+hotelInfo+", hotelPricingInfo = "+hotelPricingInfo+", destination = "+destination+"]";
    }
}
			
			
