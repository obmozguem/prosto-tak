package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Organisation organisation = organisationRequestMapper.toOrganisation(organisationRequestDto);
        organisation.setOrganisationId(id);
        return organisationResponseMapper.toOrganisationResponseDto(organisationRepository.update(organisation));


        updatedOrganisation.setName(organisation.getName() == null ? updatedOrganisation.getName() : organisation.getName());
        updatedOrganisation.setInn(organisation.getInn() == null ? updatedOrganisation.getInn() : organisation.getInn());
        updatedOrganisation.setKpp(organisation.getKpp() == null ? updatedOrganisation.getKpp() : organisation.getKpp());
        updatedOrganisation.setOkved(organisation.getOkved() == null ? updatedOrganisation.getOkved() : organisation.getOkved());
        updatedOrganisation.setLegalAddress(organisation.getLegalAddress() == null ? updatedOrganisation.getLegalAddress() : organisation.getLegalAddress());
        updatedOrganisation.setPostAddress(organisation.getPostAddress() == null ? updatedOrganisation.getPostAddress() : organisation.getPostAddress());
        updatedOrganisation.setPhone(organisation.getPhone() == null ? updatedOrganisation.getPhone() : organisation.getPhone());
        updatedOrganisation.setFax(organisation.getFax() == null ? updatedOrganisation.getFax() : organisation.getFax());
        updatedOrganisation.setEmail(organisation.getEmail() == null ? updatedOrganisation.getEmail() : organisation.getEmail());
        updatedOrganisation.setContactName(organisation.getContactName() == null ? updatedOrganisation.getContactName() : organisation.getContactName());
        updatedOrganisation.setContactEmail(organisation.getContactEmail() == null ? updatedOrganisation.getContactEmail() : organisation.getContactEmail());
        updatedOrganisation.setContactPhone(organisation.getContactPhone() == null ? updatedOrganisation.getContactPhone() : organisation.getContactPhone());
        updatedOrganisation.setCreateDt(organisation.getCreateDt() == null ? updatedOrganisation.getCreateDt() : organisation.getCreateDt());
        updatedOrganisation.setModifyDt(organisation.getModifyDt() == null ? updatedOrganisation.getModifyDt() : organisation.getModifyDt());


        updatedEmployee.setFirstName(newEmp.getFirstName() == null ? updatedEmployee.getFirstName() : newEmp.getFirstName());
        updatedEmployee.setSecondName(newEmp.getSecondName() == null ? updatedEmployee.getSecondName() : newEmp.getSecondName());
        updatedEmployee.setLastName(newEmp.getLastName() == null ? updatedEmployee.getLastName() : newEmp.getLastName());
        updatedEmployee.setEmail(newEmp.getEmail() == null ? updatedEmployee.getEmail() : newEmp.getEmail());
        updatedEmployee.setUsername(newEmp.getUsername() == null ? updatedEmployee.getUsername() : newEmp.getUsername());
        updatedEmployee.setPlmEmployee(newEmp.getPlmEmployee() == null ? updatedEmployee.getPlmEmployee() : newEmp.getPlmEmployee());
        updatedEmployee.setBucket(newEmp.getBucket() == null ? updatedEmployee.getBucket() : newEmp.getBucket());
        updatedEmployee.setCreateDt(newEmp.getCreateDt() == null ? updatedEmployee.getCreateDt() : newEmp.getCreateDt());
        updatedEmployee.setOrganisation(newEmp.getOrganisation() == null ? updatedEmployee.getOrganisation() : newEmp.getOrganisation());

        //        List<SearchEmployee> employees = (specification == null)? Collections.emptyList(): searchEmployeeRepository.findAll(specification);
//        if (enabled != null) {
//            // TODO: ИЛИ ОСТАВИТЬ ПАГИНАЦИЮ КАК БЫЛО?
//        }
//        int from = page.getNumber() * page.getSize(), to = from + page.getSize();
//        if (employees.size() < from) return Page.empty();
//        int subListSize = Math.min(employees.size(), to);
//        return Page.of(
//                employees.stream()
//                        .sorted(Comparator.comparing(e -> FullnameUtil.getFullName(e.getFirstName(), e.getSecondName(), e.getLastName())))
//                        .toList().subList(from, subListSize),
//                page,
//                employees.size()
//        );
    }


}