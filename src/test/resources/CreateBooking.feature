Feature: Kullanici olarak otel rezervasyonu olusturabilirim

  Scenario: User can be hotel booking and deleting booking
    Given User creates new reservation
    And   User gives a new token for reservation
    When  User make a hotel reservation
    Then  Reservation completed success
    And   User cancels created reservation