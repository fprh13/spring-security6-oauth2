package com.example.OAuthSession.dto;

import java.util.Map;

/**
 * 4번
 */
public class NaverResponse implements OAuth2Response{

//    {
//        resultcode=00, message=success, response={id=123123123, name=개발자유미}
//    }
    // 네이버는 response라는 곳에 담겨져서 오기 때문에 Map으로 받아주어 처리한다.

    private final Map<String, Object> attribute;

    public NaverResponse(Map<String, Object> attribute) {
        this.attribute = (Map<String, Object>) attribute.get("response");
    }

    @Override
    public String getProvider() {
        return "naver";
    }

    @Override
    public String getProviderId() {
        return attribute.get("id").toString();
    }

    @Override
    public String getEmail() {
        return attribute.get("email").toString();
    }

    @Override
    public String getName() {
        return attribute.get("name").toString();
    }
}
