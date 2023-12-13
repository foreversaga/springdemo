package com.example.springdemo.request;

import lombok.Data;

@Data
public class CreateMemberRequest {

	private String name;

	private String password;
}
