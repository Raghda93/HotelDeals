package main.java.com.deals.beans;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserInfo
{
	@JsonProperty("userId")
    private String userId;
	@JsonProperty("persona")
    private Persona persona;

	@JsonProperty("userId")
    public String getUserId ()
    {
        return userId;
    }

	@JsonProperty("userId")
    public void setUserId (String userId)
    {
        this.userId = userId;
    }

	@JsonProperty("persona")
    public Persona getPersona ()
    {
        return persona;
    }

	@JsonProperty("persona")
    public void setPersona (Persona persona)
    {
        this.persona = persona;
    }

    @Override
    public String toString()
    {
        return "[userId = "+userId+", persona = "+persona+"]";
    }
}
