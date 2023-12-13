package com.example.springdemo.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MemberDto {

	private Long id;

	private String name;

	private int status;
}
