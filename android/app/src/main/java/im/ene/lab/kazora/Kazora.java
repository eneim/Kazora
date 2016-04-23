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

import android.app.Application;
import im.ene.lab.kazora.di.component.AppComponent;
import im.ene.lab.kazora.di.component.DaggerAppComponent;
import im.ene.lab.kazora.di.component.DaggerHomeComponent;
import im.ene.lab.kazora.di.component.HomeComponent;
import im.ene.lab.kazora.di.module.ApiModule;
import im.ene.lab.kazora.di.module.HomeModule;
import im.ene.lab.kazora.di.module.NetworkModule;
import io.realm.DynamicRealm;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmMigration;
import io.realm.rx.RealmObservableFactory;

/**
 * Created by eneim on 4/22/16.
 */
public class Kazora extends Application {

  private static AppComponent appComponent;
  private static HomeComponent homeComponent;

  private static Kazora kazora;

  @Override public void onCreate() {
    super.onCreate();
    kazora = this;
    RealmConfiguration configuration =
        new RealmConfiguration.Builder(this).deleteRealmIfMigrationNeeded()
            .migration(new RealmMigration() {
              @Override public void migrate(DynamicRealm realm, long oldVersion, long newVersion) {
                // Do nothing on purpose
              }
            })
            .name(BuildConfig.REALM_NAME)
            .rxFactory(new RealmObservableFactory())
            .schemaVersion(1)
            .build();
    Realm.setDefaultConfiguration(configuration);
  }

  public static AppComponent appComponent() {
    if (appComponent == null) {
      appComponent = DaggerAppComponent.builder().build();
    }

    return appComponent;
  }

  public static HomeComponent homeComponent() {
    if (homeComponent == null) {
      homeComponent = DaggerHomeComponent.builder()
          .networkModule(new NetworkModule())
          .apiModule(new ApiModule(kazora))
          .homeModule(new HomeModule())
          .build();
    }

    return homeComponent;
  }
}
