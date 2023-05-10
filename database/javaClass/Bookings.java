package io.bootify.my_app.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Set;


@Entity
public class Bookings {

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
    private Integer bookingId;

    @Column(nullable = false)
    private OffsetDateTime bookingStartTime;

    @Column(nullable = false)
    private OffsetDateTime bookingEndTime;

    @Column
    private Integer bookingDuration;

    @Column(length = 10)
    private String bookingStatus;

    @Column(precision = 12, scale = 2)
    private BigDecimal paymentAmount;

    @Column(length = 9)
    private String paymentStatus;

    @Column
    private OffsetDateTime createdAt;

    @Column
    private OffsetDateTime updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "slot_id", nullable = false)
    private ParkingSlots slot;

    @OneToMany(mappedBy = "booking")
    private Set<Payments> bookingPaymentss;

    public Integer getBookingId() {
        return bookingId;
    }

    public void setBookingId(final Integer bookingId) {
        this.bookingId = bookingId;
    }

    public OffsetDateTime getBookingStartTime() {
        return bookingStartTime;
    }

    public void setBookingStartTime(final OffsetDateTime bookingStartTime) {
        this.bookingStartTime = bookingStartTime;
    }

    public OffsetDateTime getBookingEndTime() {
        return bookingEndTime;
    }

    public void setBookingEndTime(final OffsetDateTime bookingEndTime) {
        this.bookingEndTime = bookingEndTime;
    }

    public Integer getBookingDuration() {
        return bookingDuration;
    }

    public void setBookingDuration(final Integer bookingDuration) {
        this.bookingDuration = bookingDuration;
    }

    public String getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(final String bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public BigDecimal getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(final BigDecimal paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(final String paymentStatus) {
        this.paymentStatus = paymentStatus;
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

    public Users getUser() {
        return user;
    }

    public void setUser(final Users user) {
        this.user = user;
    }

    public ParkingSlots getSlot() {
        return slot;
    }

    public void setSlot(final ParkingSlots slot) {
        this.slot = slot;
    }

    public Set<Payments> getBookingPaymentss() {
        return bookingPaymentss;
    }

    public void setBookingPaymentss(final Set<Payments> bookingPaymentss) {
        this.bookingPaymentss = bookingPaymentss;
    }

}
