package com.demo.demo_project.data;

import lombok.Builder;
import lombok.Data;

@Data
public class TransferRequest {
    String fullName;
    Long amount;
    Long refNumber;
    Long accountNumber;
}
