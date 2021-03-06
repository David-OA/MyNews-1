package com.galou.mynews.searchNotification;

import com.galou.mynews.utils.TextUtil;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static com.galou.mynews.utils.DateUtil.convertCalendarForDisplay;
import static org.mockito.Mockito.verify;

/**
 * Created by galou on 2019-04-03
 */
@RunWith(MockitoJUnitRunner.class)
public class SearchPresenterUnitTest {

    @Mock
    private SearchContract.View searchView;

    private SearchPresenter presenter;

    private String mockedQueryTerm;
    private String mockedBeginDate;
    private String mockedEndDate;
    private List<String> mockedSectionQuery;
    private String sectionForAPI;
    private String termForAPI;

    @Before
    public void setupPresenter() {
        MockitoAnnotations.initMocks(this);
        presenter = new SearchPresenter(searchView);

        // set correct data
        mockedQueryTerm = "term1 term2";
        mockedBeginDate = "23/05/17";
        mockedEndDate = "25/05/17";
        mockedSectionQuery = new ArrayList<>();
        mockedSectionQuery.add("Arts");
        mockedSectionQuery.add("Travel");
        termForAPI = TextUtil.convertQueryTermForAPI(mockedQueryTerm);
        sectionForAPI = "news_desk%3A" + TextUtil.convertListInStringForAPI(mockedSectionQuery);

    }

    @Test
    public void createPresenter_setPresenterToView(){
        presenter = new SearchPresenter(searchView);

        verify(searchView).setPresenter(presenter);
    }

    @Test
    public void clickSearchButtonCorrectWithData_startSearch(){
        presenter.startSearch(mockedQueryTerm, mockedBeginDate, mockedEndDate, mockedSectionQuery);
        verify(searchView).disableAllErrors();
        verify(searchView).showResultResearch("20170523", "20170525", sectionForAPI, termForAPI);

    }

    @Test
    public void clickSearchButtonCorrectNoData_startSearch(){
        mockedBeginDate = "";
        mockedEndDate = "";

        presenter.startSearch(mockedQueryTerm, mockedBeginDate, mockedEndDate, mockedSectionQuery);
        verify(searchView).disableAllErrors();
        verify(searchView).showResultResearch(null, null, sectionForAPI, termForAPI);

    }

    @Test
    public void clickSearchButtonMissingQueryTerm_showErrorQueryTerm(){
        mockedQueryTerm = "";

        presenter.startSearch(mockedQueryTerm, mockedBeginDate, mockedEndDate, mockedSectionQuery);
        verify(searchView).disableAllErrors();
        verify(searchView).displayErrorQueryTerm(ErrorMessage.EMPTY);

    }

    @Test
    public void clickSearchButtonWrongQueryTerm_showErrorQueryTerm(){
        mockedQueryTerm = "@@@ 555 geer";

        presenter.startSearch(mockedQueryTerm, mockedBeginDate, mockedEndDate, mockedSectionQuery);
        verify(searchView).disableAllErrors();
        verify(searchView).displayErrorQueryTerm(ErrorMessage.INCORRECT);

    }

    @Test
    public void clickSearchButtonNoSectionSelected_showErrorQueryTerm(){
        mockedSectionQuery.remove(0);
        mockedSectionQuery.remove(0);

        presenter.startSearch(mockedQueryTerm, mockedBeginDate, mockedEndDate, mockedSectionQuery);
        verify(searchView).disableAllErrors();
        verify(searchView).displayErrorSections(ErrorMessage.EMPTY);

    }

    @Test
    public void clickSearchButtonWrongBeginDate_showErrorQueryTerm(){
        mockedBeginDate = "34/43";

        presenter.startSearch(mockedQueryTerm, mockedBeginDate, mockedEndDate, mockedSectionQuery);
        verify(searchView).disableAllErrors();
        verify(searchView).displayErrorBeginDate(ErrorMessage.INCORRECT);

    }

    @Test
    public void clickSearchButtonBeginDateInFuture_showErrorQueryTerm(){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        mockedBeginDate = convertCalendarForDisplay(calendar);

        presenter.startSearch(mockedQueryTerm, mockedBeginDate, mockedEndDate, mockedSectionQuery);
        verify(searchView).disableAllErrors();
        verify(searchView).displayErrorBeginDate(ErrorMessage.IN_FUTURE);

    }

    @Test
    public void clickSearchButtonWrongEndDate_showErrorQueryTerm(){
        mockedEndDate = "34/43";

        presenter.startSearch(mockedQueryTerm, mockedBeginDate, mockedEndDate, mockedSectionQuery);
        verify(searchView).disableAllErrors();
        verify(searchView).displayErrorEndDate(ErrorMessage.INCORRECT);

    }

    @Test
    public void clickSearchButtonEndDateBeforeBeginDate_showErrorQueryTerm(){
        mockedEndDate = "19/05/17";

        presenter.startSearch(mockedQueryTerm, mockedBeginDate, mockedEndDate, mockedSectionQuery);
        verify(searchView).disableAllErrors();
        verify(searchView).displayErrorEndDate(ErrorMessage.BEFORE_BEGIN_DATE);

    }

    @Test
    public void clickSearchButtonEndDateInFuture_showErrorQueryTerm(){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        mockedEndDate = convertCalendarForDisplay(calendar);

        presenter.startSearch(mockedQueryTerm, mockedBeginDate, mockedEndDate, mockedSectionQuery);
        verify(searchView).disableAllErrors();
        verify(searchView).displayErrorEndDate(ErrorMessage.IN_FUTURE);

    }




}
