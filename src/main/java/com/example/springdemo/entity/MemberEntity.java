package com.example.springdemo.entity;

import static jakarta.persistence.GenerationType.IDENTITY;

import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "member")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberEntity {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Long id;

	private String name;

	private String password;

	private int status;

	private Timestamp createTime;

	private Timestamp updateTime;
}
