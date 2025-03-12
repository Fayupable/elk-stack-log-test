package com.fayupable.elkstack.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ElkStackResponse {
    private String message;
    private Object data;
}
