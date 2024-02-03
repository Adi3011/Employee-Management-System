package com.employee.emsbackend.repository;

import com.employee.emsbackend.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

// repository layer exists between service layer and db and is used to perform db crud operations
// package javax.persistence creates -> EntityManagerFactory during app startup ---> which Creates EntityManager --> which manages entity
// entity -> object that persists into database with the hel-p of EntityManager
//methods existing with JPARepository are transactional(commit is performed when transaction is successful)
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
