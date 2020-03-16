package com.program.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.program.dto.MediaDTO;
import com.program.entity.MediaEntity;
import com.program.repository.MediaRepository;
import com.program.service.MediaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MediaServiceImpl implements MediaService {

    @Autowired
    private MediaRepository mediaRepository;

    @Override
    public List<MediaDTO> getAll() {
        List<MediaEntity> mediaEntities = mediaRepository.findAll();
        List<MediaDTO> mediaDTOs = new ArrayList<MediaDTO>();
        if (mediaEntities != null && mediaEntities.size() > 0) {
            mediaEntities.forEach(entity -> mediaDTOs.add(convertToDTO(entity)));
        }
        return mediaDTOs;
    }

    @Override
    public MediaDTO findById(Long mediaId) {
        MediaEntity entity = mediaRepository.getOne(mediaId);
        if (entity != null) {
            return convertToDTO(entity);
        }
        return null;
    }

    @Override
    public MediaDTO save(final MediaDTO dto) {
        MediaEntity entity = convertToEntity(dto);
        MediaEntity entitySave = mediaRepository.save(entity);
        if (entitySave != null) {
            return dto;
        }
        return null;
    }

    private MediaDTO convertToDTO(final MediaEntity entity) {
        MediaDTO mediaDTO = new MediaDTO(entity.getMediaName(), entity.getMediaSize(), entity.getMediaPath(),
                entity.getUpdateTime());
        return mediaDTO;
    }

    private MediaEntity convertToEntity(final MediaDTO mediaDTO) {
        MediaEntity mediaEntity = new MediaEntity(mediaDTO.getMediaName(), mediaDTO.getMediaSize(),
                mediaDTO.getMediaPath(), mediaDTO.getUpdateTime());

        return mediaEntity;
    }

}