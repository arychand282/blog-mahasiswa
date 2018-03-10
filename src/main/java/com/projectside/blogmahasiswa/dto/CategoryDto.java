package com.projectside.blogmahasiswa.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

@Getter
@Setter
@ToString
public class CategoryDto extends ResponseDto {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String id;

    @NotEmpty
    @Size(min = 1, max = 50)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String name;

    @Size(max = 200)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String description;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private boolean deleteFlag;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String createdBy;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Date dateCreated;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String updatedBy;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Date lastUpdated;

}
