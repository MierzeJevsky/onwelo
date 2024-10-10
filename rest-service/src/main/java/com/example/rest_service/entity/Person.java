package com.example.rest_service.entity;

import java.io.Serializable;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @NotNull
    String name;

    @NotNull
    PersonEnum personEnum;

    @Builder.Default
    @NotNull
    Boolean voted = false;

    Integer votes;

    public void addVote() {
        this.votes = votes++;
    }
}
