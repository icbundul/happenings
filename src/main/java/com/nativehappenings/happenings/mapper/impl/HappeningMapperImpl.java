package com.nativehappenings.happenings.mapper.impl;

import com.nativehappenings.happenings.api.viewmodel.HappeningViewModel;
import com.nativehappenings.happenings.mapper.HappeningMapper;
import com.nativehappenings.happenings.model.Happening;
import org.springframework.stereotype.Component;

@Component
public class HappeningMapperImpl extends BaseEntityMapper implements HappeningMapper {

    @Override
    public HappeningViewModel convertToModel(Happening entity) {

        HappeningViewModel viewModel = new HappeningViewModel();
        // TODO Fix this conversion
        viewModel = (HappeningViewModel) super.convertToBaseEntityViewModel(entity);
        viewModel.setName(entity.getName());
        viewModel.setDateFrom(entity.getDateFrom());
        viewModel.setDateTo(entity.getDateTo());
        viewModel.setText(entity.getText());
        viewModel.setTextHr(entity.getTextHr());

        return viewModel;
    }

    @Override
    public Happening convertToEntity(HappeningViewModel viewModel) {
        Happening entity = new Happening(viewModel.getId(),viewModel.getName(),
                viewModel.getDateFrom(), viewModel.getDateTo(), viewModel.getText(), viewModel.getTextHr());

        return entity;
    }

}
