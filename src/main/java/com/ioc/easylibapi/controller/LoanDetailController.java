package com.ioc.easylibapi.controller;


import com.ioc.easylibapi.models.loan.LoanDetail;
import com.ioc.easylibapi.services.LoanDetailService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

/**
 * Class LoanDetailController
 * core class where are declared the methods allowing to extract / insert / update / delete the loan detail information
 * through @PathVariable() and
 * the @RequestBody
 */
@RestController
@RequestMapping("loandetail")
public class LoanDetailController extends BaseController {

    @Autowired
    private LoanDetailService loanDetailService;

    @GetMapping("{id}")
    public LoanDetail byId(@PathVariable("id") Long id) throws Exception {
        return loanDetailService.findById(id);
    }


    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK", response = LoanDetail.class)})
    @GetMapping
    public Page<LoanDetail> search(@RequestParam(value = "q", required = false, defaultValue = "") String search,
                                @RequestParam(value = "page", required = false, defaultValue = DEFAULT_PAGE) int page,
                                @RequestParam(value = "size", required = false, defaultValue = DEFAULT_SIZE) int size,
                                @RequestParam(value = "sort", required = false, defaultValue = DEFAULT_SORT) String sort,
                                @RequestParam(value = "field", required = false, defaultValue = "id") String field) throws Exception {

        return loanDetailService.findAll(buildSpecification(search), pageRequest(page, size, sort, field));
    }

    @PostMapping
    public LoanDetail insert(@RequestBody LoanDetail loanDetail) {
        return loanDetailService.insert(loanDetail);
    }

    @PutMapping
    public LoanDetail update(@RequestBody LoanDetail loanDetail) throws Exception {
        return loanDetailService.update(loanDetail);
    }

    @PutMapping("/return")
    public LoanDetail returnDetail(@RequestBody LoanDetail loanDetail) throws Exception {
        return loanDetailService.returnDetail(loanDetail);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) throws Exception {
        loanDetailService.deleteById(id);
    }


}
