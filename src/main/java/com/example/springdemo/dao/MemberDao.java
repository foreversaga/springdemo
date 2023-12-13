package com.example.springdemo.dao;

import com.example.springdemo.entity.MemberEntity;
import com.example.springdemo.request.UpdateMemberRequest;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface MemberDao extends ListCrudRepository<MemberEntity, Long> {

	@Transactional
	@Modifying
	@Query(value = "UPDATE member m SET m.name = :#{#request.name} WHERE m.id = :#{#request.id}", nativeQuery = true)
	void updateById(@Param("request") UpdateMemberRequest request);
}
