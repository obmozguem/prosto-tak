package org.example;

import io.micronaut.context.env.Environment;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.oaosu.paksapr.common.util.ClockHolder;
import ru.oaosu.paksapr.organisation.dao.entity.Bank;
import ru.oaosu.paksapr.organisation.dao.entity.Organisation;
import ru.oaosu.paksapr.organisation.dao.entity.PlmOrganisation;
import ru.oaosu.paksapr.organisation.dto.mapper.OrganisationResponseMapper;
import ru.oaosu.paksapr.organisation.dto.organisation.OrganisationResponse;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@MicronautTest(environments = Environment.TEST)

public class CreateOrganisationServiceTest {

    @Inject
    private CreateOrganisationService createOrganisationService;

    @Inject
    private OrganisationResponseMapper organisationResponseMapper;

    static LocalDateTime time = LocalDateTime.of(2024, 1, 16, 12, 20, 20);
    static Clock oldClock;

    @BeforeAll
    static void setUp() {
        Clock fixed = Clock.fixed(time.toInstant(ZoneOffset.UTC), ZoneOffset.UTC);
        oldClock = ClockHolder.setClock(fixed);
    }

    @AfterAll
    static void tearDown() {
        ClockHolder.setClock(oldClock);
    }


    @Test
    void saveOrganisation() {
        OrganisationResponse expectedOrganisation = createOrganisation();
        OrganisationResponse actualOrganisation = createOrganisationService.saveOrganisation(expectedOrganisation);
        assertNotNull(actualOrganisation);
        assertNotNull(actualOrganisation.getOrganisationId());
        assertEquals(expectedOrganisation.getName(), actualOrganisation.getName());
        assertEquals(expectedOrganisation.getInn(), actualOrganisation.getInn());
        assertEquals(expectedOrganisation.getKpp(), actualOrganisation.getKpp());
        assertEquals(expectedOrganisation.getOkved(), actualOrganisation.getOkved());
        assertEquals(expectedOrganisation.getLegalAddress(), actualOrganisation.getLegalAddress());
        assertEquals(expectedOrganisation.getPostAddress(), actualOrganisation.getPostAddress());
        assertEquals(expectedOrganisation.getPhone(), actualOrganisation.getPhone());
        assertEquals(expectedOrganisation.getEmail(), actualOrganisation.getEmail());
        assertEquals(expectedOrganisation.getFax(), actualOrganisation.getFax());
        assertEquals(expectedOrganisation.getContactEmail(), actualOrganisation.getContactEmail());
        assertEquals(expectedOrganisation.getContactName(), actualOrganisation.getContactName());
        assertEquals(expectedOrganisation.getContactPhone(), actualOrganisation.getContactPhone());
        assertEquals(expectedOrganisation.getCreateDt(), actualOrganisation.getCreateDt());
        assertEquals(expectedOrganisation.getModifyDt(), actualOrganisation.getModifyDt());
        compareBank(expectedOrganisation.getBanks().get(0), actualOrganisation.getBanks().get(0));
        comparePlmOrganisation(expectedOrganisation.getPlmOrganisation(), actualOrganisation.getPlmOrganisation());
    }

