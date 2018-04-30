<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>
<%@page import="java.util.*"%>
<%@page import="main.java.com.deals.beans.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1256">
<link rel="stylesheet" href="HotelStyles.css" type="text/css">
<title>Hotel deals</title>


</head>
<body bgcolor="#edf7ee">

	<h2>Hotel deals</h2>

	<button onclick="document.getElementById('id01').style.display='block'"
		style="width: auto;">Search</button>
		
		
<table class=hotels>
	<col width="20%">
	<col width="70%">
	<col width="10%">
<% 
HotelsInfoProject hotelsInfoBean = (HotelsInfoProject) request.getAttribute("hotelsInfoBean");
Offers offer= hotelsInfoBean.getOffers();
Hotel[] hotels = offer.getHotel();
for(int i = 0; i < hotels.length; i++){
	Hotel hotel = hotels[i];
	if(hotel == null){
		continue;
	}
	
	HotelInfo hotelInfo = hotel.getHotelInfo();
	Destination destination = hotel.getDestination();
	HotelPricingInfo hotelPricingInfo = hotel.getHotelPricingInfo();
	HotelUrls hotelUrls = hotel.getHotelUrls();
	String decoded = java.net.URLDecoder.decode(hotelInfo.getHotelImageUrl(), "UTF-8");

%> 
	<tr>
     <td >
       <a href="<%=java.net.URLDecoder.decode(hotelUrls.getHotelInfositeUrl(),"UTF-8")%>"> <img src="<%=java.net.URLDecoder.decode(hotelInfo.getHotelImageUrl(), "UTF-8")%>" style="width:100px;height:100px;border:0">
       </a>
        
      
      </td>
      <td >
      <a href="<%=java.net.URLDecoder.decode(hotelUrls.getHotelInfositeUrl(),"UTF-8")%>" target="_blank"> <%= hotelInfo.getHotelName()  %>
      </a> 
        <h4> <%= destination.getLongName()  %> </h4>
        <p> Hotel Star Rating : <%= hotelInfo.getHotelStarRating() %> </p>
        <p> Hotel Review Total : <%= hotelInfo.getHotelReviewTotal() %> </p>
      </td>
      
      <td >
		    <h4><%=hotelPricingInfo.getAveragePriceValue() +" "+ hotelPricingInfo.getCurrency()%> </h4>  
      </td>
    </tr>
		
<%
}
%>
</table>

	<div id="id01" class="modal">

		<form class="modal-content animate" action="search"">
			<div class="imgcontainer">
				<span onclick="document.getElementById('id01').style.display='none'"
					class="close" title="Close Modal">&times;</span> <img
					src="hotels.jpg" alt="Avatar" class="avatar">
			</div>

			<div class="container">
				<table>
					<tr>
						<td><label for="destination"><b>Destination</b></label></td>
					</tr>
					<tr>
						<td><input type="text"
							placeholder="City, hotel name or address" name="destination">
						</td>
					</tr>
					<tr>
						<td><label for="sDate"><b>Start Date</b></label></td>
						<td><label for="eDate"><b>End Date</b></label></td>
						<td><label for="lengthOfStay"><b>Length of Stay</b></label></td>
					</tr>

					<tr>
						<td><input type="date" placeholder="Start date" name="sDate"> </td>
						<td><input type="date" placeholder="End date" name="eDate"> </td>
						<td><input type="number" placeholder="1,2, ..." name="lengthOfStay"></td>
					</tr>

				</table>
			</div>

			<div class="container">
				<table>

					<tr>
						<td><label for="minStarRating"><b>Min Star Rating</b></label> </td>
						<td><label for="maxStarRating"><b>Max Star Rating</b></label> </td>

					</tr>
					<tr>
						<td><input type="text2" placeholder="min star rating" name="minStarRating"></td>
						<td><input type="text2" placeholder="max star rating" name="maxStarRating"></td>
					</tr>

					<tr>
						<td><label for="minGuestRating"><b>Min Guest Rating</b></label></td>
						<td><label for="maxGuestRating"><b>Max Guest Rating</b></label></td>

					</tr>
					<tr>
						<td><input type="text2" placeholder="min guest rating" name="minGuestRating"></td>
						<td><input type="text2" placeholder="min star rating" name="maxGuestRating"></td>
					</tr>



				</table>
					<button type="submit">Search</button>
				
			</div>

			<div class="container" style="background-color: #f1f1f1">
				<button type="button" onclick="document.getElementById('id01').style.display='none'" class="cancelbtn">Cancel</button>
			</div>
		</form>
	</div>

	<script>
// Get the modal
var modal = document.getElementById('id01');

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}
</script>

</body>
</html>