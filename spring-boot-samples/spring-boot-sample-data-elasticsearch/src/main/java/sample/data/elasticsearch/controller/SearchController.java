package sample.data.elasticsearch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sample.data.elasticsearch.Customer;

import java.util.Map;

import static org.elasticsearch.index.query.QueryBuilders.queryStringQuery;

/**
 * Created by nareshm on 21/01/2016.
 */
@Controller
public class SearchController {
    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;
    @RequestMapping("/")
     public String helloWorld(Map<String, Object> model) {
        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(queryStringQuery("Alice").field("firstName"))
                .build();
        Page<Customer> sampleEntities = elasticsearchTemplate.queryForPage(searchQuery,Customer.class);
        model.put("message",sampleEntities);
       return "welcome";
    }
}
