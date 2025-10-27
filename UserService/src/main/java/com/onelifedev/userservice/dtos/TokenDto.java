package com.onelifedev.userservice.dtos;

import com.onelifedev.userservice.models.Token;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TokenDto {
    private String tokenValue;

    public static TokenDto from(Token token) {
        if (token == null) {
            return null;
        }

        TokenDto tokenDto = new TokenDto();
        tokenDto.setTokenValue(token.getTokenValue());
        return tokenDto;
    }
}
