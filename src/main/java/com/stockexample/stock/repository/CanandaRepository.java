package com.stockexample.stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stockexample.stock.entity.CanEntity;

public interface CanandaRepository extends JpaRepository<CanEntity, Long> {
}