package study.datajpa.dto;

import lombok.Data;

@Data

public class MemberDto {
    public MemberDto(Long id, String username, String teamName) {
        this.id = id;
        this.username = username;
        this.teamName = teamName;
    }

    private  Long id;
    private String username;
    private String teamName;


}
