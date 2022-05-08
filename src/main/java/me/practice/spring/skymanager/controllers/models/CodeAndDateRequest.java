package me.practice.spring.skymanager.controllers.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CodeAndDateRequest extends DateRequest {
    @NotEmpty
    private String code;
}
