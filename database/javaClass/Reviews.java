package io.bootify.my_app.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import java.time.OffsetDateTime;


@Entity
public class Reviews {

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
    private Integer reviewId;

    @Column(nullable = false)
    private Integer ratingScore;

    @Column
    private String reviewComment;

    @Column
    private OffsetDateTime createdAt;

    @Column
    private OffsetDateTime updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "center_id", nullable = false)
    private ParkingCenters center;

    public Integer getReviewId() {
        return reviewId;
    }

    public void setReviewId(final Integer reviewId) {
        this.reviewId = reviewId;
    }

    public Integer getRatingScore() {
        return ratingScore;
    }

    public void setRatingScore(final Integer ratingScore) {
        this.ratingScore = ratingScore;
    }

    public String getReviewComment() {
        return reviewComment;
    }

    public void setReviewComment(final String reviewComment) {
        this.reviewComment = reviewComment;
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

    public ParkingCenters getCenter() {
        return center;
    }

    public void setCenter(final ParkingCenters center) {
        this.center = center;
    }

}
