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

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dagger.Module;
import dagger.Provides;
import im.ene.lab.kazora.data.Api;
import javax.inject.Singleton;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.schedulers.Schedulers;

/**
 * Created by eneim on 4/22/16.
 */
@Module public class NetworkModule {

  @Singleton @Provides OkHttpClient provideClient() {
    return new OkHttpClient.Builder().build();
  }

  @Singleton @Provides Gson provideGson() {
    return new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
  }

  @Singleton @Provides Retrofit provideRetrofit(Gson gson, OkHttpClient client) {
    return new Retrofit.Builder().baseUrl(Api.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .addCallAdapterFactory(RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io()))
        .client(client)
        .build();
  }
}
