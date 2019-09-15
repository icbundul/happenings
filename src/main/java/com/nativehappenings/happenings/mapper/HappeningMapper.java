package com.nativehappenings.happenings.mapper;

import com.nativehappenings.happenings.api.viewmodel.HappeningTypeViewModel;
import com.nativehappenings.happenings.api.viewmodel.HappeningViewModel;
import com.nativehappenings.happenings.model.Happening;
import com.nativehappenings.happenings.model.HappeningType;

import java.util.List;

public interface HappeningMapper extends GenericTemplatingMapper<HappeningViewModel, Happening> {

    List<HappeningViewModel> convertViewModelListFromEntityList(List<Happening> happenings);

    List<HappeningTypeViewModel> convertTypeViewModelListFromTypeEntityList(List<HappeningType> happeningTypes);

}
