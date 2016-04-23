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

package im.ene.lab.kazora.di.module;

import android.content.res.AssetManager;
import dagger.Module;
import dagger.Provides;
import im.ene.lab.kazora.Kazora;
import javax.inject.Singleton;

/**
 * Created by eneim on 4/22/16.
 */
@Singleton @Module public class AppModule {

  private final Kazora app;

  public AppModule(Kazora app) {
    this.app = app;
  }

  @Singleton @Provides AssetManager provideAssetManager() {
    return this.app.getAssets();
  }
}
