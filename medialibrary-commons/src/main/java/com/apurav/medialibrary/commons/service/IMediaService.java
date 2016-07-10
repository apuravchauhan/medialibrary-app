package com.apurav.medialibrary.commons.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.apurav.medialibrary.commons.dto.Media;
import com.apurav.medialibrary.commons.dto.Media.Type;

/**
 * 
 * @author apurav.chauhan
 *
 */
public interface IMediaService {


	public List<Media> search(String uid, Type type);

	Media save(String uid, MultipartFile file, Media media) throws Exception;

	Media editMedia(String uid, MultipartFile file, Media media) throws Exception;

}
