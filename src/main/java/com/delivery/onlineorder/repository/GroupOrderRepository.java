package com.delivery.onlineorder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupOrderRepository extends JpaRepository<GroupOrder, Integer>, QuerydslPredicateExecutor<GroupOrder> {
}
