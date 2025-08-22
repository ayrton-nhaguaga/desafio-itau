package com.itau.itau.domain.statistic;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Map;

@Document(collection = "statistic")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Statistic {
    @Id
    private String id;
   // private long count;
    //private  double sum;
    //private double avg;
    //private double max;
    //private  double min;

    private LocalDateTime generatedAt;
    private Map<String, Object> data;
}
