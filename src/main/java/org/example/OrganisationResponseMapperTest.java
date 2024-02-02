package org.example;

import io.micronaut.context.env.Environment;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import ru.oaosu.paksapr.organisation.dao.entity.Bank;
import ru.oaosu.paksapr.organisation.dao.entity.Organisation;
import ru.oaosu.paksapr.organisation.dao.entity.PlmOrganisation;
import ru.oaosu.paksapr.organisation.dto.organisation.OrganisationResponse;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@MicronautTest (environments = Environment.TEST)
public class OrganisationResponseMapperTest {

    @Inject
    private OrganisationResponseMapper organisationResponseMapper;

    @Test
    void toOrganisationDto () {
        OrganisationResponse exp = new OrganisationResponse()
                .setOrganisationId(UUID.fromString("49068632-bef4-44a0-b30b-19155b52b402"))
                .setName("test_org1")
                .setInn("112233")
                .setKpp("12345")
                .setOkved("1.2.3")
                .setBanks(
                        List.of(new Bank().setBankId(UUID.fromString("ea690764-d7d1-420f-bd7d-24109c3f6adf"))
                                .setBankName("ИмяБанка1").setBankAddress("Банк1 Улица 1, дом 11").setCheckingAccountNumber("Проверка номера аккаунта1").setCorrespondentAccountNumber("Номер1 Корреспонденсткого счета1").setBik("112233")
                                .setCreateDt(LocalDateTime.of(2023, 12, 27, 10, 11, 20)).setModifyDt(LocalDateTime.of(2023, 12, 27, 10, 15, 14)))
                )
                .setPlmOrganisation(new PlmOrganisation().setPlmOrganisationId(1L).setCreateDt(LocalDateTime.of(2023, 12, 27, 10, 17, 27)).setModifyDt(LocalDateTime.of(2023, 12, 27, 10, 22, 49)));


        Organisation param = new Organisation()
                .setOrganisationId(UUID.fromString("49068632-bef4-44a0-b30b-19155b52b402"))
                .setName("test_org1")
                .setInn("112233")
                .setKpp("12345")
                .setOkved("1.2.3")
                .setBanks(
                        List.of(new Bank().setBankId(UUID.fromString("ea690764-d7d1-420f-bd7d-24109c3f6adf"))
                                .setBankName("ИмяБанка1").setBankAddress("Банк1 Улица 1, дом 11").setCheckingAccountNumber("Проверка номера аккаунта1").setCorrespondentAccountNumber("Номер1 Корреспонденсткого счета1").setBik("112233")
                                .setCreateDt(LocalDateTime.of(2023, 12, 27, 10, 11, 20)).setModifyDt(LocalDateTime.of(2023, 12, 27, 10, 15, 14)))
                )
                .setPlmOrganisation(new PlmOrganisation().setPlmOrganisationId(1L).setCreateDt(LocalDateTime.of(2023, 12, 27, 10, 17, 27)).setModifyDt(LocalDateTime.of(2023, 12, 27, 10, 22, 49)));

        OrganisationResponse result = organisationResponseMapper.toOrganisationDto(param);
        assertNotNull(result);
        assertNotNull(result.getOrganisationId());
        assertEquals(exp, result);
    }

