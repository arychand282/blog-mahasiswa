package com.projectside.blogmahasiswa.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.projectside.blogmahasiswa.domain.Privilege;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@ToString
public class UserDto extends ResponseDto {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String id;

    @NotEmpty
    @Size(min = 1, max = 50)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String username;

    @NotEmpty
    @Size(min = 1, max = 100)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String email;

    @NotEmpty
    @Size(min = 1, max = 50)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String password;

    @NotEmpty
    @Size(min = 1, max = 200)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String fullName;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private boolean deleteFlag;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String privilege;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String privilegeName;

}
