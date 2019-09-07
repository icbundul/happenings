package com.nativehappenings.happenings.mapper.impl;

import com.nativehappenings.happenings.api.viewmodel.HappeningViewModel;
import com.nativehappenings.happenings.mapper.HappeningMapper;
import com.nativehappenings.happenings.model.Happening;
import com.nativehappenings.happenings.model.HappeningType;
import com.nativehappenings.happenings.services.HappeningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HappeningMapperImpl extends BaseEntityMapper implements HappeningMapper {

    @Autowired
    private HappeningService happeningService;

    @Override
    public HappeningViewModel convertToModel(Happening entity) {

        HappeningViewModel viewModel = new HappeningViewModel();

        viewModel = (HappeningViewModel) convertToBaseEntityViewModel(entity, viewModel);
        viewModel.setName(entity.getName());
        viewModel.setDateFrom(entity.getDateFrom());
        viewModel.setDateTo(entity.getDateTo());
        viewModel.setText(entity.getText());
        viewModel.setTextHr(entity.getTextHr());
        viewModel.setHappeningType(entity.getHappeningType() != null ? entity.getHappeningType().getId() : null);

        return viewModel;
    }

    @Override
    public Happening convertToEntity(HappeningViewModel viewModel) {

        HappeningType happeningType = null;

        if (viewModel.getHappeningType() != null)
            happeningType = happeningService.findHappeningTypeById(viewModel.getHappeningType());


        Happening entity = new Happening(viewModel.getId(),viewModel.getName(),
                viewModel.getDateFrom(), viewModel.getDateTo(), viewModel.getText(), viewModel.getTextHr(),
                happeningType);

        return entity;
    }

}
