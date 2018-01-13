package com.udemy.services.impl.quotes;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.udemy.model.quotes.Quote;
import com.udemy.services.quotes.QuotesService;

@Service("quoteService")
public class QuoteServiceImpl implements QuotesService {

	private static final Log logger = LogFactory.getLog(QuoteServiceImpl.class);
	
	@Override
	public Quote getQuote() {
		
		RestTemplate template = new RestTemplate();
		Quote quote = template.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
		
		logger.info(quote);
		
		return quote;
	}

}
