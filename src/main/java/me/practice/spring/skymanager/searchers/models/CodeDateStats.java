package me.practice.spring.skymanager.searchers.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CodeDateStats {
    private long arrivalCount;
    private long departureCount;
    private long departurePieces;
    private long arrivalPieces;

    public CodeDateStats(Object object){
        Object[] result = (Object[]) object;
        arrivalCount = ((BigInteger)result[0]).longValue();
        departureCount = ((BigInteger)result[1]).longValue();
        departurePieces = ((BigInteger)result[2]).longValue();
        arrivalPieces = ((BigInteger)result[3]).longValue();
    }
}
