package main.java.com.deals.beans;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HotelUrls
{
	@JsonProperty("hotelSearchResultUrl")
    private String hotelSearchResultUrl;
	@JsonProperty("hotelInfositeUrl")
    private String hotelInfositeUrl;

	@JsonProperty("hotelSearchResultUrl")
    public String getHotelSearchResultUrl ()
    {
        return hotelSearchResultUrl;
    }

	@JsonProperty("hotelSearchResultUrl")
    public void setHotelSearchResultUrl (String hotelSearchResultUrl)
    {
        this.hotelSearchResultUrl = hotelSearchResultUrl;
    }

	@JsonProperty("hotelInfositeUrl")
    public String getHotelInfositeUrl ()
    {
        return hotelInfositeUrl;
    }

	@JsonProperty("hotelInfositeUrl")
    public void setHotelInfositeUrl (String hotelInfositeUrl)
    {
        this.hotelInfositeUrl = hotelInfositeUrl;
    }

    @Override
    public String toString()
    {
        return "[hotelSearchResultUrl = "+hotelSearchResultUrl+", hotelInfositeUrl = "+hotelInfositeUrl+"]";
    }
}
			
