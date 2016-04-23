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
import im.ene.lab.kazora.data.response.ArchiveResponse;
import im.ene.lab.kazora.data.response.ReportResponse;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by eneim on 4/22/16.
 */
public interface Api {

  String BASE_URL = "http://marsweather.ingenology.com";

  /**
   * Get latest weather information on Mars
   *
   * @return Observable object for weather report
   */
  @GET("/v1/latest/") Observable<ReportResponse> reports();

  /**
   * Get archive of weather information on Mars base on various filter parameters
   *
   * @return Observable object for weather archives
   */
  @GET("/v1/archive/") Observable<ArchiveResponse> archive(
      @IntRange(from = 1) @Query("page") int page);
}
