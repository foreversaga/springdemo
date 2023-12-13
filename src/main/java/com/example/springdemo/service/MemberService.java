package com.example.springdemo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.example.springdemo.constants.StatusType;
import com.example.springdemo.dao.MemberDao;
import com.example.springdemo.dto.MemberDto;
import com.example.springdemo.entity.MemberEntity;
import com.example.springdemo.request.CreateMemberRequest;
import com.example.springdemo.request.UpdateMemberRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

	private final MemberDao memberDao;

	public void createMember(CreateMemberRequest request) {
		MemberEntity memberEntity = MemberEntity.builder()
			.name(request.getName())
			.password(request.getPassword())
			.status(StatusType.ACTIVE.getValue())
			.build();
		memberDao.save(memberEntity);
	}

	public List<MemberDto> getAllMembers() {
		List<MemberEntity> memberEntities = memberDao.findAll();

		return memberEntities.stream()
			.map(memberEntity -> MemberDto.builder()
				.id(memberEntity.getId())
				.name(memberEntity.getName())
				.status(memberEntity.getStatus())
				.build()).collect(Collectors.toList());
	}

	public Optional<MemberDto> getMemberById(long id) {
		Optional<MemberEntity> result = memberDao.findById(id);
		return result.map(memberEntity -> MemberDto.builder()
			.id(memberEntity.getId())
			.name(memberEntity.getName())
			.status(memberEntity.getStatus())
			.build());
	}

	public void deleteMemberById(Long id) {
		memberDao.deleteById(id);
	}

	public void updateMemberById(UpdateMemberRequest request) {
		memberDao.updateById(request);
	}
}