    @Test
    void toOrganisation () {
        OrganisationResponse param = new OrganisationResponse().
                setOrganisationId(UUID.fromString("49068632-bef4-44a0-b30b-19155b52b402")).
                setName("test_org1").
                setInn("112233").
                setKpp("12345").
                setOkved("1.2.3")
                .setBanks(
                        List.of(new Bank().setBankId(UUID.fromString("ea690764-d7d1-420f-bd7d-24109c3f6adf"))
                                .setBankName("ИмяБанка1").setBankAddress("Банк1 Улица 1, дом 11").setCheckingAccountNumber("Проверка номера аккаунта1").setCorrespondentAccountNumber("Номер1 Корреспонденсткого счета1").setBik("112233")
                                .setCreateDt(LocalDateTime.of(2023, 12, 27, 10, 11, 20)).setModifyDt(LocalDateTime.of(2023, 12, 27, 10, 15, 14)))
                )
                .setPlmOrganisation(new PlmOrganisation().setPlmOrganisationId(1L).setCreateDt(LocalDateTime.of(2023, 12, 27, 10, 17, 27)).setModifyDt(LocalDateTime.of(2023, 12, 27, 10, 22, 49)));
        Organisation exp = new Organisation().
                setOrganisationId(UUID.fromString("49068632-bef4-44a0-b30b-19155b52b402")).
                setName("test_org1").
                setInn("112233").
                setKpp("12345").
                setOkved("1.2.3")
                .setBanks(
                        List.of(new Bank().setBankId(UUID.fromString("ea690764-d7d1-420f-bd7d-24109c3f6adf"))
                                .setBankName("ИмяБанка1").setBankAddress("Банк1 Улица 1, дом 11").setCheckingAccountNumber("Проверка номера аккаунта1").setCorrespondentAccountNumber("Номер1 Корреспонденсткого счета1").setBik("112233")
                                .setCreateDt(LocalDateTime.of(2023, 12, 27, 10, 11, 20)).setModifyDt(LocalDateTime.of(2023, 12, 27, 10, 15, 14)))
                )
                .setPlmOrganisation(new PlmOrganisation().setPlmOrganisationId(1L).setCreateDt(LocalDateTime.of(2023, 12, 27, 10, 17, 27)).setModifyDt(LocalDateTime.of(2023, 12, 27, 10, 22, 49)));
        Organisation result = organisationResponseMapper.toOrganisation(param);
        assertNotNull(result);
        assertNotNull(result.getOrganisationId());
        assertEquals(exp, result);
        assertNotNull(result.getOrganisationId());
        assertEquals(exp.getName(), result.getName());
        assertEquals(exp.getInn(), result.getInn());
        assertEquals(exp.getKpp(), result.getKpp());
        assertEquals(exp.getOkved(), result.getOkved());
        assertEquals(exp.getLegalAddress(), result.getLegalAddress());
        assertEquals(exp.getPostAddress(), result.getPostAddress());
        assertEquals(exp.getPhone(), result.getPhone());
        assertEquals(exp.getEmail(), result.getEmail());
        assertEquals(exp.getFax(), result.getFax());
        assertEquals(exp.getContactEmail(), result.getContactEmail());
        assertEquals(exp.getContactName(), result.getContactName());
        assertEquals(exp.getContactPhone(), result.getContactPhone());
        assertEquals(exp.getCreateDt(), result.getCreateDt());
        assertEquals(exp.getModifyDt(), result.getModifyDt());
        compareBank(exp.getBanks().get(0), result.getBanks().get(0));
        comparePlmOrganisation(exp.getPlmOrganisation(), result.getPlmOrganisation());
    }
    private void compareBank(Bank expectedBank, Bank acrualBank) {
        assertNotNull(expectedBank.getBankId());
        assertNotNull(acrualBank.getBankId());
        assertEquals(expectedBank.getBankName(), acrualBank.getBankName());
        assertEquals(expectedBank.getBankAddress(), acrualBank.getBankAddress());
        assertEquals(expectedBank.getCheckingAccountNumber(), acrualBank.getCheckingAccountNumber());
        assertEquals(expectedBank.getCorrespondentAccountNumber(), acrualBank.getCorrespondentAccountNumber());
        assertEquals(expectedBank.getBik(), acrualBank.getBik());
        assertEquals(expectedBank.getCreateDt(), acrualBank.getCreateDt());
        assertEquals(expectedBank.getModifyDt(), acrualBank.getModifyDt());

    }

    private void comparePlmOrganisation(PlmOrganisation expectedPlm, PlmOrganisation actualPlm) {
        assertNotNull(actualPlm);
        assertEquals(expectedPlm.getPlmOrganisationId(), actualPlm.getPlmOrganisationId());
        assertEquals(expectedPlm.getCreateDt(), actualPlm.getCreateDt());
        assertEquals(expectedPlm.getModifyDt(), actualPlm.getModifyDt());
    }


}
