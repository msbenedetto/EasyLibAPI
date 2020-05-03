package com.ioc.easylibapi.services.impl;

import com.ioc.easylibapi.models.enumerations.LoanStatus;
import com.ioc.easylibapi.models.loan.Loan;
import com.ioc.easylibapi.models.loan.LoanCreation;
import com.ioc.easylibapi.models.loan.LoanDetail;
import com.ioc.easylibapi.repository.LoanDetailRepository;
import com.ioc.easylibapi.repository.LoanRepository;
import com.ioc.easylibapi.services.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@Service("loanService")
public class LoanServiceImpl implements LoanService {

    private static final int LIMIT_DAYS = 30;

    @Autowired
    private LoanRepository loanRepository;
    @Autowired
    private LoanDetailRepository loanDetailRepository;


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
    public Loan insertLoan(LoanCreation loanCreation) {

        Loan l = loanCreation.getLoan();
        Calendar c = Calendar.getInstance();

        Date loanDate = new Date(c.getTimeInMillis());

        c.setTime(loanDate);
        c.add(Calendar.DATE, LIMIT_DAYS);
        Date returnDate = new Date(c.getTimeInMillis());

        l.setStatus(LoanStatus.ACTIVE);
        l.setDate_begin_loan(loanDate);
        l.setDate_scheduled_return(returnDate);


        Loan createdLoan = loanRepository.save(l);

        for(LoanDetail detail: loanCreation.getDetails()) {
            detail.setLoan(createdLoan);
            loanDetailRepository.save(detail);
        }

        return createdLoan;
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
    public Loan returnLoan(Loan loan) throws Exception {
        if (loan == null || loan.getId() == null || loan.getId() == 0) {
            throw new Exception("The id couldn't be found or equal to 0.");
        }
        Optional<Loan> currentEntity = loanRepository.findById(loan.getId());
        if (!currentEntity.isPresent()) {
            throw new Exception("The Loan with ID: " + loan.getId() + "couldn't be found.");
        }

        //return loan
        Loan updatedLoan = currentEntity.get();
        updatedLoan.setStatus(LoanStatus.ARCHIVED);
        Calendar c = Calendar.getInstance();
        updatedLoan.setDate_returned(new Date(c.getTimeInMillis()));

        //return all not returned details
        List<LoanDetail> details = updatedLoan.getDetails();

        for(LoanDetail detail: details) {
            if(!detail.getStatus().equals(LoanStatus.ARCHIVED)) {
                detail.setStatus(LoanStatus.ARCHIVED);
                detail.setDate_returned(new Date(c.getTimeInMillis()));
                loanDetailRepository.save(detail);
            }
        }

        Loan updatedEntity = loanRepository.save(updatedLoan);
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
