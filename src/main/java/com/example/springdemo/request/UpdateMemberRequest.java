package com.example.springdemo.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateMemberRequest {
	private Long id;
	private String name;
}
