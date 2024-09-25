package com.nahrok.tourbackend.service.impl;

import com.nahrok.tourbackend.entity.TourCharValEntity;
import com.nahrok.tourbackend.entity.TourEntity;
import com.nahrok.tourbackend.general.EnumGnlChars;
import com.nahrok.tourbackend.mapper.tour.TourCreateMapper;
import com.nahrok.tourbackend.mapper.tour.TourDetailMapper;
import com.nahrok.tourbackend.model.tour.TourCreateRequest;
import com.nahrok.tourbackend.model.tour.TourDetailResponse;
import com.nahrok.tourbackend.repo.TourCharValRepository;
import com.nahrok.tourbackend.repo.TourRepository;
import com.nahrok.tourbackend.service.ITourService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class TourServiceImpl implements ITourService {
    private final TourRepository tourRepository;

    private final TourCharValRepository tourCharValRepository;

    private final TourCreateMapper tourCreateMapper;

    private final TourDetailMapper tourDetailMapper;

    public TourServiceImpl(TourRepository tourRepository,
                           TourCharValRepository tourCharValRepository,
                           TourCreateMapper tourCreateMapper,
                           TourDetailMapper tourDetailMapper) {
        this.tourRepository = tourRepository;
        this.tourCharValRepository = tourCharValRepository;
        this.tourCreateMapper = tourCreateMapper;
        this.tourDetailMapper = tourDetailMapper;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Long tourCreate(TourCreateRequest request) {
        TourEntity tourEntity = tourCreateMapper.modelToEntity(request);

        Long tourId = tourRepository.save(tourEntity).getId();

        List<TourCharValEntity> charValEntities = new ArrayList<>();
        Map<EnumGnlChars.TourChars, String> valMap = EnumGnlChars.TourChars.valMap(request.getCharVal());
        for (Map.Entry<EnumGnlChars.TourChars, String> entry : valMap.entrySet()) {
            TourCharValEntity charValEntity = new TourCharValEntity();
            EnumGnlChars.TourChars tourChar = entry.getKey();
            charValEntity.setTourId(tourId);
            charValEntity.setCharId(tourChar.getId());
            charValEntity.setVal(entry.getValue());
            charValEntity.setValType(tourChar.getClazz());

            charValEntities.add(charValEntity);
        }
        tourCharValRepository.saveAll(charValEntities);

        return tourId;
    }

    @Override
    public TourDetailResponse getTour(Long tourId) {
        Optional<TourEntity> entity = tourRepository.findById(tourId);
        return entity.map(tourDetailMapper::entityToModel).orElse(null);
    }

    @Override
    public List<TourDetailResponse> tours() {
        List<TourEntity> tourEntity = tourRepository.findAll();
        return tourDetailMapper.entityToModel(tourEntity);
    }
}
