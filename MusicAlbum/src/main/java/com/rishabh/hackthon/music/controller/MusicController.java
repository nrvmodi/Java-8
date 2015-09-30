/**
 * 
 */
package com.rishabh.hackthon.music.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rishabh.hackthon.music.service.AlbumService;

/**
 * @author Nirav.Modi
 *
 */
@RestController
public class MusicController {
	
	@Autowired
	private AlbumService albumService;
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/")
	public String login(){
		
		return "view";
	}
	
}
