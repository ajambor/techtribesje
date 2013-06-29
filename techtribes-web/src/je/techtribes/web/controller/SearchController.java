package je.techtribes.web.controller;

import je.techtribes.domain.ContentSourceStatistics;
import je.techtribes.component.search.SearchResult;
import je.techtribes.component.search.SearchComponent;
import je.techtribes.util.PageSize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SearchController extends AbstractController {

    private SearchComponent searchService;

    @Autowired
    public SearchController(SearchComponent searchService) {
        this.searchService = searchService;
    }

    @RequestMapping(value="/search", method = RequestMethod.GET)
	public String searchByQuery(@RequestParam("q")String query, ModelMap model) {
        addCommonAttributes(model);
        setPageTitle(model, "Search");

        if (query != null && !query.isEmpty()) {
            List<SearchResult> searchResults;
            if (query.startsWith("#") || query.startsWith("@")) {
                searchResults = searchService.searchForTweets(query, PageSize.SEARCH_RESULTS);
            } else if (query.startsWith("!")) {
                searchResults = searchService.searchForAll(query.substring(1), PageSize.SEARCH_RESULTS);
            } else {
                searchResults = searchService.searchForNewsFeedEntries(query, PageSize.SEARCH_RESULTS);
            }

            model.addAttribute("query", query);
            model.addAttribute("searchResults", searchResults);
            model.addAttribute("contentSourceStatistics", new ContentSourceStatistics(searchResults).getStatistics());

            return "search";
        } else {
            return "redirect:/";
        }
	}

}
