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

package im.ene.lab.kazora.data.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import io.realm.RealmObject;
import io.realm.annotations.Ignore;

public class ArchiveEntity extends RealmObject {

  @SerializedName("terrestrial_date") @Expose public String earthDate;
  @SerializedName("sol") @Expose public Integer marsDate;
  @SerializedName("ls") @Expose public Integer marsSeason;
  @SerializedName("min_temp") @Expose public Integer minTemp;
  @SerializedName("min_temp_fahrenheit") @Expose public Float minTempFahrenheit;
  @SerializedName("max_temp") @Expose public Integer maxTemp;
  @SerializedName("max_temp_fahrenheit") @Expose public Float maxTempFahrenheit;
  @SerializedName("pressure") @Expose public Integer pressure;
  @SerializedName("pressure_string") @Expose public String pressureString;

  @Ignore @SerializedName("abs_humidity") @Expose public Object absHumidity;
  @SerializedName("wind_speed") @Expose public Integer windSpeed;
  @SerializedName("wind_direction") @Expose public String windDirection;
  @SerializedName("atmo_opacity") @Expose public String atmoOpacity;
  @SerializedName("season") @Expose public String season;
  @SerializedName("sunrise") @Expose public String sunrise;
  @SerializedName("sunset") @Expose public String sunset;
}
