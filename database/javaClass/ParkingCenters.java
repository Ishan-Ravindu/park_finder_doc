package io.bootify.my_app.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Set;


@Entity
public class ParkingCenters {

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
    private Integer centerId;

    @Column(nullable = false, length = 100)
    private String centerName;

    @Column(nullable = false)
    private String centerAddress;

    @Column(nullable = false, length = 100)
    private String centerCity;

    @Column(nullable = false, length = 100)
    private String centerState;

    @Column(nullable = false, length = 100)
    private String centerCountry;

    @Column(nullable = false, length = 20)
    private String centerPostalCode;

    @Column(precision = 18, scale = 8)
    private BigDecimal centerLatitude;

    @Column(precision = 19, scale = 8)
    private BigDecimal centerLongitude;

    @Column
    private String centerImage;

    @Column
    private OffsetDateTime createdAt;

    @Column
    private OffsetDateTime updatedAt;

    @OneToMany(mappedBy = "center")
    private Set<ParkingSlots> centerParkingSlotss;

    @OneToMany(mappedBy = "center")
    private Set<Ratings> centerRatingss;

    @OneToMany(mappedBy = "center")
    private Set<Reviews> centerReviewss;

    public Integer getCenterId() {
        return centerId;
    }

    public void setCenterId(final Integer centerId) {
        this.centerId = centerId;
    }

    public String getCenterName() {
        return centerName;
    }

    public void setCenterName(final String centerName) {
        this.centerName = centerName;
    }

    public String getCenterAddress() {
        return centerAddress;
    }

    public void setCenterAddress(final String centerAddress) {
        this.centerAddress = centerAddress;
    }

    public String getCenterCity() {
        return centerCity;
    }

    public void setCenterCity(final String centerCity) {
        this.centerCity = centerCity;
    }

    public String getCenterState() {
        return centerState;
    }

    public void setCenterState(final String centerState) {
        this.centerState = centerState;
    }

    public String getCenterCountry() {
        return centerCountry;
    }

    public void setCenterCountry(final String centerCountry) {
        this.centerCountry = centerCountry;
    }

    public String getCenterPostalCode() {
        return centerPostalCode;
    }

    public void setCenterPostalCode(final String centerPostalCode) {
        this.centerPostalCode = centerPostalCode;
    }

    public BigDecimal getCenterLatitude() {
        return centerLatitude;
    }

    public void setCenterLatitude(final BigDecimal centerLatitude) {
        this.centerLatitude = centerLatitude;
    }

    public BigDecimal getCenterLongitude() {
        return centerLongitude;
    }

    public void setCenterLongitude(final BigDecimal centerLongitude) {
        this.centerLongitude = centerLongitude;
    }

    public String getCenterImage() {
        return centerImage;
    }

    public void setCenterImage(final String centerImage) {
        this.centerImage = centerImage;
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

    public Set<ParkingSlots> getCenterParkingSlotss() {
        return centerParkingSlotss;
    }

    public void setCenterParkingSlotss(final Set<ParkingSlots> centerParkingSlotss) {
        this.centerParkingSlotss = centerParkingSlotss;
    }

    public Set<Ratings> getCenterRatingss() {
        return centerRatingss;
    }

    public void setCenterRatingss(final Set<Ratings> centerRatingss) {
        this.centerRatingss = centerRatingss;
    }

    public Set<Reviews> getCenterReviewss() {
        return centerReviewss;
    }

    public void setCenterReviewss(final Set<Reviews> centerReviewss) {
        this.centerReviewss = centerReviewss;
    }

}
