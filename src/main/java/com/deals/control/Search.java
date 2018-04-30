package main.java.com.deals.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.com.deals.beans.Destination;
import main.java.com.deals.beans.Hotel;
import main.java.com.deals.beans.HotelInfo;
import main.java.com.deals.beans.HotelsInfoProject;
import main.java.com.deals.beans.OfferDateRange;
import main.java.com.deals.beans.Offers;


@WebServlet("/search")
public class Search extends HttpServlet {

	protected void doGet(final HttpServletRequest req, final HttpServletResponse resp)
			throws ServletException, IOException {

		HotelsInfoProject hotelsInfoBean = MainPage.getHotelsInfoBean();

		HotelsInfoProject filteredResult = FilterResult(req, hotelsInfoBean);

		req.setAttribute("hotelsInfoBean", filteredResult);
		req.getRequestDispatcher("HotelsPage.jsp").forward(req, resp);

	}

	/**
	 * Filter the results
	 * @param req
	 * @param hotelsInfoBean
	 * @return
	 */
	private HotelsInfoProject FilterResult(HttpServletRequest req, HotelsInfoProject hotelsInfoBean) {

		String destination = req.getParameter("destination");
		String sDate = req.getParameter("sDate");
		String eDate = req.getParameter("eDate");
		String lengthOfStay = req.getParameter("lengthOfStay");

		String minStarRating = req.getParameter("minStarRating");
		String maxStarRating = req.getParameter("maxStarRating");

		String minGuestRating = req.getParameter("minGuestRating");
		String maxGuestRating = req.getParameter("maxGuestRating");

		Hotel[] hotels = hotelsInfoBean.getOffers().getHotel();
		Hotel [] filteredHotels = new Hotel[hotels.length];
		int j=0;
		
		for (int i = 0; i < hotels.length; i++) {

			Hotel hotel = hotels[i];
			if (!isBeanContainsDestinationCondition(hotel, destination)) {
				continue;
			}
			if (!isBeanContainsStartDateCondition(hotel, sDate)) {
				continue;
			}
			if (!isBeanContainsEndDateCondition(hotel, eDate)) {
				continue;
			}
			if (!isBeanContainsLengthOfStayCondition(hotel, lengthOfStay)) {
				continue;
			}
			if (!isBeanContainsMinStarRatingCondition(hotel, minStarRating)) {
				continue;
			}
			if (!isBeanContainsMaxStarRatingCondition(hotel, maxStarRating)) {
				continue;
			}
			if (!isBeanContainsMinGuestRatingCondition(hotel, minGuestRating)) {
				continue;
			}
			if (!isBeanContainsMaxGuestRatingCondition(hotel, maxGuestRating)) {
				continue;
			}
			
			filteredHotels[j++] = hotel;

		}
		Offers offers = new Offers();
		offers.setHotel(filteredHotels);
		
		HotelsInfoProject filteredHotelsInfo = new HotelsInfoProject();
		filteredHotelsInfo.setOffers(offers);
		return filteredHotelsInfo;
	}

	
	/**
	 * 
	 * @param hotel
	 * @param maxGuestRating
	 * @return
	 */
	private boolean isBeanContainsMaxGuestRatingCondition(Hotel hotel, String maxGuestRating) {

		if (isEmpty(maxGuestRating)) {
			return true;
		}
		Double maxGuestReviewRatingInteger = Double.valueOf(maxGuestRating);
		Double hotelGuestReviewRating = Double.valueOf(hotel.getHotelInfo().getHotelGuestReviewRating());
		if(maxGuestReviewRatingInteger >= hotelGuestReviewRating){
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @param hotel
	 * @param minGuestRating
	 * @return
	 */
	private boolean isBeanContainsMinGuestRatingCondition(Hotel hotel, String minGuestRating) {

		if (isEmpty(minGuestRating)) {
			return true;
		}
		Double minGuestReviewRatingInteger = Double.valueOf(minGuestRating);
		Double hotelGuestReviewRating = Double.valueOf(hotel.getHotelInfo().getHotelGuestReviewRating());
		if(minGuestReviewRatingInteger <= hotelGuestReviewRating){
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @param hotel
	 * @param maxStarRating
	 * @return
	 */
	private boolean isBeanContainsMaxStarRatingCondition(Hotel hotel, String maxStarRating) {

		if (isEmpty(maxStarRating)) {
			return true;
		}
		Double maxStarRatingInteger = Double.valueOf(maxStarRating);
		Double hotelStarRating = Double.valueOf(hotel.getHotelInfo().getHotelStarRating());
		if(maxStarRatingInteger >= hotelStarRating){
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @param hotel
	 * @param minStarRating
	 * @return
	 */
	private boolean isBeanContainsMinStarRatingCondition(Hotel hotel, String minStarRating) {

		if (isEmpty(minStarRating)) {
			return true;
		}
		Double minStarRatingInteger = Double.valueOf(minStarRating);
		Double hotelStarRating = Double.valueOf(hotel.getHotelInfo().getHotelStarRating());
		if(minStarRatingInteger <= hotelStarRating){
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @param hotel
	 * @param lengthOfStay
	 * @return
	 */
	private boolean isBeanContainsLengthOfStayCondition(Hotel hotel, String lengthOfStay) {

		if (isEmpty(lengthOfStay)) {
			return true;
		}
		
		if(lengthOfStay.equals(hotel.getOfferDateRange().getLengthOfStay())){
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @param hotel
	 * @param eDate
	 * @return
	 */
	private boolean isBeanContainsEndDateCondition(Hotel hotel, String eDate) {
		
		if (isEmpty(eDate)) {
			return true;
		}
		OfferDateRange offerDateRangeBean = hotel.getOfferDateRange();
		if (offerDateRangeBean == null) {
			return false;
		}
		String[] travelEndDateBean = offerDateRangeBean.getTravelEndDate();
		String[] endDateArray = eDate.split("-");
		
		for(int i=0; i<travelEndDateBean.length; i++){
			
			if(isEmpty(endDateArray[i])){
				continue;
			}
			if(!Integer.valueOf(endDateArray[i]).equals(Integer.valueOf(travelEndDateBean[i]))){
				return false;
			}
		}
		return true;
	}

	/**
	 * 
	 * @param hotel
	 * @param sDate
	 * @return
	 */
	private boolean isBeanContainsStartDateCondition(Hotel hotel, String sDate) {
		
		if (isEmpty(sDate)) {
			return true;
		}
		OfferDateRange offerDateRangeBean = hotel.getOfferDateRange();
		if (offerDateRangeBean == null) {
			return false;
		}
		String[] travelStartDateBean = offerDateRangeBean.getTravelStartDate();
		String[] startDateArray = sDate.split("-");
		
		for(int i=0; i<travelStartDateBean.length; i++){
			
			if(isEmpty(startDateArray[i])){
				continue;
			}
			if(!Integer.valueOf(startDateArray[i]).equals(Integer.valueOf(travelStartDateBean[i]))){
				return false;
			}
		}
		return true;
	}

	/**
	 * 
	 * @param hotel
	 * @param destination
	 * @return
	 */
	private boolean isBeanContainsDestinationCondition(Hotel hotel, String destination) {

		if (isEmpty(destination)) {
			return true;
		}
		Destination destinationBean = hotel.getDestination();
		HotelInfo hotelInfo = hotel.getHotelInfo();
		if (destinationBean == null) {
			return false;
		}
		if (destination.equals(destinationBean.getRegionID()) || destination.equals(destinationBean.getCity())
				|| destination.equals(destinationBean.getCountry()) || destination.equals(hotelInfo.getHotelId())
				|| destination.equals(hotelInfo.getHotelName())) {
			return true;
		}
		return false;
	}

	protected void doPost(final HttpServletRequest req, final HttpServletResponse resp)
			throws ServletException, IOException {

	}

	/**
	 * checks if the String is Empty.
	 * @param value
	 * @return
	 */
	public static boolean isEmpty(String value) {
		return (value == null || value.trim().length() == 0);
	}

}

