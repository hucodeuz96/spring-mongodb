package com.example.springmongodb.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * @author "Husniddin Ulachov"
 * @created 4:54 PM on 7/23/2022
 * @project spring-mongodb
 */
@Document(collection = "ketmon")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    @Id
    private String id;
    private String fullName;
    private Date createdAt= new Date();
}
