package com.ioc.easylibapi.controller;


import com.ioc.easylibapi.models.loan.Loan;
import com.ioc.easylibapi.services.LoanService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

/**
 * Class LoanController
 * core class where are declared the methods allowing to extract / insert / update / delete the loan information
 * through @PathVariable() and
 * the @RequestBody
 */
@RestController
@RequestMapping("loan")
public class LoanController extends BaseController {

    @Autowired
    private LoanService loanService;

    @GetMapping("{id}")
    public Loan byId(@PathVariable("id") Long id) throws Exception {
        return loanService.findById(id);
    }


    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = Loan.class)})
    @GetMapping
    public Page<Loan> search(@RequestParam(value = "q", required = false, defaultValue = "") String search,
                             @RequestParam(value = "page", required = false, defaultValue = DEFAULT_PAGE) int page,
                             @RequestParam(value = "size", required = false, defaultValue = DEFAULT_SIZE) int size,
                             @RequestParam(value = "sort", required = false, defaultValue = DEFAULT_SORT) String sort,
                             @RequestParam(value = "field", required = false, defaultValue = "id") String field) throws Exception {

        return loanService.findAll(buildSpecification(search), pageRequest(page, size, sort, field));
    }

    @PostMapping
    public Loan insert(@RequestBody Loan loan) {
        return loanService.insert(loan);
    }

    @PutMapping
    public Loan update(@RequestBody Loan loan) throws Exception {
        return loanService.update(loan);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) throws Exception {
        loanService.deleteById(id);
    }


}
