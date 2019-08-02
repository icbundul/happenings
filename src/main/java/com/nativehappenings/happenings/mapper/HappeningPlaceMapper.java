package com.nativehappenings.happenings.mapper;

import com.nativehappenings.happenings.api.viewmodel.HappeningPlaceViewModel;
import com.nativehappenings.happenings.model.HappeningPlace;
import org.springframework.stereotype.Component;

@Component
public interface HappeningPlaceMapper extends GenericTemplatingMapper<HappeningPlaceViewModel, HappeningPlace> {
}
