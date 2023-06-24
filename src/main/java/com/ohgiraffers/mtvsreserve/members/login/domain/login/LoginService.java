package com.ohgiraffers.mtvsreserve.members.login.domain.login;

import com.ohgiraffers.mtvsreserve.members.login.domain.member.MemberDTO;
import com.ohgiraffers.mtvsreserve.members.login.domain.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.ohgiraffers.mtvsreserve.members.login.domain.member.MemberDTO.toMemberDTO;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final MemberRepository memberRepository;

    /**
     * @return null 로그인 실패
     */
    public MemberDTO login(String loginId, String password) {
        return toMemberDTO(memberRepository.findByLoginId(loginId)
                .filter(m -> m.getPassword().equals(password))
                .orElse(null));
    }
}
