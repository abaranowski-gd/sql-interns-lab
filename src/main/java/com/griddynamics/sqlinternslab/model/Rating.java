package com.griddynamics.sqlinternslab.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "RATING")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rating {

    @EmbeddedId
    private Id id;

    @Column(name = "ratingDate")
    private LocalDate ratingDate;

    @Embeddable
    @NoArgsConstructor
    @Data
    public static class Id implements Serializable {
        private static final long serialVersionUID = 1L;

        @Column(name = "mId")
        private Long mId;

        @Column(name = "rId")
        private Long rId;

        @Column(name = "stars")
        private int stars;
    }
}
