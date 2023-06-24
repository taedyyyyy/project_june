package com.ohgiraffers.mtvsreserve.members.login.domain.member;

import com.ohgiraffers.mtvsreserve.members.login.domain.member.MemberDTO;
import com.ohgiraffers.mtvsreserve.members.login.domain.entity.MemberEntity;
import com.ohgiraffers.mtvsreserve.members.login.domain.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.ohgiraffers.mtvsreserve.members.login.domain.entity.MemberEntity.toMemberEntity;
import static com.ohgiraffers.mtvsreserve.members.login.domain.entity.MemberEntity.toUpdateMemberEntity;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public void save(MemberDTO memberDTO) {
        MemberEntity memberEntity = toMemberEntity(memberDTO);
        memberRepository.save(memberEntity);
    }

    public List<MemberDTO> findAll(){
        List<MemberEntity> memberEntityList=memberRepository.findAll();
        List<MemberDTO> memberDTOList=new ArrayList<>();
        for (MemberEntity memberEntity:memberEntityList) {
            memberDTOList.add(MemberDTO.toMemberDTO(memberEntity));
        }
        return memberDTOList;
    }

    public MemberDTO findByLoginId(String LoginId){
        Optional<MemberEntity> optionalMemberEntity=memberRepository.findByLoginId(LoginId);
        if(optionalMemberEntity.isPresent()){
            return MemberDTO.toMemberDTO(optionalMemberEntity.get());
        }else{
            return null;
        }
    }

    public MemberDTO updateForm(String LoginId){
        Optional<MemberEntity> optionalMemberEntity=memberRepository.findByLoginId(LoginId);
        if(optionalMemberEntity.isPresent()){
            return MemberDTO.toMemberDTO(optionalMemberEntity.get());
        }else{
            return null;
        }
    }
    public void update(MemberDTO memberDTO){
        // 업데이트 쿼리를 날려주니?...
        memberRepository.save(toUpdateMemberEntity(memberDTO));
    }

    public void delete(MemberDTO member)  {
        memberRepository.delete(toMemberEntity(member));
    }
}
