package com.example.springdemo.constants;

import lombok.Getter;

public enum StatusType {
	ACTIVE(1),
	INACTIVE(2);

	StatusType(int value) {
		this.value = value;
	}

	@Getter
	private int value;

	public static StatusType getInstance(int value) {
		for (StatusType statusType : StatusType.values()) {
			if (statusType.getValue() == value) {
				return statusType;
			}
		}

		throw new IllegalArgumentException("No matching StatusType for [" + value + "]");
	}
}
