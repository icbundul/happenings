package com.nativehappenings.happenings.mapper.impl;

import com.nativehappenings.happenings.api.viewmodel.HappeningTypeViewModel;
import com.nativehappenings.happenings.api.viewmodel.HappeningViewModel;
import com.nativehappenings.happenings.mapper.BaseTypeMapper;
import com.nativehappenings.happenings.mapper.HappeningMapper;
import com.nativehappenings.happenings.model.Happening;
import com.nativehappenings.happenings.model.HappeningType;
import com.nativehappenings.happenings.services.HappeningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class HappeningMapperImpl extends BaseEntityMapper implements HappeningMapper {

    @Autowired
    private HappeningService happeningService;

    private BaseTypeMapper<HappeningTypeViewModel, HappeningType> baseTypeMapper;

    @Override
    public HappeningViewModel convertToModel(Happening entity) {

        HappeningViewModel viewModel = new HappeningViewModel();
        baseTypeMapper = new BaseTypeMapper<>(HappeningTypeViewModel.class);

        viewModel = (HappeningViewModel) convertToBaseEntityViewModel(entity, viewModel);
        viewModel.setName(entity.getName());
        viewModel.setDateFrom(entity.getDateFrom());
        viewModel.setDateTo(entity.getDateTo());
        viewModel.setText(entity.getText());
        viewModel.setTextHr(entity.getTextHr());

        if (entity.getHappeningType() != null)
            viewModel.setHappeningType(baseTypeMapper.convertToTypeVewModel(entity.getHappeningType()));

        return viewModel;
    }

    @Override
    public Happening convertToEntity(HappeningViewModel viewModel) {

        HappeningType happeningType = null;

        if (viewModel.getHappeningType() != null)
            happeningType = happeningService.findHappeningTypeById(viewModel.getHappeningType().getId());


        Happening entity = new Happening(viewModel.getId(),viewModel.getName(),
                viewModel.getDateFrom(), viewModel.getDateTo(), viewModel.getText(), viewModel.getTextHr(),
                happeningType);

        return entity;
    }

    @Override
    public List<HappeningViewModel> convertViewModelListFromEntityList(List<Happening> happenings) {

        if (happenings == null || happenings.isEmpty())
            return Collections.EMPTY_LIST;

        List<HappeningViewModel> happeningViewModels = new ArrayList<>();

        for (Happening happening: happenings) {
            happeningViewModels.add(convertToModel(happening));
        }

        return happeningViewModels;
    }

    @Override
    public List<HappeningTypeViewModel> convertTypeViewModelListFromTypeEntityList(List<HappeningType> happeningTypes) {

        baseTypeMapper = new BaseTypeMapper<>(HappeningTypeViewModel.class);
        return baseTypeMapper.convertFromTypeEntityListToTypeViewModelList(happeningTypes);
    }
}
