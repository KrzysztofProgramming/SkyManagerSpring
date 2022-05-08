package me.practice.spring.skymanager.controllers.models;

import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DateRequest {
    @NotNull
    private Date startDate;
    @NotNull
    private Date endDate;
}
