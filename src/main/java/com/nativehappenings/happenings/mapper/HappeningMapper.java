package com.nativehappenings.happenings.mapper;

import com.nativehappenings.happenings.api.viewmodel.HappeningViewModel;
import com.nativehappenings.happenings.model.Happening;
import org.springframework.stereotype.Component;

public interface HappeningMapper extends GenericTemplatingMapper<HappeningViewModel, Happening> {

}
