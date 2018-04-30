package main.java.com.deals.beans;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HotelsInfoProject {
	
	@JsonProperty("offers")
    private Offers offers;

	@JsonProperty("offerInfo")
    private OfferInfo offerInfo;

	@JsonProperty("userInfo")
    private UserInfo userInfo;

	
	@JsonProperty("offers")
    public Offers getOffers ()
    {
        return offers;
    }

	@JsonProperty("offers")
    public void setOffers (Offers offers)
    {
        this.offers = offers;
    }

	@JsonProperty("offerInfo")
    public OfferInfo getOfferInfo ()
    {
        return offerInfo;
    }

	@JsonProperty("offerInfo")
    public void setOfferInfo (OfferInfo offerInfo)
    {
        this.offerInfo = offerInfo;
    }

	@JsonProperty("userInfo")
    public UserInfo getUserInfo ()
    {
        return userInfo;
    }

	@JsonProperty("userInfo")
    public void setUserInfo (UserInfo userInfo)
    {
        this.userInfo = userInfo;
    }

    @Override
    public String toString()
    {
        return "[offers = "+offers+", offerInfo = "+offerInfo+", userInfo = "+userInfo+"]";
    }
}