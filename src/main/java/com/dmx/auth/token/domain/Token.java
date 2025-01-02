package com.dmx.auth.token.domain;

public class Token {
    private final TokenId id;
    private final TokenCreationDate creationDate;
    private final TokenExpirationDate expirationDate;

    public Token(TokenId id, TokenCreationDate creationDate, TokenExpirationDate expirationDate) {
        this.id = id;
        this.creationDate = creationDate;
        this.expirationDate = expirationDate;
    }

    public static Token fromPrimitives(TokenDTO data) {
        return new Token(
                new TokenId(data.id()),
                new TokenCreationDate(data.cretionDate()),
                new TokenExpirationDate(data.expirationDate())
        );
    }

    public TokenId getId() {
        return this.id;
    }

    public TokenCreationDate getCreationDate() {
        return this.creationDate;
    }

    public TokenExpirationDate getExpirationDate() {
        return this.expirationDate;
    }

    public TokenDTO toPrimitives() {
        return new TokenDTO(
                this.id.value(),
                this.creationDate.value(),
                this.expirationDate.value()
        );
    }

}
