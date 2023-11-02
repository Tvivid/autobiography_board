//package com.example.board.dto;
//
//import com.example.board.dto.MemberDTO;
//import java.util.Arrays;
//import java.util.Map;
//import java.util.function.Function;
//public enum OAuthAttributes {
//
//    KAKAO("kakao", (attribute) -> {
//
//        Map<String, Object> account = (Map)attribute.get("kakao_account");
//        Map<String, String> profile = (Map)account.get("profile");
//
//        MemberDTO memberDTO = new MemberDTO();
//        memberDTO.setUserName(profile.get("nickname"));
//        memberDTO.setEmail((String)account.get("email"));
//
//        return memberDTO;
//    });
//
//    private final String registrationId; // 로그인한 서비스(ex) google, naver..)
//    private final Function<Map<String, Object>, MemberDTO> of; // 로그인한 사용자의 정보를 통하여 UserProfile을 가져옴
//
//    OAuthAttributes(String registrationId, Function<Map<String, Object>, MemberDTO> of) {
//        this.registrationId = registrationId;
//        this.of = of;
//    }
//
//    public static MemberDTO extract(String registrationId, Map<String, Object> attributes) {
//        return Arrays.stream(values())
//                .filter(value -> registrationId.equals(value.registrationId))
//                .findFirst()
//                .orElseThrow(IllegalArgumentException::new)
//                .of.apply(attributes);
//    }
//}
