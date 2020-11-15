package com.gigamog.RsvpApp.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;

import javax.validation.constraints.Email;

@Getter
@Setter
public class Guest {
    @NonNull
    @Email
    private String email;
}
