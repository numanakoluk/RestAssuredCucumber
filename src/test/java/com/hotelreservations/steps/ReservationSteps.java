package com.hotelreservations.steps;

import com.hotelreservations.models.BookingResponse;
import com.hotelreservations.services.ReservationService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class ReservationSteps {

    ReservationService reservationService;
    String authKey;
    BookingResponse bookingResponse;

    @Given("User creates new reservation")
    public void cagriBaslangici() {
        reservationService = new ReservationService();
    }

    @Given("User gives a new token for reservation")
    public void createAuth() {
        authKey = reservationService.generateToken();
    }

    @When("User make a hotel reservation")
    public void createReservation() {
        bookingResponse = reservationService.createBooking();
    }

    @Then("Reservation completed success")
    public void reservationAssertions() {
        Assertions.assertEquals("Numan", bookingResponse.getBooking().getFirstname());
        Assertions.assertEquals("Akoluk", bookingResponse.getBooking().getLastname());
        Assertions.assertEquals(1000, bookingResponse.getBooking().getTotalprice());
        Assertions.assertFalse(bookingResponse.getBooking().isDepositpaid());
        Assertions.assertEquals("Kayak Merkezi", bookingResponse.getBooking().getAdditionalneeds());
    }

    @Then("User cancels created reservation")
    public void cancelReservation() {
        reservationService.deleteReservation(authKey, bookingResponse.getBookingid());
    }
}
