package io.bootify.my_app.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Set;


@Entity
public class Users {

    @Id
    @Column(nullable = false, updatable = false)
    @SequenceGenerator(
            name = "primary_sequence",
            sequenceName = "primary_sequence",
            allocationSize = 1,
            initialValue = 10000
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "primary_sequence"
    )
    private Integer userId;

    @Column(nullable = false, length = 15)
    private String mobileNumber;

    @Column(nullable = false)
    private String passwordHash;

    @Column(nullable = false)
    private String passwordSalt;

    @Column(length = 50)
    private String firstName;

    @Column(length = 50)
    private String lastName;

    @Column
    private String email;

    @Column(length = 6)
    private String gender;

    @Column
    private LocalDate dateOfBirth;

    @Column
    private OffsetDateTime createdAt;

    @Column
    private OffsetDateTime updatedAt;

    @OneToMany(mappedBy = "user")
    private Set<Vehicles> userVehicless;

    @OneToMany(mappedBy = "user")
    private Set<Bookings> userBookingss;

    @OneToMany(mappedBy = "user")
    private Set<Ratings> userRatingss;

    @OneToMany(mappedBy = "user")
    private Set<Reviews> userReviewss;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(final Integer userId) {
        this.userId = userId;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(final String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(final String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getPasswordSalt() {
        return passwordSalt;
    }

    public void setPasswordSalt(final String passwordSalt) {
        this.passwordSalt = passwordSalt;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(final String gender) {
        this.gender = gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(final LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(final OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public OffsetDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(final OffsetDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Set<Vehicles> getUserVehicless() {
        return userVehicless;
    }

    public void setUserVehicless(final Set<Vehicles> userVehicless) {
        this.userVehicless = userVehicless;
    }

    public Set<Bookings> getUserBookingss() {
        return userBookingss;
    }

    public void setUserBookingss(final Set<Bookings> userBookingss) {
        this.userBookingss = userBookingss;
    }

    public Set<Ratings> getUserRatingss() {
        return userRatingss;
    }

    public void setUserRatingss(final Set<Ratings> userRatingss) {
        this.userRatingss = userRatingss;
    }

    public Set<Reviews> getUserReviewss() {
        return userReviewss;
    }

    public void setUserReviewss(final Set<Reviews> userReviewss) {
        this.userReviewss = userReviewss;
    }

}
