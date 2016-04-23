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

package im.ene.lab.kazora;

import android.content.res.AssetManager;
import com.google.gson.Gson;
import im.ene.lab.kazora.data.entity.ErrorEntity;
import im.ene.lab.kazora.data.response.ReportResponse;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.inject.Inject;

/**
 * Created by eneim on 4/22/16.
 */
public class Mocker {

  private final AssetManager assetManager;
  private final Gson gson;

  @Inject public Mocker(AssetManager assetManager, Gson gson) {
    this.assetManager = assetManager;
    this.gson = gson;
  }

  public final ErrorEntity mockError() throws IOException {
    return gson.fromJson(new InputStreamReader(assetManager.open("common_404.json")),
        ErrorEntity.class);
  }

  public final ReportResponse mockReportResponse() throws IOException {
    return gson.fromJson(new InputStreamReader(assetManager.open("report_success.json")),
        ReportResponse.class);
  }
}
