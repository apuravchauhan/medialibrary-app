package com.apurav.medialibrary.web.api.v1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.apurav.medialibrary.commons.dto.Media;
import com.apurav.medialibrary.commons.dto.Media.Type;
import com.apurav.medialibrary.commons.service.IMediaService;

/**
 * 
 * @author apuravchauhan
 *
 */
@RestController
@RequestMapping("/api/v1/media")
public class MediaAPI {

	@Autowired
	private IMediaService mediaService;

	// @Secured("ROLE_USR")
	@RequestMapping(method = RequestMethod.POST)
	public void mediaUpload(@RequestParam(name="file",required=false) MultipartFile[] files, Media media) throws Exception {
		if(media.getTyp()==Media.Type.YTB){
			mediaService.save("123", null, media);
		}else{
			for (MultipartFile file : files) {
				mediaService.save("123", file, media);
			}
		}
		
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<Media> listMedia() {

		return mediaService.search("123", Type.IMG);
	}
	@RequestMapping(value="/{id}",method = RequestMethod.POST)
	public Media ediatMedia(@RequestParam(name="file",required=false) MultipartFile file, Media media) throws Exception{

		return mediaService.editMedia("123", file, media);
	}

}
