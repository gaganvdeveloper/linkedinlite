package com.google.linkedinlite.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.google.linkedinlite.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Integer>{

}
