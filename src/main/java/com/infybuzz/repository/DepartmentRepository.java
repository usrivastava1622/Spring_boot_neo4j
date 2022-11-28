package com.infybuzz.repository;

import com.infybuzz.entity.Department;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends Neo4jRepository<Department,Long> {
}
