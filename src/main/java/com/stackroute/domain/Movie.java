package com.stackroute.domain;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
//import org.hibernate.annotations.Type;
//
//import javax.persistence.Entity;
//import javax.persistence.Id;

//@Entity
@Document(collection = "Movie")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Movie {

    @Id
    private Integer id;
    private String title;
//    @JsonSubTypes.Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean adult;
    private String overview;

}
