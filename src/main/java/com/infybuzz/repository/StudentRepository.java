package com.infybuzz.repository;

import com.infybuzz.entity.Student;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends Neo4jRepository<Student,Long> {

    List<Student> findByName(String name);

    List<Student> findByNameAndBirthYear(String name, Integer birthYear);//Or

    List<Student> findByBirthYearIn(List<Integer> birthYear);//match(p:Person) where p.birthYear in (1956,1943) return p

    //how to write our own query instead of neo4j generating it

    @Query("match (p:Person) where p.name=$name AND p.born =$birthYear")
    List<Student> getByBirthYearAndName(String name,Integer birthYear);


    //how to write our own query instead of neo4j generating it ,if the variables name is not matching

    @Query("match (p:Person) where p.name=$name AND p.born =$birth_Year")
    List<Student> getByBirthYearAndNameNotMatching(String name,@Param("birth_Year") Integer birthYear);

}
