package com.demo.demo_project.services;

import com.demo.demo_project.data.TransferRequest;
import com.demo.demo_project.entities.Transfer;
import com.demo.demo_project.repositories.TransferRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TransferService {
    private final TransferRepository transferRepository;

    @Autowired
    public TransferService(TransferRepository transferRepository) {
        this.transferRepository = transferRepository;
    }

    public void saveTransfer(TransferRequest transferRequest) {

        if (transferRequest.getAccountNumber() == null ||
                transferRequest.getAmount() == null ||
                transferRequest.getFullName() == null ||
                transferRequest.getFullName().trim().length() == 0 ||
                transferRequest.getRefNumber() == null) {
            log.warn("Empty parameters, make sure all parameters are filled");
            throw new RuntimeException("Empty parameter supplied");
        }
        Transfer transfer = Transfer.builder()
                .amount(transferRequest.getAmount())
                .accountNumber(transferRequest.getAccountNumber())
                .fullName(transferRequest.getFullName())
                .refNumber(transferRequest.getRefNumber())
                .build();
        transferRepository.save(transfer);
        log.info("Transfer saved successfully");
    }
}
