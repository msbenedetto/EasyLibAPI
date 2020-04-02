package com.ioc.easylibapi.services.impl;

import com.ioc.easylibapi.models.loan.Loan;
import com.ioc.easylibapi.repository.LoanRepository;
import com.ioc.easylibapi.services.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("loanService")
public class LoanServiceImpl implements LoanService {

    @Autowired
    private LoanRepository loanRepository;


    @Override
    public Loan findById(Long id) throws Exception {
        Optional<Loan> optional = loanRepository.findById(id);
        if (!optional.isPresent()) {
            throw new Exception("The Loan with ID: " + id + "couldn't be found.");
        }
        return optional.get();
    }

    @Override
    public Page<Loan> findAll(Specification<Loan> specs, Pageable pageable) {
        return loanRepository.findAll(specs, pageable);
    }

    @Override
    public Loan insert(Loan loan) {
        Loan createdEntity = loanRepository.save(loan);
        return createdEntity;
    }

    @Override
    public Loan update(Loan loan) throws Exception {
        if (loan == null || loan.getId() == null || loan.getId() == 0) {
            throw new Exception("The id couldn't be found or equal to 0.");
        }
        Optional<Loan> currentEntity = loanRepository.findById(loan.getId());
        if (!currentEntity.isPresent()) {
            throw new Exception("The Loan with ID: " + loan.getId() + "couldn't be found.");
        }
        Loan updatedEntity = loanRepository.save(loan);
        return updatedEntity;
    }

    @Override
    public void deleteById(Long id) throws Exception {
        Optional<Loan> entityToDelete = loanRepository.findById(id);
        if (!entityToDelete.isPresent()) {
            throw new Exception("The Loan with ID: " + id + "couldn't be found.");
        }
        loanRepository.deleteById(id);
    }

}
