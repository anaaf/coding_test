package com.smallworld.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/*@Getter
@Setter*/
@Data
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

    @Override
    public boolean equals(Object obj) {
        Transaction trx = (Transaction) obj;
        return this.getMtn().equals(trx.getMtn());
    }
    @Override
    public int hashCode() {
        return Mtn.hashCode();
    }

    public Transaction Get() {
        return this;
    }
}
