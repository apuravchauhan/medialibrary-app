package com.apurav.medialibrary.core.dao;

import java.util.List;

import com.apurav.medialibrary.commons.dto.Media;
import com.apurav.medialibrary.commons.dto.Media.Type;

/**
 * 
 * @author apurav.chauhan
 *
 */
public interface IMediaDao {

	Media save(Media media);

	List<Media> search(String uid, Type type);

	Media searchById(String uid, String mid);
}
