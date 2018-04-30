package main.java.com.deals.beans;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Offers
{
	@JsonProperty("Hotel")
    private Hotel[] Hotel;

	@JsonProperty("Hotel")
    public Hotel[] getHotel ()
    {
        return Hotel;
    }

	@JsonProperty("Hotel")
    public void setHotel (Hotel[] Hotel)
    {
        this.Hotel = Hotel;
    }

    @Override
    public String toString()
    {
        return "[Hotel = "+Hotel+"]";
    }
}