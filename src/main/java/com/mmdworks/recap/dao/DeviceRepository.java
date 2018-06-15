package com.mmdworks.recap.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mmdworks.recap.domain.Device;

public interface DeviceRepository extends JpaRepository<Device, Long> {

}
