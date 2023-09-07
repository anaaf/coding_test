package com.smallworld.Model;

import lombok.Setter;
import lombok.Getter;
import com.fasterxml.jackson.annotation.JsonProperty;

@Getter
@Setter
public class Transaction {
    @JsonProperty("mtn")
    private Long Mtn;
    @JsonProperty("amount")
    private Double Amount;
    @JsonProperty("senderFullName")
    private String SenderFullName;
    @JsonProperty("senderAge")
    private Integer SenderAge;
    @JsonProperty("beneficiaryFullName")
    private String BeneficiaryFullName;
    @JsonProperty("beneficiaryAge")
    private Integer BeneficiaryAge;
    @JsonProperty("issueId")
    private Integer IssueId;
    @JsonProperty("issueSolved")
    private Boolean IssueSolved;
    @JsonProperty("issueMessage")
    private String IssueMessage;
}
