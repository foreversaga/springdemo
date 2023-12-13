package com.example.springdemo.controller;

import java.util.List;
import java.util.Optional;

import com.example.springdemo.dto.MemberDto;
import com.example.springdemo.request.CreateMemberRequest;
import com.example.springdemo.request.UpdateMemberRequest;
import com.example.springdemo.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {

	private final MemberService memberService;

	@PostMapping("/createMember")
	public ResponseEntity<String> member(@RequestBody CreateMemberRequest request) {
		memberService.createMember(request);
		return ResponseEntity.ok().build();
	}

	@GetMapping("/getMembers")
	public ResponseEntity<List<MemberDto>> getMembers() {
		List<MemberDto> allMembers = memberService.getAllMembers();
		return ResponseEntity.ok(allMembers);
	}

	@GetMapping("/getMember")
	public ResponseEntity<MemberDto> getMemberById(@RequestParam Long id) {
		Optional<MemberDto> result = memberService.getMemberById(id);
		return result.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}

	@DeleteMapping("/deleteMember")
	public ResponseEntity<String> deleteMemberById(@RequestParam Long id) {
		memberService.deleteMemberById(id);
		return ResponseEntity.ok().build();
	}

	@PatchMapping("/updateMember")
	public ResponseEntity<String> updateMemberById(@RequestBody UpdateMemberRequest request) {
		memberService.updateMemberById(request);
		return ResponseEntity.ok().build();
	}
}
