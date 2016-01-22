package sample.data.elasticsearch.handlerbars;

import com.github.jknack.handlebars.Helper;
import com.github.jknack.handlebars.Options;
import com.github.jknack.handlebars.springmvc.HandlebarsViewResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by nmiriyal on 22/01/2016.
 */
@Configuration
public class HandlerBarsConfig {
    @Bean
    public HandlebarsViewResolver viewResolver() {
        HandlebarsViewResolver viewResolver = new HandlebarsViewResolver();

        Helper<Object> helper = new Helper<Object>() {
            @Override
            public CharSequence apply(final Object context, final Options options) throws IOException {
                return "Spring Helper";
            }
        };
        viewResolver.registerHelper("spring", helper);
        viewResolver.registerHelpers(HandlerBarsConfig.class);
        Map<String, Helper<?>> helpers = new HashMap<String, Helper<?>>();
        helpers.put("setHelper", helper);
        viewResolver.setHelpers(helpers);
        // no cache for testing
        viewResolver.setCache(false);

        viewResolver.setBindI18nToMessageSource(true);
        viewResolver.setPrefix("classpath:templates/");
        return viewResolver;
    }
    @Bean
    public HandlebarsViewResolver viewResolverWithoutMessageHelper() {
        return new HandlebarsViewResolver().withoutMessageHelper();
    }
}
