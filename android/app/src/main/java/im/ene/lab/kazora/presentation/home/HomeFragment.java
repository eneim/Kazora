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

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import im.ene.lab.kazora.Kazora;
import im.ene.lab.kazora.R;
import im.ene.lab.kazora.domain.model.ReportModel;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment implements HomeView {

  public static HomeFragment newInstance() {
    return new HomeFragment();
  }

  public HomeFragment() {
    // Required empty public constructor
  }

  private HomePresenter presenter;

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_home, container, false);
  }

  @Bind(R.id.text) TextView mTextView;

  @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    ButterKnife.bind(this, view);
  }

  @Override public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    presenter = Kazora.homeComponent().getHomePresenter();
    presenter.setView(this);
  }

  @Override public void onResume() {
    super.onResume();
    presenter.resume();
  }

  @Override public void showLoading(boolean show) {
    if (show) {
      mTextView.setText("Loading");
    } else {
      mTextView.setText("Done");
    }
  }

  @Override public void updateReport(ReportModel reportModel) {
    if (reportModel != null) {
      mTextView.setText(reportModel.earthDate);
    }
  }
}
