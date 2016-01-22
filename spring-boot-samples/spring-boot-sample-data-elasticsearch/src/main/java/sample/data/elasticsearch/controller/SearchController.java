package sample.data.elasticsearch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import sample.data.elasticsearch.Customer;
import sample.data.elasticsearch.CustomerRepository;

import java.util.Map;

import static org.elasticsearch.index.query.QueryBuilders.queryStringQuery;

/**
 * Created by nareshm on 21/01/2016.
 */
@Controller
public class SearchController {
    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;
    @Autowired
    private CustomerRepository customerRepository;
    @RequestMapping(value = "/getCustomer",method = RequestMethod.POST)
     public String helloWorld(@RequestParam("firstName")String firstName,@RequestParam("lastName")String lastName,Map<String, Object> model) {
        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(queryStringQuery(firstName).field("firstName"))
                .withQuery(queryStringQuery(lastName).field("lastName"))
                .build();
        Page<Customer> sampleEntities = elasticsearchTemplate.queryForPage(searchQuery,Customer.class);
        model.put("message",sampleEntities);
       return "welcome";
    }
    @RequestMapping("/")
    public String index(){
        return "index";
    }
    @RequestMapping(value = "/search",method = RequestMethod.GET)
    public String search(){
        return "search";
    }
    @RequestMapping(value = "/addCustomer", method = RequestMethod.POST)
    public String addCustomer(@ModelAttribute("customer")Customer customer,
                             ModelMap model) {
        customerRepository.save(customer);
        model.addAttribute("firstName", customer.getFirstName());
        model.addAttribute("lastName", customer.getLastName());

        return "result";
    }

}
