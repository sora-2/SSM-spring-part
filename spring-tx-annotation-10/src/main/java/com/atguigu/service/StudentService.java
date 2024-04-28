package com.atguigu.service;

import com.atguigu.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileNotFoundException;

@Service
public class StudentService {


        @Autowired
        private StudentDao studentDao;
        @Transactional( readOnly = false,
                        timeout = 1,
                        rollbackFor = Exception.class,
                        noRollbackFor = FileNotFoundException.class,
                        isolation = Isolation.READ_COMMITTED)
        public void changeInfo(){
            studentDao.updateAgeById(100,1);
            System.out.println("-----------");
            studentDao.updateNameById("test1",1);
        }
    }
