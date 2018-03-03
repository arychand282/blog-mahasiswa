package com.projectside.blogmahasiswa.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@Getter
@Setter
@ToString(callSuper = true)
@MappedSuperclass
public abstract class ResponseDto implements Serializable {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String respResult;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String respMessage;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String respCode;

}
