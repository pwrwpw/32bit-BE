### 목차

> 1. [ERD 구조](#erd-구조)
> 2. [시스템 아키텍처](#시스템-아키텍처)
> 3. [서비스 플로우](#서비스-플로우)
> 4. [기술 스택](#기술-스택)
> 5. [주요 기능](#주요-기능)
> 6. [API 명세](#api-명세)
> 7. [형상 관리 - Notion](#형상-관리)

# 프로젝트 소개


> 재무제표와 AI를 이용한 기업평가 지표 예측 서비스입니다.\
> 사용자에게는 미래의 재무 지표와 생성형 AI를 이용한 기업의 방향성을 제시합니다.\
> 
> SpringBoot와 Spring Data JPA를 사용해 기본적인 REST API를 구현하고,\
> AWS,S3,GitHub Actions을 이용해 서버를 배포했습니다.

> ### 개발 기간 및 인원
> 24.06.17 ~ 23.07.29 (6주) \
> 백엔드 2명, 프론트엔드 2명, AI 3명 (7명)

> ### [배포 링크 (접속 가능)](https://aivle.site) 👈 클릭!


# ERD 구조

![ERD](https://github.com/user-attachments/assets/14548a69-79ed-4fc9-b068-9cfa5c308920)



# 시스템 아키텍처

![시스템 아키텍처](https://github.com/user-attachments/assets/a29bf141-83c1-4ac7-be13-8931015ebade)


# 서비스 플로우

![서비스 플로우](https://github.com/user-attachments/assets/8e269d04-3e0d-4ec7-86ac-9b17357c373a)


# 기술 스택

<img width="610" alt="cafe-bom 기술 스택" src="https://github.com/user-attachments/assets/b7a31334-8d17-4006-825d-f72f95bfd973">

<br/>
<br/>

# 주요 기능

### 요약

<table align="center">
  <tr>
   <th>
    공통
   </th>
   <th>
    미인증 사용자
   </th>
   <th>
    인증 사용자
   </th>
   <th >
    관리자
   </th>
   </tr>
  <tr>
   <td align="left" width="350px" class="공통">
    - 회원가입, 로그인
    <br/>
    - 공지사항 조회
    <br/>
    - 비밀번호, 아이디 찾기
   </td>
   <td align="left" width="350px" class="미인증 사용자">
    - 기업 인증
    <br/>
    - 마이페이지 수정 및 조회
    <br/>
    - 문의사항 등록(비밀글 포함)
   </td>
   <td align="left" width="350px" class="인증 사용자">
    - 미인증 사용자 기능 포함
    <br/>
    - 보고서 조회(AI가 생성한)
    <br/>
    - 비교분석 조회(AI가 생성한)
   </td>
    <td align="left" width="350px" class="관리자">
    - 사용자 관리(인증 승인 및 정지, 탈퇴 등)
    <br/>
    - 메일 전송(특정 유저 OR 전체 메일 발송)
    <br/>
    - 공지사항 등록
    <br/>
    - 문의사항 답변 등록(비밀글 읽기 가능)
    <br/>
    - 회사 등록 및 보고서 생성(AI를 이용함)
    <br/>
    - 통계 페이지(방문자 수, 회원가입 수 등)
   </td>
  </tr>
</table>
