package com.aivle.bit.auth.service;

import static com.aivle.bit.global.exception.ErrorCode.NO_SEARCH_MEMBER;

import com.aivle.bit.auth.dto.request.SignInRequest;
import com.aivle.bit.auth.dto.response.TokenResponse;
import com.aivle.bit.auth.jwt.JwtTokenProvider;
import com.aivle.bit.auth.repository.TokenRepository;
import com.aivle.bit.global.exception.AivleException;
import com.aivle.bit.member.domain.Member;
import com.aivle.bit.member.repository.MemberRepository;
import java.time.Duration;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class SignInService {

    private final MemberRepository memberRepository;

    private final JwtTokenProvider jwtTokenProvider;

    private final TokenRepository tokenRepository;

    public TokenResponse signInUser(SignInRequest signInRequest) {
        String email = signInRequest.email();
        Member member = memberRepository.findByEmailAndIsDeletedFalse(email)
            .orElseThrow(() -> new AivleException(NO_SEARCH_MEMBER));

        member.validatePassword(signInRequest.password());

        String accessToken = jwtTokenProvider.generateAccessToken(email, member.getId(), member.getState());
        String refreshToken = jwtTokenProvider.generateRefreshToken(email, member.getId(), member.getState());

        Duration expiryDuration = jwtTokenProvider.getRefreshTokenExpiryDurationFromNow();
        tokenRepository.setValues(email, refreshToken, expiryDuration);

        return TokenResponse.of(accessToken, refreshToken);
    }
}