package org.example;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.serde.annotation.Serdeable;
import lombok.Data;

import java.util.UUID;

@Serdeable
@Data
public class OrganisationSearchDto {
    @JsonProperty("id")
    private UUID organisationId;

    private String name;

    private String inn;

    private String kpp;

    private String okved;

    @JsonProperty("address")
    private String legalAddress;

    @JsonProperty("post_address")
    private String postAddress;

    private String phone;

    private String fax;

    private String email;

    @JsonProperty("contact_name")
    private String contactName;

    @JsonProperty("contact_email")
    private String contactEmail;

    @JsonProperty("contact_phone")
    private String contactPhone;

    @JsonProperty("bank_name")
    private String bankName;

    @JsonProperty("bank_address")
    private String bankAddress;

    @JsonProperty("checking_account_number")
    private String checkingAccountNumber;

    @JsonProperty("correspondent_account_number")
    private String correspondentAccountNumber;

    private String bik;

    @JsonProperty("plm_org_id")
    private Long plmOrganisationId;

}
