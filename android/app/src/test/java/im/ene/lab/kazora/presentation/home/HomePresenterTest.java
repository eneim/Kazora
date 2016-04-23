/*
 * Copyright 2016 Nam Nguyen, nam@ene.im
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package im.ene.lab.kazora.presentation.home;

import im.ene.lab.kazora.domain.HomeRepository;
import im.ene.lab.kazora.domain.model.ReportModel;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import rx.Observable;

/**
 * Created by eneim on 4/22/16.
 */
@RunWith(MockitoJUnitRunner.class) public class HomePresenterTest {

  @Mock private HomeRepository homeRepository;

  @Mock private HomeView homeView;

  private ReportModel model = new ReportModel("2016-04-22");

  private Observable<ReportModel> expectedResult = Observable.just(model);

  private HomePresenter homePresenter;

  @Before public void setup() {
    MockitoAnnotations.initMocks(this);
    Mockito.when(homeRepository.getReport()).thenReturn(expectedResult);
  }

  @Test public void onResumeGetReportThenUpdateView() {
    // Create presenter then resume the View
    homePresenter = new HomePresenter(homeRepository);
    homePresenter.setView(homeView);
    homePresenter.resume();

    // Then verify if it works as expected
    // 1. Show loading
    Mockito.verify(homeView).showLoading(true);
    // 2. Load data
    Mockito.verify(homeRepository).getReport();
    // 3. Hide loading
    Mockito.verify(homeView).showLoading(false);
    // 4. Update loaded report
    Mockito.verify(homeView).updateReport(model);
  }

  @After public void tearDown() {

  }
}
