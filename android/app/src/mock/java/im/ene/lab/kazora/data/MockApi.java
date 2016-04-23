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

package im.ene.lab.kazora.data;

import android.support.annotation.IntRange;
import im.ene.lab.kazora.Mocker;
import im.ene.lab.kazora.data.response.ArchiveResponse;
import im.ene.lab.kazora.data.response.ReportResponse;
import java.io.IOException;
import javax.inject.Inject;
import retrofit2.http.Query;
import retrofit2.mock.BehaviorDelegate;
import rx.Observable;

/**
 * Created by eneim on 4/22/16.
 */
public class MockApi implements Api {

  private final BehaviorDelegate<Api> delegate;
  private final Mocker mocker;

  @Inject public MockApi(BehaviorDelegate<Api> delegate, Mocker mocker) {
    this.delegate = delegate;
    this.mocker = mocker;
  }

  @Override public Observable<ReportResponse> reports() {
    ReportResponse response = new ReportResponse();
    try {
      response = mocker.mockReportResponse();
    } catch (IOException er) {
      er.printStackTrace();
    }
    return delegate.returningResponse(response).reports();
  }

  @Override
  public Observable<ArchiveResponse> archive(@IntRange(from = 1) @Query("page") int page) {
    return null;
  }
}
