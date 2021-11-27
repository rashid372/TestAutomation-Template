package com.edu.lms.pages.google;

import com.edu.lms.pages.BasePage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class GooglePage extends BasePage {

    @Autowired
    private SearchComponent searchComponent;

    @Autowired
    private SearchResult searchResult;

    @Value("${app.url}")
    private String url;

    public void goTo(){
        this.webDriver.get(url);
    }

    public SearchComponent getSearchComponent() {
        return searchComponent;
    }

    public SearchResult getSearchResult() {
        return searchResult;
    }

    public void close(){
        this.webDriver.quit();
    }


    @Override
    public boolean isLoaded() {
        return this.searchComponent.isLoaded();
    }
}
