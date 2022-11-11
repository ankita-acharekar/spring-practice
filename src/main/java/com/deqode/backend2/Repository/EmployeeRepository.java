package com.deqode.backend2.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.deqode.backend2.Model.Employee;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String> {

}
