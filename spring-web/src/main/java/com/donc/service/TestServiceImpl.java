//package com.donc.service;
//
//import com.donc.dto.TestDTO;
//import com.donc.entities.TestTable;
//import com.donc.repo.springdata.JpaRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
///**
// * Created by donovan on 15/08/12.
// */
//@Service
//public class TestServiceImpl implements TestService {
//
//    @Autowired
//    private JpaRepo repo;
//
//    @Override
//    @Transactional
//    public void addTestTable(TestDTO dto) {
//        TestTable tt = new TestTable();
//        tt.setText(dto.getText());
//        repo.save(tt);
//    }
//}
