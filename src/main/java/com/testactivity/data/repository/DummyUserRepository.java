package com.testactivity.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.testactivity.data.entity.DummyUser;

@Repository
public interface DummyUserRepository extends JpaRepository<DummyUser, Integer> {

	public DummyUser findByName(String userName);
}
