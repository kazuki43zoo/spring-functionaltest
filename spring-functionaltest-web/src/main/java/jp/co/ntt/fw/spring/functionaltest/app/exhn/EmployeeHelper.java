/*
 * Copyright(c) 2014-2017 NTT Corporation.
 */
package jp.co.ntt.fw.spring.functionaltest.app.exhn;

import javax.inject.Inject;

import jp.co.ntt.fw.spring.functionaltest.domain.model.Employee;
import jp.co.ntt.fw.spring.functionaltest.domain.service.exhn.EmployeeService;

import org.dozer.Mapper;
import org.springframework.stereotype.Component;

@Component
public class EmployeeHelper {

    @Inject
    Mapper beanMapper;

    @Inject
    EmployeeService employeeService;

    void convertToForm(EmployeeForm form) {
        Employee employee = employeeService.findEmployee(1);
        beanMapper.map(employee, form);
    }

    Employee convertToEntity(EmployeeForm form) {
        Employee employee = beanMapper.map(form, Employee.class);
        // 更新対象は、ID 1のユーザのみ
        employee.setEmployeeId(1);
        return employee;
    }

}
