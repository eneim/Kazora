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

import android.support.annotation.NonNull;
import im.ene.lab.kazora.data.Api;
import im.ene.lab.kazora.data.entity.ReportEntity;
import im.ene.lab.kazora.data.response.ReportResponse;
import im.ene.lab.kazora.domain.HomeRepository;
import im.ene.lab.kazora.domain.model.ReportModel;
import io.realm.Realm;
import javax.inject.Inject;
import rx.Observable;
import rx.functions.Func1;

/**
 * Created by eneim on 4/22/16.
 */
public class HomeRepoImpl implements HomeRepository {

  private final Api api;

  @Inject public HomeRepoImpl(Api api) {
    this.api = api;
  }

  @Override public Observable<ReportModel> getReport() {
    return api.reports().onErrorReturn(new Func1<Throwable, ReportResponse>() {
      @Override public ReportResponse call(Throwable throwable) {
        return new ReportResponse();
      }
    }).flatMap(new Func1<ReportResponse, Observable<ReportModel>>() {
      @Override public Observable<ReportModel> call(@NonNull ReportResponse reportResponse) {
        if (reportResponse.report != null) {
          Realm realm = Realm.getDefaultInstance();
          realm.beginTransaction();
          ReportEntity entity = realm.copyToRealm(reportResponse.report);
          realm.commitTransaction();
          ReportModel model = entity.toModel();
          realm.close();
          return Observable.just(model);
        } else {
          return Observable.just(null);
        }
      }
    });
  }
}
