package com.demo.demo_project.data;

import com.demo.demo_project.data.enums.ResponseType;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TransferResponse {
     public Integer code;
     public ResponseType message;
}
