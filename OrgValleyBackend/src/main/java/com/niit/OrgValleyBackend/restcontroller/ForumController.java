package com.niit.OrgValleyBackend.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;


import com.niit.OrgValleyBackend.dao.Forum_MasterDao;
import com.niit.OrgValleyBackend.dao.Forum_ResponseDao;
import com.niit.OrgValleyBackend.model.Forum_Master;
import com.niit.OrgValleyBackend.model.Forum_Response;


@RestController
public class ForumController {
	
	@Autowired
	Forum_Master forum_master;
	@Autowired
	Forum_MasterDao forum_masterDao;
	@Autowired
	Forum_Response forum_response;
	@Autowired
	Forum_ResponseDao forum_responseDao;
	
	
	@RequestMapping(value = "/forums", method = RequestMethod.GET)
    public ResponseEntity<List<Forum_Master>> list() {
        List<Forum_Master> frmlst = forum_masterDao.list();
        
        if(frmlst.isEmpty()){
            return new ResponseEntity<List<Forum_Master>>(HttpStatus.NO_CONTENT);
            //You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Forum_Master>>(frmlst, HttpStatus.OK);
    }
 

	 @RequestMapping(value = "/frmadd/insert/", method = RequestMethod.POST )
	    public ResponseEntity<Void> createForum(@ModelAttribute("forumm") Forum_Master forum_master, @RequestBody Forum_Master forum_Master,   UriComponentsBuilder ucBuilder) {
	           System.out.println("Done Here Blog Storing ");
	           forum_masterDao.SaveOrUpdate(forum_Master);
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/frmadd/{fid}").buildAndExpand(forum_Master.getFid()).toUri());
	        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	    }
	 
	  //REPLYES---------------------------------------------------------------------------------------------------------------------
	 @RequestMapping(value = "/reply/insert/", method = RequestMethod.POST )
	 public ResponseEntity<Void> addReply(@ModelAttribute("reply") Forum_Response frply,@RequestBody Forum_Response fReply,   UriComponentsBuilder ucBuilder) {
	        System.out.println("Done Here commect Storing ");
	        forum_responseDao.SaveOrUpdate(fReply);
//	        int x=0;
//	        x=forumMaterDao.getlikes(fReply.getFid());
//	        System.out.println("UUUUUUUUUUUUUUUUUUUUU"+x);
//	        System.out.println("UUUUUUUUUUUUUUUUUUUUU  "+forumMaster.getFdy());
//	        x=x+1;
//	        forumMaster.setFcmtct(x);
//	        forumMaster.setFid(fReply.getFid());;
//	        forumMaterDao.SaveOrUpdate(forumMaster);
	        
	     HttpHeaders headers = new HttpHeaders();
	     headers.setLocation(ucBuilder.path("/reply/{fid}").buildAndExpand(fReply.getFid()).toUri());
	     return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	 }
	 
	 @RequestMapping(value = "/replies/{fid}", method = RequestMethod.GET)
	    public ResponseEntity<List<Forum_Response>> listAllComents(@PathVariable("fid") int fid) {
	     System.out.println(fid);   
		 List<Forum_Response> rpllst = forum_responseDao.list();
	        
	        if(rpllst.isEmpty()){
	            return new ResponseEntity<List<Forum_Response>>(HttpStatus.NO_CONTENT);
	            //You many decide to return HttpStatus.NOT_FOUND
	        }
	        return new ResponseEntity<List<Forum_Response>>(rpllst, HttpStatus.OK);
	    }
	// 
	 
}
