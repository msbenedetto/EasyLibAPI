package com.ioc.easylibapi.services.impl;

import com.ioc.easylibapi.models.enumerations.LoanStatus;
import com.ioc.easylibapi.models.loan.Loan;
import com.ioc.easylibapi.models.loan.LoanDetail;
import com.ioc.easylibapi.repository.LoanDetailRepository;
import com.ioc.easylibapi.services.LoanDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Calendar;
import java.util.Optional;

@Service("loanDetailService")
public class LoanDetailServiceImpl implements LoanDetailService {

    @Autowired
    private LoanDetailRepository loanDetailRepository;


    @Override
    public LoanDetail findById(Long id) throws Exception {
        Optional<LoanDetail> optional = loanDetailRepository.findById(id);
        if (!optional.isPresent()) {
            throw new Exception("The LoanDetail with ID: " + id + "couldn't be found.");
        }
        return optional.get();
    }

    @Override
    public Page<LoanDetail> findAll(Specification<LoanDetail> specs, Pageable pageable) {
        return loanDetailRepository.findAll(specs, pageable);
    }

    @Override
    public LoanDetail insert(LoanDetail loanDetail) {
        LoanDetail createdEntity = loanDetailRepository.save(loanDetail);
        return createdEntity;
    }

    @Override
    public LoanDetail update(LoanDetail loanDetail) throws Exception {
        if (loanDetail == null || loanDetail.getId() == null || loanDetail.getId() == 0) {
            throw new Exception("The id couldn't be found or equal to 0.");
        }
        Optional<LoanDetail> currentEntity = loanDetailRepository.findById(loanDetail.getId());
        if (!currentEntity.isPresent()) {
            throw new Exception("The LoanDetail with ID: " + loanDetail.getId() + "couldn't be found.");
        }
        LoanDetail updatedEntity = loanDetailRepository.save(loanDetail);
        return updatedEntity;
    }

    @Override
    public LoanDetail returnDetail(LoanDetail loanDetail) throws Exception {
        if (loanDetail == null || loanDetail.getId() == null || loanDetail.getId() == 0) {
            throw new Exception("The id couldn't be found or equal to 0.");
        }
        Optional<LoanDetail> currentEntity = loanDetailRepository.findById(loanDetail.getId());
        if (!currentEntity.isPresent()) {
            throw new Exception("The Loan with ID: " + loanDetail.getId() + "couldn't be found.");
        }

        LoanDetail updatedLoanDetail = currentEntity.get();
        updatedLoanDetail.setStatus(LoanStatus.ARCHIVED);
        Calendar c = Calendar.getInstance();
        updatedLoanDetail.setDate_returned(new Date(c.getTimeInMillis()));


        LoanDetail updatedEntity = loanDetailRepository.save(updatedLoanDetail);
        return updatedEntity;
    }


    @Override
    public void deleteById(Long id) throws Exception {
        Optional<LoanDetail> entityToDelete = loanDetailRepository.findById(id);
        if (!entityToDelete.isPresent()) {
            throw new Exception("The LoanDetail with ID: " + id + "couldn't be found.");
        }
        loanDetailRepository.deleteById(id);
    }

}
