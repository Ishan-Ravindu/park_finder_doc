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
import java.time.OffsetDateTime;
import java.util.Set;


@Entity
public class ParkingSlots {

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
    private Integer slotId;

    @Column(nullable = false)
    private Integer slotNumber;

    @Column(length = 7)
    private String slotSize;

    @Column(length = 9)
    private String slotType;

    @Column(length = 9)
    private String slotAvailability;

    @Column
    private OffsetDateTime createdAt;

    @Column
    private OffsetDateTime updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "center_id", nullable = false)
    private ParkingCenters center;

    @OneToMany(mappedBy = "slot")
    private Set<Bookings> slotBookingss;

    public Integer getSlotId() {
        return slotId;
    }

    public void setSlotId(final Integer slotId) {
        this.slotId = slotId;
    }

    public Integer getSlotNumber() {
        return slotNumber;
    }

    public void setSlotNumber(final Integer slotNumber) {
        this.slotNumber = slotNumber;
    }

    public String getSlotSize() {
        return slotSize;
    }

    public void setSlotSize(final String slotSize) {
        this.slotSize = slotSize;
    }

    public String getSlotType() {
        return slotType;
    }

    public void setSlotType(final String slotType) {
        this.slotType = slotType;
    }

    public String getSlotAvailability() {
        return slotAvailability;
    }

    public void setSlotAvailability(final String slotAvailability) {
        this.slotAvailability = slotAvailability;
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

    public ParkingCenters getCenter() {
        return center;
    }

    public void setCenter(final ParkingCenters center) {
        this.center = center;
    }

    public Set<Bookings> getSlotBookingss() {
        return slotBookingss;
    }

    public void setSlotBookingss(final Set<Bookings> slotBookingss) {
        this.slotBookingss = slotBookingss;
    }

}
