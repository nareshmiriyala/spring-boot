package sample.data.elasticsearch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sample.data.elasticsearch.Customer;
import sample.data.elasticsearch.CustomerRepository;

import static org.elasticsearch.index.query.QueryBuilders.queryStringQuery;

/**
 * Created by nareshm on 21/01/2016.
 */
@RestController
public class SearchController {
    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;
    @Autowired
    private CustomerRepository customerRepository;

    @RequestMapping(value = "/getCustomer", method = RequestMethod.POST, consumes = {"application/json", "application/xml"})
    public Page<Customer> helloWorld(@RequestBody Customer customer) {
        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(queryStringQuery(customer.getFirstName()).field("firstName"))
                .withQuery(queryStringQuery(customer.getLastName()).field("lastName"))
                .build();
        Page<Customer> sampleEntities = elasticsearchTemplate.queryForPage(searchQuery, Customer.class);

        return sampleEntities;
    }

    @RequestMapping(value = "/addCustomer", method = RequestMethod.POST, consumes = {"application/json", "application/xml"})
    public Customer addCustomer(@RequestBody Customer customer
    ) {
        customerRepository.save(customer);

        return customer;
    }

}
