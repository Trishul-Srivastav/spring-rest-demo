package com.trishul.springrestdemo.service;

import com.trishul.springrestdemo.model.EmployeeBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class EmployeeService {

    private static final Map<Integer, EmployeeBean> employeeBeanMap = new HashMap<>();

    @PostConstruct
    public void init() {
        log.info("adding initial emp rec to Map");
        employeeBeanMap.put(1, EmployeeBean.builder().empId(1).adharNo(123456789).designation("SE")
                .name("Chris").salary(40000).build());
        employeeBeanMap.put(2, EmployeeBean.builder().empId(2).adharNo(987654321).designation("SSE")
                .name("Steve").salary(50000).build());
        employeeBeanMap.put(3, EmployeeBean.builder().empId(3).adharNo(456987321).designation("ASE")
                .name("Wanda").salary(20000).build());
        employeeBeanMap.put(4, EmployeeBean.builder().empId(4).adharNo(369852147).designation("TL")
                .name("Natasha").salary(90000).build());
        employeeBeanMap.put(5, EmployeeBean.builder().empId(5).adharNo(486235971).designation("AM")
                .name("Tony").salary(100000).build());
    }

    public EmployeeBean addEmpDetails(EmployeeBean e) {
        int nextEmpId = employeeBeanMap.size() + 1;
        e.setEmpId(nextEmpId);
        return employeeBeanMap.put(nextEmpId, e);
    }

    public EmployeeBean getEmpById(Integer empId) {
        return employeeBeanMap.get(empId);
    }

    public List<EmployeeBean> fetchAllEmpDetails() {
        return new ArrayList<>(employeeBeanMap.values());
    }
}
