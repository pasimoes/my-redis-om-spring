package com.redis.om.sample.models.repositories;

import java.util.List;
import java.util.Set;

import com.redis.om.sample.models.Person;
import com.redis.om.spring.repository.RedisDocumentRepository;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;

public interface PeopleRepository extends RedisDocumentRepository<Person,String> {

    // Find people by their first and last name
    Iterable<Person> findByFirstNameAndLastName(String firstName, String lastName);

    // Find people by age range
    Iterable<Person> findByAgeBetween(int minAge, int maxAge);

    // Draws a circular geofilter around a spot and returns all people in that
    // radius
    Iterable<Person> findByHomeLocNear(Point point, Distance distance);

    // Performs full-text search on a person’s personal Statement
    Iterable<Person> searchByPersonalStatement(String text);

    // Performing a tag search on city
    Iterable<Person> findByAddress_City(String city);

    // Search Persons that have one of multiple skills (OR condition)
    Iterable<Person> findBySkills(Set<String> skills);

}
