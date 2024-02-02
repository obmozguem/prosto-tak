package org.example;

import io.micronaut.context.env.Environment;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import ru.oaosu.paksapr.organisation.dao.entity.Organisation;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@MicronautTest(environments = Environment.TEST)
class OrganisationSearchMapperTestOld {

    @Inject
    private OrganisationSearchMapper organisationSearchMapper;

    @Test
    void toOrganisationDto() {
        OrganisationSearchDto exp = new OrganisationSearchDto()
                .setOrganisationId(UUID.fromString("49068632-bef4-44a0-b30b-19155b52b402"))
                .setName("test_org1")
                .setInn("112233")
                .setKpp("12345")
                .setOkved("1.2.3");


        Organisation param = new Organisation()
                .setOrganisationId(UUID.fromString("49068632-bef4-44a0-b30b-19155b52b402"))
                .setName("test_org1")
                .setInn("112233")
                .setKpp("12345")
                .setOkved("1.2.3");
        OrganisationSearchDto result = organisationSearchMapper.toOrganisationSearchDto(param);
        assertNotNull(result);
        assertNotNull(result.getOrganisationId());
        assertEquals(exp, result);
    }
}