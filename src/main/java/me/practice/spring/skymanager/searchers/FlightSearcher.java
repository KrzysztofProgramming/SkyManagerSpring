package me.practice.spring.skymanager.searchers;

import me.practice.spring.skymanager.searchers.models.CodeDateStats;
import me.practice.spring.skymanager.searchers.models.NumberDateStats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@Component
public class FlightSearcher {

    @Autowired
    private EntityManager entityManager;

    private final String CODE_DATE_QUERY = "WITH DAY_FLIGHTS AS " +
            " (SELECT *  " +
            "  FROM FLIGHT_TABLE F  " +
            "  WHERE F.DEPARTURE_DATE >= :dateStart  " +
            "   AND F.DEPARTURE_DATE < :dateEnd)  " +
            "SELECT  " +
            " (SELECT COUNT(*)  " +
            "  FROM DAY_FLIGHTS F  " +
            "  WHERE F.ARRIVAL_IATA_CODE = :code) AS ARRIVAL_COUNT,  " +
            "  " +
            " (SELECT COUNT(*)  " +
            "  FROM DAY_FLIGHTS F  " +
            "  WHERE F.DEPARTURE_IATA_CODE = :code) AS DEPARTURE_COUNT,  " +
            "  " +
            " (SELECT COALESCE(SUM(B.PIECES), 0)  " +
            "  FROM DAY_FLIGHTS F  " +
            "  LEFT JOIN BAGGAGE_TABLE B ON B.FLIGHT_ID = F.FLIGHT_ID  " +
            "  WHERE F.DEPARTURE_IATA_CODE = :code) AS DEPARTURE_PIECES,  " +
            "  " +
            " (SELECT COALESCE(SUM(B.PIECES), 0)  " +
            "  FROM DAY_FLIGHTS F  " +
            "  LEFT JOIN BAGGAGE_TABLE B ON B.FLIGHT_ID = F.FLIGHT_ID  " +
            "  WHERE F.ARRIVAL_IATA_CODE = :code) AS ARRIVAL_PIECES";

    private final String NUMBER_DATE_QUERY = "WITH DAY_FLIGHTS AS " +
            " (SELECT * " +
            "  FROM FLIGHT_TABLE F " +
            "  WHERE F.DEPARTURE_DATE >= :dateStart " +
            "   AND F.DEPARTURE_DATE < :dateEnd) " +
            "SELECT (SELECT COALESCE(SUM(b.weight), 0) FROM day_flights f " +
            "  LEFT JOIN baggage_table b ON b.flight_id = f.flight_id " +
            "  WHERE f.flight_number = :number) as baggage_weight, " +
            "  (SELECT COALESCE(SUM(c.weight), 0) FROM day_flights f " +
            "  LEFT JOIN cargo_table c ON c.flight_id = f.flight_id " +
            "  WHERE f.flight_number = :number) as cargo_weight";

    @Transactional
    public NumberDateStats statsByDateAndNumber(Date startDate, Date endDate, Long number){
        Query query = this.entityManager.createNativeQuery(this.NUMBER_DATE_QUERY);
        query.setParameter("dateStart", startDate);
        query.setParameter("dateEnd", endDate);
        query.setParameter("number", number);
        return new NumberDateStats(query.getSingleResult());
    }

    @Transactional
    public CodeDateStats statsByDateAndCode(Date startDate, Date endDate, String code){
        Query query = this.entityManager.createNativeQuery(this.CODE_DATE_QUERY);
        query.setParameter("dateStart", startDate);
        query.setParameter("dateEnd", endDate);
        query.setParameter("code", code);
        return new CodeDateStats(query.getSingleResult());
    }

}