    private OrganisationResponse createOrganisation() {
        Organisation organisation = new Organisation()
                .setName("test_org1")
                .setInn("112233")
                .setKpp("12345")
                .setOkved("1.2.3")
                .setLegalAddress("юридическа Улица 1, дом 1")
                .setPostAddress("почтовая улица 1, дом 1")
                .setPhone("+74951111111")
                .setFax("+74951111111")
                .setEmail("org1@mail.ru")
                .setContactName("ИмяКонтакта1")
                .setContactEmail("contact1@email.ru")
                .setContactPhone("+79031112233")
                .setCreateDt(LocalDateTime.of(2023, 12, 27, 9, 48, 54))
                .setModifyDt(LocalDateTime.of(2023, 12, 27, 9, 54, 39))
//                .setEmployees(List.of(new Employee().setEmployeeId(UUID.fromString("19eaa6de-2ab1-4932-81b0-8e805e837ea2")).setFirstName("ИмяПервогоЭмп").setSecondName("ОтчествоПервогоЭмп").setLastName("ФамилияПервогоЭмп").setEmail("emp1@mail.ru").setUsername("employka1")
//                                .setCreateDt(LocalDateTime.of(2023, 12, 27, 10, 2, 9)).setModifyDt(LocalDateTime.of(2023, 12, 27, 10, 4, 28))
//                                .setPlmEmployee(new PlmEmployee().setPlmEmployeeId(1L).setCreateDt(LocalDateTime.of(2023, 12, 27, 10, 25, 20)).setModifyDt(LocalDateTime.of(2023, 12, 27, 10, 27, 8)))
//                                .setBucket(new Bucket().setBucketId(UUID.fromString("918a7a50-af96-4a8f-8e7e-4abc368e2be2")).setCreateDt(LocalDateTime.of(2023, 12, 27, 10, 29, 59)).setModifyDt(LocalDateTime.of(2023, 12, 27, 10, 30, 48)))
//                                .setRoles(List.of(new Role().setRoleId("ROLE_ADMIN").setDescription("Роль с правами админа").setCreateDt(LocalDateTime.of(2023, 12, 27, 10, 35, 16)).setModifyDt(LocalDateTime.of(2023, 12, 27, 10, 35, 59)),
//                                        new Role().setRoleId("ROLE_USER").setDescription("Роль с правами пользователя").setCreateDt(LocalDateTime.of(2023, 12, 27, 10, 36, 47)).setModifyDt(LocalDateTime.of(2023, 12, 27, 10, 37, 26)))),
//                        new Employee().setEmployeeId(UUID.fromString("736cc8ca-2565-4fe1-b0f6-eeeae0e94046")).setFirstName("ИмяВторогоЭмп").setSecondName("ОтчествоВторогоЭмп").setLastName("ФамилияВторогоЭмп").setEmail("emp1@mail.ru")
//                                .setUsername("employka2").setCreateDt(LocalDateTime.of(2023, 12, 27, 10, 5, 13)).setModifyDt(LocalDateTime.of(2023, 12, 27, 10, 6, 36))
//                                .setPlmEmployee(new PlmEmployee().setPlmEmployeeId(2L).setCreateDt(LocalDateTime.of(2023, 12, 27, 10, 27, 28)).setModifyDt(LocalDateTime.of(2023, 12, 27, 10, 28, 3)))
//                                .setBucket(new Bucket().setBucketId(UUID.fromString("7813f465-a472-4f37-9db8-fac57220db5a")).setCreateDt(LocalDateTime.of(2023,12,27,10,31,8)).setModifyDt(LocalDateTime.of(2023, 12, 27, 10, 30, 48)))
//                                .setRoles(List.of(new Role().setRoleId("ROLE_ADMIN").setDescription("Роль с правами админа").setCreateDt(LocalDateTime.of(2023, 12, 27, 10, 35, 16)).setModifyDt(LocalDateTime.of(2023, 12, 27, 10, 35, 59))))))

                .setBanks(
                        List.of(new Bank().setBankName("ИмяБанка1").setBankAddress("Банк1 Улица 1, дом 11").setCheckingAccountNumber("Проверка номера аккаунта1").setCorrespondentAccountNumber("Номер1 Корреспонденсткого счета1").setBik("112233")
                                .setCreateDt(LocalDateTime.of(2023, 12, 27, 10, 11, 20)).setModifyDt(LocalDateTime.of(2023, 12, 27, 10, 15, 14)))
                )
                .setPlmOrganisation(new PlmOrganisation().setPlmOrganisationId(1L).setCreateDt(LocalDateTime.of(2023, 12, 27, 10, 17, 27)).setModifyDt(LocalDateTime.of(2023, 12, 27, 10, 22, 49)));
        return organisationResponseMapper.toOrganisationDto(organisation);
    }


    void compareBank(Bank expectedBank, Bank acrualBank) {
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

//    void compareEmployees(List<Employee> expectedEmployees, List<Employee> actualEmployees) {
//        assertNotNull(actualEmployees);
//        assertEquals(expectedEmployees.size(), actualEmployees.size());
//        for (int i=0;i<expectedEmployees.size();i++){
//            Employee expEmp = expectedEmployees.get(i);
//            Employee actEmp = actualEmployees.get(i);
//            assertNotNull(actEmp);
//            assertEquals(expEmp.getEmployeeId(),actEmp.getEmployeeId());
//            assertEquals(expEmp.getFirstName(), actEmp.getFirstName());
//            assertEquals(expEmp.getSecondName(), actEmp.getSecondName());
//            assertEquals(expEmp.getLastName(), actEmp.getLastName());
//            assertEquals(expEmp.getEmail(), actEmp.getEmail());
//            assertEquals(expEmp.getUsername(), actEmp.getUsername());
//            assertEquals(expEmp.getRoles(), actEmp.getRoles());
//            assertEquals(expEmp.getPlmEmployee(), actEmp.getPlmEmployee());
//            assertEquals(expEmp.getBucket(), actEmp.getBucket());
//            assertEquals(expEmp.getCreateDt(), actEmp.getCreateDt());
//            assertEquals(expEmp.getModifyDt(), actEmp.getModifyDt());
//        }
//    }

    void comparePlmOrganisation(PlmOrganisation expectedPlm, PlmOrganisation actualPlm) {
        assertNotNull(actualPlm);
        assertEquals(expectedPlm.getPlmOrganisationId(), actualPlm.getPlmOrganisationId());
        assertEquals(expectedPlm.getCreateDt(), actualPlm.getCreateDt());
        assertEquals(expectedPlm.getModifyDt(), actualPlm.getModifyDt());
    }
}
