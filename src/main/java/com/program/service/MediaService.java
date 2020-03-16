package com.program.service;

import java.util.List;

import com.program.dto.MediaDTO;

public interface MediaService{

    List<MediaDTO> getAll();

    MediaDTO findById(final Long imageId);

    MediaDTO save(final MediaDTO dto);

}