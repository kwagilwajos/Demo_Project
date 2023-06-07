package com.demo.demo_project.controllers;
import com.demo.demo_project.data.TransferResponse;
import com.demo.demo_project.data.TransferRequest;
import com.demo.demo_project.services.TransferService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.demo.demo_project.data.ResponseCodes.*;
import static com.demo.demo_project.data.enums.ResponseType.*;

@Slf4j
@RestController
@RequestMapping("/webservice/api/v1/transfers")
public class TransferController {
    public final TransferService transferService;

    @Autowired
    public TransferController(TransferService transferService) {
        this.transferService = transferService;
    }

    @PostMapping
    public TransferResponse makeTransfer(@RequestBody TransferRequest transferRequest){
        try {
            transferService.saveTransfer(transferRequest);
        } catch (Exception e){
            log.error("Error in saving a transfer: " + e.getMessage());
            return new TransferResponse(FAILED_TRANSFER, Failure);
        }

        return new TransferResponse(SUCCESS_TRANSFER, Success);
    }

}
