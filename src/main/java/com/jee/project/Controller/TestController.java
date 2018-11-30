package com.jee.project.Controller;

import com.jee.project.DAO.CompteRepository;
import com.jee.project.Data.Budget;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestController {

    @Autowired
    private CompteRepository repos;

}
