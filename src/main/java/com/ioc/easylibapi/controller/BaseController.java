package com.ioc.easylibapi.controller;

import com.ioc.easylibapi.controller.utils.SearchCriteria;
import com.ioc.easylibapi.controller.utils.SearchOperation;
import com.ioc.easylibapi.controller.utils.SpecBuilder;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class BaseController
 *
 * @param <T> allows to paginate the extracted results
 *            -> used on UserController, RoleController and UserRoleController
 */
public class BaseController<T> {
    // original:     "(\\w+?)(:|<|>)(\"([^\"]+)\")"
    // new:          "(\\w+?)(:|<|>)(\\w+?),"
    public static final String QUERY_REGEX_PATTERN = "(\\w+?)(:|<|>)(\\w+?),";//"(\\w+?)(:|<|>)(\"([^\"]+)\")" ;
    protected static final String DEFAULT_PAGE = "0";
    protected static final String DEFAULT_SIZE = "20";
    protected static final String DEFAULT_SORT = "asc";

    protected PageRequest pageRequest(int page, int size, String sort, String field) {

        Sort.Direction d = sort.equalsIgnoreCase("desc") ? Sort.Direction.DESC : Sort.Direction.ASC;
        return PageRequest.of(page, size, d, field);
    }

    protected Specification<T> buildSpecification(String search) throws Exception {

        SpecBuilder<T> builder = new SpecBuilder<>();

        Pattern patternMultiple = Pattern.compile(QUERY_REGEX_PATTERN);
        Matcher matcherMultiple = patternMultiple.matcher(search);

        while (matcherMultiple.find()) {

            SearchOperation searchOperation = SearchOperation.of(matcherMultiple.group(1));

            String key = matcherMultiple.group(2);
            String operation = matcherMultiple.group(3);
            String value = matcherMultiple.group(4);

            builder.addSpecification(searchOperation, key, operation, value);
        }
        return builder.getSpecification();
    }


    // Test implementation
    protected List<SearchCriteria> buildSpecification2(String search) throws Exception {

        List<SearchCriteria> params = new ArrayList<>();
        if (search != null) {
            Pattern pattern = Pattern.compile(QUERY_REGEX_PATTERN);
            Matcher matcher = pattern.matcher(search + ",");
            while (matcher.find()) {
                params.add(new SearchCriteria(matcher.group(1), matcher.group(2), matcher.group(3)));
            }
        }
        return params;
    }




}