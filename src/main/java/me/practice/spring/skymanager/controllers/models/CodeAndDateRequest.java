package me.practice.spring.skymanager.controllers.models;

import lombok.*;

import javax.validation.constraints.NotEmpty;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class CodeAndDateRequest extends DateRequest {
    @NotEmpty
    private String code;
}
