package com.mmdworks.recap.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mmdworks.recap.domain.MortageDetails;

public interface MortageDetailsRepository extends JpaRepository<MortageDetails, Long> {

}
