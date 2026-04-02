package com.marsapp.marsapp.repository;

import com.marsapp.marsapp.model.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends JpaRepository<Test, Long> { }
